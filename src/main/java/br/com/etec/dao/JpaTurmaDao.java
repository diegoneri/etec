/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.dao;

import br.com.etec.model.Turma;

/**
 *
 * @author dfelix3
 */

public class JpaTurmaDao extends GenericDao<Turma, Integer> {

    public JpaTurmaDao() {
        super(Turma.class);
    }

    @Override
    protected String getSortField() {
        return "";
    }
}
