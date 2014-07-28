/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Embeddable
public class Contact implements Serializable {
    public String phoneNumber ;
    public String cellNumber ;

    

    public Contact() {
    }
    private Contact(Builder builder)
    {
        
        
        phoneNumber = builder.phoneNumber;
        cellNumber = builder.cellNumber;
        
    }
     
    public static class Builder
    {
    private String phoneNumber;
    private String cellNumber;
    
    public  Builder phoneNumber(String value)
    {
        this.phoneNumber = value;
        return this;
    }
    
     public  Builder cellNumber(String value)
    {
        this.cellNumber = value;
        return this;
    }
    
      public Builder Contact(Name contact)
    {
        
        phoneNumber = contact.getFirstName();
        cellNumber = contact.getLastName();
        
        return this;
    }
     
     
     
      public Contact build()
    {
        return new Contact(this);
    }

                
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }
    
    
}
