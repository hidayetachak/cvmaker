/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cvmaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import java.sql.*;

public class dbconnection {
    private static  String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    private static  String DB_USERNAME = "root";
    private static  String DB_PASSWORD = "";

    public boolean login(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password!");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public boolean Signuppage(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();

            String checkQuery = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet checkResult = statement.executeQuery(checkQuery);

            if (checkResult.next()) {
                JOptionPane.showMessageDialog(null, "Username already exists! Please choose a different username.");
            } else {
                String insertQuery = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
                statement.executeUpdate(insertQuery);
                JOptionPane.showMessageDialog(null, "Sign up successful!");
            }

            checkResult.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return true;
    }
}

