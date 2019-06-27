package com.projetperso.app.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SportType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "sportType")
    private List<SportEvents> sportEventsList;

    public SportType() {
    }

    public SportType(String name) {
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
