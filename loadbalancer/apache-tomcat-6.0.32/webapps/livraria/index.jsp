<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value="/css/estilo.css"/>" rel="stylesheet" type="text/css"></link>
		<title>Loja Virtual</title>
	</head>
	
	<body>
		<h2>Escolha um Livro:</h2>
		<div class="clearfloat">
			<ul id="disponiveis">
				<c:forEach var="disponivel" items="${disponiveis}">
					<li><a href="<c:url value="/add?item=${disponivel.id}"/>"><img  width="120" height="120"  src="<c:url value="/imagens/${disponivel.filename}"/>"></a></li>
				</c:forEach>
			</ul>
		</div>
		
		<h2>Carrinho:</h2>
		<ul id="carrinho">
			<c:forEach var="item" items="${carrinho}">
				<li>${item.nome} <a href="<c:url value="/deleta?item=${item.id}"/>">x</a></li>
			</c:forEach>
		</ul>
	
	</body>
	
</html>