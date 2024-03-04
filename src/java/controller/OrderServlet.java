/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.categoriesDAO;
import dal.productsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.categories;
import model.products;

/**
 *
 * @author phuc0
 */
public class OrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cid = request.getParameter("cid");
        categoriesDAO CD = new categoriesDAO();
        productsDAO PD = new productsDAO();

        if (cid == null) {
            List<categories> categories = CD.getCategories();
            List<products> products = PD.getProducts();

            request.setAttribute("menu", categories);
            request.setAttribute("categories", categories);
            request.setAttribute("products", products);
        } else {
            categories categories = CD.getCategoryByID(cid);
            List<products> products = PD.getProductsByCategory(cid);
            List<categories> menu = CD.getCategories();

            request.setAttribute("menu", menu);
            request.setAttribute("c", categories);
            request.setAttribute("products", products);
        }

        request.getRequestDispatcher("order.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cid = request.getParameter("cid");
        String name = request.getParameter("name");
        categoriesDAO CD = new categoriesDAO();
        productsDAO PD = new productsDAO();

        if (cid == null || cid.isEmpty()) {
            List<categories> categories = CD.getCategories();
            List<products> products = PD.getProductsByName(name);

            request.setAttribute("menu", categories);
            request.setAttribute("categories", categories);
            request.setAttribute("products", products);

        } else {
            categories categories = CD.getCategoryByID(cid);
            List<products> products = PD.getProductsByNameAndCategory(name, cid);
            List<categories> menu = CD.getCategories();

            request.setAttribute("menu", menu);
            request.setAttribute("c", categories);
            request.setAttribute("products", products);
        }
        request.getRequestDispatcher("order.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
