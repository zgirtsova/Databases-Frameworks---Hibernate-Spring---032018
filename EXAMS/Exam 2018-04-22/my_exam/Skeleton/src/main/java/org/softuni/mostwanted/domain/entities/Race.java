package org.softuni.mostwanted.domain.entities;


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "races")
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "laps", nullable = false, columnDefinition = "int default 0")
    private Integer laps = 0;

    @ManyToOne
    @JoinColumn(name = "district")
    private District district;

    @OneToMany(mappedBy = "race")
            //, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RaceEntry> entries;

    public Race() {
    }

    public Race(Integer laps, District district, Set<RaceEntry> entries ) {
        this.laps = laps;
        this.district = district;
        this.entries = entries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Set<RaceEntry> getEntries() {
        return entries;
    }

    public void setEntries(Set<RaceEntry> entries) {
        this.entries = entries;
    }
}
