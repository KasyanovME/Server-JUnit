package com.coursework.controllers;

import com.coursework.entities.Equipment;
import com.coursework.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;
    /**
     * Создание оборудования
     * @param equipment оборудование
     * @return созданное оборудование
     */
    @PostMapping(value = "/equipment")
    private ResponseEntity<Equipment> post(@RequestBody Equipment equipment) {
        return new ResponseEntity<>(equipmentService.create(equipment), HttpStatus.CREATED);
    }
    /**
     * Обновление информации об оборудовании
     * @param id ID оборудования
     * @param equipment оборудование
     * @return OK, если данные об оборудовании по его ID обновлены; NOT_FOUND если нет оборудования по такому ID
     */
    @PutMapping(value = "/equipment/{id}")
    private ResponseEntity<?> put(@PathVariable("id") Long id, @RequestBody Equipment equipment) {
        if (equipmentService.findById(id).isPresent()) {
            equipmentService.update(equipment, id);
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение списка всех оборудований
     * @return список всех оборудований; NOT_FOUND если оборудований нет
     */
    @GetMapping(value = "/equipment")
    private ResponseEntity<List<Equipment>> getAll() {
        List<Equipment> equipment = equipmentService.findAll();
        if (equipment != null && !equipment.isEmpty()) {
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение оборудования по его ID
     * @param id ID оборудования
     * @return оборудование по ID; NOT_FOUND если такого оборудования нет
     */
    @GetMapping(value = "/equipment/{id}")
    private ResponseEntity<Optional<Equipment>> getById(@PathVariable Long id) {
        Optional<Equipment> equipment = equipmentService.findById(id);
        if (equipment.isPresent()) {
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Удаление оборудования по его ID
     * @param id ID оборудования
     * @return OK, если оборудование по его ID удален; NOT_FOUND, если нет оборудования по такому ID
     */
    @DeleteMapping(value = "/equipment/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        if (equipmentService.findById(id).isPresent()) {
            equipmentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
