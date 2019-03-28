package ua.nure.pihnastyi.service;

import ua.nure.pihnastyi.db.CategoryDAO;
import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.entity.Category;

import java.sql.Connection;


public class CategoryService {

    private static CategoryService instance;

    public static synchronized CategoryService getInstance() {
        if (instance == null) {
            instance = new CategoryService();
        }
        return instance;
    }

    private CategoryService() {
        categoryDao = CategoryDAO.getInstance();

    }

    //////////////////////////////////

    private CategoryDAO categoryDao;


    public Category getCategoryByName(String categoryName) {
        Connection con = null;
        Category category = null;
        try {
            con = DBManager.getInstance().getConnection();

            category = categoryDao.findCategoryByName(con,categoryName);
        } finally {
            DBManager.close(con);
        }
        return category;
    }

}
