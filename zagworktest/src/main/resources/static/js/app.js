angular.module('myApp',['ui.router','myApp.controllers'])

.config(function($stateProvider, $urlRouterProvider){

	$urlRouterProvider.otherwise("/inicio");
	
	$stateProvider
	
	.state('inicio', {
		url: "/inicio",
		templateUrl : " inicio.html"
	})

	.state('creditos', {
		url: "/creditos",
		templateUrl : " creditos.html",
		controller : "CreditoController"
	})

});