package ua.nure.pihnastyi.controller.order;

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
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/listAllOrders")
public class ListAllOrders extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Status status=null;
        Map<Order, List<Goods>> orders = new LinkedHashMap();
        List<Order> listAllOrders = null;
        List<Goods> goodsList = null;

        listAllOrders=OrderService.getInstance().getAllOrder();

        for (Order order : listAllOrders) {
            status = StatusService.getInstance().getStatusById(order.getStatusId());
            order.setStatusName(status.getName());
            goodsList = GoodsService.getInstance().getAllGoodsByOrderId(order.getId());
            orders.put(order,goodsList);

        }
        req.setAttribute("orders", orders);
        req.setAttribute("goodsList",goodsList);

        req.getRequestDispatcher(Paths.LIST_ALL_ORDERS).forward(req, resp);
    }


}
