package ua.nure.pihnastyi.controller;

import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

    Map<String, Goods> cart = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("id");
        Goods goods = null;
        goods = GoodsService.getInstance().getGoodsById(goodsId);

        HttpSession session = req.getSession();


            cart.put(goodsId, goods);


        session.setAttribute("cartList", cart);


        String address = Paths.LIST_CART;
        System.out.println(cart.size());


        resp.sendRedirect(getServletContext().getContextPath() + address);
    }
}
