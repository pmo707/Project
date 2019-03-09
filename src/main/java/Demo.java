import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.UserDAO;
import ua.nure.pihnastyi.db.entity.Role;
import ua.nure.pihnastyi.db.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Demo {
    private static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) throws SQLException {
        // users  ==> [ivanov]
        // teams ==> [teamA]

        User user;
        UserDAO userDAO= new UserDAO();
      //  user = userDAO.getUser("admin","admin");

        Connection con = DBManager.getInstance().getConnection();


        System.out.println( con);
    }

}
