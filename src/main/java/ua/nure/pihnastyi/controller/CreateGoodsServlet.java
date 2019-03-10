package ua.nure.pihnastyi.controller;

import jdk.nashorn.internal.runtime.regexp.joni.WarnCallback;
import org.apache.log4j.LogManager;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createGoods")
public class CreateGoodsServlet extends HttpServlet {

    //private static final Logger LOG = LogManager.getLogger(UtilServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/WEB-INF/pages/admin/createGoods.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods goods = new Goods();

        String goodsName = req.getParameter("goodsName");
        String price = req.getParameter("price");
        String color = req.getParameter("color");
        String size = req.getParameter("size");
        String available =req.getParameter("available");
        String categoryId = req.getParameter("categoryId");
        goods.setName(goodsName);
        goods.setPrice(Long.parseLong(price));
//
        goods.setColor(color);
        goods.setSize(Long.parseLong(size));
        goods.setAvailable(Long.parseLong(available));
        goods.setCategory(categoryId);


        try {
            GoodsService.getInstance().createGoods(goods);
        } catch (DBException e) {
            e.printStackTrace();
        }

        String address = Paths.LIST_GOODS;



        resp.sendRedirect(getServletContext().getContextPath() + address);
    }
}