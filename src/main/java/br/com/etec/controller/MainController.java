/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.view.MainView;
import br.com.etec.view.action.AbstractAction;
import javax.annotation.PostConstruct;
import javax.swing.JInternalFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Component
public class MainController extends AbstractController {

    @Autowired
    private MainView view;
    @Autowired
    private AtribuicaoController atribuicaoController;

    public MainController() {
    }

    @PostConstruct
    private void init() {
        view.addWindowListener(this);
        view.addKeyListener(this);
        registerAction(view.getMenuItemAtribuicaoAulas(), new AbstractAction() {
            @Override
            public void action() {
                initAtribuicaoAulas();
            }
        });
    }

    private void initAtribuicaoAulas() {
        atribuicaoController.show(this);
    }

    public void addViewToPane(JInternalFrame frame) {
        this.view.getMainPane().add(frame);
    }

    public void show(AbstractController previousController) {
        view.setVisible(true);
        view.setResizable(false);
        previousController.cleanUp();
    }
}
