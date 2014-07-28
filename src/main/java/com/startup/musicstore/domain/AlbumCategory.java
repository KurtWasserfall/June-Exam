/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Embeddable
@Entity
public class AlbumCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String categoryName;
    @OneToMany 
    @JoinColumn (name="id")
    public static List <Album> album;
    
    private AlbumCategory()
    {
    }
    
    private AlbumCategory(Builder builder)
    {
        id=builder.id;
        categoryName=builder.categoryName;
    }
    
    public static class Builder {
        private Long id;
        private String categoryName;
        
        public Builder id(Long value)
        {
            this.id=value;
            return this;
        }
        
        public Builder categoryName(String value)
        {
            this.categoryName=value;
            return this;
            
        }
        
        public Builder AlbumCategory (AlbumCategory value)
        {
            id=value.getId();
            categoryName=value.getCategoryName();
            album=value.getAlbum();
            return this;
        }
        
        public AlbumCategory build()
        {
            return new AlbumCategory(this);
        }
    }

    public List<Album> getAlbum() {
        return album;
    }

    
    
    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
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
        if (!(object instanceof AlbumCategory)) {
            return false;
        }
        AlbumCategory other = (AlbumCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.startup.musicstore.domain.AlbumCategory[ id=" + id + " ]";
    }
    
}
