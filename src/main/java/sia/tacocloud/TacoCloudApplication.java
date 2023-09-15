package sia.tacocloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.data.IngredientRepository;
import sia.tacocloud.Ingredient.Type;
import sia.tacocloud.data.TacoRepository;
import sia.tacocloud.data.UserRepository;

import java.util.Arrays;

// This is essentially boilerplate to run the application
@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(
			IngredientRepository ingredientRepository,
			TacoRepository tacoRepository,
			UserRepository userRepository,
			PasswordEncoder passwordEncoder
	) {
		return args -> {
			Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
			Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
			Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
			Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
			Ingredient dicedTomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
			Ingredient lettuce = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
			Ingredient cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
			Ingredient monterreyJack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
			Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
			Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);

			ingredientRepository.save(flourTortilla);
			ingredientRepository.save(cornTortilla);
			ingredientRepository.save(groundBeef);
			ingredientRepository.save(carnitas);
			ingredientRepository.save(dicedTomatoes);
			ingredientRepository.save(lettuce);
			ingredientRepository.save(cheddar);
			ingredientRepository.save(monterreyJack);
			ingredientRepository.save(salsa);
			ingredientRepository.save(sourCream);

			Taco taco1 = new Taco();
			taco1.setName("Sheer Heart Attack");
			taco1.setIngredients(Arrays.asList(flourTortilla, groundBeef, carnitas, cheddar, monterreyJack, sourCream));
			tacoRepository.save(taco1);


			Taco taco2 = new Taco();
			taco2.setName("c h e e s e");
			taco2.setIngredients(Arrays.asList(cornTortilla, cheddar, monterreyJack));
			tacoRepository.save(taco2);

			Taco taco3 = new Taco();
			taco3.setName("Vegan");
			taco3.setIngredients(Arrays.asList(cornTortilla, dicedTomatoes, lettuce, salsa, sourCream));
			tacoRepository.save(taco3);

			User developer = new User("dev", passwordEncoder.encode("123"), "Bani Somo", "b", "b", "b", "b", "905");
			userRepository.save(developer);
		};
	}
}
