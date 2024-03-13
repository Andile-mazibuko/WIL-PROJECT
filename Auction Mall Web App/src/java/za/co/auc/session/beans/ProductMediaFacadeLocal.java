/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.session.beans;

import java.util.List;
import javax.ejb.Local;
import za.co.auc.entities.ProductMedia;

/**
 *
 * @author andil
 */
@Local
public interface ProductMediaFacadeLocal {

    void create(ProductMedia productMedia);

    void edit(ProductMedia productMedia);

    void remove(ProductMedia productMedia);

    ProductMedia find(Object id);

    List<ProductMedia> findAll();

    List<ProductMedia> findRange(int[] range);

    int count();
    
}
