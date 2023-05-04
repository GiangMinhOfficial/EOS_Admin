<%-- 
    Document   : login
    Created on : Feb 2, 2023, 9:39:13 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>
            .divider:after,
            .divider:before {
                content: "";
                flex: 1;
                height: 1px;
                background: #eee;
            }

            img {
                width: 100%
            }
        </style>
    </head>
    <body>
        <section class="vh-100">
            <div class="container py-5 h-100">
                <c:if test="${pageName != null}">
                    <%@include file="shared/Notifications.jsp" %>
                </c:if>
                <div class="row d-flex align-items-center justify-content-center h-100">
                    <div class="col-md-8 col-lg-7 col-xl-6">
                        <!--https://i.ibb.co/DfF8mqd/login-Page.jpg-->
                        <!--https://i.imgur.com/FKz1Arr.jpg-->
                        <img src="https://i.imgur.com/FKz1Arr.jpg" alt="EOS">
                    </div>
                    <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                        <form action="login" method="post">
                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <input type="text" class="form-control form-control-lg" placeholder="Username" name="user" required autofocus />
                                <!--<label class="form-label" for="form1Example13">Email address</label>-->
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-4">
                                <input type="password" class="form-control form-control-lg" placeholder="Password" name="pass" required />
                                <!--<label class="form-label" for="form1Example23">Password</label>-->
                            </div>

                            <!--                            <div class="mb-4">
                                                             Checkbox 
                                                            <div class="form-check">
                                                                <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />
                                                                <label class="form-check-label" for="form1Example3"> Remember me </label>
                                                            </div>
                                                            <a href="#!">Forgot password?</a>
                                                        </div>-->

                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary btn-lg btn-block">Sign in</button>

                            <!--                            <div class="divider d-flex align-items-center my-4">
                                                            <p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
                                                        </div>
                            
                                                        <a class="btn btn-primary btn-lg btn-block" style="background-color: #3b5998" href="#!"
                                                           role="button">
                                                            <i class="fab fa-facebook-f me-2"></i>Continue with Facebook
                                                        </a>
                                                        <a class="btn btn-primary btn-lg btn-block" style="background-color: #55acee" href="#!"
                                                           role="button">
                                                            <i class="fab fa-twitter me-2"></i>Continue with Twitter</a>-->
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
