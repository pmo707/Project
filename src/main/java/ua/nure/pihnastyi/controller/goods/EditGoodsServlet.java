package ua.nure.pihnastyi.controller.goods;


import javafx.application.Application;
import ua.nure.pihnastyi.controller.Paths;
import ua.nure.pihnastyi.db.entity.Category;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.service.CategoryService;
import ua.nure.pihnastyi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@WebServlet("/editGoods")
public class EditGoodsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("id");
        Goods goods;


        goods = GoodsService.getInstance().getGoodsById(goodsId);

        req.setAttribute("goods", goods);

        req.getRequestDispatcher("/WEB-INF/pages/admin/editGoods.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods goods = new Goods();
        String categoryName = req.getParameter("categoryName");
        String goodsId = req.getParameter("goodsId");
        String goodsName = req.getParameter("goodsName");
        String price = req.getParameter("price");
        String color = req.getParameter("color");
        String size = req.getParameter("size");
        String available = req.getParameter("available");
        Category category = CategoryService.getInstance().getCategoryByName(categoryName);


        goods.setId(Long.parseLong(goodsId));
        goods.setName(goodsName);
        goods.setPrice(Long.parseLong(price));
        goods.setColor(color);
        goods.setSize(Long.parseLong(size));
        goods.setAvailable(Long.parseLong(available));
        goods.setCategory(String.valueOf(category.getId()));


        GoodsService.getInstance().editGoods(goods);

        String address = Paths.LIST_GOODS;


        resp.sendRedirect(getServletContext().getContextPath() + address);
    }
}
