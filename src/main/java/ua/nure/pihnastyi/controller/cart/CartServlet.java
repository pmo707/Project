package ua.nure.pihnastyi.controller.cart;

import org.apache.log4j.Logger;
import ua.nure.pihnastyi.controller.Paths;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.service.OrderService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(CartServlet.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(Paths.CART_PAGE).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<String, Goods> cartList = (Map<String, Goods>) session.getAttribute("cartList");

        if(cartList==null){
            req.setAttribute("error", true);
            req.getRequestDispatcher(Paths.CART_PAGE).forward(req, resp);
            LOG.info("cart is empty");
            return;
        }
        LOG.info("get all goods in cart");
        String userLogin = (String) session.getAttribute("login");
        Set<String> orderKeys = cartList.keySet();
        OrderService.getInstance().createOrder(userLogin, orderKeys);
        cartList.clear();
        LOG.info("cart is clean, order created");
        req.setAttribute("cartList", cartList);
        String address = Paths.LIST_GOODS;
        resp.sendRedirect(getServletContext().getContextPath() + address);

    }
}


