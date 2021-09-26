<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Chingis.Montayev.news.model.News" %>
<%@ page import="Chingis.Montayev.news.model.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="link.jsp" %>
    <%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>--%>

</head>
<style>
    body {
        background: #eee
    }

    .date {
        font-size: 11px
    }

    .comment-text {
        font-size: 12px
    }

    .fs-12 {
        font-size: 12px
    }

    .shadow-none {
        box-shadow: none
    }

    .name {
        color: black;
    }

    .cursor:hover {
        color: black;
    }

    body {
        background: #eee
    }

    .date {
        font-size: 11px
    }

    .comment-text {
        font-size: 12px
    }

    .fs-12 {
        font-size: 12px
    }

    .shadow-none {
        box-shadow: none
    }

    .name {
        color: black;
    }

    .cursor:hover {
        color: black;
    }

    a, a:hover, a:visited, a:focus {
        text-decoration: none;
    }

    div {
        position: relative;
    }

    details,
    summary {
        display: inline;
    }

    details[open] {
        display: contents;
    }

    details[open]::after { /* пространство для записи "СВЕРНУТЬ" */
        display: block;

    }

    summary {
        color: blue;
        cursor: pointer;
    }

    details[open] summary {
        position: absolute; /* переместить запись "СВЕРНУТЬ" вниз <div> */
        bottom: -10px;
        left: 0;
    }

    details[open] summary:focus {
        outline: 0;
    }

    details summary:focus {
        outline: 0;
    }

    summary::before {
        content: "more ";
    }

    details[open] summary::before {
        content: "hide..";
    }

    summary::-webkit-details-marker {
        display: none;
    }

</style>
<body>
<%@include file="navbar.jsp" %>

<div class="container">
    <%
        ArrayList<News> news = (ArrayList<News>) request.getAttribute("allNews");

        user = (Users) request.getSession().getAttribute("currentUser");
        if (news != null) {
            for (int i = 0; i < news.size(); i++) {
    %>
    <div class="d-flex justify-content-center row">
        <div class="col-md-8">
            <div class="d-flex flex-column comment-section">
                <div class="bg-white p-2" style="border-radius: 3px; margin-top: 40px">
                    <div class="d-flex flex-row user-info"><img class="rounded-circle"
                                                                src="<%=news.get(i).getUsers().getPathImage()%>"
                                                                width="40">
                        <div class="d-flex flex-column justify-content-start ml-2"><span
                                class="d-block font-weight-bold name"><%=news.get(i).getUsers().getFullName()%></span><span
                                class="date text-black-50"></span></div>
                    </div>
                    <div class="mt-2">
                        <p class="comment-text" style="font-weight:bold "><%=news.get(i).getTopic()%>
                        </p>
                    </div>
                    <div class="mt-2">
                        <p class="comment-text"><%=news.get(i).getDescription()%>
                        </p>
                    </div>
                </div>
                <div class="bg-white" style="border: solid 1px gainsboro">
                    <div class="d-flex flex-row fs-12">
                        <div class="like p-2 cursor"><i class="fa fa-thumbs-o-up"></i><span class="ml-1">Like</span>
                        </div>
                        <%
                            if (user == null) {
                        %>
                        <div class="like p-2 cursor"><i class="fa fa-commenting-o"></i><span class="ml-1">
                            <a style="margin: 0;color: black" href="/login">comment</a></span>
                        </div>
                        <%
                        } else {

                        %>
                        <div class="like p-2 cursor"><i class="fa fa-commenting-o"></i><span class="ml-1">
                            <button type="button" data-bs-toggle="modal"
                                    data-bs-target="#modalForm">Comment</button></span>
                        </div>
                        <%
                            }
                        %>
                        <div class="like p-2 cursor"><i class="fa fa-share"></i><span class="ml-1">Share</span></div>
                    </div>
                    <%
                        if (user != null) {
                    %>
                    <div class="bg-light p-2">

                        <input type="hidden" id="newsComment-<%=i%>" name="news_id" value="<%=news.get(i).getId()%>">

                        <div class="d-flex flex-row align-items-start"><img class="rounded-circle"
                                                                            src="<%=user.getPathImage()%>"
                                                                            width="40">
                            <textarea id="area-<%=i%>"
                                      class="form-control ml-1 shadow-none textarea" name="comment"></textarea></div>
                        <div class="mt-2 text-right">
                            <button class="btn btn-primary btn-sm shadow-none" type="button"
                                    onclick="addComment(<%=i%>)">
                                comment
                            </button>
                        </div>


                    </div>
                    <%
                        }
                    %>
                </div>
                <div id="newComment-<%=i%>">
                    <div>
                        <%
                            for (int s = 0; s < news.get(i).getComments().size(); s++) {
                        %>
                        <ul class="comments" style="margin: 0px">
                            <li class="clearfix">
                                <img class="rounded-circle"
                                     src="<%=news.get(i).getComments().get(s).getUsers().getPathImage()%>"
                                     width="40">
                                <div class="post-comments" style="background-color: gainsboro; border-radius: 10px">
                                    <p style="margin-left: 30px; margin-bottom: 0px"
                                       class="meta"><%=news.get(i).getComments().get(s).getUsers().getFullName()%> says
                                        :</p>
                                    <p style="margin-left: 30px; margin-bottom: 0px">
                                        <%=news.get(i).getComments().get(s).getComment()%>
                                    </p>
                                </div>
                            </li>
                        </ul>

                        <%
                                s = 5;
                            }
                        %>
                        <details>
                            <summary></summary>
                            <%
                                for (int j = 1; j < news.get(i).getComments().size(); j++) {
                            %>

                            <ul class="comments" style="margin: 0px">
                                <li class="clearfix">
                                    <img class="rounded-circle"
                                         src="<%=news.get(i).getComments().get(j).getUsers().getPathImage()%>"
                                         width="40">
                                    <div class="post-comments" style="background-color: gainsboro; border-radius: 10px">
                                        <p style="margin-left: 30px; margin-bottom: 0px"
                                           class="meta"><%=news.get(i).getComments().get(j).getUsers().getFullName()%>
                                            says :</p>
                                        <p style="margin-left: 30px; margin-bottom: 0px">
                                            <%=news.get(i).getComments().get(j).getComment()%>
                                        </p>
                                    </div>
                                </li>
                            </ul>
                            <%
                                }
                            %>
                        </details>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <%
            }
        }
    %>
</div>

<script type="text/javascript">
    function addComment(i) {
        let newsComment = document.getElementById("newsComment-" + i).value;
        let area = document.getElementById("area-" + i).value;
        const data = {
            newsComment: newsComment,
            area: area
        }
        let respons;

        $.ajax({
            type: "POST",
            url: "/comment",
            data: data,
            success: function (result) {
                area.value = "";
                console.log(result)
                let htmlCode = "";
                htmlCode += "<ul class='comments' style='margin: 0px'>";
                for (let i = 0; i < result.length; i++) {

                    htmlCode += " <li class='clearfix'>";
                    htmlCode += "<img class='rounded-circle' src=" + result[i].users.pathImage + " width='40'>";
                    htmlCode += "<div class='post-comments' style='background-color: gainsboro; border-radius: 10px'>";
                    htmlCode += "<p style='margin-left: 30px; margin-bottom: 0px";
                    htmlCode += "class='meta'>" + result[i].users.fullName + " says :</p>"
                    htmlCode += "<p style = 'margin-left: 30px; margin-bottom: 0px' >" + result[i].comment + " </p></div> </li>"
                }
                htmlCode += "</ul>";
                document.getElementById("newComment-" + i).innerHTML = htmlCode;
                document.getElementById("area-" + i).innerHTML = "";

            },
            dataType: 'json'
        });


    }
</script>
<script>


</script>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<%@include file="script.jsp" %>
</body>
</html>
