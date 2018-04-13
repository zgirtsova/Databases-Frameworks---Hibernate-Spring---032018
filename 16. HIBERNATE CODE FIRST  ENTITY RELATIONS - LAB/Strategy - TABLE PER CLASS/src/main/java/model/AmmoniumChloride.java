package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ammonium_chloride")
public class AmmoniumChloride extends BasicChemicalIngredient {

    public AmmoniumChloride() {
        super("Ammonium Chloride", BigDecimal.valueOf(5.12), "NH4Cl");
    }
}
