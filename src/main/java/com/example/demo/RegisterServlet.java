package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/form?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "root");

            String userFirstName = request.getParameter("userFirstName");
            String userLastName = request.getParameter("userLastName");
            String userAge = (request.getParameter("userAge"));
            String gender = request.getParameter("gender");
            String course = request.getParameter("course");

            preparedStatement = conn.prepareStatement("INSERT INTO form VALUES(? , ? , ? , ?, ?);");
            preparedStatement.setString(1, userFirstName);
            preparedStatement.setString(2, userLastName);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, course);
            preparedStatement.setString(5, userAge);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();

            if (userFirstName != null && userLastName != null && userAge != null) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("userLastName", userLastName);
                httpSession.setAttribute("gender", gender);
                httpSession.setAttribute("course", course);
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}