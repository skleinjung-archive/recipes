var RecipeService = angular.module('RecipeService', [])
.service('RecipeService', ['$http', 'envService', function ($http, envService) {

    var urlBase = envService.read('apiUrl');
    var RecipeService = {};

    RecipeService.getAllRecipes = function() {
        return $http.get(urlBase + '/recipes');
    };

    RecipeService.getRecipe = function(recipeId) {
        return $http.get(urlBase + '/recipes/' + recipeId);
    };

    RecipeService.createRecipe = function(recipe) {
        return $http.post(urlBase + '/recipes', recipe);
    };

    // reference data

    RecipeService.getCategories = function() {
        return $http.get(urlBase + '/categories');
    };

    return RecipeService;

}]);
