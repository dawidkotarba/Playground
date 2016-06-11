(function () {
    "use strict"

    angular.module("countriesModule").service("feedCountriesService", function ($http) {
        var vm = this;

        vm.getAll = function () {
            var result = null;
            $http.get("/countries").success(function (response) {
                console.log(response.data);
                result = response.data;
            }).error(function () {
                alert("error");
            });

            return result;
        }
    });
})();