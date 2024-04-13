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
import za.co.auc.entities.House;
import za.co.auc.entities.Product;
import za.co.auc.entities.PropertyLocation;
import za.co.auc.session.beans.ProductFacadeLocal;
import za.co.auc.session.beans.PropertyLocationFacadeLocal;

/**
 *
 * @author andil
 */
public class EditProductDetails extends HttpServlet {
    @EJB
    private PropertyLocationFacadeLocal propertyLocationFacade;

    @EJB
    private ProductFacadeLocal productFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Product product  = (Product)session.getAttribute("toEdit");
        try{
            
            if(product instanceof House)
            {
                String province = request.getParameter("province");
                String city = request.getParameter("city");
                String street = request.getParameter("street");
                
                
                PropertyLocation location = new PropertyLocation();
                location.setProvince(province);
                location.setTown(city);
                location.setSurbub(city);
                location.setStreet(street);
                
                propertyLocationFacade.create(location);
                
                ((House) product).setLocaion(location);
                productFacade.edit(product);
                
                
            }
            
            response.sendRedirect("DashBoard.co.za");
        }catch(NullPointerException ex)
        {
            
        }
    }

}
