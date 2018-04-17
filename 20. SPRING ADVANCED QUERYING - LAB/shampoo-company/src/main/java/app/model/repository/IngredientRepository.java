package app.model.repository;

import app.model.ingredients.BasicIngredient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends IngredientBaseRepository {

    Set<BasicIngredient> findAllByNameStartingWith(String name);
}
