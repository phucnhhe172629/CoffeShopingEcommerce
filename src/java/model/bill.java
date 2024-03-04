/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phuc0
 */
public class bill {

    int id;
    int customers_id;
    String message;
    String status;
    double total;
    String date;

    public bill(int id, int customers_id, String message, String status, double total, String date) {
        this.id = id;
        this.customers_id = customers_id;
        this.message = message;
        this.status = status;
        this.total = total;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomers_id() {
        return customers_id;
    }

    public void setCustomers_id(int customers_id) {
        this.customers_id = customers_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "bill{" + "id=" + id + ", customers_id=" + customers_id + ", message=" + message + ", status=" + status + ", total=" + total + ", date=" + date + '}';
    }

}
