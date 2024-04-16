/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
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
public class LogIn extends HttpServlet
{

    @EJB
    private SysUserFacadeLocal sysUserFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogIn</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogIn at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession(true);
        SysUser user = new SysUser();
        String username = request.getParameter("username");
        byte[] password = request.getParameter("password").getBytes();
        
        if(username.equals("635970787") && request.getParameter("password").equals("0000"))
        {
            System.out.println("HI");
            response.sendRedirect("AdminServlet.co.za");
        }else
        {
            System.out.println("Not an admin: "+username);
        }
        user = findUser(username, password);
        
        if(user != null)
        {
            System.out.println("found");
            session.setAttribute("user", user);
            response.sendRedirect("DashBoard.co.za");
        }else
        {
            System.out.println("null");
        }
        
        
        
    }
    private SysUser findUser(String username,byte[] password)
    {
        List<SysUser> users = sysUserFacade.findAll();
        SysUser matchingUser = null;
        for(SysUser user : users )
        {
            if(user.getUsername().equalsIgnoreCase(username) && Arrays.equals(user.getPassword(), password)) 
            {
                matchingUser = user;
                System.out.println("");
            }
        }
    
        return matchingUser;
    }

}
