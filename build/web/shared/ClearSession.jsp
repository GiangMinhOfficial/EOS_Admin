<%-- 
    Document   : ClearSession
    Created on : Feb 26, 2023, 4:03:22 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.removeAttribute("pageName");
    session.removeAttribute("time");
    session.removeAttribute("noty");
%>