package service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;


public class LogOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body style=\"background-color:powderblue;\">");

        if (session != null) {
            session.invalidate();
            PrintWriter writer = response.getWriter();
            writer.println("<p>You are logged out</p>");
            RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp");
            dispatcher.include(request,response);
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

