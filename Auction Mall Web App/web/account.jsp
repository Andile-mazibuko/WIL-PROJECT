<%-- 
    Document   : account
    Created on : 09 Apr 2024, 11:25:00 AM
    Author     : andil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="account.css">
</head>
<body>
    <nav>
        <img src="shopping-bag.svg" alt="">  <a>sell on Auction Mall</a>
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
                <form action="">
                    <h4>#AM1111</h4>
                    <input type="text" name="firstname" value="Andile" placeholder="firstname">
                    <input type="text" name="lastname" value="Mazibuko">
                    <input type="email" name="email" value="aas@gmail.com">
                    <input type="text" name="username" value="andile_mazibuko">
                    <input type="text" name="cellphone" value="000000000">
                    <input type="submit">
                </form>
            </div>
            <div class="sum-cont wishlist" id="wishlist-cont">
               <form action="">
                    <table >
                        <thead>
                            <td class="number">#</td>
                            <td>product img</td>
                            <td>Product type</td>
                            <td>Min Price</td>
                            <td>Max Price</td>
                            <td>remove</td>

                        </thead>
                        <tr>
                            <td class="number">1</td>
                            <td><img src="p1.png" alt=""></td>
                            <td>House for sale</td>
                            <td>R90 000</td>
                            <td>R150 000</td>
                            <td><button type="submit"><img src="trash-can-solid.svg" alt=""></button></td>
                        </tr>
                        
                        
                    </table>
                </form>                
            </div>
            <div class="sum-cont password" id="password-cont">
                <form action="">
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
                        <tr>
                            <td class="number">1</td>
                            <td><button type="submit" value="">AUC114</button></td>
                            <td>Tue,28 Feb 23 10:55:20:GMT</td>
                            <td>Payment recieved</td>
                        </tr>
                        <tr>
                            <td class="number">1</td>
                            <td><button type="submit" value="">AUC114</button></td>
                            <td>Tue,28 Feb 23 10:55:20:GMT</td>
                            <td>Payment recieved</td>
                        </tr>
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
    </script>
</body>
</html>
