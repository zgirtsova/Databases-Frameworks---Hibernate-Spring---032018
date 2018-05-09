package org.softuni.mostwanted.domain.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "race_entries")
public class RaceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hasFinished")
    private boolean hasFinished;

    @Column(name = "finishTime")
    private int finishTime;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "racer_id")
    private Racer racer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Race race;

    public RaceEntry() {
    }

    public RaceEntry(boolean hasFinished, int finishTime, Car car, Racer racer) {
        this.hasFinished = hasFinished;
        this.finishTime = finishTime;
        this.car = car;
        this.racer = racer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }

//    public Race getRace() {
//        return race;
//    }

//    public void setRace(Race race) {
//        this.race = race;
//    }
}
