package org.softuni.mostwanted.domain.dto.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.softuni.mostwanted.domain.entities.Racer;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

public class CarsImportJSONDto implements Serializable {

    @Expose
    private String brand;

    @Expose
    private String model;

    @Expose
    private BigDecimal price;

    @Expose
    private int yearOfProduction;

    @Expose
    private BigDecimal maxSpeed;

    @Expose
    private BigDecimal zeroToSixty;

    @Expose
    @SerializedName("racerName")
    private String racer;

    public CarsImportJSONDto() {
    }

    public CarsImportJSONDto(String brand, String model, BigDecimal price, int yearOfProduction, BigDecimal maxSpeed, BigDecimal
            zeroToSixty, String racer) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.yearOfProduction = yearOfProduction;
        this.maxSpeed = maxSpeed;
        this.zeroToSixty = zeroToSixty;
        this.racer = racer;
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

    public String getRacer() {
        return racer;
    }

    public void setracer(String racer) {
        this.racer = racer;
    }
}
