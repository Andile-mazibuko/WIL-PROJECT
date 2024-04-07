<%-- 
    Document   : itemPage
    Created on : 03 Apr 2024, 2:13:11 PM
    Author     : andil
--%>

<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.co.auc.entities.ProductMedia"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="za.co.auc.entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="itemPage.css">
</head>
<body>
    
    <%
    
        Product product = (Product)session.getAttribute("selectedProduct");
        String description = new String(product.getDescription(),StandardCharsets.UTF_8);
        List<ProductMedia> media = product.getMedia();
    

        
    %>
    <nav>
        <img src="shopping-bag.svg" alt="">  <a>sell on Auction Mall</a>
    </nav>
    <div class="location">
        <h2> Propery for sale</h2>
        <p>South africa > KwaZulu Natal > Ulundi > J. Adams str </p>
    </div>

    <div class="main-area">
        <img src="p1.png" alt="">
        <form action="AddToWishlist.co.za" method="post" style="width: 5%;height: 10%;position: absolute; z-index: 5; top: 5%; left: 2%; display: flex;align-items: center;justify-content: center;">
            <button onclick="alert('you have successfully added this product to your wishlist')" name="submit" value="<%= product.getId() %>" type="submit" style="width: 70%;height: 60%;background-color: orangered; cursor: pointer; border: none; border-radius: 10px;"><img src="heart.svg" alt=""></button>
        </form>
        <div class="agent-area">
            <img src="agent.png" alt="">
            <h4>
                <i>work: </i> 
               <b>063 5970 787</b><br>
               <i>cell: </i> 
               <b>063 5970 787</b><br><br>
               <br><br>
                Andile Mazibuko(agent)
            </h4>
        </div>
        <div class="description">
            <h4>R<%=product.getPrice() %></h4><br>
            <p>(3) bedrooms (2) bathrooms  (2) garages</p>
            <div>
                <h4>About this property</h4>
                 <%= description%>
            </div>
        </div>
        <div class="bidding-box">
            <form action="PaymentServlet.co.za" method="post">
                <button name="buy_option" type="submit" value="<%= "bid:"+Double.sum(product.getMinimumbid(), 10000) %>" style="background-color: rgb(28, 5, 82);" onsubmit="confirm()">
                    BID <%=product.getMinimumbid() %> (8h)
                </button>
                <button name="buy_option" type="submit" value="<%= "buy:"+product.getPrice() %>" style="background-color: orangered;" onsubmit="confirm()">
                    Buy Now (R<%=product.getPrice() %>)

                </button>
            </form>
        </div>
    </div>

        <h4 style="position: absolute;top: 92%; ">Photo gallery</h4>

    <div class="images">
        <%
            for(ProductMedia pro : media)
            {
                File file = new File("D:\\Files\\projects\\Git projects\\WIL PROJECT\\WIL-PROJECT\\Auction Mall Web App\\web\\selected products\\"+pro.getFilename());
                file.createNewFile();
                OutputStream output = new FileOutputStream(file);
                output.write(pro.getFile());
                output.flush();
                output.close();

        %>
        <img src="selected products/<%=pro.getFilename() %>" alt="">
        <%}%>
    </div>
        <script>

    </script>
</body>
</html>
