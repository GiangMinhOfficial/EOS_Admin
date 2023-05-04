<%-- 
    Document   : Create
    Created on : Feb 24, 2023, 7:03:31 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <link href="shared/assets/vendors/select2/select2.css" rel="stylesheet" type="text/css"/>
        <link href="shared/assets/css/app.min.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery library -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#capdo').change(function () {
                    if ($(this).children(':selected').val() === '1') {
                        $('.form-group').eq(0).children("label").text("Mã sinh viên");
                        $('.form-group').eq(0).children("label").attr('for', 'masinhvien');
                        $('.form-group').eq(0).children("input").attr('type', 'number');
                        $('.form-group').eq(0).children("input").attr('name', 'masinhvien');
                        $('.form-group').eq(0).children("input").attr('placeholder', 'Mã sinh viên');
                    } else if ($(this).children(':selected').val() === '2') {
                        $('.form-group').eq(0).children("label").text("Mã giáo viên");
                        $('.form-group').eq(0).children("label").attr('for', 'magiaovien');
                        $('.form-group').eq(0).children("input").attr('type', 'text');
                        $('.form-group').eq(0).children("input").attr('name', 'magiaovien');
                        $('.form-group').eq(0).children("input").attr('placeholder', 'Mã giáo viên');
                    } else if ($(this).children(':selected').val() === '3') {
                        $('.form-group').eq(0).children("label").text("Admin");
                        $('.form-group').eq(0).children("label").attr('for', 'admin');
                        $('.form-group').eq(0).children("input").attr('type', 'text');
                        $('.form-group').eq(0).children("input").attr('name', 'admin');
                        $('.form-group').eq(0).children("input").attr('placeholder', 'Admin');
                    }
                });
            });
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="tab-content m-t-100">
                <div class="tab-content m-t-15">
                    <div class="tab-pane fade show active">
                        <div class="card mx-auto" style="width: 500px;">
                            <form action="/EOS_Admin/createtaikhoan" method="post">
                                <div class="card-header text-center font-weight-bold pt-2 bg-light"><h2>Tạo tài khoản</h2></div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="masinhvien">Mã sinh viên</label>
                                        <input type="number" class="form-control" name="masinhvien" placeholder="Mã sinh viên" autofocus required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="matkhau">Mật khẩu</label>
                                        <input type="text" class="form-control" name="matkhau" placeholder="Mật khẩu" required>
                                    </div>

                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="capdo">Quyền</label>
                                        <select id="capdo" class="form-control" name="capdo">
                                            <c:forEach items="${listLoaiTaiKhoan}" var="ltk">
                                                <option value="${ltk.maLoai}">${ltk.tenLoai}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group text-center">
                                        <button type="submit" class="btn btn-primary mt-2">Tạo mới</button>
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
