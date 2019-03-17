package ua.nure.pihnastyi.service;

import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.OrderDAO;
import ua.nure.pihnastyi.db.entity.Order;
import ua.nure.pihnastyi.db.entity.Status;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.db.util.ServiceConstants;

import java.sql.Connection;
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


    public void createOrder(String userLogin,Set<String> orderKeys) {
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

 //   public void createGoodsToOrder(long orderId, ) {
//        Connection con = null;
//
//        try {
//            con = DBManager.getInstance().getConnection();
//
//
//        } finally {
//            DBManager.close(con);
//        }
//
//    }
}
