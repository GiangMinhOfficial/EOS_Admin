<%-- 
    Document   : DanhSachDiemMonHocBaiThi
    Created on : Mar 4, 2023, 11:57:51 PM
    Author     : Giang Minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Điểm</title>
        <link href="shared/css/PhanTrang.css" rel="stylesheet" type="text/css"/>
        <link href="shared/css/CRUD.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            #drop a {
                color: #5cb85c
            }
        </style>

        <!-- ajax -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#textInput").on("keyup", function () {
                    var text = $("#textInput").val();
                    if (text === null || $.isEmptyObject(text)) {
                        window.location = "danhsachdiemmonhocbaithi?masinhvien=${param.masinhvien}";
                    }
//                    $.ajax({
//                        url: "danhsachdiemmonhocbaithi?masinhvien=${param.masinhvien}",
//                        data: {text: text},
//                        type: "POST",
//                        success: function (data) {
//                            var searchList = document.getElementById('content');
//                            searchList.innerHTML = data;
//                            document.getElementById('clear').innerHTML = "";
//                        }
//                    });
                });
            });
        </script>

    </head>
    <body>
        <%@include file="../shared/Header.jsp" %>
        <div class="container-xl">
            <c:if test="${pageName != null}">
                <%@include file="../shared/Notifications.jsp" %>
            </c:if>
            <div class="table-responsive mt-5">
                <div class="table-title">
                    <div class="text-center mb-4"><h1>Điểm</h1></div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="btn-group dropdown float-left">
                                <button onclick="drop()" type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split float-right" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="sr-only">Toggle Dropdown</span>
                                </button>
                                <div class="dropdown-menu" id="drop">
                                    <!--<a class="dropdown-item" href="nhapxuatdiemmonhocbaithi?func=import"><i class="fa-solid fa-file-import"></i> Import File</a>-->
                                    <a class="dropdown-item" href="nhapxuatdiemmonhocbaithi?masinhvien=${param.masinhvien}"><i class="fa-solid fa-file-export"></i> Export File</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                        <tr class="text-center">
                            <th>Môn Học</th>
                            <th>Progress Test 1</th>
                            <th>Progress Test 2</th>
                            <th>Progress Test 3</th>
                            <th>Mid-term Test</th>
                            <th>Final Exam</th>
                        </tr>
                    </thead>
                    <tbody class="text-center">
                        <c:forEach items="${listMonHoc_Diem}" var="md">
                            <tr>
                                <td><b>${md.monHoc.tenMon}</b></td>

                                <c:if test="${md.progressTest1 >= 0}">
                                    <td><fmt:formatNumber type = "number" groupingUsed = "false" value = "${md.progressTest1}" maxFractionDigits="2" /></td>
                                </c:if>
                                <c:if test="${md.progressTest1 == -1}">
                                    <td><i class="fa-regular fa-hourglass"></i></i></td>
                                </c:if>
                                <c:if test="${md.progressTest1 == -2}">
                                    <td><i class="fa-solid fa-x"></i></td>
                                    </c:if>


                                <c:if test="${md.progressTest2 >= 0}">
                                    <td><fmt:formatNumber type = "number" groupingUsed = "false" value = "${md.progressTest2}" maxFractionDigits="2" /></td>
                                </c:if>
                                <c:if test="${md.progressTest2 == -1}">
                                    <td><i class="fa-regular fa-hourglass"></i></td>
                                    </c:if>
                                    <c:if test="${md.progressTest2 == -2}">
                                    <td><i class="fa-solid fa-x"></i></td>
                                    </c:if>


                                <c:if test="${md.progressTest3 >= 0}">
                                    <td><fmt:formatNumber type = "number" groupingUsed = "false" value = "${md.progressTest3}" maxFractionDigits="2" /></td>
                                </c:if>
                                <c:if test="${md.progressTest3 == -1}">
                                    <td><i class="fa-regular fa-hourglass"></i></td>
                                    </c:if>
                                    <c:if test="${md.progressTest3 == -2}">
                                    <td><i class="fa-solid fa-x"></i></td>
                                    </c:if>


                                <c:if test="${md.midtermTest >= 0.0}">
                                    <td><fmt:formatNumber type = "number" groupingUsed = "false" value = "${md.midtermTest}" maxFractionDigits="2" /></td>
                                </c:if>
                                <c:if test="${md.midtermTest == -1}">
                                    <td><i class="fa-regular fa-hourglass"></i></td>
                                    </c:if>
                                    <c:if test="${md.midtermTest == -2}">
                                    <td><i class="fa-solid fa-x"></i></td>
                                    </c:if>


                                <c:if test="${md.finalExam >= 0.0}">
                                    <td><fmt:formatNumber type = "number" groupingUsed = "false" value = "${md.finalExam}" maxFractionDigits="2" /></td>
                                </c:if>
                                <c:if test="${md.finalExam == -1}">
                                    <td><i class="fa-regular fa-hourglass"></i></td>
                                    </c:if>
                                    <c:if test="${md.finalExam == -2}">
                                    <td><i class="fa-solid fa-x"></i></td>
                                    </c:if>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>  
    </div>   

    <script>
        function drop() {
            var display = document.getElementById('drop');
            if (display.classList.contains('show')) {
                display.classList.remove('show');
            } else {
                display.classList.add('show');
            }
        }
    </script>
</body>
</html>