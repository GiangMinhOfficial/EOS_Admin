<%-- 
    Document   : ClearLoginSession
    Created on : Mar 10, 2023, 10:03:28 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.removeAttribute("tk"); // remove the "tk" session attribute
    response.sendRedirect("/EOS_Admin/login");
%>
