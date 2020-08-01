package service;

import dao.UserDao;
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

public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        UserDao userDao = new UserDao();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.println("username" + username);

        boolean result = userDao.authenticateUser(username, password);
        User user = userDao.getUserByUsername(username);

        HttpSession session = request.getSession(false);
        ServletContext servletContext = getServletContext();

        if (session.getAttribute("user") != null) {
            out.println("please first log out ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.include(request, response);
        } else {


            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body style=\"background-color:powderblue;\">");

            if (result == true) {
                session.setAttribute("user", user);
                String name = user.getUsername();
                out.println("<head>");
                out.println("<h3>***** Welcome  " + name + "  *****</h3>");
                out.println("</head>");
                RequestDispatcher dispatcher = request.getRequestDispatcher("LibraryManagement.jsp");
                dispatcher.forward(request, response);

                String onlineUsers = (String) servletContext.getAttribute("users");
                if (onlineUsers == null) {
                    onlineUsers = username;
                } else {
                    if (!onlineUsers.contains(username)) {
                        onlineUsers = onlineUsers + " :) " + username;
                    }
                }
                servletContext.setAttribute("users", onlineUsers);
            } else if (result == false || user == null) {
                out.println("<p  style=\"color: darkblue\"> ---INVALID USERNAME OR PASSWORD!! ---</p>");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.include(request, response);

            }
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
