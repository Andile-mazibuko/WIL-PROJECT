/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class SelectedProduct extends HttpServlet 
{

    @EJB
    private SysUserFacadeLocal sysUserFacade;

    @EJB
    private ProductFacadeLocal productFacade1;

    @EJB
    private ProductFacadeLocal productFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SelectedProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SelectedProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        Product product = productFacade.find(Long.parseLong(request.getParameter("productId")));
        SysUser user = findProductOwner(product);
        session.setAttribute("productOwner", user);
        session.setAttribute("selectedProduct",product);
        
        
        
        
        request.getRequestDispatcher("itemPage.jsp").forward(request, response);
    }
    private SysUser findProductOwner(Product product)
    {
        SysUser prodOwner = null;
        for(SysUser user : sysUserFacade.findAll())
        {
            for(Product pro : user.getUserProducts())
            {
                if(pro.getId().equals(product.getId()))
                {
                    System.out.println("Owner has been found");
                    prodOwner = user;
                    break;
                }
            }
        }
        return prodOwner;
    }

    
}
