/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.session.beans;

import java.util.List;
import javax.ejb.Local;
import za.co.auc.entities.ProductBids;

/**
 *
 * @author andil
 */
@Local
public interface ProductBidsFacadeLocal {

    void create(ProductBids productBids);

    void edit(ProductBids productBids);

    void remove(ProductBids productBids);

    ProductBids find(Object id);

    List<ProductBids> findAll();

    List<ProductBids> findRange(int[] range);

    int count();
    
}
