/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.session.beans;

import java.util.List;
import javax.ejb.Local;
import za.co.auc.entities.PropertyLocation;

/**
 *
 * @author andil
 */
@Local
public interface PropertyLocationFacadeLocal {

    void create(PropertyLocation propertyLocation);

    void edit(PropertyLocation propertyLocation);

    void remove(PropertyLocation propertyLocation);

    PropertyLocation find(Object id);

    List<PropertyLocation> findAll();

    List<PropertyLocation> findRange(int[] range);

    int count();
    
}
