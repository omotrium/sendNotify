/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tayo.test.exception;

/**
 * @Author talabiomotayo on 7/1/20
 */
public class GlobalRestException extends AbstractException {

    public GlobalRestException(String code, String msg) {
        super(code, msg);
    }
}
