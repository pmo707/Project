package ua.nure.pihnastyi.controller.goods;

import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/listAllGoods")
public class ListAllGoodsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> goodsList = null;
        HttpSession session = req.getSession();
        try {
            goodsList = GoodsService.getInstance().getAllGoods();
        } catch (DBException ex) {
            ex.printStackTrace();
        }
        session.setAttribute("goodsList", goodsList);

        //req.getRequestDispatcher("/WEB-INF/pages/listAllGoods.jsp").forward(req, resp);
        req.getRequestDispatcher("/WEB-INF/pages/listAllGoods.jsp").forward(req, resp);
    }
}
