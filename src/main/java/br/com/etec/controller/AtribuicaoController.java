/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.view.PrincipalAtribuicaoView;
import java.beans.PropertyVetoException;
import javax.annotation.PostConstruct;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Component
public class AtribuicaoController extends AbstractController{

    @Autowired
    private PrincipalAtribuicaoView view;

    public AtribuicaoController(){

    }
    public AtribuicaoController(MainController parent){
        super(parent);
    }

    @PostConstruct
    private void init(){

    }

    public void show(MainController main) {
        main.addViewToPane(view);
        view.setVisible(true);
        try {
            view.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AtribuicaoController.class.getName()).log(Level.WARN, "Não foi possível maximizar a tela" , ex);
        }
    }

}
