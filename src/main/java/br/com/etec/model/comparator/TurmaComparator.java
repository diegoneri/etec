/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.model.comparator;

import br.com.etec.model.Turma;
import java.util.Comparator;

/**
 *
 * @author dfelix3
 */
public class TurmaComparator implements Comparator<Turma>{

    @Override
    public int compare(Turma o1, Turma o2) {
        int result = 
         o1.getModulo().getGradeCurricular().getHabilitacao().getSigla()
    .compareTo(o2.getModulo().getGradeCurricular().getHabilitacao().getSigla());
        if (result == 0){
            Short sq1 = o1.getModulo().getSequencia();
            Short sq2 = o2.getModulo().getSequencia();
            result = sq1.compareTo(sq2);
        }
        return result;
    }
    
}
