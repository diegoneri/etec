/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author dfelix3
 */
public abstract class HashGeneric {
    private MessageDigest messageDigest;
    private BASE64Encoder encoder;
    
    protected void useAlgorithm(String algorithm) throws NoSuchAlgorithmException{
        if (messageDigest == null || !messageDigest.getAlgorithm().equalsIgnoreCase(algorithm)) {
            messageDigest = MessageDigest.getInstance(algorithm);
        }
        if (encoder == null) {
            encoder = new BASE64Encoder();
        }
    }
    
    protected String hashByAlgorithm(String algorithm, String value) throws NoSuchAlgorithmException{
        if (value == null) {
            throw new IllegalArgumentException("Please provide a valid value to hash");
        }
        
        this.useAlgorithm(algorithm);
        byte[] hash = messageDigest.digest(value.getBytes());
        
        return encoder.encode(hash);
    }
}
