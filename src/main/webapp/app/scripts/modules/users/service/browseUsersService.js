(function () {
    "use strict";

    angular.module("usersModule").service("browseUsersService", function (feedUsersService) {
        var vm = this;

        vm.getAll = function () {
            return feedUsersService.getAll();
        }
    });

})();