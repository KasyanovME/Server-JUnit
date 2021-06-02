package com.coursework.services;

import com.coursework.entities.Activity;
import com.coursework.entities.Client;
import com.coursework.entities.Club;
import com.coursework.repositories.ClubRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClubServiceTest {

    @Autowired
    private ClubService clubService;

    @MockBean
    private ClubRepository repository;

    @Test
    public void getClubInfo() {
        Club test = new Club();
        test.setClubId(1L);
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(1L);
        Assert.assertEquals(test2, clubService.getClubInfo());
    }

    @Test
    public void updateClubInfo() {
        Club test = new Club();
        Optional test2 = Optional.of(test);
        Mockito.doReturn(test2).when(repository).findById(2L);
        Assert.assertTrue(clubService.updateClubInfo(test));
    }
}