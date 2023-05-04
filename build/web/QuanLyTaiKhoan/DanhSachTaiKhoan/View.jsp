<%-- 
    Document   : View
    Created on : Feb 26, 2023, 8:41:11 AM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tài khoản</title>
        <!-- Core css -->
        <link href="shared/assets/css/app.min.css" rel="stylesheet" />
        <style>
            a:hover, a:active, a:visited, a:link {
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
                        <a href="edittaikhoan?tendangnhap=${tk.tenDangNhap}">
                            <button class="btn btn-primary">
                                <span>Thay đổi</span>
                            </button>
                        </a>
                    </div>
                </div>
                <div class="tab-pane fade show active" id="product-overview" >
                    <div class="card mx-auto" style="width: 456px">
                        <div class="card-body">
                            <h4 class="card-title">Tài khoản</h4>
                            <div class="table-responsive">
                                <table class="product-info-table m-t-20">
                                    <tbody>
                                        <tr>
                                            <td>Tên đăng nhập</td>
                                            <td>${tk.tenDangNhap}</td>
                                        </tr>
                                        <tr>
                                            <td>Mật khẩu</td>
                                            <td>${tk.matKhau}</td>
                                        </tr>
                                        <tr>
                                            <td>Quyền</td>
                                            <td>${tk.capDo.tenLoai}</td>
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
