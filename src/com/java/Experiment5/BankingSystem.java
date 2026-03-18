package com.java.Experiment5;

import java.sql.*;

public class BankingSystem {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/bankdb";
        String user = "root";
        String password = "root"; 

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            // 🔹 BEFORE TRANSACTION
            System.out.println("Before Transaction:");
            Statement stmt1 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT * FROM accounts");

            while (rs1.next()) {
                System.out.println(
                    rs1.getInt("id") + " " +
                    rs1.getString("name") + " " +
                    rs1.getDouble("balance")
                );
            }

            // 🔹 Start Transaction
            con.setAutoCommit(false);

            int fromAccount = 1;
            int toAccount = 2;
            double amount = 1000;

            // Check balance
            PreparedStatement check = con.prepareStatement(
                "SELECT balance FROM accounts WHERE id=?"
            );
            check.setInt(1, fromAccount);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");

                if (balance >= amount) {

                    // Debit
                    PreparedStatement debit = con.prepareStatement(
                        "UPDATE accounts SET balance = balance - ? WHERE id=?"
                    );
                    debit.setDouble(1, amount);
                    debit.setInt(2, fromAccount);
                    debit.executeUpdate();

                    // Credit
                    PreparedStatement credit = con.prepareStatement(
                        "UPDATE accounts SET balance = balance + ? WHERE id=?"
                    );
                    credit.setDouble(1, amount);
                    credit.setInt(2, toAccount);
                    credit.executeUpdate();

                    // Commit
                    con.commit();
                    System.out.println("\nTransaction Successful!");

                } else {
                    System.out.println("\nInsufficient Balance!");
                    con.rollback();
                }
            }

            // 🔹 AFTER TRANSACTION
            System.out.println("\nAfter Transaction:");
            Statement stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM accounts");

            while (rs2.next()) {
                System.out.println(
                    rs2.getInt("id") + " " +
                    rs2.getString("name") + " " +
                    rs2.getDouble("balance")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}