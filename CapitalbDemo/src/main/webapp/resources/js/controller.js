'use strict';

/* Controllers */

recipeApp.controller( "RecipeHomeCtrl", [ "$scope", function($scope) {} ] );

recipeApp.controller( "RecipesCtrl", [ "$scope","recipeService", function( $scope, recipeService ) {	
	recipeService.getRecipes( $scope );		
} ] );

recipeApp.controller( "NewRecipeCtrl", [ "$scope","recipeService", function( $scope, recipeService ) {				
	
	recipeService.getRecipes( $scope );	
	
	$scope.createNewRecipe = function() {
		// build recipe ingredients
		var ingredients = [];
		$( ".ingredientName" ).each(function() {
			var ingredientName = $.trim( $(this).val() );
			if ( ingredientName != '' )
				ingredients.push( { "name": ingredientName } );
		});
		$scope.recipe.ingredients = ingredients;
		
		// Call recipeService to create a new recipe
		recipeService.createRecipe( $scope.recipe, $scope );
					
		// Push new recipe to existing table column
		$scope.recipes.push( $scope.recipe );
		
		// Reset fields values
		$scope.recipe = null;
		$scope.ingredientNames = "";
		$( ".ingredientName" ).val("");
	};		
}]);