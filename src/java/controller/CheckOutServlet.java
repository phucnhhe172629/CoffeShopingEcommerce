/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.billDAO;
import dal.categoriesDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import model.cart;
import model.categories;
import model.customer;

/**
 *
 * @author phuc0
 */
@WebServlet("/check-out")
public class CheckOutServlet extends HttpServlet {

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
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(true);
        cart c = (cart) session.getAttribute("cart");
        if (c == null) {
            c = new cart();
        }

        categoriesDAO CD = new categoriesDAO();
        List<categories> categories = CD.getCategories();

        request.setAttribute("categories", categories);
        session.setAttribute("cart", c);
        session.setAttribute("totalprice", c.getTotalPrice());
        session.setAttribute("size", c.getQuantity());
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
        HttpSession session = request.getSession(true);
        cart c = (cart) session.getAttribute("cart");
        customer acc = (customer) session.getAttribute("acc");
        String message = request.getParameter("message");
        request.setAttribute("error", "");
        if (acc == null) {
            request.setAttribute("mess", "Vui lòng đăng nhập!");
            request.getRequestDispatcher("login").forward(request, response);
        } else {
            if (c.getTotalPrice() == 0) {
                request.setAttribute("error", "Không tồn tại sản phẩm trong giỏ hàng!");
                request.getRequestDispatcher("checkout.jsp").forward(request, response);
            } else {
                billDAO BD = new billDAO();
                BD.addOrder(acc.getId(), message, "Đang chờ", c);

                session.setAttribute("size", 0);
                session.setAttribute("cart", null);
                response.sendRedirect("order");
            }
        }
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
