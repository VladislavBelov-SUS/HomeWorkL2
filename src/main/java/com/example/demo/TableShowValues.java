package com.example.demo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/formResult")
public class TableShowValues extends HttpServlet {
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    String query = null;
    String url = null;
    String username = null;
    String password = null;

    public void init(ServletConfig config) throws ServletException {

        url = "jdbc:mysql://localhost/form?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        username = "root";
        password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        query = "SELECT * FROM form";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            out.println("<html><body><h2>The Select query has following results : </h2>");
            out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
            out.println("<tr>");
            out.println("<td><b>First Name</b></td>");
            out.println("<td><b>Last Name</b></td>");
            out.println("<td><b>gender</b></td>");
            out.println("<td><b>course answer</b></td>");
            out.println("<td><b>age</b></td>");
            out.println("</tr>");

            while (resultSet.next()) {
                String userFirstName = resultSet.getString("first_Name");
                String userLastName = resultSet.getString("Last_Name");
                String gender = resultSet.getString("gender");
                String course = resultSet.getString("course_answer");
                String age = resultSet.getString("user_age");
                out.println("<tr><td>" + userFirstName + "</td><td>" + userLastName + "</td><td>" + gender + "</td><td>" + course + "</td><td>" + age + "</td></tr>");
                out.println("</tr>");
            }
            out.println("</table></br><hr></body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
