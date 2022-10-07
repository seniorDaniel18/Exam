package peaksoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            session.close();
            System.out.println("creat success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {

        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("drop success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            session.close();
            System.out.println("save success " + name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {

        try {
            Session session = Util.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM users WHERE id = " + id).executeUpdate();
            transaction.commit();
            System.out.println("delete user with id " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {

        try{
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> userList = session.createQuery("FROM User").list();
            session.getTransaction().commit();
            session.close();
            return userList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {

        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("clean success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
