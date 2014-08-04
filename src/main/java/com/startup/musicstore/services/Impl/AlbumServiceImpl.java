/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.respository.AlbumRepository;
import com.startup.musicstore.services.AlbumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class AlbumServiceImpl implements AlbumService {
    
    @Autowired
    private AlbumRepository albumRepository;
    
    @Override
    public Album find(Long id) {
        return albumRepository.findOne(id);
    }
    
    @Override
    public Album persist(Album entity) {
        return albumRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    @Override
    public Album merge(Album entity) {
        if (entity.getId() != null) {
            return albumRepository.save(entity);
        }
        return null; //To change body of generated methods, choose Tools | Templates.    }
    }
    
    @Override
    public void remove(Album entity) {
        albumRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }
    
}
