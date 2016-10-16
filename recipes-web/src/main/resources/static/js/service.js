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

    return RecipeService;

}]);
