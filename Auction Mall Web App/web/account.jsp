<%-- 
    Document   : account
    Created on : 09 Apr 2024, 11:25:00 AM
    Author     : andil
--%>

<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="za.co.auc.entities.UserOrder"%>
<%@page import="za.co.auc.entities.Car"%>
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
    <link rel="stylesheet" href="account.css">
</head>
<body>
    
    <%
        SysUser user = (SysUser)session.getAttribute("user");
        String cellphone = "";
        if(user.getCellphone() != null)
        {
            cellphone = cellphone+user.getCellphone();
        }
        
    %>
    <nav>
        <img src="shopping-bag.svg" alt="">  <a href="DashBoard.co.za">Home</a>
    </nav>
    <div class="account-summary">
        <div class="side-info">
            <button id="account">
                <img src="user.svg" alt=""> Account info
            </button>
            <button id="wishlist">
                <img src="heart-solid.svg" alt="">    wishlist
            </button>
            <button id="password">
                <img src="unlock-keyhole-solid.svg" alt="">   change password
            </button>
            <button id="orders">
                <img src="cart-shopping-solid.svg" alt="">   order history
            </button>
        </div>
        <div class="large-area">
            <div class="sum-cont account-details" id="account-cont">
                <form action="EditInformation.co.za" method="post">
                    <h4>#AC<%=user.getId() %></h4>
                    <input type="text" name="firstname" value="<%=user.getFirstname() %>" placeholder="firstname">
                    <input type="text" name="lastname" value="<%=user.getLastname() %>">
                    <input type="email" name="email" value="<%=user.getEmail() %>">
                    <input type="text" name="username" value="<%=user.getUsername() %>">
                    <input type="text" name="cellphone" value="<%=cellphone %>" oninput="validateInput(this)" placeholder="Enter your cellphone number">
                    <input type="submit">
                </form>
            </div>
            <div class="sum-cont wishlist" id="wishlist-cont">
                
                <form action="DeleteWishlist.co.za" method="post">
                    <table >
                        <thead>
                            <td class="number">#</td>
                            <td>product img</td>
                            <td>Product type</td>
                            <td>Min Price</td>
                            <td>Max Price</td>
                            <td>remove</td>

                        </thead>
                <%
                
                        List<Product> wishlist = user.getWishlist();
                
                        int count = 0;
                        for(Product pro : wishlist){
                        
                            File file = new File("D:\\Files\\projects\\Git projects\\WIL PROJECT\\WIL-PROJECT\\Auction Mall Web App\\web\\account\\"+pro.getMedia().get(0).getFilename());
                            file.createNewFile();
                            if(!file.exists())
                            {
                                file.createNewFile();
                            }
                            
                            FileOutputStream output = new FileOutputStream(file);
                            output.flush();
                            output.close();
                            count++;
                        
                        String proType;
                        if(pro instanceof House)
                        {
                            proType = "House";
                        }else
                        {
                            proType = ((Car)pro).getModel();
                        }
                %>
                        <tr>
                            <td class="number"><%=count%></td>
                            <td><img src="Dashobard products/<%=pro.getMedia().get(0).getFilename()%>" alt=""></td>
                            <td><<%= proType %></td>
                            <td>R<%= pro.getMinimumbid() %></td>
                            <td>R<%= pro.getPrice() %></td>
                            <td><button name="prodId" value="<%= pro.getId() %>" type="submit"><img src="trash-can-solid.svg" alt=""></button></td>
                        </tr>
                <%}%>
                        
                    </table>
                </form>                
            </div>
            <div class="sum-cont password" id="password-cont">
                <form action="EditPassword.co.za" method="post">
                    <label for="current">Current Password</label>
                    <input type="password" name="current" id="current" placeholder="Enter your current password">
                    <label for="new_pass">New password</label>
                    <input type="password" name="new_pass" id="new_pass" placeholder="Enter your new password">
                    <label for="confirm_new">Confirm password</label>
                    <input type="password" name="confirm_new" id="confirm_new" placeholder="Confirm your new password">
                    <input type="submit">
                </form>



            </div>
            <div class="sum-cont orders" id="orders-cont">
                <form action="">
                    <table>
                        <thead>
                            <td class="number">#</td>
                            <td>OrderNo</td>
                            <td>Date</td>
                            <td>status</td>
                        </thead>
                        <%
                            List<UserOrder>userOrders = user.getOrders();
                            int num = 0;
                            for(UserOrder order : userOrders)
                            {
                                num++;
                        %>
                        <tr>
                            <td class="number"><%= num%></td>
                            <td><button type="submit" value="">AUC<%=order.getId() %></button></td>
                            <td><%= order.getDate().toString() %></td>
                            <td><%=order.getStatus() %></td>
                        </tr>
                        <%}%>
                    </table>
                </form>
            </div>


        </div>
    </div>
    <script>
        var accountCont = document.getElementById("account-cont");
        var wishlistCont = document.getElementById("wishlist-cont");
        var passwordCont = document.getElementById("password-cont");
        var ordersCont = document.getElementById("orders-cont");

        document.getElementById("account").addEventListener("click",() =>{
            accountCont.classList.add("visible");
            wishlistCont.classList.remove("visible");
            passwordCont.classList.remove("visible");
            ordersCont.classList.remove("visible");
        });
        document.getElementById("wishlist").addEventListener("click",() =>{
            wishlistCont.classList.add("visible");
            accountCont.classList.remove("visible");
            passwordCont.classList.remove("visible");
            ordersCont.classList.remove("visible");
        });
        document.getElementById("password").addEventListener("click",() =>{
            passwordCont.classList.add("visible");
            accountCont.classList.remove("visible");
            wishlistCont.classList.remove("visible");
            ordersCont.classList.remove("visible");
        });
        document.getElementById("orders").addEventListener("click",() =>{
            ordersCont.classList.add("visible");
            accountCont.classList.remove("visible");
            wishlistCont.classList.remove("visible");
            passwordCont.classList.remove("visible");
        });
        function validateInput(inputField) {
            
            inputField.value = inputField.value.replace(/\D/g, '');
        }
    </script>
</body>
</html>
