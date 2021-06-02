package com.coursework.services;

import com.coursework.entities.Equipment;
import com.coursework.entities.Session;
import com.coursework.entities.Trainer;
import com.coursework.repositories.TrainerRepository;
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
public class TrainerServiceTest {

    @Autowired
    private TrainerService trainerService;

    @MockBean
    private TrainerRepository repository;

    @Test
    public void create() {
        Trainer test = new Trainer();
        Mockito.when(repository.save(test)).thenReturn(test);
        Assert.assertEquals(trainerService.create(test), test);
    }

    @Test
    public void delete() {
        Trainer test = new Trainer();
        test.setTrainerId(1L);
        Assert.assertTrue(trainerService.delete(1L));
    }

    @Test
    public void findAll() {
        ArrayList<Trainer> test = new ArrayList<>();
        Trainer trainer = new Trainer();
        test.add(trainer);
        Mockito.doReturn(test).when(repository).findAll();
        Assert.assertEquals(test, trainerService.findAll());
    }

    @Test
    public void findById() {
        Trainer test = new Trainer();
        test.setTrainerId(1L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(1L);
        Assert.assertEquals(test2, trainerService.findById(1L));
    }

    @Test
    public void update() {
        Trainer test = new Trainer();
        test.setTrainerId(2L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(2L);
        Assert.assertTrue(trainerService.update(test, 2L));
    }
}