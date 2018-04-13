package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "AmmonChl")
public class AmmoniumChloride extends BasicChemicalIngredient {

    public AmmoniumChloride() {
        super("Ammonium Chloride", BigDecimal.valueOf(5.12), "NH4Cl");
    }
}
