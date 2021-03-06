package ua.nure.pihnastyi.service;

import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.OrderDAO;
import ua.nure.pihnastyi.db.UserDAO;
import ua.nure.pihnastyi.db.entity.*;
import ua.nure.pihnastyi.db.util.ServiceConstants;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class OrderService {
    private static OrderService instance;

    public static synchronized OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    private OrderService() {
        orderDao = OrderDAO.getInstance();

    }

    //////////////////////////////////

    private OrderDAO orderDao;


    public void createOrder(String userLogin, Set<String> orderKeys) {
        Connection con = null;
        long orderId;
        try {
            con = DBManager.getInstance().getConnection();
            User user = UserService.getInstance().getUsersByLogin(userLogin);
            Status status = StatusService.getInstance().getStatusByName(ServiceConstants.STATUS_BOOK);
            Order order = new Order(status.getId());
            order.setUserId(user.getId());
            orderId = OrderDAO.getInstance().insertOrder(con, order);
            for (String goodsId : orderKeys) {
                OrderDAO.getInstance().insertGoodsToOrder(con, goodsId, orderId);
            }

        } finally {
            DBManager.close(con);
        }

    }

    public List<Order> getAllOrderByLogin(String userLogin) {

        List<Order> orders = null;
        Connection con = null;
        User user = null;

        try {
            con = DBManager.getInstance().getConnection();
            user = UserDAO.getInstance().findUserByLogin(con, userLogin);
            long userLoginId = user.getId();
            orders = orderDao.findAllOrdersByLogin(con, userLoginId);
        } catch (SQLException ex) {

        } finally {
            DBManager.close(con);
        }

        return orders;
    }

    public boolean setStatusByOrderId(String orderId, String orderStatus) {
        Connection con = null;
        boolean hasBaned;
        try {
            con = DBManager.getInstance().getConnection();
            Status status = StatusService.getInstance().getStatusByName(orderStatus);
            long orderStatusId = status.getId();
            hasBaned =orderDao.editStatusByOrderId(con, orderId, orderStatusId);
        } finally {
            DBManager.close(con);
        }
        return hasBaned;
    }

    public List<Order> getAllOrder() {
        List<Order> orders = null;
        Connection con = null;
        User user = null;

        try {
            con = DBManager.getInstance().getConnection();
            orders = orderDao.findAllOrders(con);
        } finally {
            DBManager.close(con);
        }

        return orders;
    }
}
