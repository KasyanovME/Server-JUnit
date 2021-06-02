package com.coursework.services;

import com.coursework.entities.Client;
import com.coursework.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    /**
     * Создание клиента
     * @param client клиент
     * @return созданный клиент
     */
    public Client create(Client client) {
        return clientRepository.save(client);
    }
    /**
     * Удаление клиента по ID
     * @param id ID клиента
     */
    public boolean delete(Long id) {
        clientRepository.deleteById(id);
        return true;
    }
    /**
     * Получение списка всех клиентов
     * @return список клиентов
     */
    public List<Client> findAll() {
        List<Client> result = clientRepository.findAll();
        return result;
    }
    /**
     * Получение списка клиентов, у которых определенный ID абонемента
     * @param id ID абонемента
     * @return список клиентов с определенным ID абонемента
     */
    public List<Client> findByAbonementId(Long id) {
        List<Client> result = clientRepository.findByAbonementId(id);
        return result;
    }
    /**
     * Получение списка клиентов по ID сеанса
     * @param id ID сеанса
     * @return Список клиентов по ID сеанса
     */
    public List<Client> findBySignUpId(Long id) {
        List<Client> result = clientRepository.findBySignUpId(id);
        return result;
    }
    /**
     * Получение клиента по его ID
     * @param id ID клиента
     * @return клиент по ID
     */
    public Optional<Client> findById(Long id) {
        Optional<Client> result = clientRepository.findById(id);
        return result;
    }
    /**
     * Обновление информации о клиенте по его ID
     * @param client клиент
     * @param id ID клиента
     */
    public boolean update(Client client, Long id) {
        client.setClientId(id);
        clientRepository.save(client);
        return true;
    }
}
