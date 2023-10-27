<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="templates/head.jsp"/>


<body>
<div class="site-wrap">
    <jsp:include page="templates/header.jsp"/>

<%--    <div class="site-blocks-cover m-auto" style="background-image: url(https://images.unsplash.com/photo-1561131668-f63504fc549d?auto=format&fit=crop&q=80&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&w=2914);" data-aos="fade">--%>
<%--        <div class="container">--%>
<%--            <div class="align-items-start align-items-md-center justify-content-end">--%>
<%--                <div class="bg-dark text-center text-md-left pt-5 pt-md-0">--%>
<%--                    <h1 class="mb-2 text-white">--%>
<%--                        Quickly scan all your favorite travel sites--%>
<%--                    </h1>--%>
<%--                    <div class="search-bar-container ">--%>

<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
    <jsp:include page="templates/search-bar.jsp"/>


<%--    <div class="site-section site-section-sm site-blocks-1">--%>
<%--        <div class="container">--%>
<%--            <div class="row">--%>
<%--                <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="">--%>
<%--                    <div class="icon mr-4 align-self-start">--%>
<%--                        <span class="icon-truck"></span>--%>
<%--                    </div>--%>

<%--                    <div class="text">--%>
<%--                        <h2 class="text-uppercase">Free Shipping</h2>--%>
<%--                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus at iaculis quam. Integer--%>
<%--                            accumsan tincidunt fringilla.</p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="100">--%>
<%--                    <div class="icon mr-4 align-self-start">--%>
<%--                        <span class="icon-refresh2"></span>--%>
<%--                    </div>--%>
<%--                    <div class="text">--%>
<%--                        <h2 class="text-uppercase">Free Returns</h2>--%>
<%--                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus at iaculis quam. Integer--%>
<%--                            accumsan tincidunt fringilla.</p>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="200">--%>
<%--                    <div class="icon mr-4 align-self-start">--%>
<%--                        <span class="icon-help"></span>--%>
<%--                    </div>--%>
<%--                    <div class="text">--%>
<%--                        <h2 class="text-uppercase">Customer Support</h2>--%>
<%--                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus at iaculis quam. Integer--%>
<%--                            accumsan tincidunt fringilla.</p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <jsp:include page="templates/collections-section.jsp"/>--%>

<%--    <jsp:include page="templates/featured-products.jsp"/>--%>

<%--    <div class="site-section block-8">--%>
<%--        <div class="container">--%>
<%--            <div class="row justify-content-center  mb-5">--%>
<%--                <div class="col-md-7 site-section-heading text-center pt-4">--%>
<%--                    <h2>Big Sale!</h2>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="row align-items-center">--%>
<%--                <div class="col-md-12 col-lg-7 mb-5">--%>
<%--                    <a href="#"><img src="static/images/blog_1.jpg" alt="Image placeholder"--%>
<%--                                     class="img-fluid rounded"></a>--%>
<%--                </div>--%>
<%--                <div class="col-md-12 col-lg-5 text-center pl-md-5">--%>
<%--                    <h2><a href="#">50% less in all items</a></h2>--%>
<%--                    <p class="post-meta mb-4">By <a href="#">Carl Smith</a> <span class="block-8-sep">&bullet;</span>--%>
<%--                        September 3, 2018</p>--%>
<%--                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quisquam iste dolor accusantium facere--%>
<%--                        corporis ipsum animi deleniti fugiat. Ex, veniam?</p>--%>
<%--                    <p><a href="shop" class="btn btn-primary btn-sm">Shop Now</a></p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

    <jsp:include page="templates/footer.jsp"/>
</div>

<jsp:include page="templates/scripts.jsp"/>
</body>
</html>