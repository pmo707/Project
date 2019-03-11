package ua.nure.pihnastyi.controller;

import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.UserDAO;
import ua.nure.pihnastyi.db.entity.Role;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String address = Paths.ERROR_LOGIN_PAGE_JSP;
        User user = null;

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        user = UserService.getInstance().getUsersByLoginAndPassword(login, password);

        if (user == null) {
            req.getRequestDispatcher(address).forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        String role = user.getRole();

        session.setAttribute("user_id", user.getId());
        session.setAttribute("role", role);
        session.setAttribute("login", login);
        session.setMaxInactiveInterval(15 * 60);
        address = Paths.LIST_GOODS;


        resp.sendRedirect(getServletContext().getContextPath() + address);


    }
}




