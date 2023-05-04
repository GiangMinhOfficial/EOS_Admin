<%-- 
    Document   : Header
    Created on : Mar 10, 2023, 8:39:16 PM
    Author     : Giang Minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>

        <link rel="stylesheet" href="shared/assets/css/clone.style.min.css"> 

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <style>
            .main-header {
                background-color: rgba(0,123,255,0.52) !important;
            }

            #user, #user:hover {
                line-height: 50px;
                cursor: pointer
            }

            .login {
                display: none;
                position: absolute;
                top: 70px;
                background-color: rgba(0,123,255,0.52);
                width: 110px;
                height: 30px;
                line-height: -50%;
                text-align: center;
                border-radius: 20px;
            }

            .login a {
                font-weight: 500;
            }

            a:hover, a:active, a:visited, a:link{
                text-decoration: none !important;
            }

            ul {
                font-weight: 600;
                font-family: "Poppins", sans-serif;
                margin-top: 0
            }

            * {
                margin-top: 0
            }


        </style>
    </head>
    <body>
        <div class="main-header">
            <div>
                <nav class="main-nav">
                    <ul>
                        <li class="drop-holder" style="position: absolute;left: 5%;">
                            <c:if test="${sessionScope.tk.capDo.maLoai == 2}">
                                <a href="viewtaikhoan?tendangnhap=${sessionScope.tk.tenDangNhap}">User ${sessionScope.tk.tenDangNhap}</a>
                            </c:if>
                            <c:if test="${sessionScope.tk.capDo.maLoai == 3}">
                                <a href="viewtaikhoan?tendangnhap=${sessionScope.tk.tenDangNhap}">Admin ${sessionScope.tk.tenDangNhap}</a>
                            </c:if>
                        </li>
                        <li class="drop-holder">
                            <a href="home.jsp">Home</a>
                        </li>
                        <c:if test="${sessionScope.tk.capDo.maLoai >= 2}">
                            <li class="drop-holder">
                                <a href="danhsachmonthi">Quản lý Bài Thi</a>
                            </li>
                            <li class="drop-holder">
                                <a href="danhsachsinhvien">Quản lý Điểm</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.tk.capDo.maLoai == 3}">
                            <li class="drop-holder">
                                <a href="danhsachtaikhoan">Quản lý Tài khoản</a>
                            </li>
                        </c:if>
                        <li class="drop-holder">
                            <i id="user" onclick="dropp()" class="fa-solid fa-user" style="color: white"></i>
                            <a id="dropp" class="dropdown-item login" href="shared/ClearLoginSession.jsp" style="display: none">Log out</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>

        <script>
            function dropp() {
                var display = document.getElementById('dropp');
                if (display.style.display === 'block') {
                    display.style.display = 'none';
                } else {
                    display.style.display = 'block';
                    display.style.width = "80px";
                    display.style.position = "absolute";
                    display.style.top = "40px";
                    display.style.boxShadow = "0px 8px 16px 0px rgba(0,0,0,0.2)";
                    display.style.padding = "3px 12px";
                    display.style.zIndex = "1";
                    display.style.backgroundColor = "rgba(0,123,255,1)";
                }
            }
        </script>
    </body>
</html>
