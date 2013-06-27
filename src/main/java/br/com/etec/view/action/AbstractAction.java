package br.com.etec.view.action;

/**
 * Componente representa uma ação, normalmente vinculada a intervenção do
 * usuário nos componentes de interface gráfica, para solicitar uma operação ao
 * sistema.
 *
 * <p> A ação é representada por
 * <code>AbstractAction</code>, um tipo de componente complementar ao
 * <code>MVC</code> (<strong>M</strong>odel <strong>V</strong>iew
 * <strong>C</strong>ontroller), um modelo arquitetural utilizado para organizar
 * os componentes do sistema. </p>
 *
 * <p> Utiliza o design pattern
 * <code>Template Method</code> para definir um estrutura/template com código
 * complementar (e opcional) a ação: </p>
 *
 * <ul> <li><code>preAction()</code>: Acionando antes da execução de
 * <code>action()</code>.</li> <li><code>posAction()</code>: Acionando após a
 * execução (com sucesso) de
 * <code>action()</code>.</li> <li><code>actionFailure()</code>: Acionando caso
 * a execução de
 * <code>action()</code> falhe.</li> </ul>
 *
 * @author dfelix3
 */
public abstract class AbstractAction {

    /**
     * Método principal, define o processamento da
     * <code>AbstractAction</code>.
     */
    protected abstract void action();

    /**
     * Método acionado <strong>antes</string> de
     * <code>action()</code>. <p>Caso uma exceção (
     * <code>RuntimeException</code>) seja lançada, a execução de toda a
     * <code>AbstractAction</code> é interrompida.</p>
     */
    protected void preAction() {
    }

    /**
     * Método executado após a conclusão de
     * <code>action()</code>.
     */
    protected void posAction() {
    }

    /**
     * Método é acionado quando alguma falha ocorre durante a execução de
     * <code>action</code>,
     * <code>preAction</code> ou
     * <code>posAction</code>.
     */
    protected void actionFailure() {
    }

    /**
     * Método responsável por organizar e executar a cadeia de métodos de
     * <code>AbstractAction</code>.
     *
     * @throws <code>RuntimeException</code> caso algum erro ocorra.
     */
    public final void actionPerformed() {
        try {
            preAction();
            action();
            posAction();
        } catch (Exception ex) {
            actionFailure();
            throw new RuntimeException(ex);
        }
    }
}
