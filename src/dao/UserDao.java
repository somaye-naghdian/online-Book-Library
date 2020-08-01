package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDao {

    public boolean authenticateUser(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public User getUserByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = null;
        try {

            Query query = session.createQuery("from User where username=: username", User.class);
            query.setParameter("username", username);
            user = (User) query.uniqueResult();

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean register(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        if (isUserExists(user))
            return false;

        try {
            session.save(user);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean isUserExists(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean result = false;
        String username = user.getUsername();

        try {
            Query query = session.createQuery("from User u where u.username=:username ", User.class);
            query.setParameter("username", username);
            User user1 = (User) query.uniqueResult();
            transaction.commit();
            session.close();
            if (user1 != null)
                result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}


