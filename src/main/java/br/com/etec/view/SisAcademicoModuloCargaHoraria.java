/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.view;

import br.com.etec.dao.JpaTurmaDao;
import br.com.etec.model.Turma;

/**
 *
 * @author dfelix3
 */
public class SisAcademicoModuloCargaHoraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        for(GradeCurricular grade: new GradeCurricularDao().listAll()){
//            System.out.println(grade.toString());
//        }
//        for(Modulo modulo: new ModuloDao().listAll()){
//            System.out.println(modulo.toString());
//        }     
        for(Turma turma: new JpaTurmaDao().listAll()){
            System.out.println(turma.getNomeTurma());
        }             
    }
}
