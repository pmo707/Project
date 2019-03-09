package ua.nure.pihnastyi.db.util;

public class DBConstants {
    public static final String USER_ID = "id";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_FULL_NAME = "full_name";

    public static final String SQL_FIND_ALL_USERS = "SELECT * FROM user u" +
            " INNER JOIN role r ON u.role_id = r.id";

    public static final String SQL_FIND_ALL_GOODS = "SELECT * FROM goods g INNER JOIN category c ON g.category_id = c.id";
    public static final String SQL_FIND_USER_BY_ID = SQL_FIND_ALL_USERS + " WHERE u.id=?";
    public static final String SQL_FIND_USER_BY_LOGIN = SQL_FIND_ALL_USERS + " WHERE u.login=?";
    public static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD =
            SQL_FIND_ALL_USERS + " WHERE u.login=? && u.password=?";
    public static final String SQL_INSERT_USER = "INSERT INTO user VALUES (DEFAULT, ?, ?, ?, ?)";
    public static final String SQL_UPDATE_USER = " UPDATE user SET login=?, password=? WHERE id=?";
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
    public static final String GOODS_DESCRIPTION = "description";
}
