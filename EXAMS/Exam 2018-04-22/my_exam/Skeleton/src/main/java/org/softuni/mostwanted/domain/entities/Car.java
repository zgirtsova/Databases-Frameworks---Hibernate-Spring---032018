package org.softuni.mostwanted.domain.entities;


import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "yearOfProduction", nullable = false)
    private int yearOfProduction;

    @Column(name = "maxSpeed")
    private BigDecimal maxSpeed;

    @Column(name = "zeroToSixty ")
    private BigDecimal zeroToSixty;

    @ManyToOne
    @JoinColumn(name = "racer_id")
    private Racer racer;

    public Car() {
    }

    public Car(String brand, String model, BigDecimal price, int yearOfProduction, BigDecimal maxSpeed, BigDecimal
            zeroToSixty, Racer racer) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.yearOfProduction = yearOfProduction;
        this.maxSpeed = maxSpeed;
        this.zeroToSixty = zeroToSixty;
        this.racer = racer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public BigDecimal getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(BigDecimal maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public BigDecimal getZeroToSixty() {
        return zeroToSixty;
    }

    public void setZeroToSixty(BigDecimal zeroToSixty) {
        this.zeroToSixty = zeroToSixty;
    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }
}
