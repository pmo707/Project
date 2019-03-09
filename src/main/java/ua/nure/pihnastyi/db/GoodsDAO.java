package ua.nure.pihnastyi.db;


import ua.nure.pihnastyi.controller.Paths;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.db.util.DBConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GoodsDAO {


    private static final String SQL_CREATE_GOODS = "INSERT INTO goods VALUES (default, ?, ?, CURRENT_TIME,?, ?, ?, ?)";
    private static GoodsDAO instance;

    public static synchronized GoodsDAO getInstance() {
        if (instance == null) {
            instance = new GoodsDAO();
        }
        return instance;
    }

    public GoodsDAO() {
    }


    public List<Goods> findAllGoods(Connection con) throws SQLException, DBException {
        List<Goods> goodsList = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(DBConstants.SQL_FIND_ALL_GOODS);
            while (rs.next()) {
                goodsList.add(extractGoods(rs));
            }
        } finally {
            DBManager.close(rs);
            DBManager.close(stmt);
        }

        return goodsList;
    }


    public void insertGoods(Connection con, Goods goods) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int k = 1;
        connection = con;
        try {
            pstmt = connection.prepareStatement(SQL_CREATE_GOODS,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(k++, goods.getName());
            pstmt.setLong(k++, goods.getPrice());
         //   pstmt.setDate(k++, (Date) goods.getCreatedAt());
            pstmt.setString(k++, goods.getColor());
            pstmt.setLong(k++, goods.getSize());
            pstmt.setLong(k++, goods.getAvailable());
            pstmt.setString(k++, goods.getCategory());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
            DBManager.close(connection);
        }

    }


    public static Goods extractGoods(ResultSet rs) throws SQLException, DBException {
        Goods goods = new Goods();
        goods.setId(rs.getInt(DBConstants.GOODS_ID));
        goods.setName(rs.getString(DBConstants.GOODS_NAME));
        goods.setPrice(rs.getLong(DBConstants.GOODS_PRICE));
        goods.setCreatedAt(rs.getDate(DBConstants.GOODS_DATE));
        goods.setColor(rs.getString(DBConstants.GOODS_COLOR));
        goods.setSize(rs.getLong(DBConstants.GOODS_SIZE));
        goods.setAvailable(rs.getLong(DBConstants.GOODS_AVAILABLE));
        goods.setCategory(rs.getString(DBConstants.GOODS_CATEGORY));
        return goods;
    }


}
