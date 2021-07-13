package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Vera", "Olegovna", (byte) 29);
        userService.saveUser("Serg", "Sergeevich", (byte) 34);
        userService.saveUser("Svetlana", "Ivanovna", (byte) 20);
        userService.saveUser("Igor", "Sergeevich", (byte) 28);

        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
        userService.getConnection().close();
    }
}
