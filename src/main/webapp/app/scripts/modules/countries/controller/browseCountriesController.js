(function () {
    "use strict";

    angular.module("countriesModule").controller("browseCountriesController", function (browseCountriesService, ngTableParams) {
        var vm = this;

        vm.tableParams = new ngTableParams({
            page: 1,
            count: 10
            //sorting: {name:'asc'}
        }, {
            //total: 10, // length of data
            getData: function() {
                return browseCountriesService.getAllCountries();
            }
        });
    });
})();