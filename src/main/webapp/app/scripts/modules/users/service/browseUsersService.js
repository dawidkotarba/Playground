(function () {
    "use strict";

    angular.module("usersModule").service("browseUsersService", function (feedUsersService) {
        var vm = this;

        vm.testFunction = function () {
            return "browseUserService";
        }
    });

})();