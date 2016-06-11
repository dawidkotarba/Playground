(function () {
    "use strict";

    angular.module("countriesModule").service("browseCountriesService", function () {
        var vm = this;

        vm.testFunction = function () {
            return "test:)";
        }
    });

})();