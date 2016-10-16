var RecipeService = angular.module('RecipeService', [])
.service('RecipeService', ['$http', function ($http) {

    var urlBase = 'http://localhost:8080/api';
    var RecipeService = {};

    RecipeService.getAllRecipes = function() {
        return $http.get(urlBase + '/recipes');
    };

    RecipeService.getRecipe = function(recipeId) {
        return $http.get(urlBase + '/recipes/' + recipeId);
    };

    return RecipeService;

}]);
