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
import model.order;

/**
 *
 * @author phuc0
 */
public class orderDAO extends DBContext {
    
    PreparedStatement stm;
    ResultSet rs;
    List<order> list = new ArrayList<>();
    
    public List<order> getOrders() {
        try {
            String strSelect = "SELECT * FROM [order]";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                order o = new order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<order> getOrdersByBID(int bid) {
        try {
            String strSelect = "SELECT * FROM [order] where bill_id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, bid);
            rs = stm.executeQuery();
            while (rs.next()) {
                order o = new order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void addOrder(int bill_id, int product_id, int quantity) {
        try {
            String strSelect = "INSERT INTO [dbo].[order] ([bill_id],[product_id],[quantity]) VALUES (?,?,?)";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, bill_id);
            stm.setInt(2, product_id);
            stm.setInt(3, quantity);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        
        orderDAO OD = new orderDAO();
        List<order> list = OD.getOrdersByBID(26);
        
        for (order o : list) {
            System.out.println(o.toString());
        }
    }
}
