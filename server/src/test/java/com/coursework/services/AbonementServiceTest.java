package com.coursework.services;

import com.coursework.entities.Abonement;
import com.coursework.repositories.AbonementRepository;
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
public class AbonementServiceTest {

    @Autowired
    private AbonementService abonementService;

    @MockBean
    private AbonementRepository repository;

    @Test
    public void create() {
        Abonement test = new Abonement();
        Mockito.when(repository.save(test)).thenReturn(test);
        Assert.assertEquals(abonementService.create(test), test);
    }

    @Test
    public void delete() {
        Abonement test = new Abonement();
        test.setAbonementId(1L);
        Assert.assertTrue(abonementService.delete(1L));
    }

    @Test
    public void findAll() {
        ArrayList<Abonement> test = new ArrayList<>();
        Abonement abonement = new Abonement();
        test.add(abonement);
        Mockito.doReturn(test).when(repository).findAll();
        Assert.assertEquals(test, abonementService.findAll());
    }

    @Test
    public void findById() {
        Abonement test = new Abonement();
        test.setAbonementId(1L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(1L);
        Assert.assertEquals(test2 , abonementService.findById(1L));
    }

    @Test
    public void update() {
        Abonement test = new Abonement();
        test.setAbonementId(2L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(2L);
        Assert.assertTrue(abonementService.update(test, 2L));
    }
}