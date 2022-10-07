package peaksoft.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {


    public static final String url = "jdbc:postgresql://localhost:5432/postgres";
    public static final String user = "postgres";
    public static final String password = "@18012004@";

    public static Connection connection() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connection success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }



    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL,"jdbc:postgresql://localhost:5432/postgres");
                settings.put(Environment.USER,"postgres");
                settings.put(Environment.PASS,"@18012004@");
                settings.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL,"true");
                settings.put(Environment.HBM2DDL_AUTO,"validate");//validate //create

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }catch (Exception e){
                System.out.println(e.getMessage());;
            }
        }
        return sessionFactory;
    }
    public static void shutDown(){
        getSessionFactory().close();
    }
}
