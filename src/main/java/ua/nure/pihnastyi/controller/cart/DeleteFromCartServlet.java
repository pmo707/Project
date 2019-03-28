package ua.nure.pihnastyi.controller.cart;

import org.apache.log4j.Logger;
import ua.nure.pihnastyi.controller.Paths;
import ua.nure.pihnastyi.db.entity.Goods;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/deleteFromCart")
public class DeleteFromCartServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(DeleteFromCartServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("id");
        HttpSession session = req.getSession();
        Map<String, Goods> cartList = (Map<String, Goods>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new HashMap<>();
            LOG.info("cart is empty");
        }
        cartList.remove(goodsId);
        LOG.info("delete goods with id:" + goodsId + " from cart");
        session.setAttribute("cartList", cartList);
        String address = Paths.LIST_CART;
        resp.sendRedirect(getServletContext().getContextPath() + address);
    }

}
