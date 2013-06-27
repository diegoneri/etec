/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.util.view;

import br.com.etec.dao.ProfessorDao;
import br.com.etec.model.Professor;

/**
 *
 * @author dfelix3
 */
public class ProfessorCellEditor extends ListValueCellEditor<Professor> {
  
    public ProfessorCellEditor(){
        super(new ProfessorDao().listAll());
    }
}
