<%-- 
    Document   : home
    Created on : Feb 5, 2023, 12:18:53 AM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            #bg {
                background-image: url("shared/images/et-o-et.jpg")
            }
        </style>
    </head>
    <body>
        <%@include file="shared/Header.jsp" %>
        <c:if test="${pageName != null}">
            <%@include file="../shared/Notifications.jsp" %>
        </c:if>
        <div style="text-align: center; margin-top: 3%" id="bg">
            <!--<img src="https://daihoc.fpt.edu.vn/wp-content/uploads/2022/09/eos13-1024x507.png" />-->
            <img src="shared/images/et-o-et.jpg" style="width: 600px"/>
        </div>
    </body>
</html>
