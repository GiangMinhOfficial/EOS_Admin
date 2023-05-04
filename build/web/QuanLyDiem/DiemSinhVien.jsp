<%-- 
    Document   : DiemSinhVien
    Created on : Mar 22, 2023, 8:04:16 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="shared/css/PhanTrang.css" rel="stylesheet" type="text/css"/>
        <link href="shared/css/CRUD.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            #drop a {
                color: #5cb85c
            }
        </style>
    </head>
    <body>
        <table class="table table-striped table-hover table-bordered">
            <thead>
                <tr class="text-center">
                    <th>Môn Học</th>
                        <c:forEach items="${listLoaiBaiThi}" var="lbt">
                        <th>${lbt.tenLoaiBaiThi}</th>
                        </c:forEach>
                </tr>
            </thead>
            <tbody class="text-center">
                <c:forEach items="${listMocHoc}" var="mh">
                    <tr>
                        <td>${mh.tenMon}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
