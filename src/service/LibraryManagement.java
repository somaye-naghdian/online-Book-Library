package service;

import dao.BookDao;
import entity.Book;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class LibraryManagement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        BookDao bookDao = new BookDao();
        User user = null;
        String bookId = request.getParameter("bookId");
        String title = request.getParameter("bookName");
        String author = request.getParameter("author");
        String choice = request.getParameter("choice");
        Integer id = Integer.parseInt(bookId);

        if (id == 0) {
            out.println("book id is false");
        }
        if (session != null) {
            user = (User) session.getAttribute("user");
        }
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body style=\"background-color:powderblue;\">");
        out.println("Welcome  " + user.getUsername());


        switch (choice) {

            case "ADD":

                try {

                    if (title.isEmpty() || author.isEmpty()) {
                        out.println("<p>All fields required </p><br> ");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("LibraryManagement.jsp");
                        dispatcher.include(request, response);
                    }else
                    if (bookDao.addBook(book)) {
                        out.println("<p style=\"color: darkblue\">The book is successfully added</p>");
                    } else {
                        out.println("<p style=\"color: darkblue\">The book can not added</p>");
                    }
                }catch (NullPointerException e){
                    out.println("<p>All fields required </p><br> ");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("LibraryManagement.jsp");
                    dispatcher.include(request, response);
                }
                break;

            case "DELETE":
                try {
                    boolean deleteBook = bookDao.deleteBook(id);
                    if (deleteBook) {
                        out.println("<p style=\"color: darkblue\">The book is successfully deleted</p>");
                    } else {
                        out.println("<p style=\"color: darkblue\">The book can not delete</p>");
                    }
                }catch (NullPointerException e){
                    out.println("<p>The Book with this specifics not found</p><br> ");
                    out.println(" to try again   <a href=LibraryManagement.jsp>Click here</a> <br> ");
                    out.println("to logout --- <a  href =Logout.jsp > Logout </a>");
                }
                break;

            case "UPDATE":
                Book returnDaoBook = null;
                try {
                    if (title.isEmpty() | author.isEmpty()) {
                        out.println("<p>All fields required </p><br> ");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("LibraryManagement.jsp");
                        dispatcher.include(request, response);
                    }
                    if (bookDao.isBookExist(book)) {
                        returnDaoBook = bookDao.searchBook(book.getId());
                    }
                    if (returnDaoBook.getId().equals(book.getId()) || returnDaoBook.getTitle().equals(book.getTitle())) {
                        out.println("<p>The new specifications of the book ' " + book.getTitle() + "'  and the previous specifications are the same</p> <br>");
                    } else {
                        boolean updateBook = bookDao.updateBook(book);
                        if (updateBook) {
                            out.println("<p>The book is successfully update</p>");
                        } else {
                            out.println("<p>The book can not up to date</p>");
                        }
                    }
                } catch (NullPointerException e) {
                    out.println("<p>All fields required </p><br> ");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("LibraryManagement.jsp");
                    dispatcher.include(request, response);
                }
                break;

            case "DISPLAY":
                List<Book> bookList = bookDao.getBookList();
                try {
                    if (bookList.size() > 0) {
                        out.println("<p style=\"color: darkblue\"> Book List </p>");
                        for (Book book1 :
                                bookList) {
                            out.println("<p style=\"color: darkblue\"> Id :" + book1.getId() + "<br> Title : " + book1.getTitle() +
                                    "<br> Author : " + book1.getAuthor() + "</p> <br>");
                        }
                    } else {
                        out.println("<p style=\"color: darkblue\">Book list is empty </p>");
                    }
                } catch (NullPointerException e) {
                    out.println("<p style=\"color: darkblue\">Book list is empty </p>");
                    out.println(" to try again   <a href=LibraryManagement.jsp>Click here</a> <br> ");
                    out.println("to logout --- <a  href =Logout.jsp > Logout </a>");
                }
                break;

            case "SEARCH":
                Book book2 = bookDao.searchBook(id);
                try {
                    if (book2.equals(null)) {
                        out.println("<p>  book with these specifications not found</p><br>");
                        out.println(" to try again   <a href=LibraryManagement.jsp>Click here</a>  ");

                    } else {

                        Integer bookId2 = book2.getId();
                        String title2 = book2.getTitle();
                        String author2 = book2.getAuthor();
                        out.println("<p style=\"color: darkblue\"> Book id : " + bookId2 + "<br> title : " + title2 +
                                "<br> author : " + author2 + "</p>");
                    }
                } catch (NullPointerException e) {
                    out.println("<p>  book with these specifications not found</p><br>");
                    out.println(" to try again   <a href=LibraryManagement.jsp>Click here</a> <br> ");
                    out.println("to logout --- <a  href =Logout.jsp > Logout </a>");

                }

                break;

        }

        ServletContext servletContext = getServletContext();
        Object users = servletContext.getAttribute("users");
        out.println("<p> online users : " + users + "</p><br>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
