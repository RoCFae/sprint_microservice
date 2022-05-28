<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Adicionar Usuario ${usuario.cpf}</title>
</head>
<body>

	<c:if test="${addUsuarioSucess}">
		<h3>Seu Usuario foi cadastrado com sucesso. Id: ${savedUsuario.id} </h3>
	</c:if>	
	
	<c:url var="save_usuario_url" value="/usuarios/save"/>
	<form:form action="${save_usuario_url}" method="usuario" modelAttribute="usuario">
	
	  <form:label path="id">Id: ${id}</form:label><br>
	  <form:input type="text" path="id" readonly="true"/><br>
	  
	  <form:label path="nome">Nome:</form:label><br>
	  <form:input type="text" path="nome"/><br>
	  
	  <form:label path="cpf">CPF:</form:label><br>
	  <form:input type="text" path="cpf"/><br>
	  
	  <input type="submit" name="salvar" value="Salvar"/>
	</form:form>
</body>
</html>