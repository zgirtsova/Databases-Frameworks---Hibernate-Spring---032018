package org.softuni.mostwanted.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "races")
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "INT NOT NULL DEFAULT 0")
    private Integer laps;

    @ManyToOne
    private District district;

    @OneToMany(mappedBy = "race")
    private Set<RaceEntry> entries = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
