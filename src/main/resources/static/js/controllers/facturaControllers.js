(function () {
  'use strict';
   myapp.controller('FacturaController',
        function($scope, $http, $window, NgTableParams) {
            var self = this;
            var facturaUrl = '../facturaController/';

            $scope.factura = [];
            $scope.nuevoArticulo = [];
            $scope.listaArticulos = [];
            $scope.listaSindicatos = [];
            $scope.listaAfiliados = [];
            $scope.listaStock = [];

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
            $scope.listaSindicatos = [
                {codigo:'1',nombre:'Sindicato 1', cuit:'111'},
                {codigo:'2',nombre:'Sindicato 2', cuit:'222'},
                {codigo:'3',nombre:'Sindicato 3', cuit:'333'}
            ];
            $scope.sindicatosTable = new NgTableParams({}, { dataset: $scope.listaSindicatos});
            $scope.listaAfiliados = [
                {sindicato:'1',ioma:'IOMA', barra:'BARRA', apeYnom:'Fede Cos', familia:'FAMI', dni:'38157990', bloqueo:'bloq', fechaBaja:'1/1/1'},
                {sindicato:'2',ioma:'IOMA', barra:'BARRA', apeYnom:'Elisa Car', familia:'FAMI', dni:'15648687', bloqueo:'bloq', fechaBaja:'1/1/1'},
                {sindicato:'3',ioma:'IOMA', barra:'BARRA', apeYnom:'Carla Agno', familia:'FAMI', dni:'30486487', bloqueo:'bloq', fechaBaja:'1/1/1'}
            ];
            $scope.afiliadosTable = new NgTableParams({}, { dataset: $scope.listaAfiliados});
            $scope.listaStock = [
                {codigo:'1',nombre:'Rueda'},
                {codigo:'2',nombre:'Volante'},
                {codigo:'3',nombre:'Ventana'}
            ];
            $scope.stockTable = new NgTableParams({}, { dataset: $scope.listaStock});




            var modalSindicato = document.getElementById('modalSindicato');
            var modalAfiliado = document.getElementById('modalAfiliado');
            var modalStock = document.getElementById('modalStock');
            var span = document.getElementsByClassName("close")[0];
            span.onclick = function() {
                modalSindicato.style.display = "none";
                modalAfiliado.style.display = "none";
                modalStock.style.display = "none";
            }
            window.onclick = function(event) {
                if (event.target == modalSindicato) {
                    modalSindicato.style.display = "none";
                }
                if (event.target == modalAfiliado) {
                    modalAfiliado.style.display = "none";
                }
                if (event.target == modalStock) {
                    modalStock.style.display = "none";
                }
            }
            $scope.buscarSindicatoModal = function() {
                modalSindicato.style.display = "block";
            }
            $scope.buscarAfiliadoModal = function() {
                modalAfiliado.style.display = "block";
            }
            $scope.buscarStockModal = function() {
                modalStock.style.display = "block";
            }


            function formatearFecha(fecha) {
                var dia = ("0" + fecha.getDate()).slice(-2);
                var mes = ("0" + (fecha.getMonth() + 1)).slice(-2);
                return (dia)+"/"+(mes)+"/"+ fecha.getFullYear();
            }

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
                $scope.nuevoArticulo.descripcion = "";
                $scope.nuevoArticulo.cantidad = "";
                $scope.nuevoArticulo.precio = "";
            };

            var articuloId = 0;
            $scope.guardarArticulo = function () {
                var nuevo = {
                    fecha:formatearFecha($scope.nuevoArticulo.fecha),
                    codigo:$scope.nuevoArticulo.codigo,
                    descripcion:$scope.nuevoArticulo.descripcion,
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

            $scope.seleccionSindicato = function(codigo, nombre, cuit) {
                $scope.factura.sindicato = codigo;
                $scope.sindicatoNombre = nombre;
                $scope.sindicatoCuit = cuit;
                modalSindicato.style.display = "none";
            };

            $scope.seleccionAfiliado = function(sindicato, nombre, dni) {
                $scope.factura.afiliado = sindicato;
                $scope.afiliadoNombre = nombre;
                $scope.afiliadoDni = dni;
                modalAfiliado.style.display = "none";
            };

            $scope.seleccionStock = function(codigo, nombre) {
                $scope.nuevoArticulo.codigo = codigo;
                $scope.nuevoArticulo.descripcion = nombre;
                modalStock.style.display = "none";
            };



            $scope.enviar = function () {
                console.log(formatearFecha($scope.factura.fecha));
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