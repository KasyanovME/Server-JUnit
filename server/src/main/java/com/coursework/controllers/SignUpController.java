package com.coursework.controllers;

import com.coursework.entities.SignUp;
import com.coursework.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    /**
     * Создание записи на сеанс
     * @param signUp запись на сеанс
     * @return создана запись на сеанс
     */
    @PostMapping(value = "/signups")
    private ResponseEntity<SignUp> post(@RequestBody SignUp signUp) {
        return new ResponseEntity<>(signUpService.create(signUp), HttpStatus.CREATED);
    }
    /**
     * Получение списка сеансов по ID клиента
     * @param id клиента
     * @return список сеансов по ID клиента
     */
    @GetMapping(value = "/signups/client/{id}")
    private ResponseEntity<List<SignUp>> getByClientId(@PathVariable Long id) {
        List<SignUp> signUps = signUpService.findSignUpsByClientId(id);
        if (signUps != null && !signUps.isEmpty()) {
            return new ResponseEntity<>(signUps, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
