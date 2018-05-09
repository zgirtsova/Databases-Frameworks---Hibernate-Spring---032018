package org.softuni.mostwanted.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "racers")
public class Racer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "bounty")
    private Float bounty;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town homeTown;

    @OneToMany(mappedBy = "racer")
    private Set<Car> cars;

    public Racer() {
    }

    public Racer(String name, Integer age, Float bounty, Town homeTown, Set<Car> cars) {
        this.name = name;
        this.age = age;
        this.bounty = bounty;
        this.homeTown = homeTown;
        this.cars = cars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Town getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(Town homeTown) {
        this.homeTown = homeTown;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
