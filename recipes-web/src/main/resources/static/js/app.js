var app = angular.module("recipes-app", []);

app.controller("RecipesController", function($scope, $http) {
    $http.get('/api/recipes').
    success(function(data, status, headers, config) {
        $scope.recipes = data;
    }).
    error(function(data, status, headers, config) {
        // log error
    });
});