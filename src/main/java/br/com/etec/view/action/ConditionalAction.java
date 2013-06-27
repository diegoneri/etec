package br.com.etec.view.action;

/**
 * Uma
 * <code>AbstractAction</code> vinculada a uma condição
 * <code>boolean</code>.
 *
 * <p>
 * <code>ConditionalAction</code> possui uma referência para outra
 * <code>AbstractAction</code>, quem efetivamente implementa a ação. Mas o
 * código dessa ação só será executado quando a condição
 * <code>boolean</code> for satisfatória (
 * <code>true</code>). </p>
 *
 * <p>Para implementar esse componente utilizamos o padrão de projeto
 * <strong>Decorator</strong>.</p>
 *
 * @see br.com.etec.view.action.BooleanExpression
 *
 * @author dfelix3
 */
public final class ConditionalAction extends AbstractAction {

    /**
     * Referência para a ação que deverá executar de acordo com a condição
     * <code>boolean</code>.
     */
    private AbstractAction action;
    /**
     * Referência para condição
     * <code>boolean</code>.
     */
    private BooleanExpression expression;

    private ConditionalAction() {
    }

    /**
     * Avalia a condição
     * <code>boolean</code> para processar ou não a ação.
     *
     * @throws <code>IllegalArgumentException</code> caso não tenha ação e/ou
     * condição <code>boolean</code> vinculada.
     */
    @Override
    protected void action() {
        if (action == null) {
            throw new IllegalArgumentException("Indique a Ação que deve ser executada, utilize o método addAction.");
        }

        if (expression == null) {
            throw new IllegalArgumentException("Indique a expressão condicional da Ação, utilize o método addConditional.");
        }

        if (expression.conditional()) {
            action.actionPerformed();
        }
    }

    /**
     * @return Constrói e retorna uma instância      * de <code>ConditionalAction</code> sem ação e condição definida.
     */
    public static ConditionalAction build() {
        return new ConditionalAction();
    }

    /**
     * Adiciona uma ação a
     * <code>ConditionalAction</code>.
     *
     * @param action ação que deve ser processada.
     * @return <code>ConditionalAction</code> com uma ação definida.
     */
    public ConditionalAction addAction(AbstractAction action) {
        this.action = action;
        return this;
    }

    /**
     * Adiciona a condição que determina se a ação deve ou não ser processada.
     *
     * @param expression condição <code>boolean</code> avaliada      * por <code>ConditionalAction</code>.
     * @return <code>ConditionalAction</code> com a      * condição <code>boolean</code> definida.
     */
    public ConditionalAction addConditional(BooleanExpression expression) {
        this.expression = expression;
        return this;
    }
}
