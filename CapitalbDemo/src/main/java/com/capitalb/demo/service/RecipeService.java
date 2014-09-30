package com.capitalb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capitalb.demo.model.Recipe;
import com.capitalb.demo.repository.RecipeDAO;

/**
 * Recipe Business Object
 * 
 * Please Note: {@link @Transactional} could be marked in service layer 
 * to control propagation level, which will override the transaction 
 * propagation in DAO layer
 * 
 * @author Leo Na
 */
@Service
public class RecipeService {

	@Autowired
	private RecipeDAO recipeDAO;

	public List<Recipe> getAll() {
		return recipeDAO.getAll();
	}

	public Recipe getById( Long id ) {
		return recipeDAO.getById( id );
	}

	@Transactional(readOnly=false)
	public void register( Recipe recipe) {
		recipeDAO.register( recipe );
	}

	@Transactional(readOnly=false)
	public void remove( Recipe recipe ) {
		recipeDAO.remove( recipe.getId() );
	}

	@Transactional(readOnly=false)
	public void remove( Long id ) {
		recipeDAO.remove( id );
	}
}
