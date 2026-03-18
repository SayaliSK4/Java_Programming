package com.java.Experiment4;

import java.sql.*;

public class ProductData {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/productdb",
                "root",
                "root"
            );

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT Product_name, Product_price FROM product"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getString(1) + " - " + rs.getDouble(2)
                );
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}