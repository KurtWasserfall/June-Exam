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
 *
 * @author 211150142
 * Kurt Wasserfall 3B
 */

@Embeddable
public class CustomerAddress implements Serializable {
    
 
    private String streetAddress;
    private String postalAddress;
    
    private CustomerAddress()
    {
    }
    
    private CustomerAddress(Builder builder)
    {
       
        streetAddress=builder.streetAddress;
        postalAddress=builder.postalAddress;
    }
    
    public static class Builder{
   
        private String streetAddress;
        private String postalAddress;
        
       
        public Builder streetAddress(String value)
        {
            this.streetAddress=value;
            return this;
        }
        
        public Builder postalAddress(String value)
        {
            this.postalAddress=value;
            return this;
        }
        
        public Builder CustomerAddress (CustomerAddress value)
        {
           
            streetAddress=value.getStreetAddress();
            postalAddress=value.getPostalAddress();
            return this;
        }
        
        public CustomerAddress build()
        {
            return new CustomerAddress(this);
        }
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }
    
            

   
}
