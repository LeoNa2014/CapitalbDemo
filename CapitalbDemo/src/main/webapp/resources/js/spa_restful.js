var userApp = angular.module("userApp", [ 'ui.bootstrap', 'ngRoute', 'ngResource' ]);

userApp.config(function($routeProvider) {
	$routeProvider.when('/users/new', {
		controller : 'NewUserCtrl',
		templateUrl : 'views/newuser.html'
	}).when('/users/:userId', {
		controller : 'UsersByIdCtrl',
		templateUrl : 'views/userbyid.html'	
	}).when('/users', {
		controller : 'UsersCtrl',
		templateUrl : 'views/users.html'	
	}).otherwise({
		controller : 'SpaCtrl',
		templateUrl: 'views/spahome.html'
    });
});

userApp.controller("SpaCtrl", [ '$scope', function($scope) {			
} ]);

userApp.controller("UsersCtrl", [ '$scope','userservice', function($scope, userservice) {	
	userservice.getUsers( $scope );		
} ]);

userApp.controller("NewUserCtrl", [ '$scope','userservice', function($scope, userservice) {				
	
	userservice.getUsers( $scope );	
	
	$scope.createNewUser = function(){
		var newuser = { 'firstname':$scope.firstname, 'lastname': $scope.lastname, 'address':$scope.address, 'email':$scope.email };
		// Call UserService to create a new user
		//
		userservice.createUser ( newuser, $scope );
					
		// Push new user to existing table column
		//
		$scope.users.push( newuser );
		// Reset fields values
		//
		$scope.firstname='';
		$scope.lastname='';
		$scope.address='';
		$scope.email='';
	};		
} ]);

userApp.controller("UsersByIdCtrl", [ '$scope','userservice', '$routeParams', function($scope, userservice, $routeParams) {	
	userservice.getUser($routeParams.userId, $scope);	
} ]);

userApp.factory( 'userservice', [ '$resource', function( $resource ){
	return new User( $resource );
}] );

function User( resource ) {
	
	this.resource = resource; 
	
	this.createUser = function ( user, scope ) {
		// 
		// Save Action Method
		//
		var User = resource('/users/new');		
		User.save(user, function(response){
			scope.message = response.message;
		});		
	}
	
	this.getUser = function ( id, scope ) {
		//
		// GET Action Method
		//
		var User = resource('/users/:userId', {userId:'@userId'});
		User.get( {userId:id}, function(user){
			scope.user = user;
		})
	}
	
	this.getUsers = function( scope ) {
		//
		// Query Action Method
		//
		var Users = resource('/users/all');
		Users.query(function(users){
			scope.users = users;
		});
	}
}
