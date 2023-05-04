<%-- 
    Document   : 404
    Created on : Mar 20, 2023, 8:48:12 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="assets/images/logo/favicon.png">
        <link href="assets/css/app.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="app">
            <div class="container-fluid">
                <div class="d-flex full-height p-v-20 flex-column justify-content-between">
                    <div class="d-none d-md-flex p-h-40">
                        <img src="assets/images/logo/logo.png" alt="">
                    </div>
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-md-6">
                                <div class="p-v-30">
                                    <h1 class="font-weight-semibold display-1 text-primary lh-1-2">404</h1>
                                    <h2 class="font-weight-light font-size-30">Whoops! Looks like you got lost</h2>
                                    <p class="lead m-b-30">We could'nt find what you were looking for.</p>
                                    <a href="/EOS_Admin/home.jsp" class="btn btn-primary btn-tone">Go Back</a>
                                </div>
                            </div>
                            <div class="col-md-6 m-l-auto">
                                <img class="img-fluid" src="images/error-1.png" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="d-none d-md-flex  p-h-40 justify-content-between"></div>
                </div>
            </div>
        </div>

        <!-- Core Vendors JS -->
        <script src="assets/js/vendors.min.js"></script>

        <!-- Core JS -->
        <script src="assets/js/app.min.js"></script>
    </body>
</html>
