(function () {
  'use strict';
   myapp.controller('FacturaController',
        function($scope, $http, $window, NgTableParams) {
            var self = this;
            var facturaUrl = '../facturaController/';
            var sindicatoSeleccionado = "0";

            $scope.factura = [];
            $scope.nuevoArticulo = [];
            $scope.listaArticulos = [];
            $scope.listaStock = [];

            $scope.factura.fecha = new Date();
            $scope.factura.nroComprobante = '00000047';

            $scope.direccion = 'Calle 1589 - CP AA1111 - CABA';
            $scope.telefono = 'Tel. 236-1258-1245';
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
            $scope.cerrarModal = function() {
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
                $http({method: 'GET',url: facturaUrl + 'cargarSindicatos'}).then(
                    function successCallback(response) {
                        $scope.sindicatosTable = new NgTableParams({}, { dataset: response.data});
                        modalSindicato.style.display = "block";
                    }, function errorCallback(response) {
                });
            }
            $scope.buscarAfiliadoModal = function() {
                if (sindicatoSeleccionado === "0") {
                    $http({method: 'GET',url: facturaUrl + 'cargarAfiliados'}).then(
                        function successCallback(response) {
                            $scope.afiliadosTable = new NgTableParams({}, { dataset: response.data});
                            modalAfiliado.style.display = "block";
                        }, function errorCallback(response) {
                    });
                } else {
                    $http({method: 'GET',url: facturaUrl + 'cargarAfiliadosPorSindicato?sindicato=' + sindicatoSeleccionado}).then(
                        function successCallback(response) {
                            $scope.afiliadosTable = new NgTableParams({}, { dataset: response.data});
                            modalAfiliado.style.display = "block";
                        }, function errorCallback(response) {
                    });
                }
            }
            $scope.buscarStockModal = function() {
                modalStock.style.display = "block";
            }

            function formatearFecha(fecha) {
                var dia = ("0" + fecha.getDate()).slice(-2);
                var mes = ("0" + (fecha.getMonth() + 1)).slice(-2);
                return (dia)+"/"+(mes)+"/"+ fecha.getFullYear();
            }

            $http({method: 'GET',url: facturaUrl + 'inicializarData'}).then(
                function successCallback(response) {
                    $http({method: 'GET',url: facturaUrl + 'cargarInformacion'}).then(
                        function successCallback(response) {
                            $scope.comprobantes = response.data.tipoComprobanteList;
                        }, function errorCallback(response) {
                    });
                }, function errorCallback(response) {
            });

            limpiarNuevoArticulo();
            function limpiarNuevoArticulo () {
                $scope.nuevoArticulo.fecha = new Date();
                $scope.nuevoArticulo.codigo = null;
                $scope.nuevoArticulo.descripcion = null;
                $scope.nuevoArticulo.cantidad = null;
                $scope.nuevoArticulo.precio = null;
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
                sindicatoSeleccionado = codigo;
                $scope.factura.sindicato = codigo;
                $scope.sindicatoNombre = nombre;
                $scope.sindicatoCuit = cuit;
                $scope.factura.afiliado = null;
                $scope.afiliadoNombre = null;
                $scope.afiliadoDni = null;
                modalSindicato.style.display = "none";
            };

            $scope.deseleccionarSindicato = function(){
                sindicatoSeleccionado = "0";
                $scope.factura.sindicato = null;
                $scope.sindicatoNombre = null;
                $scope.sindicatoCuit = null;
                modalSindicato.style.display = "none";
            }

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
                console.log("Fecha: "+formatearFecha($scope.factura.fecha));
                console.log("Tipo Comprobante: "+$scope.factura.tipoComprobante);
                console.log("Punto de Venta: "+$scope.factura.puntoVenta);
                console.log("Numero Comprobante: "+$scope.factura.nroComprobante);
                console.log("Sindicato: "+$scope.factura.sindicato);
                console.log("Afiliado: "+$scope.factura.afiliado);
                console.log("Situacion IVA: "+$scope.factura.situacionIVA);
                console.log("CondicionVenta: "+$scope.factura.condicionVenta);
                console.log("Bonificacion: "+$scope.factura.bonificacion);
                console.log("Lista Precio: "+$scope.factura.listaPrecio);
            }
        })
}());