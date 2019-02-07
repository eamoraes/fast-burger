package br.com.fastburger.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fastburger.model.Burger;
import br.com.fastburger.model.Ingredient;
import br.com.fastburger.service.BurgerService;
import br.com.fastburger.service.IngredientService;

@Configuration
public class DataLoader implements CommandLineRunner {

	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private BurgerService burgerService;

	/*
	public DataLoader(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}
	*/

	@Override
	public void run(String... args) throws Exception {
		addIngredients();
		addBurgers();
	}

	private void addIngredients() {
		Ingredient alface = new Ingredient("Alface", new BigDecimal("0.40"));
		Ingredient bacon = new Ingredient("Bacon", new BigDecimal("2.00"));
		Ingredient hamburguer = new Ingredient("Hambúrguer de carne", new BigDecimal("3.00"));
		Ingredient ovo = new Ingredient("Ovo", new BigDecimal("0.80"));
		Ingredient queijo = new Ingredient("Queijo", new BigDecimal("1.50"));
		
		
		this.ingredientService.saveAll(Arrays.asList(alface, bacon, 
				hamburguer, ovo, queijo));
	}
	
	private void addBurgers() {
		
		Burger xBacon = new Burger("X-Bacon", Arrays.asList(
				ingredientService.findByName("Bacon"),
				ingredientService.findByName("Hambúrguer de carne"),
				ingredientService.findByName("Queijo")
				));

		Burger xBurger = new Burger("X-Burger", Arrays.asList(
				ingredientService.findByName("Hambúrguer de carne"),
				ingredientService.findByName("Queijo")
				));
		
		Burger xEgg = new Burger("X-Egg", Arrays.asList(
				ingredientService.findByName("Ovo"),
				ingredientService.findByName("Hambúrguer de carne"),
				ingredientService.findByName("Queijo")
				));
		
		Burger xEggBacon = new Burger("X-Egg Bacon", Arrays.asList(
				ingredientService.findByName("Ovo"),
				ingredientService.findByName("Bacon"),
				ingredientService.findByName("Hambúrguer de carne"),
				ingredientService.findByName("Queijo")
				));
		
		this.burgerService.saveAll(Arrays.asList(xBacon, xBurger, xEgg, xEggBacon));
	}


}
