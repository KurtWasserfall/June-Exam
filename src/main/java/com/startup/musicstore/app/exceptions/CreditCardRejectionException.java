/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.exceptions;

/**
 *
 * @author boniface
 */
public class CreditCardRejectionException extends RuntimeException {

    public CreditCardRejectionException(String message) {
        super(message);
    }
    
    
}
