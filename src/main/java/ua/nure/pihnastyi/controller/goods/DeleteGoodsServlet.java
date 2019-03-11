package ua.nure.pihnastyi.controller.goods;

import ua.nure.pihnastyi.controller.Paths;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteGoods")
public class DeleteGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodsId = req.getParameter("id");
        GoodsService.getInstance().getDeleteById(goodsId);


        String address = Paths.LIST_GOODS;


        resp.sendRedirect(getServletContext().getContextPath() + address);
    }
}
