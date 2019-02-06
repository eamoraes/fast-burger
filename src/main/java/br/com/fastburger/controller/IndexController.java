package br.com.fastburger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fastburger.model.Burger;
import br.com.fastburger.model.Ingredient;
import br.com.fastburger.repository.BurgerRepository;
import br.com.fastburger.repository.IngredientRepository;

@RestController
@RequestMapping("/api")
public class IndexController {
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	BurgerRepository burgerRepository;

	@GetMapping
	public void index() {
		System.out.println("Teste");
		
		List<Ingredient> ingredients = ingredientRepository.findAll();
		
		//for (Ingredient ingredient : ingredients) {
		//	System.out.println(ingredient);
		//}
		
		ingredients.forEach(i -> System.out.println(i));
		
		List<Burger> burgers = burgerRepository.findAll();
		
		burgers.forEach(System.out::println);
	}
}
