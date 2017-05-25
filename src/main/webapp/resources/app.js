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

//app.directive('integer', function() {
//  return {
//    require: 'ngModel',
//    link: function(scope, elm, attrs, ctrl) {
//      ctrl.$validators.integer = function(modelValue, viewValue) {
//        if (ctrl.$isEmpty(modelValue)) {
//          // consider empty models to be valid
//          return true;
//        }
//
//        if (INTEGER_REGEXP.test(viewValue)) {
//          // it is valid
//          return true;
//        }
//
//        // it is invalid
//        return false;
//      };
//    }
//  };
//});
