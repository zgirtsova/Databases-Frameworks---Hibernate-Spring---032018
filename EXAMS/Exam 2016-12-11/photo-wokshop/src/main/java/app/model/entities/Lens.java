package app.model.entities;

import javafx.scene.Camera;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "lenses")
public class Lens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "make")
    private String make;

    @Column(name = "focal_length")
    private int focalLength;

    @Column(name = "max_aperture", precision = 1)
    private BigDecimal maxAperture;

    @Column(name = "compatible_make")
    private String compatibleMake;


    //same as above
    @ManyToOne(targetEntity = BasicCamera.class)
    @JoinColumn(name = "camera_id")
    private BasicCamera camera;

    private String cameraMake;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Photographer owner;


    public Lens() {
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

    public int getFocalLength() {
        return this.focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public BigDecimal getMaxAperture() {
        return this.maxAperture;
    }

    public void setMaxAperture(BigDecimal maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleMake() {
        return this.compatibleMake;
    }

    public void setCompatibleMake(String compatibleMake) {
        this.compatibleMake = compatibleMake;
    }

    public Photographer getOwner() {
        return this.owner;
    }

    public void setOwner(Photographer photographer) {
        this.owner = photographer;
    }

    public BasicCamera getCamera() {
        return camera;
    }

    public void setCamera(BasicCamera camera) {
        this.camera = camera;
    }

    public String getCameraMake() {
        return this.camera.getMake();
    }

    public void setCameraMake(String cameraMake) {
        this.cameraMake = cameraMake;
    }
}
