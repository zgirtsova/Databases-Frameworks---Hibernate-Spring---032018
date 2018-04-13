package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "nettle")
@PrimaryKeyJoinColumn(name = "id")
public class Nettle extends BasicIngredient{

    public Nettle() {
        super("Nettle", BigDecimal.valueOf(4.23));
    }
}
