<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<body>
		<h1>Lista de contas - Verifique a quantidade de selects no console no Eclipse</h1>
		<table border="1">
			<tr><td>Numero</td><td>Agencia</td><td>Transacoes</td></tr>
		<c:forEach items="${contas}" var="conta">
			<tr><td>${conta.numero}</td><td>${conta.agencia}</td><td> ${conta.transacoes}</td></tr>
		</c:forEach>
		</table>
	</body>
</html>