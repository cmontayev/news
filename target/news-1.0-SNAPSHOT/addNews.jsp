<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="link.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<%
    user = (Users) request.getSession().getAttribute("currentUser");
%>
<div class="container" style="width: 800px; margin-top: 100px">

    <%--    <form class="contact1-form validate-form" action="/addNews" method="post">--%>
    <%--<span class="contact1-form-title">--%>

    <%--</span>--%>
    <%--        <input type="hidden" name="id" value="<%=user.getId()%>">--%>

    <%--        <div class="wrap-input1 validate-input" data-validate="Subject is required">--%>
    <%--            <input class="input1" type="text" name="topic" placeholder="topic">--%>
    <%--            <span class="shadow-input1"></span>--%>
    <%--        </div>--%>
    <%--        <div class="wrap-input1 validate-input" data-validate="Message is required">--%>
    <%--            <textarea class="input1" name="description" placeholder="description"></textarea>--%>
    <%--            <span class="shadow-input1"></span>--%>
    <%--        </div>--%>
    <%--        <div class="container-contact1-form-btn">--%>
    <%--            <button class="contact1-form-btn">submit</button>--%>
    <%--        </div>--%>
    <%--    </form>--%>


    <form class="contact1-form validate-form" action="/addNews" method="post">
        <!-- Name input -->
        <input type="hidden" name="id" value="<%=user.getId()%>">

        <div class="form-outline mb-4">
            <input type="text" id="form4Example1" name="topic" class="form-control"/>
            <label class="form-label" for="form4Example1">Topic</label>
        </div>


        <!-- Message input -->
        <div class="form-outline mb-4">
            <textarea class="form-control" name="description" id="form4Example3" rows="4"></textarea>
            <label class="form-label" for="form4Example3">Description</label>
        </div>

        <!-- Checkbox -->
        <div class="form-check d-flex justify-content-center mb-4">
            <input
                    class="form-check-input me-2"
                    type="checkbox"
                    value=""
                    id="form4Example4"
                    checked
            />
            <label class="form-check-label" for="form4Example4">
                Send me a copy of this message
            </label>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">
            Send
        </button>
    </form>

</div>


<%@include file="script.jsp" %>
</body>
</html>
