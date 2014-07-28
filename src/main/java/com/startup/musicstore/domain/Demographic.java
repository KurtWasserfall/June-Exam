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
import javax.persistence.Temporal;

/**
 *
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Embeddable
public class Demographic implements Serializable {
    
    private String gender;
    private String race;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;
    
    private Demographic()
    {
    }
    
    private Demographic (Builder builder)
    {
       
        gender=builder.gender;
        race=builder.race;
        dateOfBirth=builder.dateOfBirth;
    }
    
    public static class Builder{
        
       
        private String gender;
        private String race;
        private Date dateOfBirth;
        
     
        public Builder gender(String value)
        {
            this.gender=value;
            return this;
        }
        
        public Builder race (String value)
        {
            this.race=value;
            return this;
        }
        
        public Builder dateOfBirth(Date value)
        {
            this.dateOfBirth=value;
            return this;
        }
        
        public Builder Demographic (Demographic value)
        {
            
            gender=value.getGender();
            race=value.getRace();
            dateOfBirth=value.getDateOfBirth();
            return this;
        }
        
        public Demographic build()
        {
            return new Demographic (this);
        }
        
        
    }

    String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    

}
