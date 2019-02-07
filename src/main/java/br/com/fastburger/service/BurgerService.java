package br.com.fastburger.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fastburger.model.Burger;
import br.com.fastburger.model.Ingredient;
import br.com.fastburger.service.base.CrudService;

@Service
public class BurgerService extends CrudService<Burger, Long> {

	@Autowired
	IngredientService ingredientService;

	@Override
	public Burger create(Burger burger) {
		burger.setTotalValue(new BigDecimal("0"));

		for (Ingredient ingredient : burger.getIngredients()) {
			burger.setTotalValue(burger.getTotalValue().add(ingredient.getValue()));
		}

		burger.setTotalValue(calcDiscount(burger));

		return super.create(burger);
	}

	@Override
	public Burger update(Burger burger, Long id) throws Exception {
		burger.setTotalValue(new BigDecimal("0"));

		for (Ingredient ingredient : burger.getIngredients()) {
			burger.setTotalValue(burger.getTotalValue().add(ingredient.getValue()));
		}

		burger.setTotalValue(calcDiscount(burger));

		return super.update(burger, id);
	}

	private BigDecimal calcDiscount(Burger burger) {
		BigDecimal newValue = burger.getTotalValue();

		Ingredient lettuce = ingredientService.findByName("Alface");
		Ingredient bacon = ingredientService.findByName("Bacon");
		Ingredient hamburguer = ingredientService.findByName("Hambúrguer de carne");
		Ingredient cheese = ingredientService.findByName("Queijo");

		// Map the key is the ingredient id and the value is
		// the number of each ingredient is present in the burger
		Map<Long, Integer> map = new TreeMap<>();
		for (Ingredient ingredient : burger.getIngredients()) {
			if (!map.containsKey(ingredient.getId())) {
				map.put(ingredient.getId(), 1);
			} else {
				map.replace(ingredient.getId(), map.get(ingredient.getId()) + 1);
			}
		}

		BigDecimal discount = new BigDecimal("0");

		// A lot of meat
		if (map.containsKey(hamburguer.getId())) {
			int x = map.get(hamburguer.getId()) / 3;
			if (x >= 1) {
				discount = hamburguer.getValue().multiply(new BigDecimal(x));
			}
			newValue = newValue.subtract(discount);
		}

		// A lot of cheese
		if (map.containsKey(cheese.getId())) {
			int x = map.get(cheese.getId()) / 3;
			if (x >= 1) {
				discount = cheese.getValue().multiply(new BigDecimal(x));
			}
			newValue = newValue.subtract(discount);
		}

		// Light
		if (map.containsKey(lettuce.getId()) && !map.containsKey(bacon.getId()))
			newValue = newValue.multiply(new BigDecimal("0.9"));

		return newValue;
	}

	public void saveAll(List<Burger> burgers) {
		for (Burger burger : burgers) {
			this.create(burger);
		}
	}
}
