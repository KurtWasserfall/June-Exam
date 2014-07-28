/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import java.util.*;

/**
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Embeddable
public class Name implements Serializable {
    private String firstName;
    private String lastName;

    public Name() {
    }

    
     private Name(Builder builder)
    {
        
        
        firstName = builder.firstName;
        lastName = builder.lastName;
        
    }
     
    public static class Builder
    {
    private String firstName;
    private String lastName;
    
    public  Builder firstName(String value)
    {
        this.firstName = value;
        return this;
    }
    
     public  Builder lastName(String value)
    {
        this.lastName = value;
        return this;
    }
    
      public Builder Name(Name name)
    {
        
        firstName = name.getFirstName();
        lastName = name.getLastName();
        
        return this;
    }    
     
      public Name build()
    {
        return new Name(this);
    }

                
    }
    
    
    
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    
}

   