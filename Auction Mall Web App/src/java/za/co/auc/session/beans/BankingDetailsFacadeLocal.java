/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.session.beans;

import java.util.List;
import javax.ejb.Local;
import za.co.auc.entities.BankingDetails;

/**
 *
 * @author andil
 */
@Local
public interface BankingDetailsFacadeLocal {

    void create(BankingDetails bankingDetails);

    void edit(BankingDetails bankingDetails);

    void remove(BankingDetails bankingDetails);

    BankingDetails find(Object id);

    List<BankingDetails> findAll();

    List<BankingDetails> findRange(int[] range);

    int count();
    
}
