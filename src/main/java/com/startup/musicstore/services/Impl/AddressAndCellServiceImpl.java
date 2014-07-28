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
 * @author 211150142
 * Kurt Wasserfall 3B
 */
@Service
public class AddressAndCellServiceImpl implements  AdressAndCellService
{
    @Autowired
    private CustomerRepository addressRepository;
    Customer customer;

    @Override
    public String findAddress(Long id) 
    {
       addressRepository.findOne(id);
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
        addressRepository.findOne(id);
        
        if(customer.getCustomerAddress()!=null)
        {
        String cell =""+ customer.getContact().getCellNumber();
        }
        
        else return "Could not fund customer number";
        
        return ""+customer.getCustomerNumber();
        
    }

    @Override
    public Customer find(Long id) 
    {
        return addressRepository.findOne(id);
    }

    @Override
    public Customer persist(Customer entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Customer merge(Customer entity) 
    {
        if(entity.getId()!=null)
        {
            return addressRepository.save(entity);
            
        }
        return null;
        
    }
    
    @Override
    public void remove(Customer entity) 
    {
        addressRepository.delete(entity);
    }

    @Override
    public List <Customer> findAll() {
        return addressRepository.findAll();
        
    }
    
}
