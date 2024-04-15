/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.auc.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 *
 * @author andil
 */
@Entity
public class House extends Product implements Serializable {


    private Integer bedrooms,garages,bathrooms,noOfRooms;
    @OneToOne(fetch = FetchType.EAGER)
    private PropertyLocation locaion;

    public PropertyLocation getLocaion() {
        return locaion;
    }

    public void setLocaion(PropertyLocation locaion) {
        this.locaion = locaion;
    }
    
    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getGarages() {
        return garages;
    }

    public void setGarages(Integer garages) {
        this.garages = garages;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
    
    
}
