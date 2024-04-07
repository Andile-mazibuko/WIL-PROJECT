/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.co.auc.entities.Product;
import za.co.auc.entities.ProductBids;
import za.co.auc.entities.SysUser;
import za.co.auc.session.beans.ProductBidsFacadeLocal;
import za.co.auc.session.beans.ProductFacadeLocal;

/**
 *
 * @author andil
 */
public class PaymentServlet extends HttpServlet 
{

    @EJB
    private ProductBidsFacadeLocal productBidsFacade;

    @EJB
    private ProductFacadeLocal productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        
        
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
