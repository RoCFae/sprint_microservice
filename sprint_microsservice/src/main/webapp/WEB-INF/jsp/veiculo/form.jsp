<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Adicionar Veiculo ${veiculo.placa}</title>
</head>
<body>

	<c:if test="${addVeiculoSucess}">
		<h3>Seu Veiculo foi cadastrado com sucesso. Id: ${savedVeiculo.id} </h3>
	</c:if>	
	
	<c:url var="save_veiculo_url" value="/veiculos/save"/>
	<form:form action="${save_veiculo_url}" method="veiculo" modelAttribute="veiculo">
	
	  <form:label path="id">Id: ${id}</form:label><br>
	  <form:input type="text" path="id" readonly="true"/><br>
	  
	  <form:label path="modelo">Modelo:</form:label><br>
	  <form:input type="text" path="modelo"/><br>
	  
	  <form:label path="placa">Placa:</form:label><br>
	  <form:input type="text" path="placa"/><br>
	  
	  <input type="submit" name="salvar" value="Salvar"/>
	</form:form>
</body>
</html>