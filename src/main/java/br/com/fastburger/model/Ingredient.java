package br.com.fastburger.model;

import javax.persistence.Table;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
@Table(name="ingredients")
public class Ingredient extends EntityBase<Long>{
	
	private static final long serialVersionUID = -1817742344537790139L;

	private String name;
	
	private BigDecimal value;
	
	public Ingredient() {

	}

	public Ingredient(String name, BigDecimal value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + getId() + ", name=" + name + ", value=" + value + "]";
	}

}
