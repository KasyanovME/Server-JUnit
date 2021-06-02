package com.coursework.services;

import com.coursework.entities.Activity;
import com.coursework.entities.Client;
import com.coursework.repositories.ClientRepository;
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
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository repository;

    @Test
    public void create() {
        Client test = new Client();
        Mockito.when(repository.save(test)).thenReturn(test);
        Assert.assertEquals(clientService.create(test), test);
    }

    @Test
    public void delete() {
        Client test = new Client();
        test.setClientId(1L);
        Assert.assertTrue(clientService.delete(1L));
    }

    @Test
    public void findAll() {
        ArrayList<Client> test = new ArrayList<>();
        Client client = new Client();
        test.add(client);
        Mockito.doReturn(test).when(repository).findAll();
        Assert.assertEquals(test, clientService.findAll());
    }

    @Test
    public void findById() {
        Activity test = new Activity();
        test.setActivityId(1L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(1L);
        Assert.assertEquals(test2, clientService.findById(1L));
    }

    @Test
    public void update() {
        Client test = new Client();
        test.setClientId(2L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(2L);
        Assert.assertTrue(clientService.update(test, 2L));
    }
}