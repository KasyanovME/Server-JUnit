package com.coursework.services;

import com.coursework.entities.Session;
import com.coursework.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    /**
     * Создание сеанса
     * @param session сеанс
     * @return созданный сеанс
     */
    public Session create(Session session) {
        return sessionRepository.save(session);
    }
    /**
     * Удаление сеанса по ID
     * @param id ID сеанса
     */
    public boolean delete(Long id) {
        sessionRepository.deleteById(id);
        return true;
    }
    /**
     * Получение списка всех сеансов
     * @return список сеансов
     */
    public List<Session> findAll() {
        List<Session> result = sessionRepository.findAll();
        return result;
    }
    /**
     * Получение списка сеансов по ID тренера
     * @param id ID тренера
     * @return список сеансов по ID тренера
     */
    public List<Session> findByTrainerId(Long id) {
        List<Session> result = sessionRepository.findByTrainerId(id);
        return result;
    }
    /**
     * Получение списка сеансов по ID активити
     * @param id ID активити
     * @return список сеансов по ID активити
     */
    public List<Session> findByActivityId(Long id) {
        List<Session> result = sessionRepository.findByActivityId(id);
        return result;
    }
    /**
     * Получение сеанса по его ID
     * @param id ID сеанса
     * @return сеанс по ID
     */
    public Optional<Session> findById(Long id) {
        Optional<Session> result = sessionRepository.findById(id);
        return result;
    }
    /**
     * Обновление информации о сеансе по ID сеанса
     * @param session сеанс
     * @param id ID сеанса
     */
    public boolean update(Session session, Long id) {
        session.setSessionId(id);
        sessionRepository.save(session);
        return true;
    }
}
