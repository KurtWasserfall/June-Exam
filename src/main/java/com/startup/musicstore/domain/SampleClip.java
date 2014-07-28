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
public class SampleClip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String sampleUrl;
    @OneToOne
    @JoinColumn(name="id")
    public static Track track;
    
    private SampleClip ()
    {}
    
    private SampleClip (Builder builder)
    {
        id=builder.id;
        sampleUrl=builder.sampleUrl;
    }
    
    public static class Builder
    {
        private Long id;
        private String sampleUrl;
        
        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder sampleUrl (String value)
        {
            this.sampleUrl=value;
            return this;
        }
        
        public Builder SampleClip (SampleClip value)
        {
            id=value.getId();
            sampleUrl=value.getSampleUrl();
            track=value.getTrack();
            return this;
        }
        
        public SampleClip build()
        {
            return new SampleClip(this);
        }
    }

    public Track getTrack() {
        return track;
    }
    
    

    public Long getId() {
        return id;
    }

    public String getSampleUrl() {
        return sampleUrl;
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
        if (!(object instanceof SampleClip)) {
            return false;
        }
        SampleClip other = (SampleClip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.SampleClip[ id=" + id + " ]";
    }
    
}
