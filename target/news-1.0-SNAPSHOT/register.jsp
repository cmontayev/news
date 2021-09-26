<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="link.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-6 offset-3">
            <%
                if (request.getAttribute("errorMessage") != null) {
            %>
            <div class="alert alert-warning" role="alert">
                <%=request.getAttribute("errorMessage")%>
            </div>
            <%
                }
            %>
            <form class="form" action="/register" method="post">
                <div class="form-group">
                    <label for="fullname">Full name:</label>
                    <input id="fullname" class="form-control" type="text" name="fullname">
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <input class="form-control" type="email" name="email">
                </div>
                <div class="form-group">
                    <label for="login">Login:</label>
                    <input id="login" class="form-control" type="text" name="login">
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input class="form-control" type="password" name="password">
                </div>
                <div class="form-group">
                    <label>Re-password:</label>
                    <input class="form-control" type="password" name="repassword">
                </div>
                <button class="btn btn-primary">Register</button>
            </form>
        </div>
    </div>
</div>
<%@include file="script.jsp" %>
</body>
</html>
