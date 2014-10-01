package com.capitalb.demo.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capitalb.demo.model.Ingredient;
import com.capitalb.demo.model.Recipe;
import com.capitalb.demo.service.RecipeService;

/**
 * Handles requests for home page
 * 
 * @author Leo Na
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
//		Ingredient a = new Ingredient();
//		a.setName( "beef" );
//		Ingredient b = new Ingredient();
//		b.setName( "onion" );
//		
//		List<Ingredient> ingredients = new ArrayList<Ingredient>();
//		ingredients.add(a);
//		ingredients.add(b);
//		
//		Recipe recipe = new Recipe();
//		recipe.setName( "beef" );
//		recipe.setMethod( "deep fry" );
//		recipe.setIngredients( ingredients );
//		
//		recipeService.register(recipe);
		
		
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
}
