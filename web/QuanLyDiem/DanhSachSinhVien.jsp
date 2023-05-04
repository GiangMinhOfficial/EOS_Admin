<%-- 
    Document   : diem
    Created on : Feb 11, 2023, 8:41:24 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Danh sách sinh viên</title>
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

        <!-- ajax -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#textInput").on("keyup", function () {
                    var text = $("#textInput").val();
                    if (text === null || $.isEmptyObject(text)) {
                        window.location = "danhsachsinhvien";
                    }
                    $.ajax({
                        url: "danhsachsinhvien",
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
        <%@include file="../shared/Header.jsp" %>
        <div class="container-xl">
            <c:if test="${pageName != null}">
                <%@include file="../shared/Notifications.jsp" %>
            </c:if>
            <div class="table-responsive mt-5">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="text-center mb-4"><h1>Danh sách sinh viên</h1></div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="search-box float-left">
                                    <i class="material-icons">&#xE8B6;</i>
                                    <input id="textInput" type="text" class="form-control" placeholder="Search&hellip;" autofocus>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="btn-group dropdown float-right">
                                    <a class="btn btn-outline-primary" href="createsinhvien"><i class="fa fa-plus-circle"></i> Add New</a>
                                    <button onclick="drop()" type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <div class="dropdown-menu" id="drop">
                                        <!--<a class="dropdown-item" href="nhapxuatmonthi?func=import"><i class="fa-solid fa-file-import"></i> Import File</a>-->
                                        <a class="dropdown-item" href="nhapxuatsinhvien"><i class="fa-solid fa-file-export"></i> Export File</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr class="text-center">
                                <th>Số thứ tự</th>
                                <th>Mã sinh viên</th>
                                <th>Họ Tên</th>
                                <th>Ngành</th>
                                <th>Điểm</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody id="content" class="text-center">
                            <%
                                int i = 0;
                            %>
                            <c:forEach items="${listSinhVien}" var="sv">
                                <tr>
                                    <td><%=++i%></td>
                                    <td>${sv.maSinhVien}</td>
                                    <td>${sv.ho}&nbsp;${sv.ten}</td>
                                    <td>${sv.maNganh.tenNganh}</td>
                                    <td>
                                        <a href="danhsachdiemmonhocbaithi?masinhvien=${sv.maSinhVien}"><i class="fa-regular fa-star"></i></a>
<!--                                        <form action="danhsachdiemmonhocbaithi?masinhvien=${sv.maSinhVien}" method="post" style="display: inline-block">
                                            <a href="javascript:;" onclick="parentNode.submit()"><i class="fa-regular fa-star"></i></a>
                                        </form>-->
                                    </td>
                                    <td>
                                        <a href="viewsinhvien?masinhvien=${sv.maSinhVien}" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                        <a href="editsinhvien?masinhvien=${sv.maSinhVien}" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                        <a href="deletesinhvien?masinhvien=${sv.maSinhVien}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div id="clear" class="clearfix">
                        <div class="hint-text"> Hiện có  <b>${listSinhVien.size()}</b> trên <b>${totalSize}</b> sinh viên</div>
                        <ul class="pagination">
                            <c:if test="${currentPage > 1}">
                                <li class="page-item"><a href="danhsachsinhvien?index=${currentPage - 1}"><i class="fa fa-angle-double-left"></i></a></li>
                                    </c:if>
                                    <c:forEach begin="1" end="${endPage}" var="i">
                                <li class="page-item ${currentPage == i ? "active" : ""}"><a href="danhsachsinhvien?index=${i}" class="page-link">${i}</a></li>
                                </c:forEach>
                                <c:if test="${currentPage < endPage}">
                                <li class="page-item"><a href="danhsachsinhvien?index=${currentPage + 1}" class="page-link"><i class="fa fa-angle-double-right"></i></a></li>
                                    </c:if>
                        </ul>
                    </div>
                </div>
            </div>  
        </div>   

        <script>
            function drop() {
                var display = document.getElementById('drop');
                if (display.classList.contains('show')) {
                    display.classList.remove('show');
                } else {
                    display.classList.add('show');
                }
            }
        </script>
    </body>
</html>
