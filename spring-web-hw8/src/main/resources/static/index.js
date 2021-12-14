angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };


    $scope.changePrice = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_price',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

        $scope.filterByPriceBetween = function () {
        console.log($scope.filter);
            $http({
                    url: contextPath + '/products/filter',
                    method: 'GET',
                    params: {
                        min: $scope.filter.min,
                        max: $scope.filter.max
                    }
                }).then(function (response) {
                    $scope.ProductList = response.data;
            });
    }


    $scope.loadProducts();
});