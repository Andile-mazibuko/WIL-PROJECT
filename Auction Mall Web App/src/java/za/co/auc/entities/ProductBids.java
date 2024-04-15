/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andil
 */
@Entity
public class ProductBids implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   
    @Column(name = "prod_id")
    private Long product;
    
    @Column(name = "last_bid")
    private Double lastBid;
    
    
    @OneToOne(fetch = FetchType.EAGER)
    private SysUser bidders;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    private Integer bidDuration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Double getLastBid() {
        return lastBid;
    }

    public void setLastBid(Double lastBid) {
        this.lastBid = lastBid;
    }

    public SysUser getBidders() {
        return bidders;
    }

    public void setBidders(SysUser bidders) {
        this.bidders = bidders;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBidDuration() {
        return bidDuration;
    }

    public void setBidDuration(Integer bidDuration) {
        this.bidDuration = bidDuration;
    }

    

}
