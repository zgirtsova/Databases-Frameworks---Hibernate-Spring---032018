package ex.model.entities;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "lenses")
public class Lens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "focal_length")
    private int focalLength;

    @Column(name = "max_aperture", precision = 1) //scale - общо колко са цифрите
    private BigDecimal maxAperture;

    @Column(name = "make_compatible_with")
    private String makeCompatibleWith;

    //няма да бъде колона, само логически съществува
    //private String cameraMake;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Photographer owner;

    public Lens() {
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

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public BigDecimal getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(BigDecimal maxAperture) {
        this.maxAperture = maxAperture;
    }

    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }

    public String getMakeCompatibleWith() {
        return makeCompatibleWith;
    }

    public void setMakeCompatibleWith(String makeCompatibleWith) {
        this.makeCompatibleWith = makeCompatibleWith;
    }

    //    public String getCameraMake() {
//        return this.camera.getMake();
//    }
//
//    public void setCameraMake(String cameraMake) {
//        this.cameraMake = cameraMake;
//    }
}
