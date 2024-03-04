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
import model.products;

/**
 *
 * @author phuc0
 */
public class productsDAO extends DBContext {
    
    PreparedStatement stm;
    ResultSet rs;
    List<products> list = new ArrayList<>();
    
    public List<products> getProducts() {
        try {
            String strSelect = "select * from products";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                products p = new products(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public products getProductByID(String pid) {
        try {
            String strSelect = "select * from products where id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, pid);
            rs = stm.executeQuery();
            while (rs.next()) {
                products p = new products(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<products> getProductsByCategory(String cid) {
        try {
            String strSelect = "select * from products where category_id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, cid);
            rs = stm.executeQuery();
            while (rs.next()) {
                products p = new products(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<products> getProductsByName(String name) {
        try {
            String strSelect = "select * from products where name like N'%" + name + "%'";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                products p = new products(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<products> getProductsByNameAndCategory(String name, String cid) {
        try {
            String strSelect = "select * from products where name like N'%" + name + "%' and category_id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, cid);
            rs = stm.executeQuery();
            while (rs.next()) {
                products p = new products(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void deleteByID(String pid) {
        try {
            String strSelect = "DELETE FROM [dbo].[products] WHERE id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, pid);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void addProduct(String name, String description, String price, String category_id, String image_link, String discount) {
        try {
            String strSelect = "INSERT INTO [dbo].[products] ([name],[description],[price],[category_id],[image_link],[discount]) VALUES (?,?,?,?,?,?)";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, name);
            stm.setString(2, description);
            stm.setString(3, price);
            stm.setString(4, category_id);
            stm.setString(5, image_link);
            stm.setString(6, discount);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void editProduct(String id, String name, String description, String price, String category_id, String image_link, String discount) {
        try {
            String strSelect = "UPDATE [dbo].[products] SET [name] = ?,[description] = ?,[price] = ?,[category_id] = ?,[image_link] = ?, [discount] = ? WHERE [id] = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, name);
            stm.setString(2, description);
            stm.setString(3, price);
            stm.setString(4, category_id);
            stm.setString(5, image_link);
            stm.setString(6, discount);
            stm.setString(7, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        productsDAO PD = new productsDAO();
//        List<products> list = PD.getProducts();
//        for (products c : list) {
//            System.out.println(c.toString());
//        }
        System.out.println(PD.getProductByID("1"));
    }
}
