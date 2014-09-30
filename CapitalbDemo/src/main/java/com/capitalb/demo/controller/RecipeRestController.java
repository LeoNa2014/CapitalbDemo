package com.capitalb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capitalb.demo.model.Recipe;
import com.capitalb.demo.service.RecipeService;

/**
 * Handles restful requests for Recipes
 * 
 * @author Leo Na
 */
@Controller
@RequestMapping(value="/rest/recipe")
public class RecipeRestController {

	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value="/all",  method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Recipe> listAllRecipes(){
        return recipeService.getAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Recipe getRecipeById( @PathVariable("id") Long id ) {
        return recipeService.getById( id );
    }
}
