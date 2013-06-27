/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.CategoriaProfessor;

/**
 *
 * @author dfelix3
 */
public class CategoriaProfessorDao extends GenericDao<CategoriaProfessor, String>{
    public CategoriaProfessorDao(){
        super(CategoriaProfessor.class);
    }
    @Override
    protected String getSortField() {
        return "";
    }    
}
