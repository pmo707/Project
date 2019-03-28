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

import static ua.nure.pihnastyi.db.GoodsDAO.extractGoods;

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

    public List<Order> findAllOrdersByLogin(Connection con, long userLoginId) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection connection = con;

        try {
            pstmt = connection.prepareStatement(DBConstants.SQL_FIND_ORDER_BY_LOGIN);
            pstmt.setLong(1, userLoginId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                orderList.add(extractOrder(rs));
            }
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
        }

        return orderList;
    }


    public List<Order> findAllOrders(Connection con) {

        List<Order> ordersList = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(DBConstants.SQL_FIND_ALL_ORDER);
            while (rs.next()) {
                ordersList.add(extractOrder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(stmt);
        }

        return ordersList;
    }

    public long insertOrder(Connection con, Order order) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        long orderId = 0;
        String generatedColumns[] = {"id"};
        int k = 1;
        connection = con;
        try {
            pstmt = connection.prepareStatement(DBConstants.SQL_CREATE_ORDER,
                    generatedColumns);
            pstmt.setLong(k++, order.getUserId());
            pstmt.setLong(k++, order.getStatusId());
            if (pstmt.executeUpdate() > 0) {

                java.sql.ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
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

    public boolean editStatusByOrderId(Connection con, String orderId, long orderStatusId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;

        int k = 1;
        connection = con;
        try {
            pstmt = connection.prepareStatement(DBConstants.SQL_EDIT_ORDER_STATUS_BY_ID,
                    Statement.RETURN_GENERATED_KEYS);


            pstmt.setLong(k++, orderStatusId);
            pstmt.setString(k++, orderId);

            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
        }
        return count>0;
    }

    public static Order extractOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt(DBConstants.ORDER_ID));
        order.setUserId(rs.getLong("user_id"));
        order.setStatusId(rs.getLong("status_id"));
        order.setCreatedAt(rs.getDate("created_at"));
        return order;
    }



}