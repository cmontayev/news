package Chingis.Montayev.news.servlet;

import Chingis.Montayev.news.model.Users;
import Chingis.Montayev.news.service.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        if (password.equals(repassword)) {
            if (!DBManager.isExist(login, email)) {
                DBManager.creatUser(new Users(null, name, email, login, password, null));
                String successMessage = "User has been created";
                request.setAttribute("successMessage", successMessage);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                String errorMassage = "User exists";
                request.setAttribute("errorMessage", errorMassage);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "wrong password");
            request.getRequestDispatcher("register.jsp").forward(request, response);

        }
    }
}
