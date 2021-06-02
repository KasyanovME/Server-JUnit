package com.coursework.services;

import com.coursework.entities.Abonement;
import com.coursework.entities.Activity;
import com.coursework.repositories.ActivityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityServiceTest {

    @Autowired
    private ActivityService activityService;

    @MockBean
    private ActivityRepository repository;

    @Test
    public void create() {
        Activity test = new Activity();
        Mockito.when(repository.save(test)).thenReturn(test);
        Assert.assertEquals(activityService.create(test), test);
    }

    @Test
    public void delete() {
        Activity test = new Activity();
        test.setActivityId(1L);
        Assert.assertTrue(activityService.delete(1L));
    }

    @Test
    public void findAll() {
        ArrayList<Activity> test = new ArrayList<>();
        Activity activity = new Activity();
        test.add(activity);
        Mockito.doReturn(test).when(repository).findAll();
        Assert.assertEquals(test, activityService.findAll());
    }

    @Test
    public void findById() {
        Activity test = new Activity();
        test.setActivityId(1L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(1L);
        Assert.assertEquals(test2, activityService.findById(1L));
    }

    @Test
    public void update() {
        Activity test = new Activity();
        test.setActivityId(2L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(2L);
        Assert.assertTrue(activityService.update(test, 2L));
    }
}