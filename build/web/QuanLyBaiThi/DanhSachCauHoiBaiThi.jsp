<%-- 
    Document   : DanhSachCauHoiBaiThi
    Created on : Mar 2, 2023, 8:17:33 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Danh sách câu hỏi</title>
        <link href="shared/css/PhanTrang.css" rel="stylesheet" type="text/css"/>
        <link href="shared/css/CRUD.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!--ajax-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#textInput").on("keyup", function () {
                    var text = $("#textInput").val();
                    if (text === null || $.isEmptyObject(text)) {
                        window.location = "danhsachcauhoibaithi?mabaithi=${maBaiThi}&mamon=${maMon}";
                    }
                    $.ajax({
                        url: "danhsachcauhoibaithi?mabaithi=${maBaiThi}&mamon=${maMon}",
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
        <style>
            #drop a {
                color: #5cb85c
            }
        </style>
    </head>
    <body>
        <%@include file="../shared/Header.jsp" %>
        <div class="container-fluid">
            <c:if test="${pageName != null}">
                <%@include file="../shared/Notifications.jsp" %>
            </c:if>
            <div class="table-responsive">
                <div class="table-wrapper mx-auto" style="width: 85%">
                    <div class="table-title">
                        <div class="text-center mb-4"><h3>Danh sách câu hỏi bài ${tenBaiThi} môn ${tenMon}</h3></div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="search-box float-left">
                                    <i class="material-icons">&#xE8B6;</i>
                                    <input id="textInput" type="text" class="form-control" placeholder="Search&hellip;" autofocus>
                                </div>
                            </div>

                            <!-- Split dropup button -->
                            <div class="col-sm-6">
                                <div class="btn-group dropdown float-right">
                                    <a class="btn btn-outline-primary" href="createcauhoibaithi?mabaithi=${maBaiThi}&mamon=${maMon}"><i class="fa fa-plus-circle"></i> Add New</a>
                                    <button onclick="drop()" type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <div class="dropdown-menu" id="drop">
                                        <a class="dropdown-item" href="addmore?mabaithi=${maBaiThi}&mamon=${maMon}"><i class="fa fa-plus-circle"></i> Add</a>
                                        <a class="dropdown-item" href="removecauhoi?mabaithi=${maBaiThi}&mamon=${maMon}"><i class="fa fa-minus-circle"></i> Remove</a>
                                        <!--<a class="dropdown-item" href="nhapxuatcauhoi?func=import"><i class="fa-solid fa-file-import"></i> Import File</a>-->
                                        <a class="dropdown-item" href="nhapxuatcauhoibaithi?func=export&mabaithi=${maBaiThi}"><i class="fa-solid fa-file-export"></i> Export File</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered text-center">
                        <thead>
                            <tr>
                                <th>Số thứ tự</th>
                                <th style="width: 65%">Nội dung</th>
                                <th>Hình ảnh</th>
                                <th>Độ khó</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody id="content">
                            <%
                                int i = 0;
                            %>
                            <c:forEach items="${listCauHoi}" var="ch">
                                <tr>
                                    <td><%=++i%></td>
                                    <td class="text-left">${ch.noiDung}</td>
                                    <td>${ch.hinhAnh}</td>
                                    <td>${ch.doKho}</td>
                                    <td>
                                        <a href="viewcauhoi?macauhoi=${ch.maCauHoi}&mamon=${ch.maMon.maMon.trim()}" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                        <a href="editcauhoi?macauhoi=${ch.maCauHoi}&mamon=${ch.maMon.maMon.trim()}" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                        <a href="deletecauhoi?macauhoi=${ch.maCauHoi}&mamon=${ch.maMon.maMon.trim()}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div id="clear" class="clearfix">
                        <div class="hint-text"> Hiện có  <b>${listCauHoi.size()}</b> trên <b>${listSize}</b> câu hỏi</div>
                        <ul class="pagination">
                            <c:if test="${currentPage > 1}">
                                <li class="page-item"><a href="danhsachcauhoibaithi?index=${currentPage - 1}&mabaithi=${maBaiThi}&mamon=${maMon}"><i class="fa fa-angle-double-left"></i></a></li>
                                    </c:if>
                                    <c:forEach begin="1" end="${endPage}" var="i">
                                <li class="page-item ${currentPage == i ? "active" : ""}"><a href="danhsachcauhoibaithi?index=${i}&mabaithi=${maBaiThi}&mamon=${maMon}" class="page-link">${i}</a></li>
                                </c:forEach>
                                <c:if test="${currentPage < endPage}">
                                <li class="page-item"><a href="danhsachcauhoibaithi?index=${currentPage + 1}&mabaithi=${maBaiThi}&mamon=${maMon}" class="page-link"><i class="fa fa-angle-double-right"></i></a></li>
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

