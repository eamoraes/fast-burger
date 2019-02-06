package br.com.fastburger.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fastburger.model.Ingredient;
import br.com.fastburger.response.Response;
import br.com.fastburger.service.base.CrudService;
import br.com.fastburger.utils.ControllerConstants;

@RestController
@RequestMapping(ControllerConstants.INGREDIENT_PATH)
public class IngredientController {
	
	@Autowired
	private CrudService<Ingredient, Long> service;
	
	@GetMapping
	public ResponseEntity<Response<List<Ingredient>>> findAll() {
		return ResponseEntity.ok(Response.success(service.findAll()));
	}
	
	@PostMapping
	public ResponseEntity<Response<Ingredient>> create(@RequestBody Ingredient entity) {
		entity = service.create(entity);
		return ResponseEntity.created(URI.create(ControllerConstants.INGREDIENT_PATH + "/" + entity.getId())).body(Response.success(service.create(entity)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<Ingredient>> update(@PathVariable Long id, @RequestBody Ingredient entity) throws Exception {
		return ResponseEntity.ok(Response.success(service.update(entity, id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Ingredient>> delete(@PathVariable Long id) {
		Optional<Ingredient> entity = service.delete(id);
		if (!entity.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response.error("commons.message.notFound"));
		}
		return ResponseEntity.ok(Response.success(entity.get()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Ingredient>> findOne(@PathVariable Long id) {
		Optional<Ingredient> entity = service.findById(id);
		if (!entity.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response.error("commons.message.notFound"));
		}
		return ResponseEntity.ok(Response.success(entity.get()));
	}	
}
