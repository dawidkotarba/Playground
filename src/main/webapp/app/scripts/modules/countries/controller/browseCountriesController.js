(function () {
    "use strict";

    angular.module("countriesModule").controller("browseCountriesController", function () {
        var vm = this;

        vm.testFunction = function () {
            return "test:)";
        }
    });

})();