/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.report;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

//import net.sf.jasperreports.view.JRViewer;
/**
 *
 * @author dfelix3
 */
public abstract class RelatorioBeanController<T> extends RelatorioController<T>{

    public abstract void imprimir(final List<T> dataSource);

    public abstract void imprimir(final List<T> dataSource, Map<String, ?> params);

    private void validarParametros(final String fileName, String title, final List<T> dataSource, Map<String, ?> params) {
        super.validarParametros(fileName, title, params);

        if (dataSource == null || dataSource.size() <= 0) {
            throw new RuntimeException("Impressão sem resultados...");
        }
    }
    
    protected void imprimir(final String fileName, String title, final List<T> dataSource, Map<String, ?> params) {
        try {
            validarParametros(fileName, title, dataSource, params);

            JRBeanCollectionDataSource jrDS = new JRBeanCollectionDataSource(dataSource);
            JasperPrint relatorio = criarRelatorio( fileName, params, jrDS);
            criarVisualizacao(relatorio, title);

        } catch (RuntimeException ex) {
            Logger.getLogger(RelatorioBeanController.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (JRException ex) {
            Logger.getLogger(RelatorioBeanController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao gerar o relatório " + title, ex);
        } catch (Exception e) {
            Logger.getLogger(RelatorioBeanController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException("Erro genérico " + e.getMessage(), e);
        }

    }

    private JasperPrint criarRelatorio(final String fileName, Map<String, ?> params, JRBeanCollectionDataSource jrDS) throws JRException {
        JasperPrint relatorio = JasperFillManager.fillReport(this.getClass().getResourceAsStream(DIRETORIO_ANTERIOR + fileName), ((Map<String, Object>) params), jrDS);
        return relatorio;
    }
}

