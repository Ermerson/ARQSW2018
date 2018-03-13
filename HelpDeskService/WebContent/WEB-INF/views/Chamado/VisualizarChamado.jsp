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
    <title>Listar Chamados</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="../Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Visualizar Chamado</h3>
        <hr />
        <div class="form-group">
            <label for="chId">Numero:</label>
            <input type="text" class="form-control" id="chId">
        </div>
        <div class="form-group">
            <label for="chDesc">Descrição:</label>
            <input type="text" class="form-control" id="chDesc">
        </div>
        <div class="form-group">
            <label for="stst">Status</label>
            <input type="text" class="form-control" id="stst" value="Valor Status">
        </div>  
        <div class="form-group">
            <label for="dtArb">Data Abertura:</label>
            <input type="text" class="form-control" id="dtArb" value="Valor Teste">
        </div>
        <div class="form-group">
            <label for="dtfec">Data Abertura:</label>
            <input type="text" class="form-control" id="dtfec" value="Valor Teste">
        </div>
                  
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>