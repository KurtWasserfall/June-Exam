/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.services.AdressAndCellService;
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
 *
  * @author 211150142
 * Kurt Wasserfall 3B
 */
public class AddressAndCellNumberServiceTest {
    
    public static ApplicationContext ctx;
    public Long id;
    private AdressAndCellService addressAndCellService; 
    
    public AddressAndCellNumberServiceTest() {
    }

   
    /*@Test (enabled=true)
    public void AddressTest()
    {
        addressAndCellService=ctx.getBean(AdressAndCellService.class);
        
        Customer customer = new Customer.Builder("1").customerNumber("2123").build();
        CustomerAddress customerAddress = new CustomerAddress.Builder().id(1L).postalAddress("23 Dursley way").streetAddress("None").build();
        
        id = customer.getId();
        addressAndCellService.persist(customer);
        
        String result = addressAndCellService.findAddress(id);
        Assert.assertEquals(result, "23 Dursley Way");
        
        
    }*/

    @BeforeClass
    public static void setUpClass() throws Exception 
    {
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
