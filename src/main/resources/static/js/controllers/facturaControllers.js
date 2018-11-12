(function () {
  'use strict';
   myapp.controller('FacturaController',
        function($scope, $http, $window, NgTableParams) {
            var self = this;
            var facturaUrl = '../facturaController/';

            $scope.factura = [];
            $scope.nuevoArticulo = [];
            $scope.listaArticulos = [];

            $scope.factura.fecha = new Date();
            $scope.factura.nroComprobante = '00000047';

            $scope.direccion = 'Calle 1589 - CP AA1111 - CABA';
            $scope.telefono = 'Tel. 236-1258-1245';
            $scope.comprobantes = [
                {value:'FC',name:'Factura C'},
                {value:'NC',name:'Nota de Credito C'},
                {value:'DC',name:'Nota de Debito C'}
            ];
            $scope.situacionesIva = [
                {value:'111',name:'1111 IVA'},
                {value:'222',name:'2222 IVA'},
                {value:'333',name:'3333 IVA'}
            ];
            $scope.condicionesVenta = [
                {value:'111',name:'1111 VENTA'},
                {value:'222',name:'2222 VENTA'},
                {value:'333',name:'3333 VENTA'}
            ];
            $scope.factura.listaPrecio = 'C';


//            $http({method: 'GET',url: facturaUrl + 'obtenerInformacionCentro'}).then(
//                function successCallback(response) {
//                    $scope.direccion = 'Calle 1589 - CP AA1111 - CABA';
//                    $scope.telefono = 'Tel. 236-1258-1245';
//                }, function errorCallback(response) {
//            });

            limpiarNuevoArticulo();
            function limpiarNuevoArticulo () {
                $scope.nuevoArticulo.fecha = new Date();
                $scope.nuevoArticulo.codigo = "";
                $scope.nuevoArticulo.cantidad = "";
                $scope.nuevoArticulo.precio = "";
            };

            var articuloId = 0;
            $scope.guardarArticulo = function () {
                var nuevo = {
                    fecha:$scope.nuevoArticulo.fecha,
                    codigo:$scope.nuevoArticulo.codigo,
                    descripcion:'XXX',
                    cantidad:$scope.nuevoArticulo.cantidad,
                    precio:$scope.nuevoArticulo.precio,
                    total:'YYY',
                    id: articuloId
                }
                articuloId++;
                $scope.listaArticulos.push(nuevo);
                limpiarNuevoArticulo();
                $scope.articulosTable = new NgTableParams({}, { dataset: $scope.listaArticulos});
            };

            $scope.borrarArticulo = function (id) {
                var nuevoArray = [];
                var tamanioLista = $scope.listaArticulos.length;
                for (var i = 0; i < tamanioLista; i++){
                    var articulo = $scope.listaArticulos.shift();
                    if (articulo.id != id) {
                        nuevoArray.push(articulo);
                    }
                }
                $scope.listaArticulos = nuevoArray;
                $scope.articulosTable = new NgTableParams({}, { dataset: $scope.listaArticulos});
            };

            $scope.editarArticulo = function (id) {
                var nuevoArray = [];
                var articuloAEditar;
                var tamanioLista = $scope.listaArticulos.length;
                for (var i = 0; i < tamanioLista; i++){
                    var articulo = $scope.listaArticulos.shift();
                    if (articulo.id != id) {
                        nuevoArray.push(articulo);
                    } else {
                        articuloAEditar = articulo;
                    }
                }
                $scope.listaArticulos = nuevoArray;
                $scope.articulosTable = new NgTableParams({}, { dataset: $scope.listaArticulos});
                $scope.nuevoArticulo.fecha = articuloAEditar.fecha;
                $scope.nuevoArticulo.codigo = articuloAEditar.codigo;
                $scope.nuevoArticulo.cantidad = articuloAEditar.cantidad;
                $scope.nuevoArticulo.precio = articuloAEditar.precio;
            };


            $scope.enviar = function () {
                console.log($scope.factura.fecha);
                console.log($scope.factura.tipoComprobante);
                console.log($scope.factura.puntoVenta);
                console.log($scope.factura.nroComprobante);
                console.log($scope.factura.sindicato);
                console.log($scope.factura.afiliado);
                console.log($scope.factura.situacionIVA);
                console.log($scope.factura.condicionVenta);
                console.log($scope.factura.bonificacion);
                console.log($scope.factura.listaPrecio);
            }
        })
}());