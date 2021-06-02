package com.coursework.controllers;

import com.coursework.entities.Abonement;
import com.coursework.services.AbonementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AbonementController {

    @Autowired
    private AbonementService abonementService;
    /**
     * Создание абонемента
     * @param abonement абонемент
     * @return созданный абонемент
     */
    @PostMapping(value = "/abonements")
    private ResponseEntity<Abonement> post(@RequestBody Abonement abonement) {
        return new ResponseEntity<>(abonementService.create(abonement), HttpStatus.CREATED);
    }
    /**
     * Обновление информации об абонементе
     * @param id ID абонемента
     * @param abonement абонемент
     * @return OK, если данные об абонементе по его ID обновлены; NOT_FOUND если нет абонемента по такому ID
     */
    @PutMapping(value = "/abonements/{id}")
    private ResponseEntity<?> put(@PathVariable("id") Long id, @RequestBody Abonement abonement) {
        if (abonementService.findById(id).isPresent()) {
            abonementService.update(abonement, id);
            return new ResponseEntity<>(abonement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение списка всех абонементов
     * @return список всех абонементов; NOT_FOUND если абонементов нет
     */
    @GetMapping(value = "/abonements")
    private ResponseEntity<List<Abonement>> getAll() {
        List<Abonement> abonements = abonementService.findAll();
        System.out.println(1
        );
        if (abonements != null && !abonements.isEmpty()) {
            return new ResponseEntity<>(abonements, HttpStatus.OK);
        } else {
            System.out.println(3);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение абонемента по его ID
     * @param id ID абонемента
     * @return абонемент по ID; NOT_FOUND если такого абонемента нет
     */
    @GetMapping(value = "/abonements/{id}")
    private ResponseEntity<Optional<Abonement>> getById(@PathVariable Long id) {
        Optional<Abonement> abonement = abonementService.findById(id);
        if (abonement.isPresent()) {
            return new ResponseEntity<>(abonement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Удаление абонемента по его ID
     * @param id ID абонемента
     * @return OK, если абонемент по его ID удален; NOT_FOUND, если нет абонемента по такому ID
     */
    @DeleteMapping(value = "/abonements/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        System.out.println(1);
        if (abonementService.findById(id).isPresent()) {
            abonementService.delete(id);
            System.out.println(2);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
