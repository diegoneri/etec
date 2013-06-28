/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.model.Login;
import br.com.etec.service.LoginService;
import br.com.etec.view.LoginView;
import br.com.etec.view.action.AbstractAction;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Define a
 * <code>Controller</code> principal do sistema, responsável por gerir a tela de
 * <code>Login</code>.
 *
 * <p>
 * <code>LoginController</code> é mapeada como
 * <code>@Component</code> do Spring. Dessa forma uma instância * *  * de <code>LoginController</code> pode ser criada e gerenciada pelo Spring,
 * favorecendo a Inversão de Controle <i>(IoC)</i> e Injeção de Dependência
 * <i>(DI)</i>. </p>
 *
 * <p> Essa <code>Controller</code> depende de outros componentes da * *  * camada <code>Repository</code> (Persistência) e <code>View</code> (telas).
 * As dependências são resolvidas pelo Spring, através da <strong>Injeção de
 * Dependência</strong> c/ a anotação <code>@Autowired</code>. </p>
 *
 * @see br.com.etec.service.LoginService
 *
 * @author dfelix3
 */
@Component
public class LoginController extends AbstractController {
    @Autowired
    private LoginView loginView;
    @Autowired
    private LoginService loginService;
    @Autowired
    private MainController mainController;

    /**
     * Método executado pelo
     * <code>Spring</code>, depois de criar a instância de
     * <code>LoginController</code>.
     *
     * <p>Faz o registro das ações e tratadores de eventos.</p>
     */
    @PostConstruct
    public void init() {
        this.loginView.addWindowListener(this);
        this.loginView.addKeyListener(this);
        this.initHandlers();
        this.loginView.setVisible(true);
    }

    @Override
    public void ativarJanela(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void desativarJanela(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void initHandlers() {
        registerAction(loginView.getBtnOk(), new AbstractAction() {
            @Override
            protected void action() {
                efetuarLogin(loginView.getLogin());
            }
        });
        registerAction(loginView.getBtnCancelar(), new AbstractAction() {
            @Override
            protected void action() {
                System.exit(0);
                Logger.getLogger(LoginController.class.getName()).log(Level.INFO, "ENCERRANDO O SISTEMA");
            }
        });
        loginView.getRootPane().setDefaultButton(loginView.getBtnOk());

    }

    private void efetuarLogin(Login login) throws HeadlessException {
        try {
            if (autenticarUsuario(login)) {
                JOptionPane.showMessageDialog(loginView, "Login efetuado com sucesso!");
                Logger.getLogger(LoginController.class.getName()).log(Level.INFO, "Acesso do usu\u00e1rio: " + loginView.getLogin().getUsuario());
                mainController.show(this);
            } else {
                JOptionPane.showMessageDialog(loginView, "Erro ao acessar o sistema!");
                Logger.getLogger(LoginController.class.getName()).log(Level.INFO, "Erro do usu\u00e1rio: " + loginView.getLogin().getUsuario());
            }
        } catch (Throwable e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.INFO, "Erro ao efetuar o login", e);
        }
    }

    private boolean autenticarUsuario(Login login) {
        return loginService.authenticateUser(login);
    }
    @Override
    protected void cleanUp() {
        loginView.dispose();

        super.cleanUp();
    }
}
