/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.services.AdressAndCellService;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 210218673
 */
@Service
public class AddressAndCellServiceImpl implements  AdressAndCellService
{
    @Autowired
    private CustomerRepository customerRepository;
    Customer customer;

    @Override
    public String findAddress(Long id) 
    {
       customerRepository.findOne(id);
       if(customer.getCustomerAddress()!=null)
       {
           customer.getCustomerAddress();
       }
       else
       {
           return "Could not find customer Address";
       }
       
       return "" + customer.getCustomerAddress();
       
    }

    @Override
    public String findCellNumber(Long id) {
        customerRepository.findOne(id);
        
        if(customer.getCustomerAddress()!=null)
        {
        String number =""+ customer.getCustomerNumber();
        }
        
        else return "Could not fund customer number";
        
        return ""+customer.getCustomerNumber();
        
    }

    @Override
    public Customer find(Long id) 
    {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer persist(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public Customer merge(Customer entity) 
    {
        if(entity.getId()!=null)
        {
            return customerRepository.save(entity);
            
        }
        return null;
        
    }
    
    @Override
    public void remove(Customer entity) 
    {
        customerRepository.delete(entity);
    }

    @Override
    public List <Customer> findAll() {
        return customerRepository.findAll();
        
    }
    
}
