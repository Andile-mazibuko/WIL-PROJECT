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
            <form action="">
                <input type="number" name="first_bid" id="" required min="0" placeholder="Minimum price">
                <input type="number" name="buy_now" id="" required min="0" placeholder="Maximum price">

                <select name="sell_option" id="" required>
                    <option value="">-- select --</option>
                    <option value="rent">Rental product</option>
                    <option value="buy">Sell product</option>
                </select>
                <textarea name="description" id="" cols="52" rows="10"></textarea >

                <label for="main-file"><img src="upload-solid.svg" alt="">upload main</label><br>
                <input type="file" name="main file" id="main-file" required value="main picture">

                <input type="file" name="media" id="multiple-file" multiple required placeholder="all files related to the product">
                <label for="multiple-file" style="left: 51%;"><img src="upload-solid.svg" alt="">Upload multiple</label>
                <input type="submit" value="List item">
            </form>
        </div>

    </body>
</html>
