/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.report;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JToggleButton;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

//import net.sf.jasperreports.view.JRViewer;
/**
 *
 * @author dfelix3
 */
public abstract class RelatorioController<T> {

    public static final String DIRETORIO_ANTERIOR = "../";
    private final Locale localBrasil = new Locale("pt", "BR");

    protected void incluirLocalBrasil(Map params) {
        params.put("REPORT_LOCALE", localBrasil);
    }

    protected void validarParametros(final String fileName, String title, Map<String, ?> params) {
        if (fileName == null || fileName.length() < 5) {
            throw new RuntimeException("Arquivo de impressão não informado...");
        }

        if (title == null || title.trim().equals("")) {
            title = "Centro Paula Souza";
        }

        if (params == null) {
            params = criarParametros();
        } else {
            incluirLocalBrasil(params);
        }
    }
    
    protected Map criarParametros() {
        Map params = new HashMap();
        incluirLocalBrasil(params);
        return params;
    }

    protected void criarVisualizacao(JasperPrint jp, String title) {
        JasperViewer jv = new JasperViewer(jp, false, localBrasil);
        jv.setTitle(title);
        selecionarZoomLargura(extrairPanelBotoes(jv));
        maximizarTela(jv);
        jv.setVisible(true);
    }

    private void selecionarZoomLargura(JPanel pnlBotoes) {
        JToggleButton btnZoomLarguraPagina = (JToggleButton) pnlBotoes.getComponent(12);
        btnZoomLarguraPagina.setSelected(true);
        btnZoomLarguraPagina.getActionListeners()[0].actionPerformed(new ActionEvent(btnZoomLarguraPagina, 0, null));
    }

    private JPanel extrairPanelBotoes(JasperViewer jv) {
        final JRViewer jrViewer = (JRViewer) ((JPanel) ((JPanel) ((JLayeredPane) ((JRootPane) jv.getComponent(0)).getComponent(1)).getComponent(0)).getComponent(0)).getComponent(0);
        JPanel pnlBotoes = (JPanel) jrViewer.getComponent(0);
        return pnlBotoes;
    }

    //Maximiza a tela
    private void maximizarTela(JFrame frame) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d.width, d.height);
        frame.setLocation(0, 0);
        frame.setExtendedState(6);
    }

}
