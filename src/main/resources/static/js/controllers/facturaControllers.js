(function () {
  'use strict';
   myapp.controller('FacturaController',
        function($scope, $http, $window, NgTableParams) {
            var self = this;
            var facturaUrl = '../facturaController/';

            $scope.factura = [];

            $scope.factura.fecha = new Date();

            $scope.direccion = 'Calle 1589 - CP AA1111 - CABA';
            $scope.telefono = 'Tel. 236-1258-1245';
            $scope.comprobantes = [
                {value:'FC',name:'Factura C'},
                {value:'NC',name:'Nota de Credito C'},
                {value:'DC',name:'Nota de Debito C'}
            ];

//            $http({method: 'GET',url: facturaUrl + 'obtenerInformacionCentro'}).then(
//                function successCallback(response) {
//                    $scope.direccion = 'Calle 1589 - CP AA1111 - CABA';
//                    $scope.telefono = 'Tel. 236-1258-1245';
//                }, function errorCallback(response) {
//            });
            $scope.enviar = function () {
                console.log($scope.factura.fecha);
                console.log($scope.factura.tipoComprobante);
                console.log($scope.factura.puntoVenta);
                console.log($scope.factura.nroComprobante);
                console.log($scope.factura.sindicato);
                console.log($scope.factura.afiliado);
            }
        })
}());