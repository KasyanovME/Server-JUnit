package com.coursework.controllers;

import com.coursework.entities.Discount;
import com.coursework.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DiscountController {

    @Autowired
    private DiscountService discountService;
    /**
     * Создание дисконта
     * @param discount дисконт
     * @return созданный дисконт
     */
    @PostMapping(value = "/discounts")
    private ResponseEntity<Discount> post(@RequestBody Discount discount) {
        return new ResponseEntity<>(discountService.create(discount), HttpStatus.CREATED);
    }
    /**
     * Обновление информации о дисконте
     * @param id ID дисконта
     * @param discount дисконт
     * @return OK, если данные о дисконте по его ID обновлены; NOT_FOUND если нет дисконта по такому ID
     */
    @PutMapping(value = "/discounts/{id}")
    private ResponseEntity<?> put(@PathVariable("id") Long id, @RequestBody Discount discount) {
        if (discountService.findById(id).isPresent()) {
            discountService.update(discount, id);
            return new ResponseEntity<>(discount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение списка всех дисконтов
     * @return список всех дисконтов; NOT_FOUND если дисконтов нет
     */
    @GetMapping(value = "/discounts")
    private ResponseEntity<List<Discount>> getAll() {
        List<Discount> discounts = discountService.findAll();
        if (discounts != null && !discounts.isEmpty()) {
            return new ResponseEntity<>(discounts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Получение дисконта по его ID
     * @param id ID дисконта
     * @return дисконт по ID; NOT_FOUND если такого дисконта нет
     */
    @GetMapping(value = "/discounts/{id}")
    private ResponseEntity<Optional<Discount>> getById(@PathVariable Long id) {
        Optional<Discount> discount = discountService.findById(id);
        if (discount.isPresent()) {
            return new ResponseEntity<>(discount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Удаление дисконта по его ID
     * @param id ID дисконта
     * @return OK, если дисконт по его ID удален; NOT_FOUND, если нет дисконта по такому ID
     */
    @DeleteMapping(value = "/discounts/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        if (discountService.findById(id).isPresent()) {
            discountService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
