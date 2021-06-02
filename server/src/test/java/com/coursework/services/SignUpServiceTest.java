package com.coursework.services;

import com.coursework.entities.Equipment;
import com.coursework.entities.SignUp;
import com.coursework.repositories.SignUpRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SignUpServiceTest {

    @Autowired
    private SignUpService signUpService;

    @MockBean
    private SignUpRepository repository;

    @Test
    public void findSignUpsByClientId() {
        ArrayList<SignUp> test = new ArrayList<>();
        SignUp signUp = new SignUp();
        test.add(signUp);
        Mockito.doReturn(test).when(repository).findSignUpsByClientId(1L);
        Assert.assertEquals(test, signUpService.findSignUpsByClientId(1L));
    }

    @Test
    public void create() {
        SignUp test = new SignUp();
        Mockito.when(repository.save(test)).thenReturn(test);
        Assert.assertEquals(signUpService.create(test), test);
    }
}