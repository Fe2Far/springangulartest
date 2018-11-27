/**
 * Controle Credito Controller
 */



var creditoApp = angular.module("CreditoControllers", []);

var urlBase = "http://localhost:8181";

creditoApp.controller("CreditoController", function($scope, $http) {

	
	$scope.GetValue = function (obj) {
		
		$http.get(urlBase + "/tiposRisco/" + obj).then(function (resposta) {
			
			var taxaJuros = resposta.data.taxaJuros;
			
			if(taxaJuros == null || taxaJuros==undefined){
				document.getElementById("taxaJurosInformado").value='0';
				document.getElementById("taxaJurosInformado").readOnly=false;
			} else {
				document.getElementById("taxaJurosInformado").readOnly=true;
				document.getElementById("taxaJurosInformado").value=taxaJuros;
				$scope.credito.taxaJurosInformado = taxaJuros;
			}
		});
    }
	
	$scope.novo = function() {
		$scope.credito.idCreditoCliente = null;
		$scope.credito.nomeCliente = null;
		$scope.credito.limiteCredito = null;
		$scope.credito.taxaJurosInformado = null;
		$scope.credito.tipoRisco.idTipoRisco = null;
		$scope.credito.taxaJurosInformado = null;
	}
	
	
	$scope.lista_tiposrisco = {
        availableOptions: [],
        model: null
    };
	
	var getListaDepartamento = function () {
        
		$http.get("/tiposRisco").then(function (resposta) {
            var tipoRisco = [];
            
            for (var i in resposta.data){
            	tipoRisco.push({idTipoRisco: resposta.data[i].idTipoRisco, descricao: resposta.data[i].descricao});
            }
            $scope.lista_tiposrisco.availableOptions = tipoRisco;
        });
    };
    
    getListaDepartamento();
    
	$scope.listar = function() {
		$http.get(urlBase + "/creditos").then(
			function (response) {
				$scope.creditos = response.data;
			}, function (response) {
				window.alert("Erro de Get!");
			}
		);
	}
	
	$scope.listar();
	
	
    $scope.salvar = function() {
    	$http.post(urlBase  + "/creditos", $scope.credito ).then(function(response){ 
    		$scope.listar();
			$scope.novo();
		}, function(response){
			window.alert("Erro Post!");
		});
	}
    
    $scope.excluir = function(creditoSel) {
		if(window.confirm("Tem certeza que deseja excluir?")){
			$http.delete(urlBase + '/creditos/' + creditoSel.idCreditoCliente).then(
					function(response){
						$scope.listar();
					},function(response){
						window.alert("Erro de DELETE!");
					}
			
			);
		}
	
	}
	
	
});
