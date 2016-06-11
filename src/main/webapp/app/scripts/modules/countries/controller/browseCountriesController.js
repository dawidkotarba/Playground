(function () {
    "use strict";

    angular.module("countriesModule").controller("browseCountriesController", function (browseCountriesService) {
        var vm = this;

        vm.testFunction = function () {
            return browseCountriesService.getAllCountries();
        }
    });

})();