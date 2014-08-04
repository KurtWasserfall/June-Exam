/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.Contact;
import com.startup.musicstore.domain.CreditCard;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.domain.Demographic;
import com.startup.musicstore.domain.Name;
import com.startup.musicstore.domain.Order;

import com.startup.musicstore.respository.CreditCardRepository;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import static com.startup.musicstore.test.repository.CreditCardRepositoryTest.ctx;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class CustomerRepositoryTest {
    public static ApplicationContext ctx;
    private CustomerRepository customerRepository;
   
    private Long id;
    public CustomerRepositoryTest() {
       
    }

   
    @Test (enabled = true)
     public void createCustomer() {
         customerRepository =ctx.getBean(CustomerRepository.class);
        
          Name name = new Name.Builder().firstName("Peter").lastName("Lonely").build();
          Contact contact = new Contact.Builder().cellNumber("0721111111").phoneNumber("021-7014239").build();
          CustomerAddress customerAddress = new CustomerAddress.Builder().streetAddress("Hastings").postalAddress("20 Muizenberg").build();
          
          Customer customer = new Customer.Builder("2111").customerNumber("2111").Name(name).Contact(contact).CustomerAddress(customerAddress).build();
       
        
        //Demographic demo = new Demographic.Builder().id(1L).dateOfBirth(new Date()).gender("Male").race("White").build();
        //CreditCard creditcard = new CreditCard.Builder("44444562115").id(1L).expiryDate(new Date()).balance(new BigDecimal(200)).expiryDate(new Date()).nameOnCreditCard("Harry Potter").build();
        //Order order = new Order.Builder().id(1L).orderDate(new Date()).orderNumber(1).build();
        
        customerRepository.save(customer);
        
        id=customer.getId();
        
        assertNotNull(customer);
        
     }
     
     @Test (dependsOnMethods="createCustomer", enabled = true)
     public void UpdateCustomer()
     {
         customerRepository =ctx.getBean(CustomerRepository.class);
         
         Customer customer = customerRepository.findOne(id);
         
         Customer updatedCustomer = new Customer.Builder("2111")
                 .Customer(customer)
                 .customerNumber("2114")
                 .build();
         customerRepository.save(updatedCustomer);
         Customer newCustomer = customerRepository.findOne(id);
         Assert.assertEquals(newCustomer.getCustomerNumber(), "2114");
         
     }
     
     @Test (dependsOnMethods="UpdateCustomer", enabled=true)
     public void Read()
     {
         customerRepository =ctx.getBean(CustomerRepository.class);
         Customer customer = customerRepository.findOne(id);
         Assert.assertEquals(customer.getCustomerNumber(), "2114");
         
     }
     
     @Test(dependsOnMethods="Read", enabled=true)
     public void delete()
     {
         customerRepository =ctx.getBean(CustomerRepository.class);
         Customer customer = customerRepository.findOne(id);
         customerRepository.delete(customer);
         
         Customer deletedCustomer = customerRepository.findOne(id);
         Assert.assertNull(deletedCustomer);
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
