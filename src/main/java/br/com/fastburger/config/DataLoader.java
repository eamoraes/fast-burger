package br.com.fastburger.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fastburger.model.Burger;
import br.com.fastburger.model.Ingredient;
import br.com.fastburger.repository.BurgerRepository;
import br.com.fastburger.repository.IngredientRepository;

@Configuration
public class DataLoader implements CommandLineRunner {

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private BurgerRepository burgerRepository;

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
		
		
		this.ingredientRepository.saveAll(Arrays.asList(alface, bacon, 
				hamburguer, ovo, queijo));
	}
	
	private void addBurgers() {
		
		Burger xBacon = new Burger("X-Bacon", Arrays.asList(
				ingredientRepository.findByName("Bacon"),
				ingredientRepository.findByName("Hambúrguer de carne"),
				ingredientRepository.findByName("Queijo")
				));

		Burger xBurger = new Burger("X-Burger", Arrays.asList(
				ingredientRepository.findByName("Hambúrguer de carne"),
				ingredientRepository.findByName("Queijo")
				));
		
		Burger xEgg = new Burger("X-Egg", Arrays.asList(
				ingredientRepository.findByName("Ovo"),
				ingredientRepository.findByName("Hambúrguer de carne"),
				ingredientRepository.findByName("Queijo")
				));
		
		Burger xEggBacon = new Burger("X-Egg Bacon", Arrays.asList(
				ingredientRepository.findByName("Ovo"),
				ingredientRepository.findByName("Bacon"),
				ingredientRepository.findByName("Hambúrguer de carne"),
				ingredientRepository.findByName("Queijo")
				));
		
		this.burgerRepository.saveAll(Arrays.asList(xBacon, xBurger, xEgg, xEggBacon));
	}


}
