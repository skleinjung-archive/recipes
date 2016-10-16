var app = angular.module("recipes-app", ['ngRoute']);

app.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'partials/index.html',
            controller: 'HomeController',
        })
        .when('/recipes', {
            templateUrl: 'partials/recipes/list.html',
            controller: 'RecipesListController',
        })
        .when('/recipes/:recipeId/:slug', {
            templateUrl: 'partials/recipes/detail.html',
            controller: 'RecipeDetailsController',
            resolve: {
                pageData: function($http, $route) {
                    return $http.get('/api/recipes/' + $route.current.params.recipeId)
                        .then(function(response) {
                            return response.data;
                        });
                }
            }
        });

    $locationProvider.html5Mode(true);
});