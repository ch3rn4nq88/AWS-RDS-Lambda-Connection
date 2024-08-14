package com.desarrolloinnovador.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.sql.*;

public class Main implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        String url = "jdbc:mysql://productos.xjeqi0geih6m.us-east-1.rds.amazonaws.com:3306";
        String username = "admin";
        String password = "Examplepassword";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT 1");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return "Success";
    }

}