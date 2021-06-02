package com.coursework.repositories;

import com.coursework.entities.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SignUpRepository extends JpaRepository<SignUp, Long> {
    /**
     * Запрос для нахождения всех записей клиента по его ID на сеансы
     * @param id ID клиента
     * @return Список сеансов по ID клиента
     */
    @Query(nativeQuery = true, value = "select * from sign_up where client_id = :id")
    List<SignUp> findSignUpsByClientId(@Param("id") Long id);

}
