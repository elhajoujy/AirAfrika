<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>


<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="./static/css/vol-card.css">
<link rel="stylesheet" href="./static/css/reservation-details.css">

<jsp:include page="templates/head.jsp"/>

<body>
<div class="site-wrap">
<jsp:include page="templates/header.jsp"/>
<div class="container mt-4">
    <h2>Contact Details</h2>
    <div class="container">
        <form action="reservation-confirmation" method="POST">
            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>

            <div class="form-group">
                <label for="prenom">Prénom:</label>
                <input type="text" class="form-control" id="prenom" name="prenom" required>
            </div>

            <div class="form-group">
                <label for="adresse">Adresse:</label>
                <input type="text" class="form-control" id="adresse" name="adresse" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="telephone">Téléphone:</label>
                <input type="tel" class="form-control" id="telephone" name="telephone" required>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <jsp:include page="templates/footer.jsp"/>
</div>
</body>
</html>