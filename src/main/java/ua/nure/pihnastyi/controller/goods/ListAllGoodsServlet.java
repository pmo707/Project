package ua.nure.pihnastyi.controller.goods;


import ua.nure.pihnastyi.db.entity.Goods;

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
        String sortType =req.getParameter("sortType");
        String varPrice1 =req.getParameter("varPrice1");
        String varPrice2 =req.getParameter("varPrice2");
        goodsList = GoodsService.getInstance().getAllGoods();
        if(sortType!=null){
            goodsList=GoodsService.getInstance().getAllGoodsSortByType(sortType);
        }
        if(varPrice1!=null&&varPrice2!=null){
            goodsList=GoodsService.getInstance().getAllGoodsSortByRange(varPrice1,varPrice2);
        }
        req.getServletContext().setAttribute("goodsList", goodsList);

        req.getRequestDispatcher("/WEB-INF/pages/listAllGoods.jsp").forward(req, resp);
    }
}