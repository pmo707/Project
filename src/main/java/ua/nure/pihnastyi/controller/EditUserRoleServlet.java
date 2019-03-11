package ua.nure.pihnastyi.controller;

import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setUserRoleByLogin")
public class EditUserRoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/user/setUserRoleByLogin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = Paths.ERROR_LOGIN_PAGE_JSP;
        User user = null;

        String login = req.getParameter("login");
        String role = req.getParameter("role");


        UserService.getInstance().setUserRoleByLogin(login,role);

        address = Paths.LIST_GOODS;



        resp.sendRedirect(getServletContext().getContextPath() + address);


    }
    }

