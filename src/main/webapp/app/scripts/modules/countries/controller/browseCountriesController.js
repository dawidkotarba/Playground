(function () {
    "use strict";

    angular.module("countriesModule").controller("browseCountriesController", function (browseCountriesService, ngTableParams) {
        var vm = this;
        vm.allCountries = browseCountriesService.getAllCountries();
    });
})();