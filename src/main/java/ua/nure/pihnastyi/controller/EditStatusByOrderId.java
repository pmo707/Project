package ua.nure.pihnastyi.controller;

import org.apache.log4j.Logger;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.service.OrderService;
import ua.nure.pihnastyi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setStatusByOrderId")
public class EditStatusByOrderId extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(EditUserRoleServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/admin/setStatusByOrderId.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = Paths.ERROR_LOGIN_PAGE_JSP;
        User user = null;

        String orderId = req.getParameter("orderId");
        String orderStatus = req.getParameter("orderStatus");


        OrderService.getInstance().setStatusByOrderId(orderId,orderStatus);
        LOG.info("order status changed");
        address = Paths.LIST_GOODS;



        resp.sendRedirect(getServletContext().getContextPath() + address);


    }
}