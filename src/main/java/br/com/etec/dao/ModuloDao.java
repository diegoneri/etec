/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.Modulo;

/**
 *
 * @author dfelix3
 */
public class ModuloDao extends GenericDao<Modulo, Integer>{
    public ModuloDao(){
        super(Modulo.class);
    }
    @Override
    protected String getSortField() {
        return "";
    }    
}
