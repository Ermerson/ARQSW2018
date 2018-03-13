<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Exibir Chamados</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
     <!-- Barra superior com os menus de navegação -->
     <c:import url="../Menu.jsp" />
     <!-- Container Principal-->
     <div id="main" class="container">
     	<h2 class="page-header"> ${fila.nome}</h2>   	     	
        <table class="table">
            <thead>
                <tr>
                    <th>
                        Numero
                    </th>
                    <th>
                        Descrição
                    </th>
                    <th>
                        Abertura:
                    </th>
                    <th>
                        Fechamento
                    </th>
                    <th>
                        Status
                    </th>
                    <th>
                    	Tempo
                    </th>                 
                </tr>
            </thead>
            <tbody>
                <c:forEach var="chamado" items="${chamados}">
                    <tr>
                        <th>
                            ${chamado.id}
                        </th>
                        <th>
                            ${chamado.descricao}
                        </th>
                        <th>
                            ${chamado.dt_abertura}
                        </th>
                        <th>
                            ${chamado.dt_fechamento}
                        </th>
                        <th>
                            ${chamado.status}
                        </th>
                        <th>
                         -
                        </th>
                    </tr>  
                </c:forEach>
            </tbody>
        </table>
     </div>
     <script src="js/jquery.min.js"></script>
     <script src="js/bootstrap.min.js"></script>
</body>
</html>