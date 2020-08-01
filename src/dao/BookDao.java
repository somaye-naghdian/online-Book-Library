package dao;

import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public boolean addBook(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        if (isBookExist(book)) {
            return false;
        }
        try {
            session.save(book);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteBook(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Book book = searchBook(id);
        if (!isBookExist(book)) {
            return false;
        }
        try {
            session.delete(book);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean updateBook(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
         Integer id = book.getId();
        Book book1 = searchBook(id);
        if (!isBookExist(book1)) {
            return false;
        }
        try {
            session.update(book1);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
        }

    public Book searchBook(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Book newBook = null;
        try {
            Query query = session.createQuery("from Book b where b.id=:id", Book.class);
            query.setParameter("id", id);
            query.uniqueResult();

            newBook = (Book) query.uniqueResult();

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(newBook==null )
            return null;

        return newBook;
    }

    public List<Book> getBookList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Book> bookList = new ArrayList<>();

        try {
            Query query = session.createQuery("from  Book ", Book.class);
            bookList = query.list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public boolean isBookExist(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = book.getId();

        boolean result = false;
        try {
            Query query = session.createQuery("From Book b where b.id =: id", Book.class);
            query.setParameter("id", id);
            Book book1 = (Book) query.uniqueResult();
            transaction.commit();
            session.close();

            if (book1 != null)
                result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
