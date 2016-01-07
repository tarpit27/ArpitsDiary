<%-- 
    Document   : write
    Created on : Sep 30, 2015, 7:05:01 AM
    Author     : arpit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="navbar.html" %>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 well">
                    <form class="form-horizontal" role="form" action="Write" method="POST">
                        <div class="form-group">
                            <label class="control-label col-md-2" for="title">Title:</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" placeholder="Title" name="writeTitle" autofocus="autofocus">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2" for="date">Date:</label>
                            <div class="col-md-3">
                                <input type="text" class="form-control" placeholder="YYYY-MM-DD" name="writeDate">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2" for="diary">Diary:</label>
                            <div class="col-md-10">
                                <textarea class="form-control" rows="20" cols="20" name="writeDiary" placeholder="Write your diary here.."></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2 col-md-offset-2">
                                <input type="submit" value="Submit" class="btn btn-success">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
