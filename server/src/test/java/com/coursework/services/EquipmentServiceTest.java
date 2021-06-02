package com.coursework.services;

import com.coursework.entities.Discount;
import com.coursework.entities.Equipment;
import com.coursework.repositories.EquipmentRepository;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipmentServiceTest {

    @Autowired
    private EquipmentService equipmentService;

    @MockBean
    private EquipmentRepository repository;

    @Test
    public void create() {
        Equipment test = new Equipment();
        Mockito.when(repository.save(test)).thenReturn(test);
        Assert.assertEquals(equipmentService.create(test), test);
    }

    @Test
    public void delete() {
        Equipment test = new Equipment();
        test.setEquipmentId(1L);
        Assert.assertTrue(equipmentService.delete(1L));
    }

    @Test
    public void findAll() {
        ArrayList<Equipment> test = new ArrayList<>();
        Equipment discount = new Equipment();
        test.add(discount);
        Mockito.doReturn(test).when(repository).findAll();
        Assert.assertEquals(test, equipmentService.findAll());
    }

    @Test
    public void findById() {
        Equipment test = new Equipment();
        test.setEquipmentId(1L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(1L);
        Assert.assertEquals(test2, equipmentService.findById(1L));
    }

    @Test
    public void update() {
        Equipment test = new Equipment();
        test.setEquipmentId(2L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(2L);
        Assert.assertTrue(equipmentService.update(test, 2L));
    }
}