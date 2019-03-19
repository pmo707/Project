package ua.nure.pihnastyi.controller.goods;


import ua.nure.pihnastyi.controller.Paths;
import ua.nure.pihnastyi.db.entity.Category;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.service.CategoryService;
import ua.nure.pihnastyi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createGoods")
public class CreateGoodsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/WEB-INF/pages/admin/createGoods.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Goods goods = new Goods();


        String goodsName = req.getParameter("goodsName");
        String price = req.getParameter("price");
        String color = req.getParameter("color");
        String size = req.getParameter("size");
        String available = req.getParameter("available");
        String categoryName = req.getParameter("categoryName");
        Category category = CategoryService.getInstance().getCategoryByName(categoryName);
        if (category == null) {
            req.setAttribute("error", true);
            req.getRequestDispatcher("/WEB-INF/pages/admin/createGoods.jsp").forward(req, resp);
            return;
        }
        goods.setName(goodsName);
        goods.setPrice(Long.parseLong(price));
        goods.setColor(color);
        goods.setSize(Long.parseLong(size));
        goods.setAvailable(Long.parseLong(available));
        goods.setCategory(String.valueOf(category.getId()));


            GoodsService.getInstance().createGoods(goods);

        String address = Paths.LIST_GOODS;


        resp.sendRedirect(getServletContext().getContextPath() + address);
    }
}