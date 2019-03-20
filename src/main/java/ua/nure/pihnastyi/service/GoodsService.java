package ua.nure.pihnastyi.service;


import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.GoodsDAO;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.util.ServiceConstants;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsService {

    private static GoodsService instance;

    public static synchronized GoodsService getInstance() {
        if (instance == null) {
            instance = new GoodsService();
        }
        return instance;
    }

    private GoodsService() {
        goodsDao = GoodsDAO.getInstance();

    }

    //////////////////////////////////

    private GoodsDAO goodsDao;

    public List<Goods> getAllGoods() {
        List<Goods> goods = null;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            goods = goodsDao.findAllGoods(con);
        } catch (SQLException ex) {

        } finally {
            DBManager.close(con);
        }

        return goods;
    }


    public List<Goods> getAllGoodsByOrderId(long orderId) {

        List<Goods> goods = null;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            goods = goodsDao.findAllGoodsByOrderId(con, orderId);
        } catch (SQLException ex) {

        } finally {
            DBManager.close(con);
        }

        return goods;
    }

    public boolean createGoods(Goods goods) {

        Connection con = null;
        boolean hasCreated;

        try {
            con = DBManager.getInstance().getConnection();
            hasCreated = goodsDao.insertGoods(con, goods);
        } finally {
            DBManager.close(con);
        }
        return hasCreated;
    }


    public void editGoods(Goods goods) {

        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            goodsDao.editGoods(con, goods);

        } finally {
            DBManager.close(con);
        }
    }

    public Goods getGoodsById(String goodsId) {
        Goods goods = null;
        Connection con = null;
        try {
            con = DBManager.getInstance().getConnection();
            goods = goodsDao.findGoodsById(con, goodsId);

        } finally {
            DBManager.close(con);
        }
        return goods;
    }

    public void getDeleteById(String goodsId) {

        Connection con = null;
        Goods goods = null;
        try {
            con = DBManager.getInstance().getConnection();

            goodsDao.dropGoodsById(con, goodsId);
        } finally {
            DBManager.close(con);
        }
    }

    public List<Goods> getAllGoodsSortByRangePrice(String varPrice1, String varPrice2) {

        List<Goods> goods = new ArrayList<>();
        Connection con = null;

        con = DBManager.getInstance().getConnection();
        try {
            goods = goodsDao.findAllGoodsByRangePrice(con, varPrice1, varPrice2);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con);
        }

        return goods;

    }

    public List<Goods> getAllGoodsSortByRangeSize(String varSize1, String varSize2) {

        List<Goods> goods = new ArrayList<>();
        Connection con = null;

        con = DBManager.getInstance().getConnection();
        try {
            goods = goodsDao.findAllGoodsByRangeSize(con, varSize1, varSize2);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con);
        }

        return goods;

    }

    public List<Goods> getAllGoodsSortByCategory(String varCategory) {
        List<Goods> goods = new ArrayList<>();
        Connection con = null;

        con = DBManager.getInstance().getConnection();
        try {
            goods = goodsDao.findAllGoodsByCategory(con, varCategory);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con);
        }

        return goods;
    }


    public List<Goods> getAllGoodsSortByColor(String varColor) {
        List<Goods> goods = new ArrayList<>();
        Connection con = null;

        con = DBManager.getInstance().getConnection();

        try {
            goods = goodsDao.findAllGoodsByColor(con, varColor);
        } catch (SQLException e) {
            e.printStackTrace();


        } finally {
            DBManager.close(con);
        }

        return goods;
    }

    public List<Goods> getAllGoodsSortByType(String sortType) {
        List<Goods> goods = null;
        Connection con = null;

        con = DBManager.getInstance().getConnection();
        try {
            switch (sortType) {

                case ServiceConstants.SORT_BY_NAME_AZ:
                    goods = goodsDao.findAllGoodsByNameAZ(con);
                    break;
                case ServiceConstants.SORT_BY_NAME_ZA:
                    goods = goodsDao.findAllGoodsByNameZA(con);
                    break;
                case ServiceConstants.SORT_BY_PRICE_LOW_TO_HIGH:
                    goods = goodsDao.findAllGoodsByPriceLowToHigh(con);
                    break;
                case ServiceConstants.SORT_BY_PRICE_HIGH_TO_LOW:
                    goods = goodsDao.findAllGoodsByPriceHighToLow(con);
                    break;
                case ServiceConstants.SORT_BY_DATE_NEW_TO_OLD:
                    goods = goodsDao.findAllGoodsByDateNewToOld(con);
                    break;
                case ServiceConstants.SORT_BY_DATE_OLD_TO_NEW:
                    goods = goodsDao.findAllGoodsByDateOldToNew(con);
                    break;
                default:
                    goods = goodsDao.findAllGoodsByNameAZ(con);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con);
        }

        return goods;
    }


}
