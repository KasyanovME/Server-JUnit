package com.coursework.services;

import com.coursework.entities.Equipment;
import com.coursework.entities.Session;
import com.coursework.repositories.SessionRepository;
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
public class SessionServiceTest {

    @Autowired
    private SessionService sessionService;

    @MockBean
    private SessionRepository repository;

    @Test
    public void create() {
        Session test = new Session();
        Mockito.when(repository.save(test)).thenReturn(test);
        Assert.assertEquals(sessionService.create(test), test);
    }

    @Test
    public void delete() {
        Session test = new Session();
        test.setSessionId(1L);
        Assert.assertTrue(sessionService.delete(1L));
    }

    @Test
    public void findAll() {
        ArrayList<Session> test = new ArrayList<>();
        Session session = new Session();
        test.add(session);
        Mockito.doReturn(test).when(repository).findAll();
        Assert.assertEquals(test, sessionService.findAll());
    }

    @Test
    public void findByTrainerId() {
        ArrayList<Session> test = new ArrayList<>();
        Session session = new Session();
        test.add(session);
        Mockito.doReturn(test).when(repository).findByTrainerId(1L);
        Assert.assertEquals(test, sessionService.findByTrainerId(1L));
    }

    @Test
    public void findByActivityId() {
        ArrayList<Session> test = new ArrayList<>();
        Session session = new Session();
        test.add(session);
        Mockito.doReturn(test).when(repository).findByActivityId(1L);
        Assert.assertEquals(test, sessionService.findByActivityId(1L));
    }

    @Test
    public void findById() {
        Session test = new Session();
        test.setSessionId(1L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(1L);
        Assert.assertEquals(test2, sessionService.findById(1L));
    }

    @Test
    public void update() {
        Session test = new Session();
        test.setSessionId(2L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(2L);
        Assert.assertTrue(sessionService.update(test, 2L));
    }
}