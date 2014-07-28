/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Entity
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String albumTitle;
    private BigDecimal unitPrice;
    private int inventory;
    private int sales;
    @OneToOne
    @Embedded
    @JoinColumn(name="id")
    public static OrderItem orderItem;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id")
    public static Track track;
    @OneToOne
    @JoinColumn(name="id")
    public static MarketingInformation marketingInformation;
    
    
    private Album()
    {}
    
    private Album (Builder builder)
    {
        id=builder.id;
        albumTitle=builder.albumTitle;
        unitPrice=builder.unitPrice;
        inventory=builder.inventory;
        sales=builder.sales;
    }
    
    public static class Builder{
        private Long id;
        private String albumTitle;
        private BigDecimal unitPrice;
        private int inventory;
        private int sales;
        
        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder albumTitle(String value)
        {
            this.albumTitle=value;
            return this;
        }
        
        public Builder unitPrice(BigDecimal value)
        {
            this.unitPrice=value;
            return this;
        }
        
        public Builder inventory (int value)
        {
            this.inventory=value;
            return this;
        }
        
        public Builder sales (int value)
        {
            this.sales=value;
            return this;
        }
        
        public Builder Album (Album value)
        {
            id=value.getId();
            albumTitle=value.getAlbumTitle();
            unitPrice=value.getUnitPrice();
            inventory=value.getInventory();
            sales=value.getSales();
            track=value.getTrack();
            orderItem=value.getOrderItem();
            marketingInformation=value.getMarketingInformation();
            
            return this;
        }
        
        public Album build()
        {
            return new Album (this);
        }
    }

    public  OrderItem getOrderItem() {
        return orderItem;
    }

    public  Track getTrack() {
        return track;
    }

    public  MarketingInformation getMarketingInformation() {
        return marketingInformation;
    }
    
    

   
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public int getSales() {
        return sales;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Album[ id=" + id + " ]";
    }
    
}
