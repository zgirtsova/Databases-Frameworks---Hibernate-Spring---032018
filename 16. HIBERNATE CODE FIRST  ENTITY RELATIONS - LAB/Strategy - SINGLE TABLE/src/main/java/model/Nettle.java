package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Nettle")
public class Nettle extends BasicIngredient{

    public Nettle() {
        super("Nettle", BigDecimal.valueOf(4.23));
    }
}
