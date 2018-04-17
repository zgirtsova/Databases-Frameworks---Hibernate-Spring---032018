package app.model.repository;

import app.model.ingredients.BasicIngredient;
import app.model.ingredients.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IngredientBaseRepository extends JpaRepository<BasicIngredient, Long>{

}
