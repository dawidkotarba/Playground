(function () {
    "use strict";

    angular.module("countriesModule").service("browseCountriesService", function (feedCountriesService) {
        var vm = this;

        vm.getAllCountries = function () {
            return feedCountriesService.getAll();
        }
    });
})();