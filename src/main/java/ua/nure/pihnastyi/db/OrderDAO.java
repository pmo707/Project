package ua.nure.pihnastyi.db;

import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.entity.Order;
import ua.nure.pihnastyi.db.entity.Role;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.db.util.DBConstants;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {


    private static OrderDAO instance;

    public static synchronized OrderDAO getInstance() {
        if (instance == null) {
            instance = new OrderDAO();
        }
        return instance;
    }

    public OrderDAO() {
    }

//    public List<Order> findOrderByLogin(Connection con, String userLogin) throws SQLException{
//        List<Order> orderList = new ArrayList<>();
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        Connection connection = con;
//
//        try {
//            pstmt = connection.prepareStatement(DBConstants.SQL_FIND_GOODS_BY_ID);
//            pstmt.setString(1, userLogin);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                orderList.add(extractOrder(rs));
//            }
//        } finally {
//            DBManager.close(rs);
//            DBManager.close(pstmt);
//        }
//
//        return orderList;
//    }

    public long insertOrder(Connection con, Order order) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        long orderId = 0;
        String generatedColumns[] = { "id" };
        int k = 1;
        connection = con;
        try {
            pstmt = connection.prepareStatement(DBConstants.SQL_CREATE_ORDER,
                    generatedColumns);
            pstmt.setLong(k++, order.getUserId());
            pstmt.setLong(k++, order.getStatusId());
            //orderId= pstmt.getGeneratedKeys().getInt(0);
            if (pstmt.executeUpdate() > 0) {

                java.sql.ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if ( generatedKeys.next() ) {
                    orderId = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
        }
        return orderId;
    }

    public void insertGoodsToOrder(Connection con, String goodsId, long orderId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int k = 1;
        connection = con;
        try {
            pstmt = connection.prepareStatement(DBConstants.SQL_ADD_GOODS_TO_ORDER,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(k++, orderId);
            pstmt.setLong(k++, Long.parseLong(goodsId));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
        }
    }

    public static Order extractOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt(DBConstants.ROLE_ID));
        order.setUserId(rs.getLong("user_id"));
        order.setStatusId(rs.getLong("status_id"));
        return order;
    }


}