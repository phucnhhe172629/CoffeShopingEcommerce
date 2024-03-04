/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.bill;
import model.cart;
import model.item;

/**
 *
 * @author phuc0
 */
public class billDAO extends DBContext {

    PreparedStatement stm, stm2;
    ResultSet rs;
    List<bill> list = new ArrayList<>();

    public List<bill> getBill() {
        try {
            String strSelect = "select * from bill";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                bill b = new bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<bill> getBillByCustomer(int id) {
        try {
            String strSelect = "select * from bill where [customers_id] = ? order by id desc";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                bill b = new bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public bill getBillByID(String bid) {
        try {
            String strSelect = "select * from bill where id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, bid);
            rs = stm.executeQuery();
            while (rs.next()) {
                bill b = new bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                return b;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<bill> getBillDESC() {
        try {
            String strSelect = "select * from bill order by id desc";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                bill c = new bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<bill> getTop5Bill() {
        try {
            String strSelect = "select top 5 * from bill order by id desc";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                bill b = new bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void addOrder(int customers_id, String message, String status, cart cart) {
        LocalDate date = java.time.LocalDate.now();
        String dateString = date.toString();
        if (message == null || message.isEmpty()) {
            message = "Không có";
        }
        try {
            String strInsert = "INSERT INTO [dbo].[bill] ([customers_id] ,[message] ,[status] ,[total] ,[date]) VALUES (?,?,?,?,?)";
            stm = connection.prepareStatement(strInsert);
            stm.setInt(1, customers_id);
            stm.setString(2, message);
            stm.setString(3, status);
            stm.setDouble(4, cart.getTotalPrice());
            stm.setString(5, dateString);
            stm.executeUpdate();

            String strSelect = "select top 1 id from [dbo].[bill] order by id desc";
            stm2 = connection.prepareStatement(strSelect);
            rs = stm2.executeQuery();
            orderDAO OD = new orderDAO();
            if (rs.next()) {
                int bill_id = rs.getInt(1);
                for (item i : cart.getItems()) {
                    OD.addOrder(bill_id, i.getProduct().getId(), i.getQuantity());
                }
            }
            stm2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<bill> getBillToday() {
        try {
            String strSelect = "SELECT * FROM [Assignment].[dbo].[bill] WHERE DATEDIFF(DAY,date,GETDATE()) = 0";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                bill b = new bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<bill> getBillThisMonth() {
        try {
            String strSelect = "SELECT * FROM [Assignment].[dbo].[bill] WHERE DATEDIFF(MONTH,date,GETDATE()) = 0";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                bill b = new bill(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public double getRevenueToday() {
        billDAO BD = new billDAO();
        List<bill> today = BD.getBillToday();

        double r = 0;
        for (bill b : today) {
            r += b.getTotal();
        }
        return r;
    }

    public int getNumberToday() {
        billDAO BD = new billDAO();
        List<bill> today = BD.getBillToday();

        return today.size();
    }

    public double getRevenueThisMonth() {
        billDAO BD = new billDAO();
        List<bill> month = BD.getBillThisMonth();

        double r = 0;
        for (bill b : month) {
            r += b.getTotal();
        }
        return r;
    }

    public int getNumberThisMonth() {
        billDAO BD = new billDAO();
        List<bill> month = BD.getBillThisMonth();

        return month.size();
    }

    public void delete(String bid) {
        try {
            String strSelect = "delete from bill where id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, bid);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(String bid, String status) {
        try {
            String strSelect = "UPDATE [dbo].[bill] SET [status] = ? WHERE id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, status);
            stm.setString(2, bid);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        billDAO BD = new billDAO();
        List<bill> list = BD.getBillByCustomer(1);

        for (bill b : list) {
            System.out.println(b.toString());
        }
    }
}
