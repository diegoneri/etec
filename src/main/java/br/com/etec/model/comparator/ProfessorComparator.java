/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.model.comparator;

import br.com.etec.model.Professor;
import java.util.Comparator;

/**
 *
 * @author dfelix3
 */
public class ProfessorComparator implements Comparator<Professor> {

    @Override
    public int compare(Professor o1, Professor o2) {
        return o1.getNome().compareToIgnoreCase(o2.getNome().toLowerCase());
    }
    
}
