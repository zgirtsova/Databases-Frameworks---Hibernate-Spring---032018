package ex.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "cameras")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "camera_type")
public abstract class BasicCamera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "make", nullable = false)
    private String make;

    // коментарите тук не са свързани с валидатора, а с constraint-ите в самата база
    // ако гърми, ще е на ниво база
    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "is_full_frame")
    private boolean isFullFrame;

    @Min(100)
    @Column(name = "min_iso", nullable = false)
    private int minISO;

    @Column(name = "max_iso")
    private int maxISO;

    @OneToMany(mappedBy = "primaryCamera")
    private Set<Photographer> primaryPhotographer;


    //трябва да са fetchType.LAZY
    @OneToMany(mappedBy = "secondaryCamera")
    private Set<Photographer> secondaryPhotographer;

    //неимплементиран тип, ще го импл в класовете, които extend-ват BasicCamera
    //трябва ни, за да вземем типа на камерата
    protected abstract String type();

    protected BasicCamera() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isFullFrame() {
        return isFullFrame;
    }

    public void setFullFrame(boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public int getMinISO() {
        return minISO;
    }

    public void setMinISO(int minISO) {
        this.minISO = minISO;
    }

    public int getMaxISO() {
        return maxISO;
    }

    public void setMaxISO(int maxISO) {
        this.maxISO = maxISO;
    }

    public Set<Photographer> getPrimaryPhotographer() {
        return primaryPhotographer;
    }

    public void setPrimaryPhotographer(Set<Photographer> primaryPhotographer) {
        this.primaryPhotographer = primaryPhotographer;
    }

    public Set<Photographer> getSecondaryPhotographer() {
        return secondaryPhotographer;
    }

    public void setSecondaryPhotographer(Set<Photographer> secondaryPhotographer) {
        this.secondaryPhotographer = secondaryPhotographer;
    }

}
