package com.coursework.services;

import com.coursework.entities.SignUp;
import com.coursework.repositories.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpService {

    @Autowired
    private SignUpRepository signUpRepository;
    /**
     * Получение списка сеансов по ID клиента
     * @param id клиента
     * @return список сеансов по ID клиента
     */
    public List<SignUp> findSignUpsByClientId(Long id) {
        List<SignUp> result = signUpRepository.findSignUpsByClientId(id);
        return result;
    }
    /**
     * Создание записи на сеанс
     * @param signUp запись на сеанс
     * @return создана запись на сеанс
     */
    public SignUp create(SignUp signUp) {
        return signUpRepository.save(signUp);
    }
}
