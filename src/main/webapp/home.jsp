<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%
    double solde = request.getAttribute("solde") == null ? 0 : (double) request.getAttribute("solde");
%>
<html>
<head>
    <title>
      Home Page | Welcome
    </title>
</head>
<body>

<h1>
    Welcome to the Home Page

</h1>
<h2>
    Solde : <%= solde %>
</h2>

</body>
</html>
