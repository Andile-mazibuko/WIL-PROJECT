/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.co.auc.entities.Product;
import za.co.auc.entities.ProductBids;
import za.co.auc.entities.SysUser;
import za.co.auc.entities.UserOrder;
import za.co.auc.session.beans.ProductBidsFacadeLocal;
import za.co.auc.session.beans.ProductFacadeLocal;
import za.co.auc.session.beans.SysUserFacadeLocal;
import za.co.auc.session.beans.UserOrderFacadeLocal;

/**
 *
 * @author andil
 */
public class ProcessPayment extends HttpServlet {

    @EJB
    private UserOrderFacadeLocal userOrderFacade;

    @EJB
    private SysUserFacadeLocal sysUserFacade;
 
    @EJB
    private ProductBidsFacadeLocal productBidsFacade;

    @EJB
    private ProductFacadeLocal productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        Product selectedProduct = (Product)session.getAttribute("selectedProduct");
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String posCode = request.getParameter("postal_code");
        
        String nameOnCard = request.getParameter("card_name");
        String cardNumber = request.getParameter("card_number");
        String expDate = request.getParameter("exp_date");
        String cvv = request.getParameter("cvv");
                
        SysUser user = (SysUser)session.getAttribute("user");;
        List<Product>userProducts = new ArrayList<>();
        userProducts.add(selectedProduct);
        UserOrder order = new UserOrder();
        order.setDate(new Date());
        order.setStatus("Payment Recieved");
        order.setProducts(userProducts);
        userOrderFacade.create(order);
        List<UserOrder> orders = user.getOrders();
        orders.add(order);
        sysUserFacade.edit(user);
        
        String buyOption = (String) session.getAttribute("buyOption");
        double price = (Double)session.getAttribute("price");
        
        if(buyOption.equalsIgnoreCase("bid"))
        {
            selectedProduct.setMinimumbid(price);
            ProductBids mathingBid = findMatchingBids(selectedProduct);

                ProductBids bid = new ProductBids();
                bid.setProduct(selectedProduct.getId());
                bid.setDate(new Date());
                bid.setLastBid(price);
                SysUser bidders =(SysUser)session.getAttribute("user");
                //bidders.add();
                bid.setBidders(bidders);
                System.out.println("FINALLYYYYYYYYYYYYYYYYYYYYYYYYY!!!!!!!!!!!!!!!!!!");
                productBidsFacade.create(bid);
            
        }else
        {
            selectedProduct.setStatus("bought");
        }
        productFacade.edit(selectedProduct);
        response.sendRedirect("DashBoard.co.za");
    }

    private ProductBids findMatchingBids(Product selected)
    {
        List<ProductBids> bids = productBidsFacade.findAll();
        ProductBids productBid = new ProductBids();
        
        for(ProductBids bid : bids)
        {
            if(bid.getProduct().equals(selected.getId()))
            {
                productBid = bid;
            }else
            {
                productBid = null;
            }
            
        }
        return productBid;
    }
}
