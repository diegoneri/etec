/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.mock;

import br.com.etec.model.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dfelix3
 */
public class ProfessorMock {
    
    public static List<Professor> getListProfessor(){
        List<Professor> newList = new ArrayList<>();
        for(int i = 0; i <10; i++){
            newList.add(new Professor());
        }
        return newList;
    }
}
