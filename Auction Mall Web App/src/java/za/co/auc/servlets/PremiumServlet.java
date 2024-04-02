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
import za.co.auc.entities.BankingDetails;
import za.co.auc.entities.SysUser;
import za.co.auc.session.beans.BankingDetailsFacadeLocal;

/**
 *
 * @author andil
 */
public class PremiumServlet extends HttpServlet 
{

    @EJB
    private BankingDetailsFacadeLocal bankingDetailsFacade;

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
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String posCode = request.getParameter("postal_code");
        
        String nameOnCard = request.getParameter("card_name");
        String cardNumber = request.getParameter("card_number");
        String expDate = request.getParameter("exp_date");
        String cvv = request.getParameter("cvv");
        
        SysUser user = (SysUser)session.getAttribute("user");
        bankingDetailsFacade.create(createBankDetails(user,fullName, email, address, city, posCode, nameOnCard, cardNumber, expDate, cvv));
        
        response.sendRedirect("DashBoard.co.za");
    }

    private BankingDetails createBankDetails(SysUser user,String fullname,String email,String address,String city, String posCode,String nameOnCard,String cardNumber,String expDate,String cvv)
    {
        BankingDetails bankingDetails = new BankingDetails();
        bankingDetails.setUser(user.getId());
        bankingDetails.setFullName(fullname);
        bankingDetails.setEmail(email);
        bankingDetails.setAddress(address);
        bankingDetails.setCity(city);
        bankingDetails.setAddress(address);
        bankingDetails.setPosCode(posCode);
        bankingDetails.setNameOnCard(nameOnCard);
        bankingDetails.setExpDate(expDate);
        bankingDetails.setCardNumber(cardNumber);
        bankingDetails.setCvv(cvv);
        
        return bankingDetails;
    }

}
