package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Vera", "Olegovna", (byte) 29);
        userDaoJDBC.saveUser("Serg", "Sergeevich", (byte) 34);
        userDaoJDBC.saveUser("Svetlana", "Ivanovna", (byte) 20);
        userDaoJDBC.saveUser("Igor", "Sergeevich", (byte) 28);

        System.out.println(userDaoJDBC.getAllUsers());
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
        userDaoJDBC.getConnection().close();
    }
}
