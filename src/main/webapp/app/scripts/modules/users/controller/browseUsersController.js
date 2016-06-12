(function () {
    "use strict";

    angular.module("usersModule").controller("browseUsersController", function (browseUsersService) {
        var vm = this;
        vm.all = browseUsersService.getAll();
    });

})();