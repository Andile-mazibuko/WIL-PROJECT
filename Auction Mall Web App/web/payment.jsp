<%-- 
    Document   : payment
    Created on : 25 Mar 2024, 1:38:05 PM
    Author     : andil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="payment.css">
</head>
<body>
    <nav>
        <img src="shopping-bag.svg" alt="">  <a>Payment Page</a>
    </nav>
    <div class="payment-cont">
        <form action="PremiumServlet.co.za" method="post">

            <div class="billing">
                <h3>Billing Address </h3>
                <label for="full_name"><img src="user.svg" alt=""> Full name</label>
                <input type="text" name="full_name" id="full_name" placeholder="Andile L. Mazibuko">
                
                <label for="email"><img src="mail.svg" alt=""> Email</label>
                <input type="email" name="email" id="email" placeholder="andile@example.com">
                
                <label for="address"><img src="address-book-solid.svg" alt=""> Address</label>
                <input type="text" name="address" id="address" placeholder="51 w. 15th street">
                
                <label for="city"> <img src="city-solid.svg" alt=""> City</label>
                <input type="text" name="city" id="city" placeholder="Ulundi">
                
                <label for="postal_code"> Code</label>
                <input type="number" name="postal_code" id="postal_code" placeholder="3865">
            </div>
            <div class="payment">
                <h3>Payment</h3>
                <div class="cards">
                    <img src="cc-visa.svg" alt="">
                    <img src="cc-mastercard.svg" alt="">
                    <img src="apple-pay.svg" alt="">
                </div>
                <label for="card_name"> Name on the card</label>
                <input type="text" name="card_name" id="card_name" placeholder="Andile Lethu Mazibuko">

                <label for="card_number">Credit card Number</label>
                <input type="text" name="card_number" id="card_number" placeholder="1111-2222-3333-4444">

                <label for="exp_date">Exp date</label>
                <input type="text" name="exp_date" placeholder="MM / YY">

                <label for="cvv">CVV</label>
                <input type="numberS" name="cvv" placeholder="000" minlength="3" maxlength="3">
            </div>
            <button type="submit">Proceed with payment</button>
        </form>
    </div>
</body>
</html>
