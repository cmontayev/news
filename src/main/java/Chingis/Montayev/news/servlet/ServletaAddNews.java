package Chingis.Montayev.news.servlet;

import Chingis.Montayev.news.model.News;
import Chingis.Montayev.news.model.Users;
import Chingis.Montayev.news.service.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletaAddNews", value = "/addNews")
public class ServletaAddNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addNews.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.parseInt(request.getParameter("id"));
        String topic = request.getParameter("topic");
        String description = request.getParameter("description");

        News news = new News(null, userId, topic, description);
        DBManager.creatNews(news);
        response.sendRedirect("/home");
    }
}
