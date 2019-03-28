package ua.nure.pihnastyi.controller;


import org.apache.log4j.Logger;
import ua.nure.pihnastyi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setUserRoleByLogin")
public class EditUserRoleServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(EditUserRoleServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(Paths.SET_USER_ROLE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address;
        boolean hasChange;
        String login = req.getParameter("login");
        String role = req.getParameter("role");

        hasChange = UserService.getInstance().setUserRoleByLogin(login, role);
        if (!hasChange) {
            req.setAttribute("error", true);
            req.getRequestDispatcher(Paths.SET_USER_ROLE_PAGE).forward(req, resp);
            LOG.info("Login doesn't find");
            return;
        }
        LOG.info("role changed");
        address = Paths.LIST_GOODS;
        resp.sendRedirect(getServletContext().getContextPath() + address);
    }
}

