/**
 * Recipe App
 */
var recipeApp = angular.module( "RecipeApp", [ "ngRoute", "ngResource" ] );

recipeApp.config( function( $routeProvider ) {
	$routeProvider.when("/newRecipe", {
		controller : "NewRecipeCtrl",
		templateUrl : "templates/newRecipe.html"
	}).when("/recipes", {
		controller : "RecipesCtrl",
		templateUrl : "templates/recipes.html"
	}).otherwise({
		controller : "RecipeHomeCtrl",
		templateUrl: "templates/home.html"
	});
});

recipeApp.controller( "RecipeHomeCtrl", [ "$scope", function($scope) {} ] );

recipeApp.controller( "RecipesCtrl", [ "$scope","recipeService", function( $scope, recipeService ) {	
	recipeService.getRecipes( $scope );		
} ] );

recipeApp.controller( "NewRecipeCtrl", [ "$scope","recipeService", function( $scope, recipeService ) {				
	
	recipeService.getRecipes( $scope );	
	
	$scope.createNewRecipe = function() {
		var ingredients = [];
		$.each( $scope.ingredientNames, function( i, v ) {
			ingredients.push({"name":v});
		});
		$scope.recipe.ingredients = ingredients;
		
		// Call recipeService to create a new recipe
		recipeService.createRecipe( $scope.recipe, $scope );
					
		// Push new recipe to existing table column
		$scope.recipes.push( $scope.recipe );
		
		// Reset fields values
		$scope.recipe = null;
		$scope.ingredientNames = "";
	};		
}]);

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