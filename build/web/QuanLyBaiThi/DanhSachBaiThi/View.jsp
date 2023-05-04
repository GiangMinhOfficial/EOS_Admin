<%-- 
    Document   : View
    Created on : Feb 26, 2023, 8:41:11 AM
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
        <!-- Core css -->
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
                <div class="m-b-15 row">
                    <div class="col-7"></div>
                    <div class="col-5">
                        <a href="editbaithi?mabaithi=${bt.maBaiThi}">
                            <button class="btn btn-primary">
                                <span>Thay đổi</span>
                            </button>
                        </a>
                    </div>
                </div>
                <div class="tab-pane fade show active" id="product-overview" >
                    <div class="card mx-auto" style="width: 456px">
                        <div class="card-body">
                            <h4 class="card-title">Bài Thi</h4>
                            <div class="table-responsive">
                                <table class="product-info-table m-t-20">
                                    <tbody>
                                        <tr>
                                            <td>Mã bài thi</td>
                                            <td>${bt.maBaiThi}</td>
                                        </tr>
                                        <tr>
                                            <td>Môn học</td>
                                            <td>${bt.monHoc.tenMon}</td>
                                        </tr>
                                        <tr>
                                            <td>Loại bài thi</td>
                                            <td>${lbt.tenLoaiBaiThi}</td>
                                        </tr>
                                        <tr>
                                            <td>Số câu</td>
                                            <td>${lbt.soCau}</td>
                                        </tr>
                                        <tr>
                                            <td>Thời gian làm bài</td>
                                            <td>${lbt.thoiGianLamBai}</td>
                                        </tr>
                                        <tr>
                                            <td>Thời gian mở đề</td>
                                            <td>${bt.thoiGianMoDe}</td>
                                        </tr>
                                        <tr>
                                            <td>Thời gian đóng đề</td>
                                            <td>${bt.thoiGianDongDe}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
