/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.crypto;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author dfelix3
 */
public interface Hashing {
    
    String hash(String value) throws NoSuchAlgorithmException;
}
