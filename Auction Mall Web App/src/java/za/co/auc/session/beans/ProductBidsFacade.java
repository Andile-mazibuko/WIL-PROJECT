/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.auc.entities.ProductBids;

/**
 *
 * @author andil
 */
@Stateless
public class ProductBidsFacade extends AbstractFacade<ProductBids> implements ProductBidsFacadeLocal {

    @PersistenceContext(unitName = "Auction_Mall_Web_AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductBidsFacade() {
        super(ProductBids.class);
    }
    
}
