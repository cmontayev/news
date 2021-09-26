package Chingis.Montayev.news.servlet;

import Chingis.Montayev.news.model.Comment;
import Chingis.Montayev.news.model.Users;
import Chingis.Montayev.news.service.DBManager;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ServletAddComment", value = "/comment")
public class ServletAddComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer news_id = Integer.parseInt(request.getParameter("newsComment"));
        Users users = (Users) request.getSession().getAttribute("currentUser");
        String comment = request.getParameter("area");
        Integer users_id = Math.toIntExact(users.getId());

        Comment comment1 = new Comment(null, users_id, news_id, comment);

        if (DBManager.creatComment(comment1)
        ) {

            ArrayList<Comment> comments = DBManager.getCommentByNewsId(news_id);

            PrintWriter printWriter = response.getWriter();
            Gson gson = new Gson();
            printWriter.write(gson.toJson(comments));
        }

    }
}
