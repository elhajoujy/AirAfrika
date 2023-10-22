<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="text-center mt-5">
        <h1>Thank You!</h1>
        <h2 class="text-success ">
            Your reservation has been successfully submitted.
        </h2>
        <h3>
           Prix total : <c:out value="${prixTotal}"/> DH
        </h3>
        <p>Your reservation has been successfully submitted. Here are the details:</p>


        <div class="alert alert-success">
            <strong>Reservation Details:</strong>
            <ul>
                <li><strong>Name:</strong>
                    <c:out value="${client.nom}"/>
                </li>
                <li><strong>Email:</strong>
                    <c:out value="${client.email}"/>
                </li>
<%--                <li><strong>Date:</strong>--%>
<%--                    <c:out value="${reservation.date_Reservation}"/>--%>
<%--                </li>--%>
<%--                <li><strong>Time:</strong>--%>
<%--                    <c:out value="${reservation.heure_Reservation}"/>--%>
<%--                </li>--%>
            </ul>
        </div>

        <p>If you have any questions or need further assistance, please contact our customer service:</p>
        <address>
            <strong>Customer Service:</strong><br>
            Phone: 0659707721 <br>
            Email: elhjoujy@gmail.com
        </address>

        <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Return to Home</a>
    </div>
</div>

</body>
</html>
