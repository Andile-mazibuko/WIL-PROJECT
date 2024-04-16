/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.co.auc.entities.SysUser;
import za.co.auc.session.beans.ProductFacadeLocal;
import za.co.auc.session.beans.SysUserFacadeLocal;

/**
 *
 * @author andil
 */
public class AdminServlet extends HttpServlet 
{

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private SysUserFacadeLocal sysUserFacade;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        session.setAttribute("pending", findAllPendiAgents());
        session.setAttribute("products", productFacade.findAll());
        
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
    private List<SysUser> findAllPendiAgents()
    {
        List<SysUser> allUsers = sysUserFacade.findAll();
        List<SysUser> users = new ArrayList<>();
        
            for(SysUser user : allUsers)
            {
                if(user.getUserType().equalsIgnoreCase("pending"))
                {
                    users.add(user);
                }
            }
        
        
        return users;
    }
    

}
