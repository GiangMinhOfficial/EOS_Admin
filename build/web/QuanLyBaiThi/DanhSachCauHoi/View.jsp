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
        <title>View Cau Hoi</title>
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
            <div class="tab-content m-t-40">
                <div class="m-b-15 row">
                    <div class="col-7"></div>
                    <div class="col-5">
                        <a href="editcauhoi?macauhoi=${ch.maCauHoi}&mamon=${ch.maMon.maMon.trim()}">
                            <button class="btn btn-primary">
                                <span>Thay đổi</span>
                            </button>
                        </a>
                    </div>
                </div>
                <div class="tab-pane fade show active" id="product-overview" >
                    <div class="card mx-auto" style="width: 1000px">
                        <div class="card-body">
                            <h4 class="card-title">Câu hỏi</h4>
                            <div class="table-responsive">
                                <table class="product-info-table m-t-20">
                                    <tbody>
                                        <tr>
                                            <td>Mã câu hỏi</td>
                                            <td>${ch.maCauHoi}</td>
                                        </tr>
                                        <tr>
                                            <td>Môn học</td>
                                            <td>${ch.maMon.tenMon}</td>
                                        </tr>
                                        <tr>
                                            <td>Nội dung</td>
                                            <td>${ch.noiDung}</td>
                                        </tr>
                                        <tr>
                                            <td>Loại câu hỏi</td>
                                            <td>${chct.loaiCauHoi.tenLoai}</td>
                                        </tr>
                                        <tr>
                                            <td>Lựa chọn A </td>
                                            <td>${chct.a}</td>
                                        </tr>
                                        <tr>
                                            <td>Lựa chọn B </td>
                                            <td>${chct.b}</td>
                                        </tr>
                                        <tr>
                                            <td>Lựa chọn C </td>
                                            <td>${chct.c}</td>
                                        </tr>
                                        <tr>
                                            <td>Lựa chọn D </td>
                                            <td>${chct.d}</td>
                                        </tr>
                                        <tr>
                                            <td>Đáp án</td>
                                            <td>
                                                <c:if test="${da.noiDung == 'a'}">
                                                    A. ${chct.a}
                                                </c:if>
                                                <c:if test="${da.noiDung == 'b'}">
                                                    B. ${chct.b}
                                                </c:if>
                                                <c:if test="${da.noiDung == 'c'}">
                                                    C. ${chct.c}
                                                </c:if>
                                                <c:if test="${da.noiDung == 'd'}">
                                                    D. ${chct.d}
                                                </c:if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Độ khó</td>
                                            <td>${ch.doKho}</td>
                                        </tr>
                                        <tr>
                                            <td>Hình ảnh</td>
                                            <!--<td>${ch.hinhAnh}</td>-->
                                            <td>
                                                <!--<img src="https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png" style="width: 400px" />-->
                                                <img src="shared/images/CauHoi/${ch.hinhAnh}" onerror="this.onerror=null;this.src='shared/images/others/img-14.jpg';" style="width: 400px" />
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
