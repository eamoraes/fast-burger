package br.com.fastburger.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class EntityBase<T> implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private T id;
	
	public EntityBase() {

	}

	public EntityBase(T id) {
		super();
		this.id = id;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
}
