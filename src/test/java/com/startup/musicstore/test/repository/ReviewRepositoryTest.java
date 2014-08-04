/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.Review;
import com.startup.musicstore.respository.ReviewRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author 211150142
 * Kurt Wasserfall 3B
 */
public class ReviewRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private ReviewRepository reviewRepository;
    
    public ReviewRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(enabled = true)
    public void createReview() {
        
        reviewRepository=ctx.getBean(ReviewRepository.class);
        
        Review review = new Review.Builder()
                .description("This album is good on the soul vibe")
                .rating(3)
                .build();
               
        reviewRepository.save(review);
        
        id=review.getId();
        Assert.assertNotNull(review);
    }
    
    @Test (dependsOnMethods="createReview", enabled=true)
    public void UpdateReview()
    {
     reviewRepository=ctx.getBean(ReviewRepository.class);
     
     Review review = reviewRepository.findOne(id);
     
     Review updatedReview= new Review.Builder()
             .Review(review)
             .description("Jazz to the nazz5")
             .build();
     
     reviewRepository.save(updatedReview);
     Review newReview = reviewRepository.findOne(id);
     Assert.assertEquals(newReview.getDescription(), "Jazz to the nazz5");
    }
    
    @Test (dependsOnMethods="UpdateReview",enabled=true)
    public void readReview()
    {
        reviewRepository=ctx.getBean(ReviewRepository.class);
     
        Review review = reviewRepository.findOne(id);
        
        Assert.assertEquals(review.getDescription(),"Jazz to the nazz5");
                  
    }
    
    @Test (dependsOnMethods = "readReview",enabled=true)
    public void deleteReview()
    {
        reviewRepository=ctx.getBean(ReviewRepository.class);
     
        Review review = reviewRepository.findOne(id);
        
        reviewRepository.delete(review);
        
        Review deletedReview = reviewRepository.findOne(id);
        
        Assert.assertNotNull(reviewRepository);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
