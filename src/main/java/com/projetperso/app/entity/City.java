package com.projetperso.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class City implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "city")
    private List<SportEvents> sportEventsList;


    public City() {
    }

    public City(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SportEvents> getSportEventsList() {
       return sportEventsList;
   }

     public void setSportEventsList(List<SportEvents> sportEventsList) {
       this.sportEventsList = sportEventsList;
   }
}
