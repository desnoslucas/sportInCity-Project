package com.projetperso.app.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class SportEvents implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name;

    private String description;

    private Float price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_fk")
    private City city;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sportType_fk")
    private SportType sportType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "months_fk")
    private Months months;

    public String pictureName;


    public SportEvents() {
    }


    public SportEvents(Long id, String name, String description, Float price, City city, SportType sportType, Months months, String pictureName) {
        this.id = id;
        Name = name;
        this.description = description;
        this.price = price;
        this.city = city;
        this.sportType = sportType;
        this.months = months;
        this.pictureName = pictureName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public Months getMonths() {
        return months;
    }

    public void setMonths(Months months) {
        this.months = months;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    @Override
    public String toString() {
        return "SportEvents{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", city=" + city +
                ", sportType=" + sportType +
                ", months=" + months +
                ", pictureName='" + pictureName + '\'' +
                '}';
    }
}
