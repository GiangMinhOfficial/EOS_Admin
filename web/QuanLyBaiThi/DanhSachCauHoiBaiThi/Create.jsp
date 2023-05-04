<%-- 
    Document   : Create
    Created on : Feb 24, 2023, 7:03:31 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <link href="shared/assets/vendors/select2/select2.css" rel="stylesheet" type="text/css"/>
        <link href="shared/assets/css/app.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container-fluid">
            <div class="tab-content m-t-100">
                <div class="tab-content m-t-15">
                    <div class="tab-pane fade show active">
                        <div class="card mx-auto" style="width: 510px;">
                            <form action="/EOS_Admin/createcauhoibaithi" method="post">
                                <input type="hidden" name="mamon" value="${mh.maMon}" />
                                <input type="hidden" name="mabaithi" value="${param.mabaithi}" />
                                <div class="card-header text-center font-weight-bold pt-2 bg-light"><h2>Tạo câu hỏi cho bài thi ${bt.loaiBaiThi.tenLoaiBaiThi}</h2></div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="macauhoi">Mã câu hỏi</label>
                                        <input type="text" class="form-control" name="macauhoi" placeholder="Mã câu hỏi" required autofocus>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="mamon">Môn học</label>
                                        <input type="text" class="form-control" value="${mh.tenMon}" readonly />
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="baithi">Bài thi</label>
                                        <input type="text" class="form-control" value="${bt.loaiBaiThi.tenLoaiBaiThi}" readonly />
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="noidung">Nội dung</label>
                                        <textarea type="text" class="form-control" name="noidung" placeholder="Nội dung" rows="3" required></textarea>
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
                                        <input type="text" class="form-control" name="a" placeholder="Lựa chọn A" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="b">Lựa chọn B</label>
                                        <input type="text" class="form-control" name="b" placeholder="Lựa chọn B" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="c">Lựa chọn C</label>
                                        <input type="text" class="form-control" name="c" placeholder="Lựa chọn C" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="d">Lựa chọn D</label>
                                        <input type="text" class="form-control" name="d" placeholder="Lựa chọn D" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="dapan">Đáp án</label>
                                        <select class="form-control" name="dapan">
                                            <option value="a">a</option>
                                            <option value="b">b</option>
                                            <option value="c">c</option>
                                            <option value="d">d</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="hinhanh">Hình ảnh</label>
                                        <input type="text" class="form-control" name="hinhanh" placeholder="Hình ảnh" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="dokho">Độ khó</label>
                                        <input type="number" class="form-control" name="dokho" placeholder="Độ khó" required>
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
    </form>

</body>
</html>
