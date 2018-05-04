package app.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "DSLR")
public class DSLRCamera extends BasicCamera {

    @Column(name = "max_shutter_speed")
    private int maxShutterSpeed;

    public DSLRCamera() {
    }

    public DSLRCamera(int maxShutterSpeed) {
        super();
        this.maxShutterSpeed = maxShutterSpeed;
    }

    public int getMaxShutterSpeed() {
        return this.maxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    @Override
    public String type() {
        return "DSLR";
    }
}
