/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.TipoContrato;

/**
 *
 * @author dfelix3
 */
public class TipoContratoDao extends GenericDao<TipoContrato, Integer> {
    public TipoContratoDao(){
        super(TipoContrato.class);
    }
    @Override
    protected String getSortField() {
        return "";
    }    
}
