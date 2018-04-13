package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "mint")
public class Mint extends BasicIngredient{

    public Mint() {
        super("Mint", BigDecimal.valueOf(2.34));
    }
}
