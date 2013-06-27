/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.GradeCurricular;

/**
 *
 * @author dfelix3
 */
public class GradeCurricularDao extends GenericDao<GradeCurricular, Integer> {
    public GradeCurricularDao(){
        super(GradeCurricular.class);
    }
    
    @Override
    protected String getSortField() {
        return "";
    }
}
