package com.capitalb.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capitalb.demo.model.Recipe;
import com.capitalb.demo.service.RecipeService;

/**
 * Handles requests for Recipe management pages
 * 
 * @author Leo Na
 */
@Controller
@RequestMapping(value="/recipe")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value="/all",  method=RequestMethod.GET )
	public String displayAllRecipes( Model model ) {
		model.addAttribute( "newRecipe", new Recipe() );
		model.addAttribute( "recipes", recipeService.getAll() );
		return "recipes";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerNewRecipe( Model model, 
    		@Valid @ModelAttribute("newRecipe") Recipe newRecipe, 
    		BindingResult result ) {
		
		if ( result.hasErrors() ) {
			/* generating error messages */
			return displayAllRecipes( model );
		}
		recipeService.register( newRecipe );
        return displayAllRecipes( model );
    }
}
