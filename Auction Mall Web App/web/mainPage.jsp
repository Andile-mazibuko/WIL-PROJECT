<%-- 
    Document   : mainPage
    Created on : 13 Mar 2024, 5:25:26 PM
    Author     : andil
--%>

<%@page import="za.co.auc.entities.Car"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="za.co.auc.entities.House"%>
<%@page import="za.co.auc.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="za.co.auc.entities.SysUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="mainPage.css">
</head>
<body>
    <nav>
        
        <img src="shopping-bag.svg" alt="">  <%
             SysUser user = (SysUser)session.getAttribute("user");
            if(user.getUserType().equalsIgnoreCase("premium"))
            {
            %>
                <a href="sellPage.jsp">sell on Auction Mall</a>
                <ul>
                    <li><a href="userProducts.jsp">Manage products</a></li>
                </ul>
            <%
                }else{
            %>
            <a href="payment.jsp">Go to premium</a>
            <%}%>
    </nav>

<%

       
        
%>
    <!--

        ADVERTS
    -->
    <div class="adverts">
        <div class="logo-area">
            <img src="logo.png" alt="">
        </div>
        <div class="search-form">
            <form action="">
               <input type="search" name="" id="" placeholder=" Search for anything">
               <select name="" id="">
                    <option value="">All categories</option>
                    <option value=""></option>
               </select>
               <button type="submit"><img src="search.svg" alt=""></button>
            </form>
        </div>

        <div class="account">
            <img src="user-fill.svg" alt=""> <a href="account.jsp"><h5><%=user.getFirstname()%> <%=user.getLastname()%></h5></a>
        </div>
        
        <div class="wishlist">
            <a href="wishlist.jsp">
                <img src="heart.svg" alt="">
            </a>
        </div>
        
        <div class="cart">
            <a href="">
                <img src="shopping-cart.svg" alt="">
                <h4>cart 0</h4>
            </a>
        </div>
        <!--
            1.    --------------------------------------------------------------------------------------------------
        
        -->
       <div class="shop-by-category">
            <h5>Shop by category</h5>
            <div class="list">
               <a href="">
                    <img src="house-solid.svg" alt=""><span> houses to rent</span> 
                </a>
            </div>
            <div class="list">
                <a href="">
                    <img src="car-solid.svg" alt=""><span> Vehicles to rent</span> 
                </a>
            </div>
            <div class="list">
                <a href="">
                    <img src="house-solid.svg" alt=""><span> houses to buy</span> 
                 </a>
             </div>
             <div class="list">
                 <a href="">
                    <img src="car-solid.svg" alt=""><span> Vehicles to buy</span> 
                 </a>
             </div>
             
            
       </div> 
        <!--
           2. -------------------------------------------------------------------------------------------------------

        -->
       <div class="adverts-heading">
            The latest from Auction mall
       </div>
       <div class="advert-area">                          
            <div class="ad-container">
                <img src="ad.jpg" alt="">
                <img src="ad.jpg" alt="">
                <img src="ad.jpg" alt="">
                <img src="ad.jpg" alt="">
                <img src="ad.jpg" alt="">
                
            </div>
            
       </div>

    </div>
    <!--
        END OF AD SECTION

            CONTENT AREA
    -->
    <h1>DEALS</h1>
    <h1 style="left: 50%; color: aqua;"><a href="">see more</a></h1>
    <div class="content-area">
       <%
           
            List<Product> products = (List<Product>)session.getAttribute("products");
            
            
            
            for(Product product : products){
       
           File file = new File("D:\\Files\\projects\\Git projects\\WIL PROJECT\\WIL-PROJECT\\Auction Mall Web App\\web\\Dashobard products\\"+product.getMedia().get(0).getFilename());
           File file1 = new File("D:\\Files\\projects\\Git projects\\WIL PROJECT\\WIL-PROJECT\\Auction Mall Web App\\web\\Dashobard products\\"+product.getMedia().get(1).getFilename());
           File file2 = new File("D:\\Files\\projects\\Git projects\\WIL PROJECT\\WIL-PROJECT\\Auction Mall Web App\\web\\Dashobard products\\"+product.getMedia().get(2).getFilename());
           file.createNewFile();
           OutputStream output = new FileOutputStream(file);
           OutputStream output1 = new FileOutputStream(file1);
           OutputStream output2 = new FileOutputStream(file2);
           output.write(product.getMainPic());
           output1.write(product.getMedia().get(1).getFile());
           output2.write(product.getMedia().get(2).getFile());
           
           
           output.flush();
           output.close();
           
           output1.flush();
           output1.close();
           
           output2.flush();
           output2.close();
       %>
        <div class="cont">      
            <img src="Dashobard products/<%= product.getMedia().get(0).getFilename() %>" alt="">
                <div class="extra-img">
                    <img src="Dashobard products/<%= product.getMedia().get(1).getFilename() %>" alt="">
                    <img src="Dashobard products/<%= product.getMedia().get(2).getFilename() %>" alt="">
                    <img src="Dashobard products/<%= product.getMedia().get(0).getFilename() %>" alt="">
                </div>
                <div class="cont-summary">
                    <%if(product instanceof House)
                    {
                        House house = (House)product;
                        %>
                    <img src="bed-solid.svg" alt="" style="left: 0; top: 25%;"> <h4 style="left: 21%;"> <%=house.getBedrooms() %></h4>
                    <img src="shower-solid.svg" alt="" style="left: 30%; top: 25%;"> <h4 style="left: 50%;"> <%=house.getBathrooms() %></h4>
                    <img src="car-solid.svg" alt="" style="left: 55%; top: 25%;"> <h4 style="left: 75%;"> <%=house.getGarages() %></h4>
                    <%}else if(product instanceof Car){
                    
                        Car car = (Car)product;
                    %>
                        <img src="gauge-high-solid.svg" alt="" style="left: 0; top: 25%;"> <h4 style="left: 21%;"> <%= car.getKilometres()%> km</h4>
                        <img src="code-fork-solid.svg" alt="" style="left: 55%; top: 25%;"> <h4 style="left: 72%;"> <%= car.getGearType()  %></h4>
                        <img src="gas-pump-solid.svg" alt="" style="left: 80%; top: 25%;"> <h4 style="left: 98%;"> <%= car.getFuelType()  %></h4>
                    <%}%>
                </div>
                <div class="price-area">
                    <!--
                        this can also represent the price of rental houses E.G. R4000/M
                    -->
                    <h4 style="margin-left: 50%;">R<%= product.getPrice() %></h4>
                </div>
                <form action="SelectedProduct.co.za" method="post">
                    <button name="productId" value="<%= product.getId() %>" type="submit">see more</button>
                </form>
        </div>
        <%}%>
       
    </div>


</body>
</html>