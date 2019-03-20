package ua.nure.pihnastyi.controller.order;

import org.apache.log4j.Logger;
import ua.nure.pihnastyi.controller.LoginServlet;
import ua.nure.pihnastyi.controller.Paths;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.entity.Order;
import ua.nure.pihnastyi.db.entity.Status;
import ua.nure.pihnastyi.service.GoodsService;
import ua.nure.pihnastyi.service.OrderService;
import ua.nure.pihnastyi.service.StatusService;

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
public class ListOldOrders extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ListOldOrders.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> ordersList = null;
        Status status = null;
        Map<Order, List<Goods>> ordersUser = new HashMap();
        List<Goods> goodsList = null;
        HttpSession session = req.getSession();
        String userLogin = (String) session.getAttribute("login");

        ordersList = OrderService.getInstance().getAllOrderByLogin(userLogin);
        for (Order order : ordersList) {
            status = StatusService.getInstance().getStatusById(order.getStatusId());
            order.setStatusName(status.getName());
            goodsList = GoodsService.getInstance().getAllGoodsByOrderId(order.getId());
            ordersUser.put(order, goodsList);
        }
        LOG.info("Get all old orders by login");
        req.setAttribute("ordersUser", ordersUser);
        req.setAttribute("ordersList", ordersList);

        req.getRequestDispatcher(Paths.LIST_OLD_ORDERS).forward(req, resp);
    }
}
