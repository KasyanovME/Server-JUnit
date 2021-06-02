package com.coursework.services;

import com.coursework.entities.Activity;
import com.coursework.entities.Client;
import com.coursework.entities.Discount;
import com.coursework.repositories.DiscountRepository;
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
public class DiscountServiceTest {

    @Autowired
    private DiscountService discountService;

    @MockBean
    private DiscountRepository repository;

    @Test
    public void create() {
        Discount test = new Discount();
        Mockito.when(repository.save(test)).thenReturn(test);
        Assert.assertEquals(discountService.create(test), test);
    }

    @Test
    public void delete() {
        Discount test = new Discount();
        test.setDiscountId(1L);
        Assert.assertTrue(discountService.delete(1L));
    }

    @Test
    public void findAll() {
        ArrayList<Discount> test = new ArrayList<>();
        Discount discount = new Discount();
        test.add(discount);
        Mockito.doReturn(test).when(repository).findAll();
        Assert.assertEquals(test, discountService.findAll());
    }

    @Test
    public void findById() {
        Discount test = new Discount();
        test.setDiscountId(1L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(1L);
        Assert.assertEquals(test2, discountService.findById(1L));
    }

    @Test
    public void update() {
        Discount test = new Discount();
        test.setDiscountId(2L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(2L);
        Assert.assertTrue(discountService.update(test, 2L));
    }
}