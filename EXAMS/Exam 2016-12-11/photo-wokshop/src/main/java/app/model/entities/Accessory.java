package app.model.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accessories")
public class Accessory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Photographer.class)
    @JoinColumn(name = "owner_id")
    private Photographer owner;

    public Accessory() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photographer getOwner() {
        return this.owner;
    }

    public void setOwner(Photographer photographer) {
        this.owner = photographer;
    }
}
