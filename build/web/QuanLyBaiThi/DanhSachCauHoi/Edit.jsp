<%-- 
    Document   : Edit
    Created on : Feb 26, 2023, 11:13:50 AM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <form action="/EOS_Admin/editcauhoi" method="post" enctype="multipart/form-data">
                                <div class="card-header text-center font-weight-bold pt-2 bg-light"><h2>Thay đổi câu hỏi</h2></div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="macauhoi">Mã câu hỏi</label>
                                        <input type="text" class="form-control" name="macauhoi" placeholder="Mã câu hỏi" value="${ch.maCauHoi}" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="tenmonhoc">Tên môn học</label>
                                        <select class="form-control" name="mamon">
                                            <c:forEach items="${listMonHoc}" var="mh">
                                                <option value="${mh.maMon.trim()}" ${mh.maMon.trim() == ch.maMon.maMon.trim() ? "selected" : ""}>${mh.tenMon}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="noidung">Nội dung</label>
                                        <textarea type="text" class="form-control" name="noidung" placeholder="Nội dung" rows="3" required>${ch.noiDung}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="loaicauhoi">Loại câu hỏi</label>
                                        <select class="form-control" name="loaicauhoi">
                                            <c:forEach items="${listLoaiCauhoi}" var="lch">
                                                <option value="${lch.maLoai}" ${lch.maLoai == chct.loaiCauHoi.maLoai ? "selected" : ""}>${lch.tenLoai}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="a">Lựa chọn A</label>
                                        <input type="text" class="form-control" name="a" placeholder="Lựa chọn A" value="${chct.a}" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="b">Lựa chọn B</label>
                                        <input type="text" class="form-control" name="b" placeholder="Lựa chọn B" value="${chct.b}" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="c">Lựa chọn C</label>
                                        <input type="text" class="form-control" name="c" placeholder="Lựa chọn C" value="${chct.c}" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="d">Lựa chọn D</label>
                                        <input type="text" class="form-control" name="d" placeholder="Lựa chọn D" value="${chct.d}" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="dapan">Đáp án</label>
                                        <select class="form-control form-control" name="dapan">
                                            <option ${da.noiDung == 'a' ? "selected" : ""}>a</option>
                                            <option ${da.noiDung == 'b' ? "selected" : ""}>b</option>
                                            <option ${da.noiDung == 'c' ? "selected" : ""}>c</option>
                                            <option ${da.noiDung == 'd' ? "selected" : ""}>d</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="dokho">Độ khó</label>
                                        <input type="text" class="form-control" name="dokho" placeholder="Độ khó" value="${ch.doKho}" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="hinhanh">Hình ảnh</label>
                                        <!--<input type="text" class="form-control" name="hinhanh" placeholder="Hình ảnh" value="${ch.hinhAnh}" required>-->
                                        <input type="file" class="form-control" name="hinhanh" >
                                        <br>
                                        <img class="form-control"  src="shared/images/CauHoi/${ch.hinhAnh}" onerror="this.onerror=null;this.src='shared/images/others/img-14.jpg';" style="width: 100%; margin: auto" />
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
