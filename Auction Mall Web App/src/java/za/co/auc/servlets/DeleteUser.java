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
import za.co.auc.entities.ProductBids;
import za.co.auc.entities.SysUser;
import za.co.auc.session.beans.ProductBidsFacadeLocal;
import za.co.auc.session.beans.SysUserFacadeLocal;

/**
 *
 * @author andil
 */
public class DeleteUser extends HttpServlet
{

    @EJB
    private ProductBidsFacadeLocal productBidsFacade;

    @EJB
    private SysUserFacadeLocal sysUserFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        SysUser user = sysUserFacade.find(Long.parseLong(request.getParameter("toDelete")));
        
        List<ProductBids> bids = productBidsFacade.findAll();
        
        for(ProductBids bid : bids)
        {
            if(bid.getBidders().getId() == user.getId())
            {
                productBidsFacade.remove(bid);
            }
            //bid.getBidders()
        }
        sysUserFacade.remove(user);
        response.sendRedirect("AdminServlet.co.za");
    }

}
