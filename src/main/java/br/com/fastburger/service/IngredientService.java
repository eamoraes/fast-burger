package br.com.fastburger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastburger.model.Ingredient;
import br.com.fastburger.repository.IngredientRepository;
import br.com.fastburger.service.base.CrudService;

@Service
public class IngredientService extends CrudService<Ingredient, Long> {
	@Autowired
	IngredientRepository ingredientRepository;
	
	public void saveAll(List<Ingredient> ingredients) {
		for (Ingredient ingredient : ingredients) {
			this.create(ingredient);
		}
	}

	public Ingredient findByName(String string) {
		return ingredientRepository.findByName(string);
	}

}
