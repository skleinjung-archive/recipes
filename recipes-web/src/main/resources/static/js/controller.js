app.controller('HomeController', function($scope, pageData) {
    $scope.name = 'HomeController';
    //$scope.params = $routeParams;
    $scope.recipe = pageData;
});


app.controller("RecipeListController", function($scope, $http, RecipeService) {
    $scope.status = "";
    $scope.recipes = [];

    getRecipes();

    function getRecipes() {
        RecipeService.getAllRecipes()
            .success(function(recipes) {
                $scope.recipes = recipes
            })
            .error(function(error) {
                $scope.status = "Unable to load recipe data: " + error.message;
            });
    }
});

app.controller('RecipeDetailsController', function($scope, $route, RecipeService) {
    $scope.status = "";
    $scope.recipe = [];

    getRecipeDetails();

    function getRecipeDetails() {
        RecipeService.getRecipe($route.current.params.recipeId)
            .success(function(recipe) {
                $scope.recipe = recipe;
            })
            .error(function(error) {
                $scope.status = "Unable to load recipe data: " + error.message;
            });
    }

    //$scope.recipe = pageData;
});

app.controller('RecipeCreateController', function($scope, $http, RecipeService) {
    $scope.recipe = {};
    $scope.recipe.instructions = [];

    $scope.submitForm = function() {
        RecipeService.createRecipe($scope.recipe)
            .success(function(result) {
                if (!result.success) {
                    $scope.staus = "Please fix the indicated errors and try again.";
                    $scope.errors = result.errors;
                }
            })
            .error(function(result) {
                $scope.staus = "Please fix the indicated errors and try again.";
                $scope.errors = result.errors;
            });
    };

    $scope.addInstruction = function() {
        $scope.recipe.instructions.push({text: ''});
    }

    $scope.removeInstruction = function(index) {
        $scope.recipe.instructions.splice(index, 1);
    }
});
