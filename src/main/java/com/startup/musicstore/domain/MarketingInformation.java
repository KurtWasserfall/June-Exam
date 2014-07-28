/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
* @author 211150142
 * Kurt Wasserfall 3B
 */
@Entity
public class MarketingInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String statusOfInformation;
    @OneToMany
    @JoinColumn(name="id")
    public static Review review;
    @OneToOne
    @JoinColumn(name="id")
    public static ArtistInformation artistInformation;
    
    private MarketingInformation()
    {
    }
    
    private MarketingInformation(Builder builder)
    {
        id=builder.id;
        statusOfInformation=builder.statusOfInformation;
    }
    
    public static class Builder{
        
        private Long id;
        private String statusOfInformation;
        
        public Builder id(Long value)
        {
            this.id=value;
            return this;
                    
        }
        
        public Builder statusOfInformation (String value)
        {
            this.statusOfInformation=value;
            return this;
        }
        
        public Builder MarketingInformation(MarketingInformation value)
        {
            id=value.getId();
            statusOfInformation=value.getStatusOfInformation();
            review=value.getReview();
            artistInformation=value.getArtistInformation();
            return this;
        }
        
        public MarketingInformation build()
        {
            return new MarketingInformation(this);
        }
    }

    public Long getId() {
        return id;
    }

    public  Review getReview() {
        return review;
    }

    public  ArtistInformation getArtistInformation() {
        return artistInformation;
    }
    
    

    public String getStatusOfInformation() {
        return statusOfInformation;
    }
    
    

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof MarketingInformation)) {
            return false;
        }
        MarketingInformation other = (MarketingInformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.MarketingInformation[ id=" + id + " ]";
    }
    
}
