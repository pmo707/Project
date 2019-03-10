package ua.nure.pihnastyi.service;


import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.GoodsDAO;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.db.exeption.DBException;

import java.sql.Connection;
import java.sql.SQLException;
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

    public List<Goods> getAllGoods() throws DBException {
        List<Goods> goods = null;
        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            goods = goodsDao.findAllGoods(con);
        } catch (SQLException ex) {
            throw new DBException("Cannot obtain all goods", ex);
        } finally {
            DBManager.close(con);
        }

        return goods;
    }


    public void createGoods(Goods goods) throws DBException {

        Connection con = null;

        try {
            con = DBManager.getInstance().getConnection();
            goodsDao.insertGoods(con, goods);
        } finally {
            DBManager.close(con);
        }

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
}
