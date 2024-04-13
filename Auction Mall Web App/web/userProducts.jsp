<%-- 
    Document   : userProducts
    Created on : 10 Apr 2024, 3:10:59 PM
    Author     : andil
--%>

<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="za.co.auc.entities.ProductMedia"%>
<%@page import="za.co.auc.entities.Car"%>
<%@page import="za.co.auc.entities.PropertyLocation"%>
<%@page import="za.co.auc.entities.House"%>
<%@page import="za.co.auc.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="za.co.auc.entities.SysUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="wishlist.css">
</head>
<body class="body">
    
    <%
        
    
    
    %>
    <nav>
        <img src="shopping-bag.svg" alt="">  <a>sell on Auction Mall</a>
    </nav>
    <div class="container">
        <%
            SysUser user = (SysUser)session.getAttribute("user");
            List<Product> products = user.getUserProducts();
            String name = "Unspecified location";
            
            for(Product product : products){
                ProductMedia media = product.getMedia().get(0);
                String filename = media.getFilename();
                File file = new File("D:\\Files\\projects\\Git projects\\WIL PROJECT\\WIL-PROJECT\\Auction Mall Web App\\web\\userProducts\\"+filename);
                file.createNewFile();
                FileOutputStream output = new FileOutputStream(file);
                output.write(media.getFile());
                output.flush();
                output.close();
                if(product instanceof House)
                {
                    PropertyLocation prodLoc = ((House)product).getLocaion();
                    if(prodLoc != null)
                    {
                      name = "South Africa > "+prodLoc.getProvince()+" > "+ prodLoc.getTown()+" > "+ prodLoc.getStreet() ;
                    }
                }else if(product instanceof Car)
                {
                    name = ((Car)product).getModel();
                }
        %>
        <div class="wishlist-card">
            <img src="userProducts/+<%= filename%>" alt="">
            <div class="wishlist-content">
                <p><%= name %></p>
                <h4>R<%=product.getPrice() %></h4>
                <form action="EditProduct.co.za" method="post" style="width: 40%;height: 50%;position: absolute; z-index: 5; bottom: 5%; right: 0; display: flex;align-items: center;justify-content: center;">
                    <button name="productId" value="<%= product.getId() %>" type="submit" style="width: 70%;height: 70%;background-color: rgb(28, 5, 82); cursor: pointer; border: none; border-radius: 10px; color: white;"> Edit Product</button>
                </form>
            </div>
        </div>
        <%}%>
       
    </div>
 
</html>
