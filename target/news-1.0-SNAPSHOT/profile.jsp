<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<%
    if (request.getSession().getAttribute("currentUser") != null) {
        user = (Users) request.getSession().getAttribute("currentUser");
%>
<div class="container rounded bg-white mt-5 mb-5">

    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img style="width: 90px; height: 90px" class="rounded-circle mt-5"
                     src="<%=user.getPathImage()%>"><span
                    class="font-weight-bold"><%=user.getFullName()%></span><span
                    class="text-black-50"><%=user.getEmail()%></span><span> </span></div>
        </div>
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <form action="/profile" method="post">
                    <input type="hidden" name="id" value="<%=user.getId()%>">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Profile Settings</h4>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Full name</label><input type="text"
                                                                                            class="form-control"
                                                                                            name="fullname"
                                                                                            value="<%=user.getFullName()%>">
                        </div>
                        <div class="col-md-6"><label class="labels">Email</label><input type="text" class="form-control"
                                                                                        name="email"
                                                                                        value="<%=user.getEmail()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">Login</label><input type="text"
                                                                                         class="form-control"
                                                                                         value="<%=user.getLogin()%>">
                        </div>
                        <div class="col-md-12"><label class="labels">Password</label><input type="password"
                                                                                            class="form-control"
                                                                                            placeholder="enter password">
                        </div>
                        <div class="col-md-12"><label class="labels">New Password</label><input type="password"
                                                                                                class="form-control"
                                                                                                placeholder="enter new password">
                        </div>
                        <div class="col-md-12"><label class="labels">Path image</label><input type="text"
                                                                                              class="form-control"
                                                                                              placeholder="path"></div>
                    </div>
                </form>
                <div class="mt-5 text-center">
                    <button class="btn btn-primary profile-button" type="button">Save Profile</button>
                </div>
            </div>
        </div>

    </div>
</div>
<%
    }
%>

<%@include file="script.jsp" %>
</body>
</html>
