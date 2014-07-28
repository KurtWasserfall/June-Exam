/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Embeddable 
@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private int orderNumber;
    private Date orderDate;
    @OneToMany
    @JoinColumn(name="id")
    public static OrderItem orderItem;
    
    private Order()
    {
    }
    
    private Order(Builder builder)
    {
        id=builder.id;
        orderNumber=builder.orderNumber;
        orderDate=builder.orderDate;
    }
    
    public static class Builder{
    
        private Long id;
        private int orderNumber;
        private Date orderDate;
        
        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder orderNumber (int value)
        {
            this.orderNumber=value;
            return this;
        }
        
        public Builder orderDate (Date value)
        {
            this.orderDate=value;
            return this;
        }
        
        public Builder Order (Order value)
        {
            id=value.getId();
            orderNumber=value.getOrderNumber();
            orderDate=value.getOrderDate();
            orderItem=value.getOrderItem();
            return this;
        }
        
        public Order build()
        {
            return new Order (this);
        }
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }
    
    



    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
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
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Order[ id=" + id + " ]";
    }
    
}
