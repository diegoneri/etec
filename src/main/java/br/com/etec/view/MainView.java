package br.com.etec.view;

import br.com.etec.util.Utils;
import java.awt.event.KeyEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.springframework.stereotype.Component;
/**
 *
 * @author dfelix3
 */
@Component
public class MainView extends JFrame {

    /** Método construtor da classe MainView */
    public MainView() {
        initComponents();
    }

    /** Este método é invocado pelo construtor e seu objetivo é inicializar
     * o form.
     * WARNING: Não modifique este código. O seu conteúdo é automaticamente
     * regerado pelo editor visual do formulário.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JDesktopPane();
        menuBarr = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuAtribuicao = new javax.swing.JMenu();
        menuItemAtribuicaoAulas = new javax.swing.JMenuItem();
        menuDadosCadastrais = new javax.swing.JMenu();
        menuItemProfessor = new javax.swing.JMenuItem();
        menuItemCategoriaFuncional = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("br/com/etec/view/Bundle"); // NOI18N
        setTitle(bundle.getString("MainView.title")); // NOI18N
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(Utils.getDefaultImage());
        setMinimumSize(new java.awt.Dimension(1250, 700));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1250, 700));

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPane.setName("mainPane"); // NOI18N
        getContentPane().add(mainPane, java.awt.BorderLayout.CENTER);

        menuBarr.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuBarr.setName("menuBarr"); // NOI18N

        menuArquivo.setMnemonic(KeyEvent.VK_A);
        menuArquivo.setText(bundle.getString("MainView.menuArquivo.text")); // NOI18N
        menuArquivo.setActionCommand(bundle.getString("MainView.menuArquivo.actionCommand")); // NOI18N
        menuArquivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuArquivo.setName("menuArquivo"); // NOI18N
        menuBarr.add(menuArquivo);

        menuAtribuicao.setMnemonic(KeyEvent.VK_T);
        menuAtribuicao.setText(bundle.getString("MainView.menuAtribuicao.text")); // NOI18N
        menuAtribuicao.setActionCommand(bundle.getString("MainView.menuAtribuicao.actionCommand")); // NOI18N
        menuAtribuicao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuAtribuicao.setName("menuAtribuicao"); // NOI18N

        menuItemAtribuicaoAulas.setText(bundle.getString("MainView.menuItemAtribuicaoAulas.text")); // NOI18N
        menuItemAtribuicaoAulas.setName("menuItemAtribuicaoAulas"); // NOI18N
        menuAtribuicao.add(menuItemAtribuicaoAulas);

        menuBarr.add(menuAtribuicao);

        menuDadosCadastrais.setText(bundle.getString("MainView.menuDadosCadastrais.text")); // NOI18N
        menuDadosCadastrais.setName("menuDadosCadastrais"); // NOI18N

        menuItemProfessor.setText(bundle.getString("MainView.menuItemProfessor.text")); // NOI18N
        menuItemProfessor.setName("menuItemProfessor"); // NOI18N
        menuDadosCadastrais.add(menuItemProfessor);

        menuItemCategoriaFuncional.setText(bundle.getString("MainView.menuItemCategoriaFuncional.text")); // NOI18N
        menuItemCategoriaFuncional.setName("menuItemCategoriaFuncional"); // NOI18N
        menuDadosCadastrais.add(menuItemCategoriaFuncional);

        menuBarr.add(menuDadosCadastrais);

        setJMenuBar(menuBarr);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane mainPane;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuAtribuicao;
    private javax.swing.JMenuBar menuBarr;
    private javax.swing.JMenu menuDadosCadastrais;
    private javax.swing.JMenuItem menuItemAtribuicaoAulas;
    private javax.swing.JMenuItem menuItemCategoriaFuncional;
    private javax.swing.JMenuItem menuItemProfessor;
    // End of variables declaration//GEN-END:variables

    public JDesktopPane getMainPane() {
        return mainPane;
    }

    public JMenu getMenuArquivo() {
        return menuArquivo;
    }

    public JMenu getMenuAtribuicao() {
        return menuAtribuicao;
    }

    public JMenuBar getMenuBarr() {
        return menuBarr;
    }

    public JMenu getMenuDadosCadastrais() {
        return menuDadosCadastrais;
    }

    public JMenuItem getMenuItemAtribuicaoAulas() {
        return menuItemAtribuicaoAulas;
    }

    public JMenuItem getMenuItemCategoriaFuncional() {
        return menuItemCategoriaFuncional;
    }

    public JMenuItem getMenuItemProfessor() {
        return menuItemProfessor;
    }

    public static void main(String args[]){
        new MainView().setVisible(true);
    }


}
