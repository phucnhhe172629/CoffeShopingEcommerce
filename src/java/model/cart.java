/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.productsDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phuc0
 */
public class cart {

    List<item> items;

    public cart() {
        items = new ArrayList<>();
    }

    public cart(List<item> items) {
        this.items = items;
    }

    public List<item> getItems() {
        return items;
    }

    public void setItems(List<item> items) {
        this.items = items;
    }

    public item getItemByID(int id) {
        if (items == null) {
            return null;
        }
        for (item i : items) {
            if (i.getProduct().id == id) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityByID(int id) {
        return getItemByID(id).getQuantity();
    }

    public void addItem(item i) {
        if (getItemByID(i.getProduct().id) == null) {
            items.add(i);
        } else {
            item in = getItemByID(i.getProduct().id);
            in.setQuantity(in.getQuantity() + i.getQuantity());
        }
    }

    public void removeItemByID(int id) {
        if (getItemByID(id) != null) {
            items.remove(getItemByID(id));
        }
    }

    public double getTotalPrice() {
        double t = 0;
        for (item i : items) {
            t += i.getQuantity() * i.getProduct().getPrice();
        }
        return t;
    }

    public int getQuantity() {
        int q = 0;
        for (item i : items) {
            q += i.getQuantity();
        }
        return q;
    }

    public static void main(String[] args) {

        productsDAO PD = new productsDAO();
        cart c = new cart();
        item i = new item(PD.getProductByID("1"), 1);
        c.addItem(i);
        System.out.println(c);
    }
}
