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
import javax.persistence.OneToOne;

/**
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Entity
public class Track implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private int trackNumber;
    private String trackTitle;
    @OneToOne
    @JoinColumn(name="id")
    public static SampleClip sampleClip;
    
    private Track()
    {
    }
    
    private Track(Builder builder)
    {
        id=builder.id;
        trackNumber=builder.trackNumber;
        trackTitle=builder.trackTitle;
    }
    
    public static class Builder{
        private Long id;
        private int trackNumber;
        private String trackTitle;
        
        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder trackNumber (int value)
        {
            this.trackNumber=value;
            return this;
        }
        
        public Builder trackTitle(String value)
        {
            this.trackTitle=value;
            return this;
        }
        
        public Builder Track (Track value)
        {
            id=value.getId();
            trackNumber=value.getTrackNumber();
            trackTitle=value.getTrackTitle();
            sampleClip=value.getSampleClip();
            return this;
        }
        
        public Track build()
        {
            return new Track(this);
        }
                
    }

    public  SampleClip getSampleClip() {
        return sampleClip;
    }

    
    
    public Long getId() {
        return id;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public String getTrackTitle() {
        return trackTitle;
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
        if (!(object instanceof Track)) {
            return false;
        }
        Track other = (Track) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.Track[ id=" + id + " ]";
    }
    
}
