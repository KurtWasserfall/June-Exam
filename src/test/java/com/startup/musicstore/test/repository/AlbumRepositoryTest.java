/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.respository.AlbumRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import static com.startup.musicstore.test.repository.CreditCardRepositoryTest.ctx;
import java.math.BigDecimal;
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
 *
  * @author 211150142
 * Kurt Wasserfall 3B
 */
public class AlbumRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private AlbumRepository albumRepository;
    
    public AlbumRepositoryTest() {
    }

    
    @Test
    public void createAlbum() {
        
        albumRepository=ctx.getBean(AlbumRepository.class);
        
        Album album = new Album.Builder()
                .albumTitle("Favourite Worst Nightmare")
                .inventory(3)
                .unitPrice( new BigDecimal(200.00))
                .sales(2)
                .build();
        albumRepository.save(album);
        
        id=album.getId();
        Assert.assertNotNull(album);
    }
    
    @Test (dependsOnMethods="createAlbum", enabled=true)
    public void UpdateAlbum()
    {
     albumRepository=ctx.getBean(AlbumRepository.class);
     
     Album album = albumRepository.findOne(id);
     
     Album updatedAlbum= new Album.Builder()
             .Album(album)
             .albumTitle("Brainstorm")
             .build();
     
     albumRepository.save(updatedAlbum);
     Album newAlbum = albumRepository.findOne(id);
     Assert.assertEquals(newAlbum.getAlbumTitle(), "Brainstorm");
    }
    
    @Test (dependsOnMethods="UpdateAlbum",enabled=true)
    public void readAlbum()
    {
        albumRepository=ctx.getBean(AlbumRepository.class);
     
        Album album = albumRepository.findOne(id);
        
        Assert.assertEquals(album.getAlbumTitle(),"Brainstorm");
                  
    }
    
    @Test (dependsOnMethods = "readAlbum",enabled=true)
    public void deleteAlbum()
    {
        albumRepository=ctx.getBean(AlbumRepository.class);
     
        Album album = albumRepository.findOne(id);
        
        albumRepository.delete(album);
        
        Album deletedAlbum=albumRepository.findOne(id);
        
        Assert.assertNull(deletedAlbum);
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
