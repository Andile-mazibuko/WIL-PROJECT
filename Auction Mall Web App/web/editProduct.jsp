<%-- 
    Document   : editProduct
    Created on : 13 Apr 2024, 11:14:17 AM
    Author     : andil
--%>

<%@page import="za.co.auc.entities.PropertyLocation"%>
<%@page import="za.co.auc.entities.Car"%>
<%@page import="za.co.auc.entities.House"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="za.co.auc.entities.ProductMedia"%>
<%@page import="java.io.File"%>
<%@page import="za.co.auc.entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="editProduct.css">
</head>
<body>
    <nav>
        <img src="shopping-bag.svg" alt="">  <a>sell on Auction Mall</a>
        <ul>
            <li><a href="">Manage products</a></li>
        </ul>
    </nav>
    
    <%
        Product product  = (Product)session.getAttribute("toEdit");
        ProductMedia media = product.getMedia().get(0);
        String filename = media.getFilename();
        File file = new File("D:\\Files\\projects\\Git projects\\WIL PROJECT\\WIL-PROJECT\\Auction Mall Web App\\web\\userProducts\\"+filename);
        file.createNewFile();
        FileOutputStream output = new FileOutputStream(file);
        output.write(media.getFile());
        output.flush();
        output.close();

        
    %>
    <div class="prod-container">
        <img src="userProducts/<%=filename %>" alt=""><h4>R<%=product.getPrice() %></h4>
        <form action="EditProductDetails.co.za" method="post">
            <%
            
            if(product instanceof House){
                House house = (House)product;
                PropertyLocation loc = ((House)product).getLocaion();
            %>
            <label for="province">Province</label>
            <input type="text" value="" name="province" id="province" placeholder="Enter the province of your property">

            <label for="city">City</label>
            <input type="text" value="" name="city" id="city" placeholder="Enter the city of your property">

            <label for="street">Street</label>
            <input type="text" value="" name="street" id="street" placeholder="Enter the street address of your property">

            <label for="bedrooms">Bedrooms no:</label>
            <input type="number" value="<%= house.getBedrooms() %>" name="bedrooms" id="bedrooms" placeholder="Enter the number of bedrooms">

            <label for="rooms">Rooms No</label>
            <input type="number" value="<%= house.getBathrooms() %>" name="rooms" id="rooms" placeholder="Enter the total number of rooms">

            <label for="garages">Garages</label>
            <input type="number" value="<%= house.getGarages() %>" name="garages" id="garages" placeholder="enter the number of garages ">
            <%}
            else if(product instanceof Car)
            {
                Car car = (Car)product;

            %>
            
            <label for="kilometres">KM traveled</label>
            <input type="number" name="kilometres" value="<%= car.getKilometres() %>" id="kilometres" min="<%=car.getKilometres()%>" placeholder="Enter the distance travelled in km">
            <%}%>
            <input type="submit" value="Edit" onsubmit="alert('You have successfully updated this item')">
            
        </form>
    </div>
</body>
</html>
