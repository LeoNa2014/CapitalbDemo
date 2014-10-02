'use strict';

/* Services */

recipeApp.factory( "recipeService", [ "$resource", function( $resource ) {
	return new Recipe( $resource );
}]);

function Recipe( resource ) {
	
	this.resource = resource; 
	
	this.createRecipe = function ( recipe, scope ) {
		// Save recipe
		var Recipe = resource( _contextPath + "/rest/recipe/new" );		
		Recipe.save(recipe, function( result ){
			console.log( result );
			scope.message = result.message;
		});		
	}
	
	this.getRecipe = function ( id, scope ) {
		// GET recipe
		var Recipe = resource( _contextPath + "/rest/recipe/:recipeId", {recipeId:"@recipeId"} );
		Recipe.get( {recipeId:id}, function(recipe) {
			scope.recipe = recipe;
		})
	}
	
	this.getRecipes = function( scope ) {
		// GET recipes
		var Recipes = resource( _contextPath + "/rest/recipe/all" );
		Recipes.query(function(recipes){
			scope.recipes = recipes;
		});
	}
}