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
public enum Hash {
    MD5("MD5"), SHA256("SHA-256"), SHA512("SHA-512");
    private String algorithm;
    private HashValue hashing;

    private Hash(String algorithm) {
        this.algorithm = algorithm;
        this.hashing = new HashValue();
    }

    public String encode(String value) throws NoSuchAlgorithmException {
        return hashing.hash(value);
    }

    private class HashValue extends HashGeneric implements Hashing {

        @Override
        public String hash(String value) throws NoSuchAlgorithmException {
            return hashByAlgorithm(algorithm, value);
        }
    }
}
