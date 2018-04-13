package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "nettle")
public class Nettle extends BasicIngredient{

    public Nettle() {
        super("Nettle", BigDecimal.valueOf(4.23));
    }
}
