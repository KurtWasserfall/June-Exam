/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Review;
import com.startup.musicstore.respository.ReviewRepository;
import com.startup.musicstore.services.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    
    @Override
    public Review find(Long id) {
       return reviewRepository.findOne(id);
               
    }

    @Override
    public Review persist(Review entity) {
        return reviewRepository.save(entity);
    }

    @Override
    public Review merge(Review entity) {
        if(entity.getId() != null)
        {
            return reviewRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Review entity) {
       reviewRepository.delete(entity);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
    
}
