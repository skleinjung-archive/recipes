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
       return $http({
            method  :'POST',
            url: urlBase + '/recipes',
            data: $.param(recipe),                                          // pass in data as strings
            headers :{'Content-Type':'application/x-www-form-urlencoded'}   // set the headers so angular passing info as form data (not request payload)
        })
    };

    return RecipeService;

}]);
