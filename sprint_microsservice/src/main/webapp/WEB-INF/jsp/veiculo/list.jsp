<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<p>Listagem de Veiculos</p>
	
	<p><a href="veiculos/form">Adicionar novo</a></p>		
	
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Placa</th>
				<th>Modelo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="veiculo" items="${veiculos}">
				<tr>
					<td>${veiculo.id}</td>
					<td>${veiculo.modelo}</td>
					<td>${veiculo.placa}</td>
					<td><a href="veiculos/${veiculo.id}">Edit</a></td>
					<td><a href="veiculos/${veiculos.id}/delete">Apagar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		
		
	</table>
</body>
</html>