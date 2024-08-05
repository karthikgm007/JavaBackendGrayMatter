<%@page import="com.quickbite.utilities.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*" %>
<%@ page import="com.quickbite.utilities.DatabaseConnection" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        .custom-table th, .custom-table td {
            text-align: center;
        }
        .form-container {
            margin-top: 20px;
        }
        .submit-btn {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container form-container">
        <form action="OrderServlet" method="post">
            <table class="table table-bordered custom-table">
                <thead class="thead-dark">
                    <tr>
                        <th>Item</th>
                        <th>Cost</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Connection conn = null;
                        try {
                            conn = DatabaseConnection.getConnection();
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT * FROM Item");

                            while (rs.next()) {
                                int itemId = rs.getInt("Id");
                                String name = rs.getString("Name");
                                double cost = rs.getDouble("Cost");
                    %>
                    <tr>
                        <td><%= name %></td>
                        <td><%= cost %></td>
                        <td>
                            <input type="number" class="form-control" name="quantity" min="0" value="0">
                            <input type="hidden" name="itemId" value="<%= itemId %>">
                        </td>
                    </tr>
                    <%
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            if (conn != null) {
                                try {
                                    conn.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    %>
                </tbody>
            </table>
            <input type="submit" class="btn btn-danger submit-btn" value="Submit">
        </form>
    </div>
</body>
</html>
