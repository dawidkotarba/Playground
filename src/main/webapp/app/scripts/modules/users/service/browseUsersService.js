(function () {
    "use strict";

    angular.module("usersModule").service("browseUsersService", function () {
        var vm = this;

        vm.testFunction = function () {
            return "test:)";
        }
    });

})();