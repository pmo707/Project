package ua.nure.pihnastyi.controller.order;

import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.entity.Order;
import ua.nure.pihnastyi.service.GoodsService;
import ua.nure.pihnastyi.service.OrderService;

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

@WebServlet("/listOldOrders")
public class listOldOrders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> ordersList = null;
        Map<Long,List<Goods>> ordersUser = new HashMap();
        Map<String,String> test = new HashMap();
        List<Goods> goodsList = null;
        HttpSession session = req.getSession();
        String userLogin = (String) session.getAttribute("login");

        ordersList = OrderService.getInstance().getAllOrderByLogin(userLogin);
        for (Order order:ordersList) {
            goodsList=GoodsService.getInstance().getAllGoodsByOrderId(order.getId());
            ordersUser.put(order.getId(),goodsList);
        }
test.put("1","asdasd");
        req.setAttribute("ordersUser",ordersUser);
        req.setAttribute("test",test);


//getServletContext()
        req.getRequestDispatcher("/WEB-INF/pages/user/listOldOrders.jsp").forward(req, resp);
    }

}
