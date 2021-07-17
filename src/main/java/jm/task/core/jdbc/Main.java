package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {
        /*UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Vera", "Olegovna", (byte) 29);
        userDaoJDBC.saveUser("Serg", "Sergeevich", (byte) 34);
        userDaoJDBC.saveUser("Svetlana", "Ivanovna", (byte) 20);
        userDaoJDBC.saveUser("Igor", "Sergeevich", (byte) 28);

        System.out.println(userDaoJDBC.getAllUsers());
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
        userDaoJDBC.getConnection().close();*/

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Vera", "Olegovna", (byte) 29);
        userDaoHibernate.saveUser("Serg", "Sergeevich", (byte) 34);
        userDaoHibernate.saveUser("Svetlana", "Ivanovna", (byte) 20);
        userDaoHibernate.saveUser("Igor", "Sergeevich", (byte) 28);

        System.out.println(userDaoHibernate.getAllUsers());
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
        userDaoHibernate.getSessionFactory().close();
    }
}
