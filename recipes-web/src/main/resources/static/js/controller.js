app.controller('HomeController', function($scope, pageData) {
    $scope.name = 'HomeController';
    //$scope.params = $routeParams;
    $scope.recipe = pageData;
});


app.controller("RecipesListController", function($scope, $http) {
    $http.get('/api/recipes').
    success(function(data, status, headers, config) {
        $scope.recipes = data;
    }).
    error(function(data, status, headers, config) {
        // log error
    });
});

app.controller('RecipeDetailsController', function($scope, pageData) {
    $scope.name = 'RecipeController';
    //$scope.params = $routeParams;
    $scope.recipe = pageData;
});
