package sia.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.Ingredient;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

    public List<Ingredient> findByType(Ingredient.Type type);
}
