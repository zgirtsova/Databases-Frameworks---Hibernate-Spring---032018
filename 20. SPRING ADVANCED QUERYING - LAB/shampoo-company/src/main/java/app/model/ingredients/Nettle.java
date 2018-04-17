package app.model.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "NT")
public class Nettle extends BasicIngredient{

    public Nettle() {
        super("Nettle", BigDecimal.valueOf(4.23));
    }
}
