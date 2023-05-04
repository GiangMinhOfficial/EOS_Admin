<%-- 
    Document   : RemoveCauHoi
    Created on : Mar 8, 2023, 6:54:43 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>AddMoreCauHoi</title>
        <link href="shared/css/PhanTrang.css" rel="stylesheet" type="text/css"/>
        <link href="shared/css/CRUD.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!--ajax-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#textInput").on("keyup", function () {
                    var text = $("#textInput").val();
                    if (text === null || $.isEmptyObject(text)) {
                        window.location = "removecauhoi?mabaithi=${param.mabaithi}";
                    }
                    $.ajax({
                        url: "removecauhoi?mamon=${maMon}&mabaithi=${param.mabaithi}", // pick which servlet to request data
                        data: {text: text},
                        type: "POST",
                        success: function (data) {
                            var searchList = document.getElementById('content');
                            searchList.innerHTML = data;
                            document.getElementById('clear').innerHTML = "";
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="pt-2" style="position: absolute;top: 0;">
                <a href="home.jsp">
                    <img class="rounded-lg" src="shared/images/eos-logo.jpg" alt="Logo" width="70px">
                </a>
            </div>
            <div class="table-responsive">
                <div class="table-wrapper mx-auto" style="width: 85%">
                    <form action="removecauhoi" method="get">
                        <input type="hidden" name="mamon" value="${maMon}" />
                        <input type="hidden" name="mabaithi" value="${maBaiThi}" />
                        <div class="table-title">
                            <div class="text-center mb-4"><h1>Remove ${tenMon}</h1></div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="search-box float-left">
                                        <i class="material-icons">&#xE8B6;</i>
                                        <input id="textInput" type="text" class="form-control" placeholder="Search&hellip;" autofocus>
                                    </div>
                                </div>
                                <div class="col-sm-6 float-right">
                                    <button type="submit" class="btn btn-outline-primary add-new float-right" name="remove" value="remove"><i class="fa fa-minus-circle"></i> Remove</button>
                                </div>
                            </div>
                        </div>
                        <table class="table table-striped table-hover table-bordered text-center">
                            <thead>
                                <tr>
                                    <th>Pick</th>
                                    <th>Số thứ tự</th>
                                    <th style="width: 65%">Nội dung</th>
                                    <th>Hình ảnh</th>
                                    <th>Độ khó</th>
                                </tr>
                            </thead>
                            <tbody id="content">
                                <%
                                    int i = 0;
                                %>
                                <c:forEach items="${listCauHoi}" var="ch">
                                    <tr>
                                        <td>
                                            <input type="checkbox" name="${ch.maCauHoi}" value="${ch.maCauHoi}">
                                        </td>
                                        <td><%=++i%></td>
                                        <td class="text-left">${ch.noiDung}</td>
                                        <td>${ch.hinhAnh}</td>
                                        <td>${ch.doKho}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>  
        </div>   
    </body>
</html>