package ex.model.entities;

import org.hibernate.annotations.CollectionId;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//пишем Entity навсякъде, където имаме таблица
@Entity
@DiscriminatorValue(value = "DSLR")
public class DSLRCamera extends BasicCamera {

    @Column(name = "max_shutter_speed")
    private int maxShutterSpeed;


    @Override
    protected String type() {
        return "DSLR";
    }

    //празен конструктор, той ни взима конструктора от супер, от BasicCamera-та
    public DSLRCamera() {
    }

    //трябва да ни създаде основните неща от супер и после неговите си неща
    public DSLRCamera(int maxShutterSpeed) {
        super();
        this.maxShutterSpeed = maxShutterSpeed;
    }

    // без getter/setter методите не работи ModelMapper-а
    public int getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

}
