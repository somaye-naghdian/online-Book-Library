package service;

import dao.UserDao;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String userName = request.getParameter("Username");
        String password = request.getParameter("Password");
        String confirmPassword = request.getParameter("ConfirmPassword");
        String email = request.getParameter("Email");
        if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || password.isEmpty() ||
                confirmPassword.isEmpty() || email.isEmpty()) {
            out.println("All fields required<br>");
            out.println("Try again <br>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
            dispatcher.include(request, response);
        }
        if(password.length()<8){
            out.println(" password is not safe <br>  try again");
            RequestDispatcher dispatcher =request.getRequestDispatcher("Register.jsp");
            dispatcher.include(request,response);
        }else
        if (!password.equals(confirmPassword)) {
            out.println(" password and confirm Password are not the same <br>  try again");
            RequestDispatcher dispatcher =request.getRequestDispatcher("Register.jsp");
            dispatcher.include(request,response);
            return;
        }
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);

        try {
            UserDao userDao =new UserDao();
            boolean result = userDao.register(user);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Successful</title>");
            out.println("</head>");
            out.println("<body style=\"background-color:powderblue;\">");
            out.println("<center>");

           if (result) {
                out.println("Thanks for Registering with us :");
                out.println("To login with new Username and Password <a href=index.jsp>Click here</a>");
            } else {
                out.println("<h3>Registration Failed</h3>");
                out.println("To try again<a href=Register.jsp>Click here</a>");
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
