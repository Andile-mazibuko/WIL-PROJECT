/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class CreateAccount extends HttpServlet {

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
            out.println("<title>Servlet CreateAccount</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateAccount at " + request.getContextPath() + "</h1>");
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
        String name = request.getParameter("full name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        byte[] password = request.getParameter("password").getBytes();
        
        createUser(name, username, email, password, session);
        
        
        
    }
    private void createUser(String name,String username, String email, byte[] password, HttpSession session)
    {
        String[] names = name.split(" ");
        SysUser user = new SysUser();
        user.setCart(new ArrayList<>());
        user.setWishlist(new ArrayList<>());
        user.setOrders(new ArrayList<>());
        user.setOrders(new ArrayList());
        
        user.setEmail(email);
        user.setLastname(names[1]);
        user.setFirstname(names[0]);
        user.setPassword(password);
        user.setUsername(username);
        session.setAttribute("user", user);
        sysUserFacade.create(user);
       
    }

}
