package com.coursework.repositories;

import com.coursework.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    /**
     * Запрос для нахождения клиентов по ID абонемента
     * @param id ID абонемента
     * @return список клиентов с определенным ID абонемента
     */
    @Query(nativeQuery = true, value = "select * from Client where abonement_id = :id")
    List<Client> findByAbonementId(@Param("id") Long id);

    /**
     * Запрос для нахождения клиентов по ID сеанса группового занятия, на которое клиенты записаны
     * @param id ID сеанса
     * @return список клиентов, записанных на определенный сеанс группового занятия
     */
    @Query(nativeQuery = true, value = "select * from Client where client_id in (select client_id from sign_up where session_id = :id)")
    List<Client> findBySignUpId(@Param("id") Long id);

}
