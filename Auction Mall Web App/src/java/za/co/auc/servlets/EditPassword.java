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
import za.co.auc.entities.SysUser;
import za.co.auc.session.beans.SysUserFacadeLocal;

/**
 *
 * @author andil
 */
public class EditPassword extends HttpServlet
{

    @EJB
    private SysUserFacadeLocal sysUserFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditPassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditPassword at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String password = request.getParameter("current");
        String newPassword = request.getParameter("new_pass");
        String confirmPass = request.getParameter("confirm_pass");
        SysUser user = (SysUser)session.getAttribute("user");
        
       //TODO: Impelemnt the code required to edit password 
            user.setPassword(newPassword.getBytes());
            sysUserFacade.edit(user);
        response.sendRedirect("DashBoard.co.za");
        
        
    }

}
