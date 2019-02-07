package br.com.fastburger.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="burgers")
public class Burger extends EntityBase<Long> {
	
	private static final long serialVersionUID = 2151810644301858413L;

	private String name;
	
	private BigDecimal totalValue;

	@ManyToMany
	@JoinColumn(name = "ingredient_id")
	private List<Ingredient> ingredients;
	
	public Burger() {

	}
	
	public Burger(String name, List<Ingredient> ingredients) {
		super();
		this.name = name;
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		if (this.ingredients == null) {
			this.ingredients = new ArrayList<>();
		}
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		if (this.ingredients == null) {
			this.ingredients = new ArrayList<>();
		}
		this.ingredients = ingredients;
	}
	
	public void addIngredients(Ingredient ingredient) {
		if (this.ingredients == null) {
			this.ingredients = new ArrayList<>();
		}
		this.ingredients.add(ingredient);
	}

	public boolean hasIngredients() {
		return this.ingredients != null && this.ingredients.size() > 0;
	}
	
	public BigDecimal getTotalValue() {
		return totalValue;
	}
	
	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "Burger [id=" + getId() + ", name=" + name + ", totalValue=" + totalValue + ", ingredients="
				+ ingredients + "]";
	}

}
