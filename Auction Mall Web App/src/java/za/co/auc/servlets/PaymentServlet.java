/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.co.auc.entities.Product;
import za.co.auc.session.beans.ProductFacadeLocal;

/**
 *
 * @author andil
 */
public class PaymentServlet extends HttpServlet 
{

    @EJB
    private ProductFacadeLocal productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        Product selectedProduct = (Product)session.getAttribute("selectedProduct");
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String posCode = request.getParameter("postal_code");
        
        String nameOnCard = request.getParameter("card_name");
        String cardNumber = request.getParameter("card_number");
        String expDate = request.getParameter("exp_date");
        String cvv = request.getParameter("cvv");
       
        String buyOption = (String) session.getAttribute("buyOption");
        double price = (Double)session.getAttribute("price");
        
        if(buyOption.equalsIgnoreCase("bid"))
        {
            selectedProduct.setMinimumbid(price);
        }else
        {
            selectedProduct.setStatus("bought");
        }
        productFacade.edit(selectedProduct);
        response.sendRedirect("DashBoard.co.za");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        //
        String submitValue = request.getParameter("buy_option");
        String[] values = submitValue.split(":");
       
        session.setAttribute("buyOption", values[0]);
        session.setAttribute("price", Double.parseDouble(values[1]));
        request.getRequestDispatcher("productPayment.jsp").forward(request, response);
        
    }

}
