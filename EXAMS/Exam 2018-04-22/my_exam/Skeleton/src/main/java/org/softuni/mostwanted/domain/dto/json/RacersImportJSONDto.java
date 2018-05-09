package org.softuni.mostwanted.domain.dto.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Town;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

public class RacersImportJSONDto implements Serializable {


    @Expose
    private String name;

    @Expose
    private Integer age;

    @Expose
    private Float bounty;

    @Expose
    @SerializedName(value = "homeTown")
    private String homeTown;

    public RacersImportJSONDto() {
    }

    public RacersImportJSONDto(String name, Integer age, Float bounty, String homeTown) {
        this.name = name;
        this.age = age;
        this.bounty = bounty;
        this.homeTown = homeTown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getBounty() {
        return bounty;
    }

    public void setBounty(Float bounty) {
        this.bounty = bounty;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
}
