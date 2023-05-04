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
        <title>Sinh viên</title>
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
                        <a href="editsinhvien?masinhvien=${sv.maSinhVien}">
                            <button class="btn btn-primary">
                                <span>Thay đổi</span>
                            </button>
                        </a>
                    </div>
                </div>
                <div class="tab-pane fade show active" id="product-overview" >
                    <div class="card mx-auto" style="width: 600px">
                        <div class="card-body">
                            <h4 class="card-title">Sinh viên</h4>
                            <div class="table-responsive">
                                <table class="product-info-table m-t-20">
                                    <tbody>
                                        <tr>
                                            <td>Mã sinh viên</td>
                                            <td>${sv.maSinhVien}</td>
                                        </tr>
                                        <tr>
                                            <td>Họ và tên</td>
                                            <td>${sv.ho}&nbsp;${sv.ten}</td>
                                        </tr>
                                        <tr>
                                            <td>Ngành</td>
                                            <td>${sv.maNganh.tenNganh}</td>
                                        </tr>
                                        <tr>
                                            <td>Ngày Sinh</td>
                                            <td>${sv.ngaySinh}</td>
                                        </tr>
                                        <tr>
                                            <td>Số điện thoại</td>
                                            <td>${sv.soDienThoai}</td>
                                        </tr>
                                        <tr>
                                            <td>Ghi chú</td>
                                            <td>${sv.mess}</td>
                                        </tr>
                                        <tr>
                                            <td>Tên đăng nhập</td>
                                            <td>${sv.maTaiKhoan.tenDangNhap}</td>
                                        </tr>
                                        <tr>
                                            <td>Ảnh đại diện</td>
                                            <td>
                                                <img src="shared/images/SinhVien/${sv.anhDaiDien}" onerror="this.onerror=null;this.src='shared/images/others/img-14.jpg';" style="width: 250px" />
                                            </td>
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
