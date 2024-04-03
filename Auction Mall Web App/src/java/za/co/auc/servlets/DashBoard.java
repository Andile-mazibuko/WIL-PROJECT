/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.servlets;

import java.io.IOException;
import java.util.List;
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
public class DashBoard extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        session.setAttribute("products", getAllProducts());
        
        
        request.getRequestDispatcher("mainPage.jsp").forward(request, response);
                
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
    
    }
    private List<Product> getAllProducts()
    {
        return productFacade.findAll();
    }
}