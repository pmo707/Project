package ua.nure.pihnastyi.db.util;

public class DBConstants {
    public static final String USER_ID = "id";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";

    public static final String SQL_FIND_ALL_USERS = "SELECT * FROM user u" +
            " INNER JOIN roles r ON u.role_id = r.id";

    public static final String SQL_FIND_ALL_GOODS = "SELECT * FROM goods g INNER JOIN category c ON g.category_id = c.id";
    public static final String SQL_FIND_GOODS_BY_ID = SQL_FIND_ALL_GOODS + " WHERE g.id=?";


    public static final String SQL_FIND_CATEGORY_BY_NAME = "SELECT * FROM category WHERE name_category=?";
    public static final String SQL_FIND_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";

    public static final String SQL_DELETE_GOODS_BY_ID = "DELETE FROM goods WHERE id=?";


    public static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM user u INNER JOIN roles r ON u.role_id = r.id WHERE u.login=?";

    public static final String SQL_EDIT_USER_ROLE = "UPDATE roles\n" +
            "INNER JOIN user ON user.role_id = roles.id\n" +
            "SET user.role_id = ? \n" +
            "WHERE user.login = ?;";

    public static final String SQL_FIND_ROLE_BY_NAME = "SELECT * FROM roles WHERE name=?";






    public static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD =
            SQL_FIND_ALL_USERS + " WHERE u.login=? && u.password=?";
    public static final String SQL_INSERT_USER = "INSERT INTO user VALUES (DEFAULT, ?, ?, ?, ?)";
    public static final String SQL_UPDATE_GOODS = " UPDATE goods\n" +
            "SET name = 'Alfred Schmidt', price = 11,createdAt=CURRENT_TIME,color ='red', size =11,available = 11, category_id=1\n" +
            "WHERE id = 5";
    public static final String SQL_DELETE_USER = " DELETE FROM user WHERE id=?";
    public static final String SQL_SELECT_USER_GROUPS =
            "SELECT g.name FROM user_group ug" +
                    " INNER JOIN `group` g ON g.id=ug.group_id" +
                    " WHERE ug.user_id=?";
    public static final String SQL_CREATE_USER_GROUP = "INSERT INTO user_group VALUES(?, ?)";
    public static final String SQL_GET_GROUP_ID_BY_NAME = "SELECT id FROM `group` WHERE name=?";
    public static final String SQL_DELETE_USER_GROUP = "DELETE FROM user_group WHERE user_id=?";


    public static final String ROLE = "name";
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_USER = "user";
    public static final String GROUP_NAME = "name";

    public static final String GOODS_ID = "id";
    public static final String GOODS_NAME = "name";
    public static final String GOODS_PRICE = "price";
    public static final String GOODS_DATE = "createdAt";
    public static final String GOODS_COLOR = "color";
    public static final String GOODS_SIZE = "size";
    public static final String GOODS_AVAILABLE = "available";
    public static final String GOODS_CATEGORY = "name_category";


    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "name_category";


    public static final String ROLE_ID = "id";
    public static final String ROLE_NAME = "name";

}
