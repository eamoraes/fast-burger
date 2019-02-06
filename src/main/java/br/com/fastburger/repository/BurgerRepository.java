package br.com.fastburger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fastburger.model.Burger;

@Repository
public interface BurgerRepository extends JpaRepository<Burger, Long> {
	
}
