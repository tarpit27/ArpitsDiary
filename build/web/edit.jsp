<%-- 
    Document   : edit
    Created on : Oct 29, 2015, 10:15:24 PM
    Author     : arpit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/editCss.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    </head>
    <body>
        <!-- JSTL -->
        <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <sql:setDataSource var="toEdit" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/arpitsdiary" user="root" password="arpit"></sql:setDataSource>
        <sql:query dataSource="${toEdit}" var="result">
            select title,diary from content where username = "${sessionScope.username}" and title = "${param.editTitle}" ;
        </sql:query>

            <!-- Navbar -->
            <%@include file="navbar.html" %>
            
        <!-- To display -->
        <div class="container">
            <div class="row">
                <form action="Edit" method="post">
                    <c:forEach var="row" items="${result.rows}">
                        <div class="row">
                            <div class="col-md-4 col-md-offset-4">
                                <div class="form-group">
                                    <input type="text" value="${row.title}" class="form-control" name="title" readonly="readonly" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-8 col-md-offset-2">
                                <textarea rows="10" cols="15" class="form-control" name="newDiary" >${row.diary}</textarea>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <button class="form-control btn btn-danger">Edit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
