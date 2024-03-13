/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.session.beans;

import java.util.List;
import javax.ejb.Local;
import za.co.auc.entities.House;

/**
 *
 * @author andil
 */
@Local
public interface HouseFacadeLocal {

    void create(House house);

    void edit(House house);

    void remove(House house);

    House find(Object id);

    List<House> findAll();

    List<House> findRange(int[] range);

    int count();
    
}
