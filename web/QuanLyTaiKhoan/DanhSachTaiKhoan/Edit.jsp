<%-- 
    Document   : Edit
    Created on : Feb 26, 2023, 11:13:50 AM
    Author     : Giang Minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thay đổi tài khoản</title>
        <!-- page css -->
        <link href="shared/assets/vendors/select2/select2.css" rel="stylesheet" type="text/css"/>
        <!-- Core css -->
        <link href="shared/assets/css/app.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="tab-content m-t-100">
                <div class="tab-content m-t-15">
                    <div class="tab-pane fade show active">
                        <div class="card mx-auto" style="width: 500px;">
                            <form action="/EOS_Admin/edittaikhoan" method="post">
                                <input type="hidden" name="capdo" value="${tk.capDo.maLoai}" />
                                <div class="card-header text-center font-weight-bold pt-2 bg-light"><h2>Thay đổi tài khoản</h2></div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="tendangnhap">Tên đăng nhập</label>
                                        <input type="text" class="form-control" name="tendangnhap" value="${tk.tenDangNhap}" placeholder="Tên đăng nhập" autofocus readonly required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="matkhau">Mật khẩu</label>
                                        <input type="text" class="form-control" name="matkhau" value="${tk.matKhau}" placeholder="Mật khẩu" required>
                                    </div>

                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="capdo">Quyền</label>
                                        <!--                                        <select id="capdo" class="form-control" name="capdo">
                                        <c:forEach items="${listLoaiTaiKhoan}" var="ltk">
                                            <option value="${ltk.maLoai}" ${ltk.maLoai == tk.capDo.maLoai ? "selected" : ""}>${ltk.tenLoai}</option>
                                        </c:forEach>
                                    </select>-->
                                        <input type="text" class="form-control" value="${tk.capDo.tenLoai}" placeholder="Quyền" readonly>
                                    </div>
                                    <div class="form-group text-center">
                                        <button type="submit" class="btn btn-primary mt-2">Thay đổi</button>
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
