package com.capitalb.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Ingredient
 * @author Leo Na
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="Ingredient")
@TableGenerator( 
		name = "IngredientIdGenerator",
		table = "sequence_table",
		pkColumnName = "generatorName",
		pkColumnValue = "IngredientIdGenerator",
		valueColumnName = "generatorValue",
		initialValue = 100001,
		allocationSize = 1 
	)
public class Ingredient implements Serializable {

	private static final long serialVersionUID = 1695076438554922869L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="IngredientIdGenerator")
	private Long id;

	@Column(nullable = false, unique=true)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
