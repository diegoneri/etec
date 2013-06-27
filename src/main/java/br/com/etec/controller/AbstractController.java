/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.view.action.AbstractAction;
import br.com.etec.view.event.AbstractEvent;
import br.com.etec.view.listener.AbstractEventListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 * Classe abstrata que define uma estrutura para componentes da camada
 * controller do padrão arquitetural MVC.
 *
 * <p><code>Controller</code> é o componente intermediário entre a apresentação
 * (View) e os componentes de negócio (Serviços + DAO + Model).</p>
 *
 * <p>Habilita:</p> <ul> <li>Definição de
 * <code>eventos</code> e
 * <code>ações</code> para os componentes gráficos.</li> <li>Apresentar
 * mensagens de erros gerados em
 * <code>ações</code>dos componentes gráficos.</li> <li>Liberar recursos do
 * componente no encerramento da janela.</li> </ul>
 *
 * @author dfelix3
 */
public abstract class AbstractController implements ActionListener, WindowListener, KeyListener {

    private static Logger log = Logger.getLogger(AbstractController.class.getName());
    private AbstractController parent;
    private Map<String, AbstractAction> actions = new HashMap<>();
    private Map<Class<?>, List<AbstractEventListener<?>>> eventListeners =
            new HashMap<>();

    public AbstractController() {
    }

    /**
     * Controller possui um auto-relacionamento, útil em situações aonde uma
     * hierarquia de controladores deve ser respeitada.
     *
     * @param parent controller <i>pai</i>
     */
    public AbstractController(AbstractController parent) {
        if (parent != null) {
            this.parent = parent;
        }
    }

    /**
     * Registra uma
     * <code>ação</code> a um componente
     * <code>button</code>.
     *
     * @param source
     * @param action
     */
    protected void registerAction(AbstractButton source, AbstractAction action) {
        if (source.getActionCommand() == null) {
            throw new RuntimeException("Componente (Button) sem ação definida!");
        }
        log.debug("Registrando action: " + action.getClass().getName() + " para o botão: " + source.getText());
        source.addActionListener(this);
        this.actions.put(source.getActionCommand(), action);
    }

    /**
     * Registra uma
     * <code>ação</code> a um componente
     * <code>button</code>.
     *
     * @param source
     * @param action
     */
    protected void registerKeyAction(Component source, AbstractAction action) {
        if (source.getName() == null) {
            throw new RuntimeException("Component sem nome definido para ação de tecla!");
        }
        log.debug("Registrando key action: " + action.getClass().getName() + " para o component: " + source.getName());
        source.addKeyListener(this);
        this.actions.put(source.getName(), action);
    }

    /**
     * Aciona o
     * <code>AbstractEventListener</code> relacionado ao
     * <code>AbstractEvent</code> para que o
     * <code>listener</code> trate o evento.
     *
     * @param event referência do evento gerado
     */
    @SuppressWarnings("unchecked")
    protected void fireEvent(AbstractEvent<?> event) {
        if (eventListeners.get(event.getClass()) != null) {
            for (AbstractEventListener eventListener : eventListeners.get(event.getClass())) {
                log.debug("Evento: " + event.getClass().getName() + " com listener: " + eventListener.getClass().getName());
                eventListener.handleEvent(event);
            }
        }
        if (parent != null) {
            parent.fireEvent(event);
        }
    }

    /**
     * Registra um
     * <code>listener</code> que deve ser acionado de acordo com o tipo do
     * <code>evento</code>.
     *
     * @param eventClass tipo do evento
     * @param eventListener tratador (<code>listener</code>) do evento
     */
    protected void registerEventListener(Class<?> eventClass, AbstractEventListener<?> eventListener) {
        log.debug("Registrando listener: " + eventListener + " para o evento: " + eventClass.getName());
        java.util.List<AbstractEventListener<?>> listenersForEvent = eventListeners.get(eventClass);
        if (listenersForEvent == null) {
            listenersForEvent = new ArrayList<>();
        }
        listenersForEvent.add(eventListener);
        eventListeners.put(eventClass, listenersForEvent);
    }

    protected AbstractAction getAction(ActionEvent actionEvent) {
        AbstractButton button = (AbstractButton) actionEvent.getSource();
        return getAbstractAction(button);
    }

    protected AbstractAction getAction(KeyEvent keyEvent) {
        if (keyEvent.getSource() instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) keyEvent.getSource();
            return getAbstractAction(button);
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        AbstractAction action = getAction(actionEvent);
        executeAction(action, actionEvent);
    }

    /**
     * Caso ocorra alguma falha durante a
     * <code>ação</code> apresenta uma mensagem.
     *
     * @param ex
     */
    protected void handlerException(Exception ex) {
        log.error("Ocorreu um erro!", ex);
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public AbstractController getParentController() {
        return parent;
    }

    /**
     * Método utilizado para liberar recursos carregados pela
     * <code>Controller</code>.
     */
    protected void cleanUp() {
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        cleanUp();
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                evaluateAction(keyEvent.getSource().getClass());
                break;
            case KeyEvent.VK_ESCAPE:
                evaluateEscape(keyEvent.getSource().getClass());
                break;
        }
        AbstractAction action = getAction(keyEvent);
        executeAction(action, keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void executeAction(AbstractAction action, ActionEvent actionEvent) {
        try {
            if (action != null) {
                log.debug("Executando action: " + action.getClass());
                try {
                    action.actionPerformed();
                } catch (Exception ex) {
                    handlerException(ex);
                }
            }
        } catch (ClassCastException e) {
            handlerException(new IllegalArgumentException("Action source não é um Abstractbutton: " + actionEvent));
        }
    }

    private void executeAction(AbstractAction action, KeyEvent keyEvent) {
        try {
            if (action != null && keyEvent.isActionKey()) {
                log.debug("Executando action: " + action.getClass());
                try {
                    action.actionPerformed();
                } catch (Exception ex) {
                    handlerException(ex);
                }
            }
        } catch (ClassCastException e) {
            handlerException(new IllegalArgumentException("Action source não é um Abstractbutton: " + keyEvent));
        }
    }

    private AbstractAction getAbstractAction(AbstractButton button) {
        String actionCommand = button.getActionCommand();
        return actions.get(actionCommand);
    }
}
