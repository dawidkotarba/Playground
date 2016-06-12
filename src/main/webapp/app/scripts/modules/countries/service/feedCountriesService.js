(function () {
    "use strict"

    angular.module("countriesModule").service("feedCountriesService", function ($http) {
        var vm = this;

        vm.getAll = function () {
            var result = [];
            $http.get("/countries").success(function (response) {
                result.push(response);
            }).error(function (response) {
                console.log(response);
            });
            return result;
        }
    });
})();