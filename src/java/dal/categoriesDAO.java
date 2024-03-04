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
import model.categories;

/**
 *
 * @author phuc0
 */
public class categoriesDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<categories> list = new ArrayList<>();

    public List<categories> getCategories() {
        try {
            String strSelect = "select * from categories";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                categories c = new categories(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public categories getCategoryByID(String cid) {
        try {
            String strSelect = "select * from categories where id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, cid);
            rs = stm.executeQuery();
            while (rs.next()) {
                categories c = new categories(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(String cid) {
        try {
            String strSelect = "delete from categories where id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, cid);
            stm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void add(String name, String descrtion) {
        try {
            String strSelect = "INSERT INTO [dbo].[categories] ([name],[description]) VALUES (?,?)";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, name);
            stm.setString(2, descrtion);
            stm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(String id, String name, String descrtion) {
        try {
            String strSelect = "UPDATE [dbo].[categories] SET [name] = ?,[description] = ? WHERE id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, name);
            stm.setString(2, descrtion);
            stm.setString(3, id);
            stm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        categoriesDAO CD = new categoriesDAO();
        List<categories> list = CD.getCategories();

        for (categories c : list) {
            System.out.println(c.toString());
        }
    }
}
