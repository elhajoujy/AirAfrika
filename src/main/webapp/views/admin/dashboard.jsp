<%@ page import="java.util.Collection" %>
<%@ page import="ma.yc.airafraik.entities.VolEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    Collection<VolEntity> vols = (Collection<VolEntity>) request.getAttribute("vols") ;
%>

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
        <div class="statistics-cards justify-content-between  d-flex ">
            <div class="reservation-cancelled">
                cancelled
                yearly and monthly
            </div>
            <div class="reservation-confirm">
                confirmed
                yearly and monthly
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
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
                                        <button class="btn btn-danger">
                                            Delete
                                        </button>
                                    </td>
                                    <td>
                                        <button class="btn btn-warning">
                                            update
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
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