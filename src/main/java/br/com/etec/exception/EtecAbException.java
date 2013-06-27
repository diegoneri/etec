/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exception;

/**
 *
 * @author dfelix3
 */
public class EtecAbException extends Exception{
    public EtecAbException(String message){
        super(message);
    }
    public EtecAbException(String message, Throwable cause){
        super(message, cause);
    }    
}
