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
        <title>JSP Page</title>
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
                            <form action="/EOS_Admin/editsinhvien" method="post" enctype="multipart/form-data">
                                <div class="card-header text-center font-weight-bold pt-2 bg-light"><h2>Thay đổi sinh viên</h2></div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="masinhvien">Mã sinh viên</label>
                                        <input value="${sv.maSinhVien}" type="text" class="form-control" name="masinhvien" placeholder="Mã sinh viên" autofocus readonly>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="ho">Họ</label>
                                        <input value="${sv.ho}" type="text" class="form-control" name="ho" placeholder="Họ" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="ten">Tên</label>
                                        <input value="${sv.ten}" type="text" class="form-control" name="ten" placeholder="Tên" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="manganh">Ngành</label>
                                        <select class="form-control" name="manganh">
                                            <c:forEach items="${listNganh}" var="n">
                                                <option value="${n.maNganh}" ${n.maNganh == sv.maNganh.maNganh ? "selected" : ""}>${n.tenNganh}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="ngaysinh">Ngày Sinh</label>
                                        <input value="${sv.ngaySinh}" type="date" class="form-control" name="ngaysinh" placeholder="Ngày Sinh" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="sodienthoai">Số điện thoại</label>
                                        <input value="${sv.soDienThoai}" type="number" class="form-control" name="sodienthoai" placeholder="Số điện thoại">
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="ghichu">Ghi chú</label>
                                        <input value="${sv.mess}" type="text" class="form-control" name="ghichu" placeholder="Ghi chú">
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="tendangnhap">Tên đăng nhập</label>
                                        <input value="${sv.maTaiKhoan.tenDangNhap}" type="text" class="form-control" name="tendangnhap" placeholder="Tên đăng nhập" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="anhdaidien">Ảnh đại diện</label>
                                        <input type="file" class="form-control" name="anhdaidien" >
                                        <br>
                                        <img class="form-control"  src="shared/images/SinhVien/${sv.anhDaiDien}" onerror="this.onerror=null;this.src='shared/images/others/img-14.jpg';" style="width: 50%" />
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
