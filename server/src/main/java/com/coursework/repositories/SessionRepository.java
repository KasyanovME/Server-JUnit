package com.coursework.repositories;

import com.coursework.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    /**
     * Запрос для нахождения сеансов по ID тренера
     * @param id ID тренера
     * @return Список сеансов по ID тренера
     */
    @Query(nativeQuery = true, value = "select * from session where trainer_id = :id")
    List<Session> findByTrainerId(@Param("id") Long id);

    /**
     * Запрос для нахождения сеансов по ID активити
     * @param id ID активити
     * @return Список сеансов  по ID активити
     */
    @Query(nativeQuery = true, value = "select * from session where activity_id = :id")
    List<Session> findByActivityId(@Param("id") Long id);

}
