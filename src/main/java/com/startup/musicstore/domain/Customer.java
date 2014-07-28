/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

/**
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerNumber;
    @Embedded
    private Name name;
    @Embedded
    private Contact contact;
    @Embedded
    private CustomerAddress customerAddress;
    //@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   // @JoinColumn(name="id_PK")
   // private CustomerAddress customerAddress;
    @OneToOne
    @JoinColumn(name="id")
    public static Demographic demographic;
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Credit_number")
    public static List <CreditCard >CreditCard;
    @OneToMany
    @JoinColumn(name="id")
    
    public static Order order;
    
    private Customer()
    {
    }
    
    private Customer (Builder builder)
    {
        id=builder.id;
        customerNumber=builder.customerNumber;
        name=builder.name;
        contact=builder.contact;
        
    }
    
    public static class Builder
    {
        private Long id;
        private String customerNumber;
        private Name name;
        private Contact contact;
        private CustomerAddress customerAddress;
        
        public Builder (String value)
        {
            this.customerNumber=value;
        }
        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder customerNumber(String value)
        {
            this.customerNumber=value;
            return this;
        }
        
        public Builder Name (Name value)
        {
            this.name=value;
            return this;
        }
        
        public Builder Contact (Contact value)
        {
            this.contact=value;
            return this;
        }
        
         public Builder CustomerAddress (CustomerAddress value)
        {
            this.customerAddress=value;
            return this;
        }
        
        public Builder Customer (Customer value)
        {
            id=value.getId();
            customerNumber=value.getCustomerNumber();
            name=value.getName();
            contact=value.getContact();
            customerAddress= value.getCustomerAddress();
            demographic=value.getDemographic();
            CreditCard = value.getCreditCard();
            order=value.getOrder();
            return this;
            
            
        }
        
        public Customer build()
        {
            return new Customer(this);
        }
        
        
    }

    public Order getOrder() {
        return order;
    }
    
    
    
    

    public String getCustomerNumber() {
        return customerNumber;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public List<CreditCard> getCreditCard() {
        return CreditCard;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Customer[ id=" + id + " ]";
    }
    
}
