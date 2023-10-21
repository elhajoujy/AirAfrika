<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="../../static/css/admin/dashboard.css">
<jsp:include page="../../templates/head.jsp"/>


<body>
<div class="site-wrap">
<%--    <jsp:include page="templates/header.jsp"/>--%>

    <jsp:include page="templates/header.jsp"/>
    <div class="container mt-3 preview-statistics-container">
        <h2>
            Show some statistics here
        </h2>
        <div class="d-flex justify-content-center ">
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                    cancelled yearly and monthly
                                </div>
                                <div class="h5 mb-0 font-weight-bold text-gray-800">
                                    50 cancelled
                                </div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-calendar fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                    confirmed yearly and monthly
                                </div>
                                <div class="h5 mb-0 font-weight-bold text-gray-800">
                                    50 confirmed
                                </div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-calendar fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>



    <div class="site-section">
        <div class="container">
            <div class="vol-operation-actions my-4">
                <button class="btn btn-primary " data-toggle="modal" data-target=".bd-example-modal-lg">
                    Add Vol
                </button>
                <button class="btn btn-primary" data-toggle="modal" data-target=".addAvionModal">
                    Add Avion
                </button>
            </div>
            <div class="row mb-5">
                <div class="col-md-12">
                    <div class="site-blocks-table">
                        <table class="table table-hover text-center">
                            <thead>
                            <tr>
                                <th scope="col">id</th>
                                <th scope="col">depart</th>
                                <th scope="col">arrive</th>
                                <th scope="col">avion</th>
                                <th scope="col">NbrPlace</th>
                                <th scope="col">DELETE</th>
                                <Th scope="col">UPDATE</th>
                            </tr>
                            </thead>
                            <tbody>
<%--                            TODO : LOOP INTO VOLS AND SHOW THEM HERE
--%>
                            <c:forEach items="${vols}" var="vol">
                                <tr>
                                    <th scope="row">${vol.id}</th>
                                    <td>${vol.villeDepart}</td>
                                    <td>${vol.villeArrivee}</td>
                                    <td>${vol.avion.nomAvion}</td>
                                    <td>${vol.nomberDePlaces}</td>
                                    <td>

                                        <a href="${pageContext.request.contextPath}/vol-supprimer?id=${vol.id}" class="btn btn-danger">Delete</a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/vol-update?id=${vol.id}" class="btn btn-warning">update</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="modal fade addAvionModal" tabindex="-1" role="dialog" aria-labelledby="addAvionModal" aria-hidden="true">
                <div class="modal-dialog modal-lg p-4">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-black" id="addAvionModal">
                                Avion information
                            </h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="container">
                            <h2>Formulaire d'Informations d'Avion</h2>
                            <form method="post" action="admin-avion">
                                <div class="form-group">
                                    <label for="nom_avion">Nom de l'Avion</label>
                                    <input type="text" class="form-control" id="nom_avion" name="nom_avion" value="">
                                </div>
                                <div class="form-group">
                                    <label for="nombre_place">Nombre de Places</label>
                                    <input type="number" class="form-control" id="nombre_place" name="nombre_place" value="">
                                </div>
                                <button type="submit" class="btn btn-primary mb-4">
                                    Ajouter
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>



            <div class="modal fade  bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="addVolModal" aria-hidden="true">
                <div class="modal-dialog modal-lg p-4">
                    <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title text-black" id="addVolModal">
                                    Vol information
                                </h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>

                            </div>
                        <div class="container">
                            <h2>Formulaire d'Informations de Vol</h2>
                            <form method="post" action="admin-vol">
                                <div class="form-group">
                                    <label for="code">Code</label>
                                    <input type="text" class="form-control" id="code" name="code" value="${vol.getCode()}">
                                </div>
                                <div class="form-group">
                                    <label for="heure_depart">Heure de Départ</label>
                                    <input type="time" class="form-control" id="heure_depart" name="heure_depart" value="${vol.getHeureDepart()}">
                                </div>
                                <div class="form-group">
                                    <label for="heure_arrivee">Heure d'Arrivée</label>
                                    <input type="time" class="form-control" id="heure_arrivee" name="heure_arrivee" value="${vol.getHeureArrivee()}">
                                </div>
                                <div class="form-group">
                                    <label for="date_depart">Date de Départ</label>
                                    <input type="date" class="form-control" id="date_depart" name="date_depart" value="<c:out value="${vol.dateDepart}"/> ">
                                </div>
                                <div class="form-group">
                                    <label for="date_arrivee">Date d'Arrivée</label>
                                    <input type="date" class="form-control" id="date_arrivee" name="date_arrivee" value="<c:out value="${vol.dateArrive}"/> ">
                                </div>
                                <div class="form-group">
                                    <label for="ville_depart">Ville de Départ</label>
                                    <input type="text" class="form-control" id="ville_depart" name="ville_depart" value="${vol.getVilleDepart()}">
                                </div>
                                <div class="form-group">
                                    <label for="ville_arrivee">Ville d'Arrivée</label>
                                    <input type="text" class="form-control" id="ville_arrivee" name="ville_arrivee" value="${vol.getVilleArrivee()}">
                                </div>
                                <div class="form-group">
                                    <label for="avion">Avion</label>
                                    <select class="form-control" id="avion" name="avion">
                                        <option>-</option>
                                        <c:forEach items="${avions}" var="avion">
                                            <c:if test="${avion.id == vol.avion.id}">
                                                <option value="${avion.id}" selected>${avion.nomAvion}</option>
                                            </c:if>
                                            <c:if test="${avion.id != vol.avion.id}">
                                                <option value="${avion.id}">${avion.nomAvion}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="nombre_de_places">Nombre de Places</label>
                                    <input type="number" class="form-control" id="nombre_de_places" name="nombre_de_places" value="${vol.getNomberDePlaces()}">
                                </div>
                                <div class="form-group">
                                    <label for="prix">Prix</label>
                                    <input type="number" class="form-control" id="prix" name="prix" value="${vol.getPrix()}">
                                </div>
<%--                                <div class="form-group">--%>
<%--                                    <label for="aeroport_id">ID de l'Aéroport</label>--%>
<%--                                    <input type="number" class="form-control" id="aeroport_id" name="aeroport_id">--%>
<%--                                </div>--%>

<%--                                <div class="form-group">--%>
<%--                                    <label for="societe_aerienne_id">ID de la Compagnie Aérienne</label>--%>
<%--                                    <input type="number" class="form-control" id="societe_aerienne_id" name="societe_aerienne_id">--%>
<%--                                </div>--%>
<%--                                <div class="form-group">--%>
<%--                                    <label for="ville_id">ID de la Ville</label>--%>
<%--                                    <input type="number" class="form-control" id="ville_id" name="ville_id">--%>
<%--                                </div>--%>
<%--                                <div class="form-group">--%>
<%--                                    <label for="vol_id">ID du Vol</label>--%>
<%--                                    <input type="number" class="form-control" id="vol_id" name="vol_id">--%>
<%--                                </div>--%>
<%--                                <div class="form-group">--%>
<%--                                    <label for="avion_id">ID de l'Avion</label>--%>
<%--                                    <input type="number" class="form-control" id="avion_id" name="avion_id">--%>
<%--                                </div>--%>
                                <button type="submit" class="btn btn-primary mb-4">
                                    Ajouter
                                </button>
                            </form>


                    </div>
                </div>
            </div>

<%--            <div class="row">--%>
<%--                <div class="col-md-6">--%>
<%--                    <div class="row mb-5">--%>
<%--                        <div class="col-md-6">--%>
<%--                            <button class="btn btn-outline-primary btn-sm btn-block">Delete</button>--%>
<%--                        </div>--%>

<%--                        <!-- Button trigger add product modal -->--%>
<%--                        <div class="col-md-6 mb-3 mb-md-0">--%>
<%--                            <button class="btn btn-primary btn-sm btn-block" data-toggle="modal"--%>
<%--                                    data-target="#addProductModal">Add Vol--%>
<%--                            </button>--%>
<%--                        </div>--%>

<%--                        <!-- Add product Modal -->--%>
<%--                        <div class="modal fade bd-example-modal-lg" id="addProductModal" tabindex="-1" role="dialog"--%>
<%--                             aria-labelledby="myLargeModalLabel" aria-hidden="true">--%>
<%--                            <div class="modal-dialog modal-lg modal-dialog-centered">--%>
<%--                                <form class="modal-content" action="add-product" method="post"--%>
<%--                                      enctype="multipart/form-data">--%>
<%--                                    <div class="modal-header">--%>
<%--                                        <h5 class="modal-title text-black" id="addProductModalLabel">--%>
<%--                                            Product information--%>
<%--                                        </h5>--%>

<%--                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                                            <span aria-hidden="true">&times;</span>--%>
<%--                                        </button>--%>
<%--                                    </div>--%>

<%--                                    <div class="modal-body" style="padding: 0">--%>
<%--                                        <div class="p-3">--%>
<%--                                            <div class="form-group row">--%>
<%--                                                <div class="col-md-12">--%>
<%--                                                    <label for="product-name" class="text-black">--%>
<%--                                                        Name <span class="text-danger">*</span>--%>
<%--                                                    </label>--%>

<%--                                                    <input name="product-name" type="text" class="form-control"--%>
<%--                                                           id="product-name">--%>
<%--                                                </div>--%>
<%--                                            </div>--%>

<%--                                            <div class="form-group row">--%>
<%--                                                <div class="col-md-12">--%>
<%--                                                    <label for="product-image" class="text-black">--%>
<%--                                                        Image <span class="text-danger">*</span>--%>
<%--                                                    </label>--%>

<%--                                                    <input name="product-image" type="file" class="form-control"--%>
<%--                                                           id="product-image">--%>
<%--                                                </div>--%>
<%--                                            </div>--%>

<%--                                            <div class="form-group row">--%>
<%--                                                <div class="col-md-12">--%>
<%--                                                    <label for="product-price" class="text-black">--%>
<%--                                                        Price <span class="text-danger">*</span>--%>
<%--                                                    </label>--%>

<%--                                                    <input name="product-price" type="number" class="form-control"--%>
<%--                                                           id="product-price">--%>
<%--                                                </div>--%>
<%--                                            </div>--%>

<%--                                            <div class="form-group row">--%>
<%--                                                <div class="col-md-12">--%>
<%--                                                    <label for="product-description" class="text-black">--%>
<%--                                                        Description <span class="text-danger">*</span>--%>
<%--                                                    </label>--%>

<%--                                                    <textarea name="product-description" id="product-description"--%>
<%--                                                              cols="30" rows="7"--%>
<%--                                                              class="form-control"></textarea>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>

<%--                                            <div class="form-group row">--%>
<%--                                                <div class="col-md-12">--%>
<%--                                                    <label for="product-amount" class="text-black">--%>
<%--                                                        Amount <span class="text-danger">*</span>--%>
<%--                                                    </label>--%>

<%--                                                    <input name="product-amount" type="number" class="form-control"--%>
<%--                                                           id="product-amount">--%>
<%--                                                </div>--%>
<%--                                            </div>--%>

<%--                                            <div class="form-group row">--%>
<%--                                                <div class="col-md-12">--%>
<%--                                                    <label for="product-category" class="text-black">--%>
<%--                                                        Category <span class="text-danger">*</span>--%>
<%--                                                    </label>--%>

<%--                                                    <select name="product-category" id="product-category"--%>
<%--                                                            class="form-control">--%>
<%--                                                        <c:forEach items="${category_list}" var="o">--%>
<%--                                                            <option value="${o.id}">${o.name}</option>--%>
<%--                                                        </c:forEach>--%>
<%--                                                    </select>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

<%--                                    <div class="modal-footer">--%>
<%--                                        <button type="button" class="btn btn-outline-primary btn-sm btn-block"--%>
<%--                                                data-dismiss="modal" style="margin-top: 0">--%>
<%--                                            Cancel--%>
<%--                                        </button>--%>

<%--                                        <button type="submit" class="btn btn-primary btn-sm btn-block"--%>
<%--                                                style="margin-top: 0">--%>
<%--                                            Save--%>
<%--                                        </button>--%>
<%--                                    </div>--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
    </div>

    <jsp:include page="../../templates/footer.jsp"/>
</div>

<jsp:include page="../../templates/scripts.jsp"/>
</body>
</html>