/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.TipoAtribuicao;

/**
 *
 * @author dfelix3
 */
public class TipoAtribuicaoDao extends GenericDao<TipoAtribuicao, Character> {
    public TipoAtribuicaoDao(){
        super(TipoAtribuicao.class);
    }
    @Override
    protected String getSortField() {
        return "";
    }    
}
