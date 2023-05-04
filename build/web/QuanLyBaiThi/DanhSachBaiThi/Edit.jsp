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
                            <form action="/EOS_Admin/editbaithi" method="post">
                                <div class="card-header text-center font-weight-bold pt-2 bg-light"><h2>Thay đổi bài thi</h2></div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="mabaithi">Mã bài thi</label>
                                        <input type="text" class="form-control" name="mabaithi" placeholder="Mã bài thi" value="${bt.maBaiThi}" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="monhoc">Môn học</label>
                                        <select class="form-control" name="mamon">
                                            <c:forEach items="${listMonHoc}" var="mh">
                                                <option value="${mh.maMon}" ${mh.maMon == bt.monHoc.maMon ? "selected" : ""}>${mh.tenMon}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="loaibaithi">Loại bài thi</label>
                                        <select class="form-control" name="maloaibaithi">
                                            <c:forEach items="${listLoaiBaiThi}" var="loaibt">
                                                <option value="${loaibt.maLoaiBaiThi}" ${loaibt.maLoaiBaiThi == bt.loaiBaiThi.maLoaiBaiThi ? "selected" : ""}>${loaibt.tenLoaiBaiThi}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="socau">Số câu</label>
                                        <input type="text" class="form-control" name="socau" placeholder="Số câu" value="${lbt.soCau}" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="thoigianlambai">Thời gian làm bài</label>
                                        <input type="text" class="form-control" name="thoigianlambai" placeholder="Thời gian làm bài" value="${lbt.thoiGianLamBai}" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="thoigianmode">Thời gian mở đề</label>
                                        <input type="datetime-local" class="form-control" name="thoigianmode" placeholder="Thời gian mở đề" value="${bt.thoiGianMoDe}">
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="thoigiandongde">Thời gian đóng đề</label>
                                        <input type="datetime-local" class="form-control" name="thoigiandongde" placeholder="Thời gian đóng đề" value="${bt.thoiGianDongDe}">
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
