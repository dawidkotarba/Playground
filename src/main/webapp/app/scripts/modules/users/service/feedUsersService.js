(function () {
    "use strict"

    angular.module("usersModule").service("feedUsersService", function ($http) {
        var vm = this;

        vm.getAll = function () {
            var result = [];
            $http.get("/users").success(function (response) {
                result.push(response);
            }).error(function (response) {
                console.log(response);
            });
            return result;
        }
    });
})();