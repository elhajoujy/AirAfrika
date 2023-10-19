<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="vol-card">
    <div class="vols-info">
        <div class="vol-info">
            <div class="logo-vol-comapny">
                <img  src="https://beebom.com/wp-content/uploads/2018/12/IranAir.jpg" alt="logo">
            </div>
            <div class="vol-info-heure-depart">
                <p>12:00</p>
                <p>
                   <c:out value="${vol}"/>
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
        <a href="#">Rservez</a>
        <p>
            Lorem ipsum dolor, sit amet consectetur .
        </p>
        <p>
            Message details
        </p>
    </div>
</div>