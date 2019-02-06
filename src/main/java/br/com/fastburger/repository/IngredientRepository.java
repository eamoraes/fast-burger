package br.com.fastburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fastburger.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	Ingredient findByName(String string);

}
