package com.coursework.services;

import com.coursework.entities.Club;
import com.coursework.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;
    /**
     * Получение общей информации о клубе
     * @return информация о клубе
     */
    public Optional<Club> getClubInfo() {
        return clubRepository.findById(1L);
    }
    /**
     * Обновление информации о клубе
     * @param club клуб
     */
    public boolean updateClubInfo(Club club) {
        club.setClubId(1L);
        clubRepository.save(club);
        return true;
    }
}
