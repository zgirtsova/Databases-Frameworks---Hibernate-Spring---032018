package app.model.ingredients;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "STRBR")
public class Strawberry extends BasicIngredient {

    public Strawberry() {
        super("Strawberry", BigDecimal.valueOf(0.22));
    }
}
