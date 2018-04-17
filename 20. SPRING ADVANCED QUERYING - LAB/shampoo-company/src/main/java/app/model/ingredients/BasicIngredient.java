package app.model.ingredients;

import app.model.shampoos.BasicShampoo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ingredients_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient implements Ingredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(mappedBy = "ingredients",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<BasicShampoo> shampoos;

    public BasicIngredient(){};
    public BasicIngredient(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public List<BasicShampoo> getShampoos() {
        return this.shampoos;
    }

    @Override
    public void setShampoos(List<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }

    @Override
    public String toString() {
        return "BasicIngredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                //", shampoos=" + shampoos +
                '}';
    }

    // Getters and setters


}
