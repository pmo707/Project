package ua.nure.pihnastyi.controller.cart;

import ua.nure.pihnastyi.controller.Paths;
import ua.nure.pihnastyi.db.entity.Cart;
import ua.nure.pihnastyi.db.entity.Goods;

import ua.nure.pihnastyi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("id");
        Goods goodsForAdd = GoodsService.getInstance().getGoodsById(goodsId);
        HttpSession session = req.getSession();
        Map<String, Goods> cartList = (Map<String, Goods>) session.getAttribute("cartList");
        if (cartList == null) {
            cartList = new HashMap<>();
        }
        cartList.put(goodsId, goodsForAdd);
        session.setAttribute("cartList", cartList);
        String address = Paths.LIST_CART;


        resp.sendRedirect(getServletContext().getContextPath() + address);
    }
}
