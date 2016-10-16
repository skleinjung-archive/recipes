var app = angular.module("recipes-app", ['ngRoute']);

app.controller("RecipesController", function($scope, $http) {
    $http.get('/api/recipes').
    success(function(data, status, headers, config) {
        $scope.recipes = data;
    }).
    error(function(data, status, headers, config) {
        // log error
    });
});

app.controller('RecipeController', function($scope, pageData) {
    $scope.name = 'RecipeController';
    //$scope.params = $routeParams;
    $scope.recipe = pageData;
});

app.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/:recipeId/:slug', {
            templateUrl: 'recipes/detail.html',
            controller: 'RecipeController',
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