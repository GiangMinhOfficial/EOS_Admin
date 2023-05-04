<%-- 
    Document   : Notifications
    Created on : Feb 25, 2023, 10:53:08 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">

        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <!-- Popper.js -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.10.2/umd/popper.min.js"></script>

        <!-- Bootstrap JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>
    </head>
    <body>
<!--        <div style="position: absolute">
            <div aria-live="polite" aria-atomic="true" style="position: relative; min-height: 20px;">-->
                <div class="toast" style="position: absolute; top: 25px; right: 25px;">
                    <div class="toast-header">
                        <!--<img src="..." class="rounded mr-2" alt="...">-->
                        <strong class="mr-auto">${sessionScope.pageName}</strong>
                        <!--<small>11 mins ago</small>-->
                        <!--                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>-->
                    </div>
                    <div class="toast-body">
                        ${sessionScope.noty}
                    </div>
                </div>
<!--            </div>
        </div>-->

        <script>
            $(document).ready(function () {
                $('.toast').toast({
                    autohide: false, // add this line to disable autohide
                    onShown: function () {
                        $('.toast').toast('show');
                    },
                    delay: 2000,
                    autohide: true
                });
                $('.toast').toast('show');
                <%
                    session.removeAttribute("pageName");
                %>
            });

//            const timeoutSeconds = 0.5;
//            setInterval(function () {
//                const loginTime = <%= session.getAttribute("time") %>;
//                const currentTime = new Date().getTime();
//                const timeDifference = (currentTime - loginTime) / 1000;
//
//                if (timeDifference >= timeoutSeconds) {
//                    $.ajax({
//                        url: 'shared/ClearSession.jsp',
//                        success: function () {
//                            // Session cleared successfully
//                        },
//                        error: function () {
//                            // Error clearing session
//                        }
//                    });
//                }
//            }, 500);
        </script>
    </body>
</html>
