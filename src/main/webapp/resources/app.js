angular.module('tomatoTable', [])
.controller('TomatoData', function($scope, $http) {

    $scope.add = function() {

        if ($scope.size !== "undefined"){
            var config = {
                params: {
                    size: $scope.size
                }
            }

             $http.get('sales/data', config).
                    then(function(response) {
                        $scope.sales = response.data;
                    });

        } else {
             $http.get('sales/data').
                    then(function(response) {
                        $scope.sales = response.data;
                    });

        }
        }

});
