var app = angular.module("recipes-app", ['ngRoute', 'RecipeService']);

app.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'partials/home.html',
            controller: 'HomeController',
        })
        .when('/recipes', {
            templateUrl: 'partials/recipes/list.html',
            controller: 'RecipeListController',
        })
        .when('/recipes/:recipeId/:slug', {
            templateUrl: 'partials/recipes/detail.html',
            controller: 'RecipeDetailsController',
        });

    $locationProvider.html5Mode(true);
});