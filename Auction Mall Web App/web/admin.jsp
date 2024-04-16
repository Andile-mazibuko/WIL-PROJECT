<%-- 
    Document   : admin
    Created on : 16 Apr 2024, 6:59:34 PM
    Author     : andil
--%>

<%@page import="za.co.auc.entities.PropertyLocation"%>
<%@page import="za.co.auc.entities.Car"%>
<%@page import="za.co.auc.entities.House"%>
<%@page import="za.co.auc.entities.SysUser"%>
<%@page import="za.co.auc.entities.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="admin.css">
</head>
<body>
    <nav>
        <a>Admin Page</a>
    </nav>
    
    <%
        List<Product> products = (List<Product>) session.getAttribute("products");
        List<SysUser> pendingUsers = (List<SysUser>)session.getAttribute("pending");
    
    %>
    <div class="admin_main">
        <div class="left">
            <form action="">
                <button style="border-top: 2px solid gainsboro;">
                    <img src="user.svg" alt="">approve agents <div class="num"><%=pendingUsers.size() %></div>
                </button>
                <button>
                    <img src="mail.svg" alt="">Houses</button>
                <button>
                    <img src="gauge-high-solid.svg" alt=""> Vehicles
                </button>
                <button>
                    <img src="chart-line-solid.svg" alt="">    Analyse
                </button>
                <button type="submit">
                   <img src="gears-solid.svg" alt=""> Manage
                </button>
            </form>
        </div>
        <div class="right">
            <div class="summary num_users">
                <h1>83</h1>
                <p>Number of registered users </p>
                <img src="gears-solid.svg" alt="">
            </div>
            <div class="summary num_products">
                <h1>83</h1>
                <p>Number of products </p>
                <img src="gears-solid.svg" alt="">
            </div>
            <div class="summary visits">
                <h1>83</h1>
                <p>Number of vists </p>
                <img src="gears-solid.svg" alt="">
            </div>

            <form action="ApproveAgent.co.za" method="post" style="margin-top: 20%;">
                <table id="agents">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>name</th>
                            <th>surname</th>
                            <th>email</th>
                            <th>password</th>
                            <th>action</th>
                        </tr>
                    </thead>
                    <%
                        int count = 0;
                        for(SysUser user : pendingUsers){
                            count++;
                    %>
                    <tr>
                        <td><%= count %></td>
                        <td><%= user.getFirstname() %></td>
                        <td><%= user.getLastname() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getPassword().toString() %></td>
                        <td><button type="submit" name="toApprove" value="<%=user.getId()%>">approve</button></td>
                    </tr>
                    <%}%>
                </table>
                
            </form>
                <form action="SelectedProduct.co.za" method="post">
                <table>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>description</th>
                            <th>min price</th>
                            <th>max price</th>
                            <th>action</th>
                        </tr>
                    </thead>
                    <%
                    
                    String description = "";
                     int i = 0;   
                    for(Product pro : products){
                        i++;
                        if(pro instanceof House)
                        {
                            PropertyLocation loc = ((House)pro).getLocaion();
                            description = loc.getProvince()+" > "+loc.getTown()+" > "+loc.getStreet();
                            
                        }else if(pro instanceof Car)
                        {
                            description = ((Car)pro).getModel();
                        }
                    %>
                    <tr>
                        <td><%=i%></td>
                        <td><%=description%></td>
                        <td>R<%=pro.getMinimumbid()%></td>
                        <td>R<%=pro.getPrice() %></td>
                        <td><button type="submit" name="productId" value="<%=pro.getId()%>">see more</button></td>
                    </tr>
                    <%}%>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
