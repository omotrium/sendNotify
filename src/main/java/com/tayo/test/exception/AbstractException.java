/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tayo.test.exception;


/**
 * @Author talabiomotayo on 7/1/20
 */
public class AbstractException extends RuntimeException {

    String code;

    public AbstractException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
