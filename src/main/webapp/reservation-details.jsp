<%@ page import="java.util.Collection" %>
<%@ page import="ma.yc.airafraik.entities.VolEntity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    VolEntity vol = request.getAttribute("vol") != null ? (VolEntity) request.getAttribute("vol") : null;
%>


<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="./static/css/vol-card.css">
<link rel="stylesheet" href="./static/css/reservation-details.css">

<jsp:include page="templates/head.jsp"/>

<body>
<div class="site-wrap">
    <jsp:include page="templates/header.jsp"/>
    <% assert vol != null; %>
    <div class="container">
        <div class="container m-4 reservation-details-container">
            <div class="flight-details">
                <h2>
                    This is the flight you have selected :
                </h2>
                <div class="flight-details-container">
                    <div class="flight-information-card">
                        <div class="vol-card">
                            <div class="vols-info">
                                <div class="vol-info">
                                    <div class="logo-vol-comapny">
                                        <img  src="https://beebom.com/wp-content/uploads/2018/12/IranAir.jpg" alt="logo">
                                    </div>
                                    <div class="vol-info-heure-depart">
                                        <p>12:00</p>
                                        <p>
                                            Safi (SFI)
                                        </p>
                                    </div>
                                    <div class="rounded-divider"></div>
                                    <div class="vol-info-heure-arrive">
                                        <p>14:00</p>
                                        <p>
                                            Casablanca (CMN)
                                        </p>
                                    </div>
                                    <div class="vol-duration">
                                        <p>2h</p>
                                    </div>
                                </div>
                                <div class="vol-info">
                                    <div class="logo-vol-comapny">
                                        <img  src="https://beebom.com/wp-content/uploads/2018/12/IranAir.jpg" alt="logo">
                                    </div>
                                    <div class="vol-info-heure-depart">
                                        <p>12:00</p>
                                        <p>
                                            Casablanca (CMN)
                                        </p>
                                    </div>
                                    <div class="rounded-divider"></div>
                                    <div class="vol-info-heure-arrive">
                                        <p>14:00</p>
                                        <p>
                                            Rabat (RBA)
                                        </p>
                                    </div>
                                    <div class="vol-duration">
                                        <p>2h</p>
                                    </div>
                                </div>
                            </div>
                            <div class="vol-reservation">
                                <h3> 435 - MAD </h3>
                                <p>
                                    Lorem ipsum dolor, sit amet consectetur .
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="customzie-your-flight-conatainer">
                    <div class="basic">
                        <h2>Basic </h2>
                    </div>
                    <div class="smart">
                        <h2>smart</h2>
                    </div>
                    <div class="permium">
                        <h2>Permium</h2>
                    </div>
                </div>
                <div class="for-passangers">
                    <h2>For the passanagers </h2>
                </div>
                <div class="more-extracs">
                    <h2>Special meal on the board </h2>
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        Rerum, maiores itaque eaque, id adipisci cumque atque mollitia
                        impedit blanditiis sint odio, autem eveniet dolorum earum pariatur
                        quisquam accusantium similique nemo.
                    </p>
                </div>
            </div>
            <div class="your-booking">
                <h2>
                    Your booking details :
                </h2>
                <div class="your-booking-container">
                    <img src="" alt="" class="your-booking-image">
                    <div class="your-booking-header">
                        <div class="from-info">
                            <p>Marrakech</p>
                            <p>From</p>
                            <p>17-10-2023</p>
                        </div>
                        <div class="logo-info">
                            🛫
                        </div>
                        <div class="to-info">
                            <p>Istanbul </p>
                            <p>to</p>
                            <p>18-10-2023</p>
                        </div>
                    </div>
                    <div class="booking-details">
                        <hr>
                        <div class="passnger">
                            <p>1 Passenger</p>
                            <p>430.33</p>
                        </div>
                        <hr>
                        <div class="your-booking-total">
                            <p>Total </p>
                            <h2>494.22$</h2>
                        </div>
                        <div>
                            <p>Payment method</p>
                            <p>Visa</p>
                        </div>
                        <form class="confirmation" method="get" action="reservation-confirmation">
                            <input type="hidden" name="id" value="<%=vol.getId()%>" >
                            <input class="button-reservation btn btn-sm btn-primary"  type="submit" value="Confirm">
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="templates/footer.jsp"/>
</div>
</body>
</html>