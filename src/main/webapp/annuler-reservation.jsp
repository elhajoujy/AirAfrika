<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="templates/head.jsp"/>


<body>
<div class="site-wrap">
    <jsp:include page="templates/header.jsp"/>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-header">
                    Annuler Reservation
                </div>
                <div class="card-body">
                    <form method="post" action="annulerReservation">
                        <div class="form-group">
                            <label for="reservationNumber">Numéro de Réservation :</label>
                            <input type="text" class="form-control" id="reservationNumber" name="reservationNumber" placeholder="Entrez le numéro de réservation">
                        </div>
                        <div class="form-group">
                            <label for="cancellationReason">Raison de l'Annulation :</label>
                            <textarea class="form-control" id="cancellationReason" name="cancellationReason" rows="4" placeholder="Expliquez la raison de l'annulation"></textarea>
                        </div>
                        <button type="submit" class="btn btn-danger">Annuler la Réservation</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<!-- Include Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
