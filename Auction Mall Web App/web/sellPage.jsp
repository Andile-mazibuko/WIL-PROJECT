<%-- 
    Document   : sellPage
    Created on : 25 Mar 2024, 12:07:13 PM
    Author     : andil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="sellStyle.css">
</head>
<body>
    <nav>
        <img src="shopping-bag.svg" alt="">  <a>Premium section</a>
    </nav>
    <div class="form-cont">
        <form action="SellPageServlet.co.za" method="post" enctype="multipart/form-data">
            <input type="number" name="buynow" id="" min="0" placeholder="Maximum price">
            <input type="number" name="bid_price" id="bid" min="0" placeholder="Minimum price" >
        
           
            <select name="sell_option" id="select" >
                <option value="">-- select --</option>
                <option value="rent_car">Car to rent</option>
                <option value="buy_car">Car to sell</option>
                <option value="rent_house">House to rent</option>
                <option value="buy_house">House to sell</option>
            </select>
            <input type="number" name="bid" id="bid" min="0" placeholder="Minimum price" class="invisible">
        
            <!--House hidden attributes-->

            <input type="number" name="bedrooms" id="bedrooms" min="0" placeholder="No. of bed rooms" class="invisible">
            <input type="number" name="bathrooms" id="bathrooms" min="0" placeholder="No. of bath rooms" class="invisible">
            <input type="number" name="garages" id="garage" min="0" placeholder="No. of garages" class="invisible">
            
            <!--Car hidden attributes-->
            
            <input type="number" name="kilometres" id="kilometres" placeholder="No. of km travelled" class="invisible">
            <select name="geartype" id="geartype" class="invisible">
                <option value="M">Manual</option>
                <option value="A">Automatic</option>
            </select>
            <select name="fueltype" id="fueltype" class="invisible">
                <option value="Diesiel">Diesel</option>
                <option value="Petrol">Petrol (Gasoline)</option>
                <option value="Natural Gas">Natural Gas</option>
                <option value="Propane">Propane</option>
                <option value="Electricity">Electricity</option>
            </select>
            <input type="text" name="model" id="model" placeholder="Model" class="invisible">


            <textarea name="description" id="" cols="52" rows="10"></textarea >

            <label for="main-file"><img src="upload-solid.svg" alt="">upload main</label><br>
            <input type="file" name="main file" id="main-file" value="main picture">
            
            <input type="file" name="media" id="multiple-file" multiple placeholder="all files related to the product">
            <label for="multiple-file" style="left: 51%;"><img src="upload-solid.svg" alt="">Upload multiple</label>
            <input type="submit" value="List item">
        </form>
    </div>


    <script src="sell.js"></script>
</body>
</html>
