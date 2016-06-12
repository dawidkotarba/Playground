(function () {
    'use strict';

    angular
        .module('PlaygroundSpringApp', [
            'ngAnimate',
            'ngCookies',
            'ngResource',
            'ngRoute',
            'ngSanitize',
            'ngTouch',
            'countriesModule',
            'usersModule',
            'ngTable'
        ])
        .config(function ($routeProvider) {
            $routeProvider
                .when('/', {
                    templateUrl: 'views/main.html',
                    controller: 'browseCountriesController',
                    controllerAs: 'main'
                })
                .when('/about', {
                    templateUrl: 'views/about.html',
                    controller: 'browseUsersController',
                    controllerAs: 'about'
                })
                .otherwise({
                    redirectTo: '/'
                });
        });
})();