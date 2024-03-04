/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.admin;

/**
 *
 * @author phuc0
 */
public class adminDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    public admin getAdmin(String username, String password) {
        try {
            String strSelect = "select * from admin where username = ? and password = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            while (rs.next()) {
                admin a = new admin(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        adminDAO AD = new adminDAO();
        admin a = AD.getAdmin("admin", "123456");

        System.out.println(a);
    }
}
