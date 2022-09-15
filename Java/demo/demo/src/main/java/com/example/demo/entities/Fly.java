package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flys")
public class Fly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // unique id per Fly
    private String company;
    // private String from;
    // private String destination;
    
    private LocalDateTime localDateTimeOfTheFly;
    private Integer numberOfPlaces;
    private boolean postporned; // was the Fly consumed or was postporned
    private LocalDateTime nextDepartPrograme; // next date of the fly if postporneed


    

    public Fly(Long id, String company, LocalDateTime localDateTimeOfTheFly, Integer numberOfPlaces, boolean postporned,
            LocalDateTime nextDepartPrograme) {
        this.id = id;
        this.company = company;
        this.localDateTimeOfTheFly = localDateTimeOfTheFly;
        this.numberOfPlaces = numberOfPlaces;
        this.postporned = postporned;
        this.nextDepartPrograme = nextDepartPrograme;
    }

    @OneToOne
    @JoinColumn(name = "id_from")
    private From from;

    @OneToOne
    @JoinColumn(name = "id_to")
    private To to;

    @ManyToMany(mappedBy = "zboruriPerUser", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> calatoriAiZborului;




 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // public String getDestination() {
    //     return destination;
    // }

    // public void setDestination(String destination) {
    //     this.destination = destination;
    // }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getLocalDateTimeOfTheFly() {
        return localDateTimeOfTheFly;
    }

    public void setLocalDateTimeOfTheFly(LocalDateTime localDateTimeOfTheFly) {
        this.localDateTimeOfTheFly = localDateTimeOfTheFly;
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(Integer numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public boolean isPostporned() {
        return postporned;
    }

    public void setPostporned(boolean postporned) {
        this.postporned = postporned;
    }

    // public String getFrom() {
    //     return from;
    // }

    // public void setFrom(String from) {
    //     this.from = from;
    // }

    public LocalDateTime getNextDepartPrograme() {
        return nextDepartPrograme;
    }

    public void setNextDepartPrograme(LocalDateTime nextDepartPrograme) {
        this.nextDepartPrograme = nextDepartPrograme;
    }




}