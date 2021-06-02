package com.coursework.controllers;

import com.coursework.entities.Session;
import com.coursework.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;
    /**
     * Создание сеанса
     * @param session сеанс
     * @return созданный сеанс
     */
    @PostMapping(value = "/sessions")
    private ResponseEntity<Session> post(@RequestBody Session session) {
        return new ResponseEntity<>(sessionService.create(session), HttpStatus.CREATED);
    }
    /**
     * Обновление информации о сеансе
     * @param id ID сеанса
     * @param session сеанс
     * @return OK, если данные о сеансе по его ID обновлены; NOT_FOUND если нет сеанса по такому ID
     */
    @PutMapping(value = "/sessions/{id}")
    private ResponseEntity<?> put(@PathVariable("id") Long id, @RequestBody Session session) {
        if (sessionService.findById(id).isPresent()) {
            sessionService.update(session, id);
            return new ResponseEntity<>(session, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/sessions")
    private ResponseEntity<List<Session>> getAll() {
        List<Session> sessions = sessionService.findAll();
        if (sessions != null && !sessions.isEmpty()) {
            return new ResponseEntity<>(sessions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение списка всех сеансов
     * @return список всех сеансов; NOT_FOUND если сеансов нет
     */
    @GetMapping(value = "/sessions/trainer/{id}")
    private ResponseEntity<List<Session>> getByTrainerId(@PathVariable Long id) {
        List<Session> sessions = sessionService.findByTrainerId(id);
        if (sessions != null && !sessions.isEmpty()) {
            return new ResponseEntity<>(sessions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение списка сеансов по ID активити
     * @param id ID активити
     * @return список сеансов по ID активити
     */
    @GetMapping(value = "/sessions/activity/{id}")
    private ResponseEntity<List<Session>> getByActivityId(@PathVariable Long id) {
        List<Session> sessions = sessionService.findByActivityId(id);
        if (sessions != null && !sessions.isEmpty()) {
            return new ResponseEntity<>(sessions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Удаление сеанса по его ID
     * @param id ID сеанса
     * @return OK, если сеанс по его ID удален; NOT_FOUND, если нет сеанса по такому ID
     */
    @DeleteMapping(value = "/sessions/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        if (sessionService.findById(id).isPresent()) {
            sessionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
