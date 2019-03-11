package ua.nure.pihnastyi.db;


import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.db.util.DBConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GoodsDAO {


    private static final String SQL_CREATE_GOODS = "INSERT INTO goods VALUES (default, ?, ?, CURRENT_TIME,?, ?, ?, ?)";
    private static final String SQL_EDIT_GOODS = "UPDATE goods SET name= ?, price =?," +
            "createdAt=CURRENT_TIME,color =?, size =?,available = ?, category_id=? WHERE id = ?";
//    private static final String SQL_FIND_GOODS_BY_ID = "SELECT * FROM goods WHERE id=?";
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
        }

    }

    public void editGoods(Connection con, Goods goods) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int k = 1;
        connection = con;
        try {
            pstmt = connection.prepareStatement(SQL_EDIT_GOODS,
                    Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(k++, goods.getName());
            pstmt.setLong(k++, goods.getPrice());
            pstmt.setString(k++, goods.getColor());
            pstmt.setLong(k++, goods.getSize());
            pstmt.setLong(k++, goods.getAvailable());
            pstmt.setString(k++, goods.getCategory());
            pstmt.setLong(k++, goods.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
        }

    }


    public Goods findGoodsById(Connection con, String goodsId) {

        Goods goods = null;

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connection = con;
            pstmt = connection.prepareStatement(DBConstants.SQL_FIND_GOODS_BY_ID);
            pstmt.setString(1, goodsId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                goods = extractGoods(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);

        }
        return goods;
    }

    public void dropGoodsById(Connection con, String goodsId) {

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            connection = con;
            pstmt = connection.prepareStatement(DBConstants.SQL_DELETE_GOODS_BY_ID);
            pstmt.setInt(1, Integer.parseInt(goodsId));
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);

        }
    }


    public static Goods extractGoods(ResultSet rs) throws SQLException {
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
