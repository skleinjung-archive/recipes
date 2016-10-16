var app = angular.module(
    "recipes-app",
    [
        'ngRoute',
        'environment',
        'RecipeService'
    ]);

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

app.config(function(envServiceProvider) {
    envServiceProvider.config({
        domains: {
            development: ['localhost', 'dev.local'],
            //production: ['acme.com', 'acme.net', 'acme.org']
            // anotherStage: ['domain1', 'domain2'],
            // anotherStage: ['domain1', 'domain2']
        },
        vars: {
            development: {
                apiUrl: '//localhost:8080/api',
                // staticUrl: '//localhost/static'
                // antoherCustomVar: 'lorem',
                // antoherCustomVar: 'ipsum'
            },
            production: {
                // apiUrl: '//api.acme.com/v2',
                // staticUrl: '//static.acme.com'
                // antoherCustomVar: 'lorem',
                // antoherCustomVar: 'ipsum'
            }
            // anotherStage: {
            //  customVar: 'lorem',
            //  customVar: 'ipsum'
            // }
        }
    });

    envServiceProvider.check();
});