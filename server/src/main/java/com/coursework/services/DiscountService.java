package com.coursework.services;

import com.coursework.entities.Discount;
import com.coursework.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {

    @Autowired
    DiscountRepository discountRepository;
    /**
     * Создание дисконта
     * @param discount дисконт
     * @return созданный дисконт
     */
    public Discount create(Discount discount) {
        return discountRepository.save(discount);
    }
    /**
     * Удаление дисконта по ID
     * @param id Id дисконта
     */
    public boolean delete(Long id) {
        discountRepository.deleteById(id);
        return true;
    }
    /**
     * Получение списка всех дисконтов
     * @return список дисконтов
     */
    public List<Discount> findAll() {
        List<Discount> result = discountRepository.findAll();
        return result;
    }
    /**
     * Получение дисконта по ID
     * @param id ID дисконта
     * @return дисконт по ID
     */
    public Optional<Discount> findById(Long id) {
        Optional<Discount> result = discountRepository.findById(id);
        return result;
    }
    /**
     * Обновление информации о дисконте по его ID
     * @param discount дисконт
     * @param id ID дисконта
     */
    public boolean update(Discount discount, Long id) {
        discount.setDiscountId(id);
        discountRepository.save(discount);
        return true;
    }
}
