package com.capitalb.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capitalb.demo.model.Recipe;

@Repository
@Transactional
public class RecipeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Recipe> getAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Recipe> criteria = cb.createQuery( Recipe.class );
		Root<Recipe> recipe = criteria.from( Recipe.class );
		criteria.select( recipe ).orderBy( cb.asc( recipe.get( "name" ) ) );
		return entityManager.createQuery( criteria ).getResultList();
	}

	public Recipe getById( Long id ) {
		return entityManager.find ( Recipe.class, id );
	}
	
	public void register( Recipe recipe) {
		entityManager.persist( recipe );
        return;
    }
}
