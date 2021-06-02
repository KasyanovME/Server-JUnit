package com.coursework.services;

import com.coursework.entities.Equipment;
import com.coursework.repositories.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;
    /**
     * Создание оборудования
     * @param equipment оборудование
     * @return созданное оборудование
     */
    public Equipment create(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }
    /**
     * Удаление оборудования по ID
     * @param id Id оборудования
     */
    public boolean delete(Long id) {
        equipmentRepository.deleteById(id);
        return true;
    }
    /**
     * Получение списка всех оборудований
     * @return список оборудований
     */
    public List<Equipment> findAll() {
        List<Equipment> result = equipmentRepository.findAll();
        return result;
    }
    /**
     * Получение оборудования по ID
     * @param id ID оборудования
     * @return оборудование по ID
     */
    public Optional<Equipment> findById(Long id) {
        Optional<Equipment> result = equipmentRepository.findById(id);
        return result;
    }
    /**
     * Обновление информации об оборудовании по его ID
     * @param equipment оборудование
     * @param id ID оборудования
     */
    public boolean update(Equipment equipment, Long id) {
        equipment.setEquipmentId(id);
        equipmentRepository.save(equipment);
        return true;
    }
}
