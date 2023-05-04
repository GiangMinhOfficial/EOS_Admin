<%-- 
    Document   : login
    Created on : Mar 22, 2023, 8:57:48 PM
    Author     : Giang Minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Core css -->
        <link href="shared/assets/css/app.min.css" rel="stylesheet">
        <style>
            #rem:hover, #remember {
                cursor: pointer
            }
        </style>
    </head>
    <body>
        <div class="app">
            <div class="container-fluid p-0 h-100">
                <div class="row no-gutters h-100 full-height">
                    <div class="col-lg-4 d-none d-lg-flex bg" style="background-image:url('https://i.imgur.com/FKz1Arr.jpg')"></div>
                    <div class="col-lg-8 bg-white">
                        <div class="container h-100">
                            <div class="row no-gutters h-100 align-items-center">
                                <div class="col-md-8 col-lg-7 col-xl-6 mx-auto">
                                    <h2>Sign In</h2>
                                    <p class="m-b-30">Enter your account to access to EOS</p>
                                    <form action="login" method="post">
                                        <input type="submit" hidden />
                                        <div class="form-group">
                                            <label class="font-weight-semibold" for="userName">Username:</label>
                                            <div class="input-affix">
                                                <img class="prefix-icon" src="shared/icons/user-regular.svg" style="width: 10px"/>
                                                <input type="text" value="${user}" class="form-control" id="userName" placeholder="Username" name="user" required autofocus >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="font-weight-semibold" for="password">Password:</label>
                                            <div class="input-affix m-b-10">
                                                <img class="prefix-icon" src="shared/icons/lock-solid.svg" style="width: 10px"/>
                                                <input type="password" value="${pass}" class="form-control" id="password" placeholder="Password" name="pass" required >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="d-flex align-items-center justify-content-between">
                                                <span class="font-size-13 text-muted" style="display: flex">
                                                    <input id="remember" type="checkbox" class="form-control" name="remember" value="remember"/>
                                                    <label id="rem" onclick="remember()" style="margin-bottom: 0; padding-left: 5px">Remember?</label>
                                                </span>
                                                <button class="btn btn-primary">Sign In</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function remember() {
                var checking = document.getElementById('remember');
                if (!checking.checked) {
                    checking.checked = true;
                } else {
                    checking.checked = false;
                }
                console.log(checking.checked);
            }
        </script>


        <!-- Core Vendors JS -->
        <script src="shared/assets/js/vendors.min.js"></script>

        <!-- page js -->

        <!-- Core JS -->
        <script src="shared/assets/js/app.min.js"></script>
    </body>
</html>
