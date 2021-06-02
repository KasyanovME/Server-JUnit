package com.coursework.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 *  Класс Abonement
 */
@Data
@Entity
@NoArgsConstructor
public class Abonement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long abonementId;

    private String type;

    private Double cost;
    private String massageAccess;
    private String saunaAccess;

    @OneToMany(mappedBy = "abonement", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private Set<Client> clientsWithAbonement;

    public void setAbonementId(Long abonementId) {
        this.abonementId = abonementId;
    }

    public Long getAbonementId() {
        return abonementId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getMassageAccess() {
        return massageAccess;
    }

    public void setMassageAccess(String massageAccess) {
        this.massageAccess = massageAccess;
    }

    public String getSaunaAccess() {
        return saunaAccess;
    }

    public void setSaunaAccess(String saunaAccess) {
        this.saunaAccess = saunaAccess;
    }

    public Set<Client> getClientsWithAbonement() {
        return clientsWithAbonement;
    }

    public void setClientsWithAbonement(Set<Client> clientsWithAbonement) {
        this.clientsWithAbonement = clientsWithAbonement;
    }
}
