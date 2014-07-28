/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.Customer;

/**
 *
  * @author 211150142
 * Kurt Wasserfall 3B
 */
public interface AdressAndCellService extends Services <Customer, Long>
{
    public String findAddress(Long id);
    
    public String findCellNumber(Long id);
            
}
