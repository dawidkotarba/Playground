(function () {
    "use strict";

    angular.module("usersModule").controller("browseUsersController", function () {
        var vm = this;

        vm.testFunction = function () {
            return "test:)";
        }
    });

})();