/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Embeddable
@Entity
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="id")
    private Long id;
    private int quantity;
    
    private OrderItem()
    {
    }
    
    private OrderItem(Builder builder)
    {
        id=builder.id;
        quantity=builder.quantity;
    }
    
    public static class Builder{
        
        private Long id;
        private int quantity;
        
        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder quantity (int value)
        {
            this.quantity=value;
            return this;
        }
        
        public Builder OrderItem(OrderItem value)
        {
            id=value.getId();
            quantity=value.getQuantity();
            return this;
        }
        
        public OrderItem build()
        {
            return new OrderItem(this);
        }
    }

    public int getQuantity() {
        return quantity;
    }
    
    

    public Long getId() {
        return id;
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
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.OrderItem[ id=" + id + " ]";
    }
    
}
