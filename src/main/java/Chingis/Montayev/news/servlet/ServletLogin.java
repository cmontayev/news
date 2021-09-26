package Chingis.Montayev.news.servlet;

import Chingis.Montayev.news.model.Users;
import Chingis.Montayev.news.service.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String news = request.getParameter("news");
        HttpSession session = request.getSession();
        session.setAttribute("news_p", news);

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        HttpSession session_2 = request.getSession();
        String news_p = (String) session_2.getAttribute("news_p");
        Users user = DBManager.getUserByLogin(login, pass);
        if (user != null) {
            request.getSession().setAttribute("currentUser", user);
            if (news_p != null) {
                if (news_p.equals("news")) {
                    response.sendRedirect("/addNews");
                }
            } else {
                response.sendRedirect("/home");
            }
        } else {
            request.setAttribute("errorMessage", "Invalid login and password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
