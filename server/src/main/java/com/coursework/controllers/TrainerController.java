package com.coursework.controllers;

import com.coursework.entities.Trainer;
import com.coursework.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainerController {

    @Autowired
    private TrainerService trainerService;
    /**
     * Создание тренера
     * @param trainer тренер
     * @return созданный тренер
     */
    @PostMapping(value = "/trainers")
    private ResponseEntity<Trainer> post(@RequestBody Trainer trainer) {
        return new ResponseEntity<>(trainerService.create(trainer), HttpStatus.CREATED);
    }
    /**
     * Обновление информации о тренере
     * @param id ID тренера
     * @param trainer тренер
     * @return OK, если данные о тренере по его ID обновлены; NOT_FOUND если нет тренера по такому ID
     */
    @PutMapping(value = "/trainers/{id}")
    private ResponseEntity<?> put(@PathVariable("id") Long id, @RequestBody Trainer trainer) {
        if (trainerService.findById(id).isPresent()) {
            trainerService.update(trainer, id);
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение списка всех тренеров
     * @return список всех тренеров; NOT_FOUND если тренеров нет
     */
    @GetMapping(value = "/trainers")
    private ResponseEntity<List<Trainer>> getAll() {
        List<Trainer> trainers = trainerService.findAll();
        if (trainers != null && !trainers.isEmpty()) {
            return new ResponseEntity<>(trainers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение тренера по его ID
     * @param id ID тренера
     * @return тренер по ID; NOT_FOUND если такого тренера нет
     */
    @GetMapping(value = "/trainers/{id}")
    private ResponseEntity<Optional<Trainer>> getById(@PathVariable Long id) {
        Optional<Trainer> trainer = trainerService.findById(id);
        if (trainer.isPresent()) {
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Удаление тренера по его ID
     * @param id ID тренера
     * @return OK, если тренер по его ID удален; NOT_FOUND, если нет тренера по такому ID
     */
    @DeleteMapping(value = "/trainers/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        if (trainerService.findById(id).isPresent()) {
            trainerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
