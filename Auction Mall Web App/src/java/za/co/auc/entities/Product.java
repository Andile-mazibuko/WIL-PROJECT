/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andil
 */
@Entity
public abstract class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double price,minimumbid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateListed;
    private String buyType;
    private byte[] description;
    private String status="listed";
    @Lob
    private byte[] mainPic;
    @OneToMany
    @JoinTable(name = "prod_files")
    private List<ProductMedia> media;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getMinimumbid() {
        return minimumbid;
    }

    public void setMinimumbid(double minimumbid) {
        this.minimumbid = minimumbid;
    }
    public Date getDateListed() {
        return dateListed;
    }

    public void setDateListed(Date dateListed) {
        this.dateListed = dateListed;
    }

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getMainPic() {
        return mainPic;
    }

    public void setMainPic(byte[] mainPic) {
        this.mainPic = mainPic;
    }

    public List<ProductMedia> getMedia() {
        return media;
    }

    public void setMedia(List<ProductMedia> media) {
        this.media = media;
    }
    
    
}
