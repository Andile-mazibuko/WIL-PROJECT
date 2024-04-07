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
import za.co.auc.entities.SysUser;
import za.co.auc.session.beans.ProductFacadeLocal;
import za.co.auc.session.beans.SysUserFacadeLocal;

/**
 *
 * @author andil
 */
public class AddToWishlist extends HttpServlet 
{

    @EJB
    private SysUserFacadeLocal sysUserFacade;

    @EJB
    private ProductFacadeLocal productFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        SysUser user = (SysUser)session.getAttribute("user");
        Product product = productFacade.find(Long.parseLong(request.getParameter("submit")));
        
            if(!isProductAvailale(user.getWishlist(), product))
            {
                user.getWishlist().add(product);
                sysUserFacade.edit(user);
            }else
            {
                //exception product already exist
            }
        
                
        
        request.getRequestDispatcher("itemPage.jsp").forward(request, response);
        
        
    }
    private boolean isProductAvailale(List<Product>userProducts,Product product)
    {
        boolean isAvailable = false;
        for(Product pro : userProducts)
        {
            if(pro.equals(product))
            {
                isAvailable = true;
            }
        }
        
      return isAvailable;
    }

}
