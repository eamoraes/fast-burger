package br.com.fastburger.service;

import org.springframework.stereotype.Service;

import br.com.fastburger.model.Burger;
import br.com.fastburger.service.base.CrudService;

@Service
public class BurgerService extends CrudService<Burger, Long> {
	
}
