package com.coursework.controllers;

import com.coursework.entities.Activity;
import com.coursework.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivitiesController {

    @Autowired
    private ActivityService activityService;
    /**
     * Создание активити
     * @param activity активити
     * @return созданный активити
     */
    @PostMapping(value = "/activities")
    private ResponseEntity<Activity> post(@RequestBody Activity activity) {
        return new ResponseEntity<>(activityService.create(activity), HttpStatus.CREATED);
    }
    /**
     * Обновление информации об активити
     * @param id ID активити
     * @param activity активити
     * @return OK, если данные об активити по его ID обновлены; NOT_FOUND если нет активити по такому ID
     */
    @PutMapping(value = "/activities/{id}")
    private ResponseEntity<?> put(@PathVariable("id") Long id, @RequestBody Activity activity) {
        if (activityService.findById(id).isPresent()) {
            activityService.update(activity, id);
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение списка всех активити
     * @return список всех активити; NOT_FOUND если активити нет
     */
    @GetMapping(value = "/activities")
    private ResponseEntity<List<Activity>> getAll() {
        List<Activity> activities = activityService.findAll();
        if (activities != null && !activities.isEmpty()) {
            return new ResponseEntity<>(activities, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение активити по его ID
     * @param id ID активити
     * @return активити по ID; NOT_FOUND если такого активити нет
     */
    @GetMapping(value = "/activities/{id}")
    private ResponseEntity<Optional<Activity>> getById(@PathVariable Long id) {
        Optional<Activity> activity = activityService.findById(id);
        if (activity.isPresent()) {
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Удаление активити по его ID
     * @param id ID активити
     * @return OK, если активити по его ID удален; NOT_FOUND, если нет активити по такому ID
     */
    @DeleteMapping(value = "/activities/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        if (activityService.findById(id).isPresent()) {
            activityService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
