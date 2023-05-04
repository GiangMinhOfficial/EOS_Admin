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
        <title>Tạo bài thi</title>
        <link href="shared/assets/vendors/select2/select2.css" rel="stylesheet" type="text/css"/>
        <link href="shared/assets/css/app.min.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery library -->
        <!--        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                <script>
                    $(document).ready(function () {
                        var selectedValue = $("#maloaibaithi").val(); // get the initial value of the select
                        console.log(selectedValue);
        
                        $.ajax({
                            url: 'createbaithi?mode=1&mamon=${param.mamon}&data=' + selectedValue,
                            type: 'get',
                            success: function () {
                                $('#socau').attr('value', ${soCau});
                            }
                        });
        
                        $("#maloaibaithi").change(function () {
                            selectedValue = $(this).val();
                            console.log(selectedValue);
                            $.ajax({
                                url: 'createbaithi?mode=1&data=' + selectedValue,
                                type: 'get',
                                success: function () {
                                    console.log(${soCau});
                                    $('#socau').attr('value', ${soCau});
                                }
                            });
                        });
        
        
                    });
                </script>-->
    </head>
    <body>
        <div class="container-fluid">
            <div class="tab-content m-t-100">
                <div class="tab-content m-t-15">
                    <div class="tab-pane fade show active">
                        <div class="card mx-auto" style="width: 500px;">
                            <form id="form" action="/EOS_Admin/createbaithi" method="post">
                                <input type="hidden" id="listLoaiBaiThi" value="${listLoaiBaiThi}">
                                <div class="card-header text-center font-weight-bold pt-2 bg-light"><h2>Tạo bài thi</h2></div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="mabaithi">Mã bài thi</label>
                                        <input type="text" class="form-control" name="mabaithi" placeholder="Mã bài thi" autofocus required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="monhoc">Môn học</label>
                                        <select class="form-control" name="mamon" onchange="change()">
                                            <c:forEach items="${listMonHoc}" var="mh">
                                                <option value="${mh.maMon.trim()}" ${mh.maMon.trim().equals(param.mamon) ? "selected" : ""}>${mh.tenMon}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="loaibaithi">Loại bài thi</label>
                                        <select id="maloaibaithi" class="form-control" name="maloaibaithi">
                                            <c:forEach items="${listLoaiBaiThi}" var="loaibt">
                                                <option value="${loaibt.maLoaiBaiThi}">${loaibt.tenLoaiBaiThi}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="socau">Số câu</label>
                                        <input id="socau" type="text" class="form-control" name="socau" value="${soCau}" placeholder="Số câu" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="thoigianlambai">Thời gian làm bài</label>
                                        <input id="thoigianlambai" type="text" class="form-control" name="thoigianlambai" value="${thoiGianLamBai}" placeholder="Thời gian làm bài" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="thoigianmode">Thời gian mở đề</label>
                                        <input type="datetime-local" class="form-control" name="thoigianmode" placeholder="Thời gian mở đề" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="thoigiandongde">Thời gian đóng đề</label>
                                        <input type="datetime-local" class="form-control" name="thoigiandongde" placeholder="Thời gian đóng đề" required>
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

    <script>
        function change(o) {
            console.log(document.getElementById('form'))
            var form = document.getElementById('form');
            form.setAttribute("method", "get");
            form.submit();
        }
    </script>
</body>
</html>
