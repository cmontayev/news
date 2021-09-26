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
                if (request.getAttribute("successMessage") != null) {
            %>
            <div class="alert alert-success" role="alert">
                <%=request.getAttribute("successMessage")%>
            </div>
            <%
                }
            %>
            <%
                if (request.getAttribute("errorMessage") != null) {
            %>
            <div class="alert alert-warning" role="alert">
                <%=request.getAttribute("errorMessage")%>
            </div>
            <%
                }
            %>
            <%
                if (request.getSession().getAttribute("currentUser") != null) {
                    user = (Users) request.getSession().getAttribute("currentUser");
            %>
            <div class="alert alert-warning" role="alert">
                <%=user.toString()%>
            </div>
            <%
                }
            %>
            <form class="form" action="/login" method="post">
                <div class="form-group" style="margin: 20px">
                    <label>Login:</label>
                    <input class="form-control" type="text" name="login">
                </div>
                <div class="form-group" style="margin: 20px">
                    <label>Password:</label>
                    <input class="form-control" type="password" name="password">
                </div>
                <button class="btn btn-primary" style="margin: 10px">Login</button>
                <div class="mt-5">
                    <p class="text-center">Dont have an account?
                        <a class="" href="/register"> Register</a>
                    </p>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="script.jsp" %>
</body>
</html>
