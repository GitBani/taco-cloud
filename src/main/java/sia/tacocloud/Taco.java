package sia.tacocloud;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Data
@Table
public class Taco {

    @Id
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 25, message = "Name must be 3-25 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<IngredientRef> ingredientRefs;
}
