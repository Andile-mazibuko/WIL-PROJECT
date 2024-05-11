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
import za.co.auc.entities.Product;
import za.co.auc.session.beans.ProductFacadeLocal;

/**
 *
 * @author andil
 */
public class EndSale extends HttpServlet
{

    @EJB
    private ProductFacadeLocal productFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        //HttpSession session = request.getSession();
        
        try
        {
            Long prodId = Long.parseLong(request.getParameter("prodId"));
            Product prod = productFacade.find(prodId);
            
            prod.setStatus("sold");
            
            productFacade.edit(prod);
            response.sendRedirect("DashBoard.co.za");
        }catch(NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
        
    }

}
