package ua.nure.pihnastyi.db;

import ua.nure.pihnastyi.db.entity.Category;
import ua.nure.pihnastyi.db.util.DBConstants;

import java.sql.*;


public class CategoryDAO {

    private static CategoryDAO instance;

    public static synchronized CategoryDAO getInstance() {
        if (instance == null) {
            instance = new CategoryDAO();
        }
        return instance;
    }

    public CategoryDAO() {
    }

    public Category findCategoryByName(Connection con, String categoryName) {

        Category category = null;

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connection = con;
            pstmt = connection.prepareStatement(DBConstants.SQL_FIND_CATEGORY_BY_NAME);
            pstmt.setString(1, categoryName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                category = extractCategory(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
        }
        return category;
    }


    public static Category extractCategory(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt(DBConstants.CATEGORY_ID));
        category.setName(rs.getString(DBConstants.CATEGORY_NAME));
        return category;
    }


}
