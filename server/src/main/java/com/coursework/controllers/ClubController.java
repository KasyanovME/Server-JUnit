package com.coursework.controllers;

import com.coursework.entities.Club;
import com.coursework.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;
    /**
     * Обновление информации о клубе
     * @param club клуб
     * @return обновленная информация о клубе
     */
    @PutMapping(value = "/club")
    private ResponseEntity<?> put(@RequestBody Club club) {
        clubService.updateClubInfo(club);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    /**
     * Получение общей информации о клубе
     * @return информация о клубе; NOT_FOUND если клуба нет
     */
    @GetMapping(value = "/club")
    private ResponseEntity<Optional<Club>> get() {
        Optional<Club> club = clubService.getClubInfo();
        System.out.println(5125);
        if (club.isPresent()) {
            System.out.println(6677);
            return new ResponseEntity<>(club, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
