<%@ page import="Chingis.Montayev.news.model.Users" %>
<%
    Users user = (Users) request.getSession().getAttribute("currentUser");
    if (user == null) {
%>
<div class="container">
    <nav style="border-radius: 10px" class="navbar navbar-expand-lg navbar-dark bg-dark"
         aria-label="Ninth navbar example">
        <div class="container-xl">
            <a style="margin-left: 100px" class="navbar-brand" href="#">News</a>
            <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarsExample07XL" aria-controls="navbarsExample07XL" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="navbar-collapse collapse" id="navbarsExample07XL" style="">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Sign in</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login?news=news">Add News</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<%
} else {
%>
<div class="container">
    <nav style="border-radius: 10px" class="navbar navbar-expand-lg navbar-dark bg-dark"
         aria-label="Ninth navbar example">
        <div class="container-xl">
            <a style="margin-left: 100px" class="navbar-brand" href="#">News</a>
            <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarsExample" aria-controls="navbarsExample" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="navbar-collapse collapse" id="navbarsExample" style="">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/profile">My Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/addNews">Add News</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <%
        }
    %>
</div>

