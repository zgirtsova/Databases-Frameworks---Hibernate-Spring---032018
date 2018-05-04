package app.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cameras")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "camera_type")
public abstract class BasicCamera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "make")
    private String make;

    @NotNull
    @Column(name = "domain")
    private String model;

    @Column(name = "is_full_frame")
    private boolean isFullFrame;

    @NotNull
    @Min(100)
    @Column(name = "min_iso")
    private int minISO;

    @Column(name = "max_iso")
    private int maxISO;

    @OneToMany(mappedBy = "camera")
    private Set<Lens> lensSet;

    @OneToMany(mappedBy = "primaryCamera")
    private Set<Photographer> photographerSet;

    protected abstract String type();

    public BasicCamera() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean getIsFullFrame(){
        return this.isFullFrame;
    }

    public void setIsFullFrame(boolean isFullFrame){
        this.isFullFrame = isFullFrame;
    }

    public int getMinISO() {
        return this.minISO;
    }

    public void setMinISO(int minISO) {
        this.minISO = minISO;
    }

    public int getMaxISO() {
        return this.maxISO;
    }

    public void setMaxISO(int maxISO) {
        this.maxISO = maxISO;
    }

    public Set<Lens> getLensSet() {
        return lensSet;
    }

    public void setLensSet(Set<Lens> lensSet) {
        this.lensSet = lensSet;
    }
}
