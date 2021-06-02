package com.coursework.services;

import com.coursework.entities.Abonement;
import com.coursework.repositories.AbonementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbonementService {

    @Autowired
    private AbonementRepository abonementRepository;

    /**
     * Создание абонемента
     *
     * @param abonement абонемент
     * @return созданный абонемент
     */
    public Abonement create(Abonement abonement) {
        return abonementRepository.save(abonement);
    }

    /**
     * Удаление абонемента по его ID
     *
     * @param id ID абонемента
     */
    public boolean delete(Long id) {
        abonementRepository.deleteById(id);
        return true;
    }

    /**
     * Получение списка всех абонементов
     *
     * @return список абонементов
     */
    public List<Abonement> findAll() {
        List<Abonement> result = abonementRepository.findAll();
        return result;
    }

    /**
     * Получение абонемента по его ID
     *
     * @param id ID абонемента
     * @return абонемент по ID
     */
    public Optional<Abonement> findById(Long id) {
        Optional<Abonement> result = abonementRepository.findById(id);
        return result;
    }

    /**
     * Обновление информации об абонементе по ID абонемента
     *
     * @param abonement абонемент
     * @param id        ID абонемента
     */
    public boolean update(Abonement abonement, Long id) {
        abonement.setAbonementId(id);
        abonementRepository.save(abonement);
        return true;
    }
}
