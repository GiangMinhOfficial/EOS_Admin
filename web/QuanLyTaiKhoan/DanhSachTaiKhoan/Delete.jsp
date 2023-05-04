<%-- 
    Document   : Delete
    Created on : Feb 26, 2023, 8:08:42 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete</title>

        <!-- Core css -->
        <link href="shared/assets/css/app.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container-fluid">
            <div class="tab-content m-t-100">
                <div class="tab-pane fade show active" id="product-overview" >
                    <div class="card mx-auto" style="width: 456px">
                        <div class="card-body">
                            <h4 class="card-title">Tai Khoan</h4>
                            <form action="deletetaikhoan" method="post">
                                <input type="hidden" name="tendangnhap" value="${tk.tenDangNhap}" />
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

