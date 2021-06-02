package com.coursework.controllers;

import com.coursework.entities.Client;
import com.coursework.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    /**
     * Создание клиента
     * @param client клиент
     * @return созданный клиент
     */
    @PostMapping(value = "/clients")
    private ResponseEntity<Client> post(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }
    /**
     * Обновление информации о клиенте
     * @param id ID клиента
     * @param client клиент
     * @return OK, если данные о клиенте по его ID обновлены; NOT_FOUND если нет клиента по такому ID
     */
    @PutMapping(value = "/clients/{id}")
    private ResponseEntity<?> put(@PathVariable("id") Long id, @RequestBody Client client) {
        if (clientService.findById(id).isPresent()) {
            clientService.update(client, id);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение списка всех клиентов
     * @return список всех клиентов; NOT_FOUND если клиентов нет
     */
    @GetMapping(value = "/clients")
    private ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientService.findAll();
        if (clients != null && !clients.isEmpty()) {
            return new ResponseEntity<>(clients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение списка клиентов по ID абонемента
     * @param id ID абонемента
     * @return список клиентов по ID абонемента; NOT_FOUND если таких клиентов нет
     */
    @GetMapping(value = "/clients/{id}")
    private ResponseEntity<List<Client>> getByAbonementId(@PathVariable("id") Long id) {
        List<Client> clients = clientService.findByAbonementId(id);
        if (clients != null && !clients.isEmpty()) {
            return new ResponseEntity<>(clients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Получение списка клиентов по ID сеанса
     * @param id ID сеанса
     * @return список клиентов по ID сеанса; NOT_FOUND если таких клиентов нет
     */
    @GetMapping(value = "/clients/signup/{id}")
    private ResponseEntity<List<Client>> getBySignUpId(@PathVariable("id") Long id) {
        List<Client> clients = clientService.findBySignUpId(id);
        if (clients != null && !clients.isEmpty()) {
            return new ResponseEntity<>(clients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Удаление клиента по его ID
     * @param id ID клиента
     * @return OK, если клиент по его ID удален; NOT_FOUND, если нет клиента по такому ID
     */
    @DeleteMapping(value = "/clients/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        if (clientService.findById(id).isPresent()) {
            clientService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
