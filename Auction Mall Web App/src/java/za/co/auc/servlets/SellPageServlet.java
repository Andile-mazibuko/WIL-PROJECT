/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import za.co.auc.entities.Car;
import za.co.auc.entities.House;
import za.co.auc.entities.Product;
import za.co.auc.entities.ProductMedia;
import za.co.auc.entities.SysUser;
import za.co.auc.session.beans.ProductFacadeLocal;
import za.co.auc.session.beans.ProductMediaFacadeLocal;
import za.co.auc.session.beans.SysUserFacadeLocal;

/**
 *
 * @author andil
 */
@MultipartConfig
public class SellPageServlet extends HttpServlet
{

    @EJB
    private SysUserFacadeLocal sysUserFacade;

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private ProductMediaFacadeLocal productMediaFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
         Collection<Part> parts = request.getParts();
         List<ProductMedia> productMedia = new ArrayList<>();
        
            for(Part part : parts)
            {
                
                InputStream input = part.getInputStream();
                byte[] fileContent = new byte[input.available()];
                input.read(fileContent);
                ProductMedia media = new ProductMedia();
                if(part.getSubmittedFileName() != null)
                {
                    media.setFile(fileContent);
                    media.setFilename(part.getSubmittedFileName());
                    productMedia.add(media);
                    productMediaFacade.create(media);
                }
                
                
                
            }
            
            
        HttpSession session = request.getSession();
        SysUser user = (SysUser)session.getAttribute("user");
        List<Product> userProducts = user.getUserProducts();
        Double maximumPrice = Double.parseDouble(request.getParameter("buynow"));
        Double minimumPrice = Double.parseDouble(request.getParameter("bid_price"));
        String option = request.getParameter("sell_option");
        String description = request.getParameter("description");
        Part mainFilePart = request.getPart("main file");
        InputStream in = mainFilePart.getInputStream();
        byte[] main = new byte[in.available()];
        in.read(main);
        
        Product product;
        
        
        if(option.contains("car"))
        {
            String gearType = request.getParameter("geartype");
            Integer kilometres = Integer.parseInt(request.getParameter("kilometres"));
            String fuel = request.getParameter("fueltype");
            String model = request.getParameter("model");
            
            product = new Car();
            product.setPrice(maximumPrice);
            product.setDateListed(new Date());
            product.setDescription(description.getBytes());
            product.setBuyType(option.substring(0, 3));
            product.setMainPic(main);
            product.setMedia(productMedia);
            product.setMinimumbid(minimumPrice);
            
            Car car = (Car)product;
            car.setFuelType(fuel);
            car.setGearType(gearType);
            car.setKilometres(kilometres);
            car.setModel(model);
            
            product = car;
        }else
        {
            Integer bedrooms = Integer.parseInt(request.getParameter("bedrooms"));
            Integer bathrooms = Integer.parseInt(request.getParameter("bathrooms"));
            Integer garages = Integer.parseInt(request.getParameter("garages"));
            
            product = new House();
            product.setPrice(maximumPrice);
            product.setDateListed(new Date());
            product.setDescription(description.getBytes());
            product.setBuyType(option.substring(0, 3));
            product.setMainPic(main);
            product.setMedia(productMedia);
            product.setMinimumbid(minimumPrice);
           
            House house = (House)product;
            house.setBathrooms(bathrooms);
            house.setBedrooms(bedrooms);
            house.setGarages(garages);
            
            product = house;
        }
       
        userProducts.add(product);
       
        productFacade.create(product);
        sysUserFacade.edit(user);
        session.setAttribute("user", user);
        response.sendRedirect("DashBoard.co.za");
       
    }
    
}
