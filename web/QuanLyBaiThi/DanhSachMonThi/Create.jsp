<%-- 
    Document   : Create
    Created on : Feb 24, 2023, 7:03:31 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <link href="../../shared/assets/vendors/select2/select2.css" rel="stylesheet" type="text/css"/>
        <link href="../../shared/assets/css/app.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container-fluid">
            <div class="tab-content m-t-100">
                <div class="tab-content m-t-15">
                    <div class="tab-pane fade show active">
                        <div class="card mx-auto" style="width: 500px;">
                            <form action="/EOS_Admin/createmonthi">
                                <div class="card-header text-center font-weight-bold pt-2 bg-light"><h2>Tạo môn thi</h2></div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="MaMon">Mã môn:</label>
                                        <input type="text" class="form-control" name="mamon" placeholder="Mã môn" autofocus required>
                                    </div>
                                    <div class="form-group">
                                        <label class="font-weight-semibold" for="TenMon">Tên môn:</label>
                                        <input type="text" class="form-control" name="tenmon" placeholder="Tên môn" required>
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
