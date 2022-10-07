package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Util.connection();


        UserService userService = new UserServiceImpl();
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        //   JDBC

//        userService.createUsersTable();

//        userService.saveUser("Daniel", "Toktosunov", (byte)40);
//        userService.saveUser("Atabek", "Dosbaev", (byte) 33);
//        userService.saveUser("Siymik", "Bayaliev", (byte) 29);
//        userService.saveUser("Riskeldi", "Osmonaliev", (byte) 41);

//        System.out.println(userService.getAllUsers());

//        userService.cleanUsersTable();

//        userService.dropUsersTable();


        //    Hibernate

//        userDaoHibernate.createUsersTable();

//        userDaoHibernate.saveUser("Daniel", "Toktosunov", (byte) 18);
//        userDaoHibernate.saveUser("Talant", "Zhanybaev", (byte) 23);
//        userDaoHibernate.saveUser("Siymik", "Bayaliev", (byte) 21);
//        userDaoHibernate.saveUser("Riskeldi", "Osmonaliev", (byte) 25);

//        System.out.println(userDaoHibernate.getAllUsers());

//        userDaoHibernate.cleanUsersTable();

//        userDaoHibernate.dropUsersTable();


    }
}
