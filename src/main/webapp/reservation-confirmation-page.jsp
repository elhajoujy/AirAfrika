<%@ page import="java.util.Collection" %>
<%@ page import="ma.yc.airafraik.entities.VolEntity" %>
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
    <form id="reservation-form" method="post" action="reservation-confirmation">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="name">Full Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter your full name" required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email address" required>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="phone">Phone Number</label>
            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Enter your phone number" required>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="flight">Flight Number</label>
                    <input type="text" class="form-control" id="flight" name="flight" placeholder="Enter your flight number" required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="date">Flight Date</label>
                    <input type="date" class="form-control" id="date" name="date" required>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="comments">Additional Comments</label>
            <textarea class="form-control" id="comments" name="comments" rows="4" placeholder="Any additional comments or special requests"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <jsp:include page="templates/footer.jsp"/>
</div>
</body>
</html>