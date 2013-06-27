/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.report;

import br.com.etec.util.dao.EteAb01EntityManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

//import net.sf.jasperreports.view.JRViewer;
/**
 *
 * @author dfelix3
 */
public abstract class RelatorioDatabaseController<T> extends RelatorioController<T>{
   
    public abstract void imprimir(Map<String, ?> params);

    private void validarParametros(final String fileName, String title, Map<String, ?> params, Connection connection) {
        super.validarParametros(fileName, title, params);

        try {
            if (connection == null || connection.isClosed()){
                throw new RuntimeException("Não há uma conexão válida estabelecida...");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não há uma conexão válida estabelecida...", ex);
        }
    }

    protected void imprimir(final String fileName, String title, Connection connection, Map<String, ?> params) {
        try {
            validarParametros(fileName, title, params, connection);
            JasperPrint relatorio = criarRelatorio( fileName, params, connection);
            criarVisualizacao(relatorio, title);

        } catch (RuntimeException ex) {
            Logger.getLogger(RelatorioDatabaseController.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (JRException ex) {
            Logger.getLogger(RelatorioDatabaseController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao gerar o relatório " + title, ex);
        } catch (Exception e) {
            Logger.getLogger(RelatorioDatabaseController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException("Erro genérico " + e.getMessage(), e);
        }

    }    
      
    private JasperPrint criarRelatorio(final String fileName, Map<String, ?> params, Connection connection) throws JRException {
        JasperPrint relatorio = JasperFillManager.fillReport(this.getClass().getResourceAsStream(DIRETORIO_ANTERIOR + fileName), ((Map<String, Object>) params), connection);
        return relatorio;
    }    
}
