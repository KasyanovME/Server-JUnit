package com.coursework.services;

import com.coursework.entities.Activity;
import com.coursework.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    /**
     * Создание группового занятия (активити)
     * @param activity активити
     * @return созданный активити
     */
    public Activity create(Activity activity) {
        return activityRepository.save(activity);
    }
    /**
     * Удаление активити по его ID
     * @param id ID активити
     */
    public boolean delete(Long id) {
        activityRepository.deleteById(id);
        return true;
    }
    /**
     * Получение списка всех активити
     * @return список активити
     */
    public List<Activity> findAll() {
        List<Activity> result = activityRepository.findAll();
        return result;
    }
    /**
     * Получение активити по его ID
     * @param id ID активити
     * @return активити по ID
     */
    public Optional<Activity> findById(Long id) {
        Optional<Activity> result = activityRepository.findById(id);
        return result;
    }
    /**
     * Обновление информации об активити по ID активити
     * @param activity активити
     * @param id ID активити
     */
    public boolean update(Activity activity, Long id) {
        activity.setActivityId(id);
        activityRepository.save(activity);
        return true;
    }
}
