/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.session.beans;

import java.util.List;
import javax.ejb.Local;
import za.co.auc.entities.UserOrder;

/**
 *
 * @author andil
 */
@Local
public interface UserOrderFacadeLocal {

    void create(UserOrder userOrder);

    void edit(UserOrder userOrder);

    void remove(UserOrder userOrder);

    UserOrder find(Object id);

    List<UserOrder> findAll();

    List<UserOrder> findRange(int[] range);

    int count();
    
}
