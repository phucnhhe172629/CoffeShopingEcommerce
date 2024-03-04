/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.customer;

/**
 *
 * @author phuc0
 */
public class customerDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<customer> list = new ArrayList<>();

    public List<customer> getAllCustomer() {
        try {
            String strSelect = "select * from customers";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                customer c = new customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public customer getCustomer(String username, String password) {
        try {
            String strSelect = "select * from customers where username = ? and password = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            while (rs.next()) {
                customer c = new customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public customer getCustomer(String username) {
        try {
            String strSelect = "select * from customers where username = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, username);
            rs = stm.executeQuery();
            while (rs.next()) {
                customer c = new customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void signUpCustomer(String username, String password, String fullname, String phone, String address) {
        try {
            String strSelect = "INSERT INTO [dbo].[customers] ([username],[password],[fullname],[phone],[address]) VALUES (?,?,?,?,?)";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, fullname);
            stm.setString(4, phone);
            stm.setString(5, address);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteCustomer(String id) {
        try {
            String strSelect = "DELETE FROM [dbo].[customers] WHERE id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateCustomer(int id, String name, String phone, String address) {
        try {
            String strSelect = "UPDATE [dbo].[customers] SET [fullname] = ? ,[phone] = ? ,[address] = ? WHERE [id] = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, name);
            stm.setString(2, phone);
            stm.setString(3, address);
            stm.setInt(4, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void changePass(int id, String pass) {
        try {
            String strSelect = "UPDATE [dbo].[customers] SET [password] = ? WHERE [id] = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, pass);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        customerDAO CD = new customerDAO();

        List<customer> list = CD.getAllCustomer();
        for (customer li : list) {
            System.out.println(li);
        }
    }
}
