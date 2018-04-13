package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "Mint")
public class Mint extends BasicIngredient{

    public Mint() {
        super("Mint", BigDecimal.valueOf(2.34));
    }
}
