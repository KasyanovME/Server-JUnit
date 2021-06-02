package com.coursework.services;

import com.coursework.entities.Trainer;
import com.coursework.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;
    /**
     * Создание тренера
     * @param trainer тренер
     * @return созданный тренер
     */
    public Trainer create(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    /**
     * Удаление тренера по его ID
     * @param id ID тренера
     */
    public boolean delete(Long id) {
        trainerRepository.deleteById(id);
        return true;
    }
    /**
     * Получение списка всех тренеров
     * @return список тренеров
     */
    public List<Trainer> findAll() {
        List<Trainer> result = trainerRepository.findAll();
        return result;
    }
    /**
     * Получение тренера по его ID
     * @param id ID тренера
     * @return тренер по ID
     */
    public Optional<Trainer> findById(Long id) {
        Optional<Trainer> result = trainerRepository.findById(id);
        return result;
    }
    /**
     * Обновление информации о тренере по ID тренера
     * @param trainer тренер
     * @param id ID тренера
     */
    public boolean update(Trainer trainer, Long id) {
        trainer.setTrainerId(id);
        trainerRepository.save(trainer);
        return true;
    }
}
