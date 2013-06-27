/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.Professor;

/**
 *
 * @author dfelix3
 */
public class ProfessorDao extends GenericDao<Professor, Integer>{
    public ProfessorDao(){
        super(Professor.class);
    }

    @Override
    protected String getSortField() {
        return "nome";
    }    
}
