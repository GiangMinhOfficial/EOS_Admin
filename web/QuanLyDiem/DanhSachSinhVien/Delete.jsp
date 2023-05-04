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
                            <h4 class="card-title">Sinh viên</h4>
                            <form action="deletesinhvien" method="post">
                                <input type="hidden" name="masinhvien" value="${sv.maSinhVien}" />
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
                                                <td>Ảnh đại diện</td>
                                                <td>${sv.anhDaiDien}</td>
                                            </tr>
                                            <tr>
                                                <td>Ghi chú</td>
                                                <td>${sv.mess}</td>
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

