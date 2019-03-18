package ua.nure.pihnastyi.controller.cart;

import ua.nure.pihnastyi.controller.Paths;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.service.GoodsService;
import ua.nure.pihnastyi.service.OrderService;
import ua.nure.pihnastyi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/pages/user/cart.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Map<String, Goods> cartList = (Map<String, Goods>) session.getAttribute("cartList");
        String userLogin = (String) session.getAttribute("login");
        Set<String> orderKeys = cartList.keySet();
        OrderService.getInstance().createOrder(userLogin,orderKeys);
        cartList.clear();
        req.setAttribute("cartList", cartList);

        String address = Paths.LIST_GOODS;

        resp.sendRedirect(getServletContext().getContextPath() + address);

    }
}


