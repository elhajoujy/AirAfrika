<%@ page import="java.util.Collection" %>
<%@ page import="ma.yc.airafraik.entities.VolEntity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    Collection<VolEntity> vols = (Collection<VolEntity>) request.getAttribute("vols");
%>


<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="./static/css/vol-card.css">

<jsp:include page="templates/head.jsp"/>

<body>
<div class="site-wrap">
    <jsp:include page="templates/header.jsp"/>
</div>

<jsp:include page="templates/hero.jsp"/>
<jsp:include page="componenets/search-filer-vols.jsp"/>

<div class="container flex-box">
    <c:if test="${empty vols}">
        <div class="alert alert-danger" role="alert">
            Aucun vol trouvé
        </div>
    </c:if>
    <c:if test="${not empty vols}">
        <div class="alert mt-3 alert-success" role="alert">
            ${vols.size()} vol(s) trouvé(s)
        </div>
    </c:if>

<%--    <c:forEach items="${vols}" var="vol">--%>
<%--        <c:set var="vol" value="${vol}" scope="request"/>--%>
<%--        <jsp:include page="componenets/vol-card.jsp" flush="true"/>--%>
<%--    </c:forEach>--%>
    <c:forEach items="${vols}" var="vol">
        <div class="vol-card">
            <div class="vols-info">
                <div class="vol-info">
                    <div class="logo-vol-comapny">
                        <img src="https://beebom.com/wp-content/uploads/2018/12/IranAir.jpg" alt="logo">
                    </div>
                    <div class="vol-info-heure-depart">
                        <p><c:out value="${vol.heureDepart}" /></p>
                        <p><c:out value="${vol.villeDepart}" /></p>
                    </div>
                    <div class="rounded-divider"></div>
                    <div class="vol-info-heure-arrive">
                        <p><c:out value="${vol.heureArrivee}" /></p>
                        <p><c:out value="${vol.villeArrivee}" /></p>
                    </div>
                    <div class="vol-duration">
                        <!-- You can calculate the duration based on your data -->
                        <p>
                            <c:out value="${vol.heureArrivee}" />
                        </p>
                    </div>
                </div>

            </div>
            <div class="vol-reservation">
                <h3><c:out value="${vol.prix}" /> - MAD</h3>
                <form action="reservation-details" method="get">
                    <input type="hidden" name="id" value="${vol.id}">
                    <input class="button-reservation"  type="submit" value="Réservez">
                </form>
<%--                <a href="reservation-details/${vol.id}">Réservez</a>--%>
                <p>
                    Lorem ipsum dolor, sit amet consectetur.
                </p>
            </div>
        </div>
    </c:forEach>



</div>
<%--<div class="container">--%>
<%--        <jsp:include page="templates/footer.jsp"/>--%>
<%--</div>--%>

<jsp:include page="templates/scripts.jsp"/>
</body>
</html>