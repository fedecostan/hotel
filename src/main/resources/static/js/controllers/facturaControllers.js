(function () {
  'use strict';
   myapp.controller('FacturaController',
        function($scope, $http, $window, NgTableParams) {
            var self = this;
            var facturaUrl = '../facturaController/';
            var sindicatoSeleccionado = null;

            $scope.factura = [];
            $scope.nuevoArticulo = [];
            $scope.listaArticulos = [];
            $scope.listaProductos = [];
            $scope.totales = [];

            $scope.factura.fecha = new Date();
            $scope.factura.nroComprobante = '00000047';

            $scope.direccion = 'Calle 1589 - CP AA1111 - CABA';
            $scope.telefono = 'Tel. 236-1258-1245';
            $scope.factura.listaPrecio = 'C';

            var modalSindicato = document.getElementById('modalSindicato');
            var modalAfiliado = document.getElementById('modalAfiliado');
            var modalProducto = document.getElementById('modalProducto');
            var span = document.getElementsByClassName("close")[0];
            $scope.cerrarModal = function() {
                modalSindicato.style.display = "none";
                modalAfiliado.style.display = "none";
                modalProducto.style.display = "none";
            };
            window.onclick = function(event) {
                if (event.target == modalSindicato) {
                    modalSindicato.style.display = "none";
                }
                if (event.target == modalAfiliado) {
                    modalAfiliado.style.display = "none";
                }
                if (event.target == modalProducto) {
                    modalProducto.style.display = "none";
                }
            };
            $scope.buscarSindicatoModal = function() {
                $http({method: 'GET',url: facturaUrl + 'cargarSindicatos'}).then(
                    function successCallback(response) {
                        $scope.sindicatosTable = new NgTableParams({}, { dataset: response.data});
                        modalSindicato.style.display = "block";
                    }, function errorCallback(response) {
                });
            };
            $scope.buscarSindicatoInput = function() {
                $http({method: 'GET',url: facturaUrl + 'buscarSindicatoPorCodigo?codigo=' + $scope.factura.sindicato}).then(
                    function successCallback(response) {
                        sindicatoSeleccionado = response.data.codigo;
                        $scope.sindicatoNombre = response.data.nombre;
                        $scope.sindicatoCuit = response.data.cuit;
                        $scope.factura.afiliado = null;
                        $scope.afiliadoNombre = null;
                        $scope.afiliadoDni = null;
                    }, function errorCallback(response) {
                });
            };

            $scope.buscarAfiliadoModal = function() {
                if (sindicatoSeleccionado === null) {
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
            };

            $scope.buscarAfiliadoInput = function() {
                if (sindicatoSeleccionado === null) {
                    $http({method: 'GET',url: facturaUrl + 'buscarAfiliadoPorId?id=' + $scope.factura.afiliado}).then(
                        function successCallback(response) {
                            $scope.afiliadoNombre = response.data.nombre;
                            $scope.afiliadoDni = response.data.dni;
                        }, function errorCallback(response) {
                    });
                } else {
                    $http({method: 'GET',url: facturaUrl + 'buscarAfiliadoPorIdYSindicato?id=' + $scope.factura.afiliado + "&sindicato=" + sindicatoSeleccionado}).then(
                        function successCallback(response) {
                            $scope.afiliadoNombre = response.data.nombre;
                            $scope.afiliadoDni = response.data.dni;
                        }, function errorCallback(response) {
                    });
                }
            };

            $scope.buscarProductoModal = function() {
                $http({method: 'GET',url: facturaUrl + 'cargarProductos?fecha=' + formatearFecha($scope.nuevoArticulo.fecha)}).then(
                    function successCallback(response) {
                        $scope.productosTable = new NgTableParams({}, { dataset: response.data});
                        modalProducto.style.display = "block";
                    }, function errorCallback(response) {
                });
            };

            $scope.buscarProductoInput = function() {
                $http({method: 'GET',url: facturaUrl + 'cargarProductosPorId?id=' + $scope.nuevoArticulo.codigo + '&fecha=' + formatearFecha($scope.nuevoArticulo.fecha)}).then(
                    function successCallback(response) {
                        $scope.nuevoArticulo.descripcion = response.data.descripcion;
                        if (response.data.descripcion != "N/P"){
                            $scope.nuevoArticulo.cantidad = 1;
                        } else {
                            $scope.nuevoArticulo.cantidad = null;
                        }
                        if ($scope.factura.listaPrecio === "A"){
                            $scope.nuevoArticulo.precio = response.data.precioA;
                            $scope.nuevoArticulo.total = response.data.precioA;
                        } else if ($scope.factura.listaPrecio === "B"){
                            $scope.nuevoArticulo.precio = response.data.precioB;
                            $scope.nuevoArticulo.total = response.data.precioB;
                        } else {
                            $scope.nuevoArticulo.precio = response.data.precioC;
                            $scope.nuevoArticulo.total = response.data.precioC;
                        }
                    }, function errorCallback(response) {
                });
            };

            function formatearFecha(fecha) {
                var dia = ("0" + fecha.getDate()).slice(-2);
                var mes = ("0" + (fecha.getMonth() + 1)).slice(-2);
                return (dia)+"/"+(mes)+"/"+ fecha.getFullYear();
            };

            function obtenerFecha(fechaStr) {
                var dia = Number(fechaStr.substring(0,2));
                var mes = Number(fechaStr.substring(3,5))-1;
                var anio = Number(fechaStr.substring(6,10));
                return new Date(anio,mes,dia);
            };

            $http({method: 'GET',url: facturaUrl + 'inicializarData'}).then(
                function successCallback(response) {
                    $http({method: 'GET',url: facturaUrl + 'cargarInformacion'}).then(
                        function successCallback(response) {
                            $scope.comprobantes = response.data.tipoComprobanteList;
                            $scope.situacionesIva = response.data.situacionIvaList;
                            $scope.condicionesVenta = response.data.condicionVentaList;
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
                $scope.nuevoArticulo.total = null;
            };

            var articuloId = 0;
            $scope.guardarArticulo = function () {
                var nuevo = {
                    fecha:formatearFecha($scope.nuevoArticulo.fecha),
                    codigo:$scope.nuevoArticulo.codigo,
                    descripcion:$scope.nuevoArticulo.descripcion,
                    cantidad:$scope.nuevoArticulo.cantidad,
                    precio:$scope.nuevoArticulo.precio,
                    total:$scope.nuevoArticulo.total,
                    id: articuloId
                }
                articuloId++;
                $scope.listaArticulos.push(nuevo);
                limpiarNuevoArticulo();
                $scope.articulosTable = new NgTableParams({}, { dataset: $scope.listaArticulos});
                actualizarTotales();
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
                actualizarTotales();
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
                $scope.nuevoArticulo.fecha = obtenerFecha(articuloAEditar.fecha);
                $scope.nuevoArticulo.codigo = articuloAEditar.codigo;
                $scope.nuevoArticulo.descripcion = articuloAEditar.descripcion;
                $scope.nuevoArticulo.cantidad = articuloAEditar.cantidad;
                $scope.nuevoArticulo.precio = articuloAEditar.precio;
                $scope.nuevoArticulo.total = articuloAEditar.total;
                actualizarTotales();
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
                sindicatoSeleccionado = null;
                $scope.factura.sindicato = null;
                $scope.sindicatoNombre = null;
                $scope.sindicatoCuit = null;
                $scope.factura.afiliado = null;
                $scope.afiliadoNombre = null;
                $scope.afiliadoDni = null;
                modalSindicato.style.display = "none";
            };

            $scope.seleccionAfiliado = function(id, nombre, dni) {
                $scope.factura.afiliado = id;
                $scope.afiliadoNombre = nombre;
                $scope.afiliadoDni = dni;
                modalAfiliado.style.display = "none";
            };

            $scope.seleccionProducto = function(codigo, descripcion, precioA, precioB, precioC) {
                $scope.nuevoArticulo.codigo = codigo;
                $scope.nuevoArticulo.descripcion = descripcion;
                $scope.nuevoArticulo.cantidad = 1;
                if ($scope.factura.listaPrecio === "A"){
                    $scope.nuevoArticulo.precio = precioA;
                    $scope.nuevoArticulo.total = precioA;
                } else if ($scope.factura.listaPrecio === "B"){
                    $scope.nuevoArticulo.precio = precioB;
                    $scope.nuevoArticulo.total = precioB;
                } else {
                    $scope.nuevoArticulo.precio = precioC;
                    $scope.nuevoArticulo.total = precioC;
                }
                modalProducto.style.display = "none";
            };

            $scope.enviar = function () {
                console.log("Fecha: "+formatearFecha($scope.factura.fecha));
                console.log("Tipo Comprobante: "+$scope.factura.tipoComprobante);
                console.log("Punto de Venta: "+$scope.factura.puntoVenta);
                console.log("Numero Comprobante: "+$scope.factura.nroComprobante);
                console.log("Sindicato: "+$scope.factura.sindicato);
                console.log("Afiliado: "+$scope.factura.afiliado);
                console.log("Situacion IVA: "+$scope.factura.situacionIVA);
                console.log("Condicion de Venta: "+$scope.factura.condicionVenta);
                console.log("Bonificacion: "+$scope.factura.bonificacion);
                console.log("Lista Precio: "+$scope.factura.listaPrecio);
            };

            $scope.actualizarNuevoTotal = function() {
                $scope.nuevoArticulo.total = $scope.nuevoArticulo.cantidad * $scope.nuevoArticulo.precio;
            };

            $scope.actualizarDescuento = function () {
                actualizarTotales();
            };

            function actualizarTotales() {
                var sum = 0;
                for (var i=0; i<$scope.listaArticulos.length; i++){
                    sum += $scope.listaArticulos[i].total;
                }
                $scope.totales.subtotal = sum;
                if (typeof $scope.factura.bonificacion === 'undefined'){
                    $scope.totales.descuento = 0;
                    $scope.totales.total = sum;
                } else {
                    $scope.totales.descuento = $scope.factura.bonificacion;
                    $scope.totales.total = sum - (sum * $scope.factura.bonificacion / 100);
                }
            };
        })
}());