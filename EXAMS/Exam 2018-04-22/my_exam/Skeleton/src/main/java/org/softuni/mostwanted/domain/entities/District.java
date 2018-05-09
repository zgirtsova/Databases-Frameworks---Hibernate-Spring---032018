package org.softuni.mostwanted.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "districts")
public class District implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;


    //в Race има foreign key към този field
    @OneToMany(mappedBy = "district")
    private Set<Race> raceSet;

    public District() {
    }

    public District(String name, Town town) {
        this.name = name;
        this.town = town;
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

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
