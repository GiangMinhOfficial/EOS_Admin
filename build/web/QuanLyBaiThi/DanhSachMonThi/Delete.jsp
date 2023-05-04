<%-- 
    Document   : Delete
    Created on : Feb 26, 2023, 8:08:42 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.MonHoc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- page css -->

        <!-- Core css -->
        <!--<link href="assets/css/app.min.css" rel="stylesheet">-->
        <link href="shared/assets/css/app.min.css" rel="stylesheet" />
        <style>
            a:hover, a:active, a:visited, a:link{
                text-decoration: none;
                color: white
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="tab-content m-t-100">
                <!--                <div class="m-b-15 row">
                                    <div class="col-7"></div>
                                    <div class="col-5">
                                        <a href="editmonthi?mamon=${mh.maMon.trim()}">
                                            <button class="btn btn-primary">
                                                <i class="anticon anticon-edit"></i>
                                                <span>Thay đổi</span>
                                            </button>
                                        </a>
                                    </div>
                                </div>-->
                <div class="tab-pane fade show active" id="product-overview" >
                    <div class="card mx-auto" style="width: 456px">
                        <div class="card-body">
                            <h4 class="card-title">Môn học</h4>
                            <form action="deletemonthi" method="post">
                                <div class="table-responsive">
                                    <table class="product-info-table m-t-20">
                                        <tbody>
                                            <tr>
                                                <td>Mã môn:</td>
                                                <td>${mh.maMon}</td>
                                            </tr>
                                            <tr>
                                                <td>Tên Môn:</td>
                                                <td>${mh.tenMon}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                            
                                    <input type="hidden" name="mamon" value="${mh.maMon}"/>
                                    <input type="hidden" name="tenmon" value="${mh.tenMon}"/>

                                    <div class="text-center mt-4">
                                        <button class="btn btn-primary">
                                            <span>Xác nhận xóa</span>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

