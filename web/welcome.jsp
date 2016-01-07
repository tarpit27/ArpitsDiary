<%-- 
    Document   : welcome
    Created on : Oct 22, 2015, 1:34:38 PM
    Author     : arpit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome ${sessionScope.username}</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/customWelcome.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

        <script src="js/welcomeJs.js"></script>

    </head>
    <body>

        <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <sql:setDataSource var="data" driver="com.mysql.jdbc.Driver" 
                           url="jdbc:mysql://localhost:3306/ArpitsDiary" 
                           user="root" password="arpit"/>

        <sql:query dataSource="${data}" var="result">
            select * from content where username="${sessionScope.username}";
        </sql:query>

        <%! int counter = 0;%>

        <c:forEach var="count" items="${result.rows}">
            <% counter++;%>
        </c:forEach>


        <div id="myCarousel"  class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <c:forEach var="count"  begin="1" end="<%=counter%>">
                    <li data-target="#myCarousel" data-slide-to="${count}"></li>
                    </c:forEach>
                    <%counter = 0;%>
            </ol>
            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <div class="container-fluid well">
                        <div class="row">
                            <div class="col-md-12 heading">
                                <div id="brand">
                                    <span id="brand-greet">welcome_</span>${sessionScope.username}
                                </div>
                                <div class="head-title">
                                    ${sessionScope.username}'s #personal diary
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <c:forEach var="carRow" items="${result.rows}">
                    <div class="item">
                        <div class="container-fluid well">
                            <div class="row">
                                <div class="col-md-12 heading">
                                    <div id="brand">
                                        <span id="brand-greet" class="text-info">${carRow.title}</span>
                                    </div>
                                    <div class="head-title">
                                        ${sessionScope.username}'s #personal diary
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- Left and Right controls -->
            <a href="#myCarousel" class="left carousel-control" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a href="#myCarousel" class="right carousel-control" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>



        <%@include file="navbar.html" %>



        <div class="container">

            <c:if test="${empty result.rows}">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="alert alert-danger text-center">
                            <strong>No diary yet! </strong>Start writing now.
                        </div>
                    </div>
                </div>
            </c:if>

            <!-- To provide editing -->       
            <div class="row text-center" id="editRow">
                <div class="col-md-6 col-md-offset-3 page-header">
                    <form action="edit.jsp" method="get" class="form-inline">
                        <div class="form-group">
                            <div class="input-group">
                                <input type="text" name="editTitle" class="form-control" placeholder="Enter title to edit..." size="60"/>
                                <span class="input-group-btn">
                                    <input type="submit" class="form-control btn btn-warning" value="Edit"/>
                                </span>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <c:forEach var="row" items="${result.rows}" varStatus="status">

                <div class="col-md-6">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <strong>#${status.index + 1}.</strong> ${row.title}
                            <a href="#diary${status.index}" data-toggle="collapse">
                                <span id="plusSign" class="pull-right glyphicon glyphicon-plus-sign"></span>
                            </a>
                        </div>
                        <div class="panel-collapse collapse" id="diary${status.index}">
                            <div class="panel-body">
                                <blockquote>
                                    <i class="fa fa-quote-left fa-2x"></i> ${row.diary}<br>
                                    <footer>${sessionScope.username}'s diary</footer>
                                </blockquote>
                            </div>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>
    </body>
</html>
