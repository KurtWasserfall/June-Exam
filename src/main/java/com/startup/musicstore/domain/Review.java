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

/**
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Entity
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="id")
    private Long id;
    private String description;
    private int rating;
    
    private Review()
    {}
    
    private Review(Builder builder)
    {
        id=builder.id;
        description=builder.description;
        rating=builder.rating;
    }
    
    public static class Builder{
        private Long id;
        private String description;
        private int rating;
        
        public Builder id (Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder description(String value)
        {
            this.description=value;
            return this;
        }
        
        public Builder rating (int value)
        {
            this.rating=value;
            return this;
        }
        
        public Builder Review (Review value)
        {
            id=value.getId();
            description=value.getDescription();
            rating=value.getRating();
                    return this;
        }
        
        public Review build()
        {
            return new Review (this);
        }
        
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
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
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Review[ id=" + id + " ]";
    }
    
}
