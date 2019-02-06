package br.com.fastburger.service;

import org.springframework.stereotype.Service;

import br.com.fastburger.model.Ingredient;
import br.com.fastburger.service.base.CrudService;

@Service
public class IngredientService extends CrudService<Ingredient, Long> {

}
