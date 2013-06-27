/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.view;

import br.com.etec.dao.AtribuicaoDao;
import br.com.etec.dao.DisciplinaDao;
import br.com.etec.dao.PeriodoLetivoDao;
import br.com.etec.exception.EtecAbException;
import br.com.etec.model.Atribuicao;
import br.com.etec.model.Disciplina;
import br.com.etec.model.PeriodoLetivo;
import br.com.etec.model.Turma;
import br.com.etec.util.Operacao;
import br.com.etec.util.TipoAtribuicaoBuilder;
import br.com.etec.util.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jdesktop.observablecollections.ObservableCollections;
import org.springframework.stereotype.Component;

/**
 *
 * @author dfelix3
 */
@Component
public class PrincipalAtribuicaoView extends JInternalFrame {

    /**
     * Método construtor da classe PrincipalAtribuicaoView
     */
    private DisciplinaDao disDao = new DisciplinaDao();
    private AtribuicaoDao atrDao = new AtribuicaoDao();
    private Operacao operacao = Operacao.NENHUM;

    public PrincipalAtribuicaoView(){
        this(new PeriodoLetivoDao().listAllActive());
    }
    public PrincipalAtribuicaoView(List<PeriodoLetivo> periodosLetivos) {
        initPeriodosLetivos(periodosLetivos);
        initComponents();
    }

    /**
     * Este método é invocado pelo construtor e seu objetivo é inicializar o
     * form. WARNING: Não modifique este código. O seu conteúdo é
     * automaticamente regerado pelo editor visual do formulário.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listPeriodoLetivo = listPeriodoLetivo;
        periodoLetivo = new br.com.etec.model.PeriodoLetivo();
        turma = new br.com.etec.model.Turma();
        listAtribuicao = ObservableCollections.observableList(new ArrayList<Atribuicao>());
        paneltitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSelecionePeriodo = new javax.swing.JLabel();
        cboPeriodoLetivo = new javax.swing.JComboBox();
        lblSelecionePeriodo1 = new javax.swing.JLabel();
        cboTurma = new javax.swing.JComboBox();
        btnIniciarAtribuicao = new javax.swing.JButton();
        panelDados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAtribuicao = new javax.swing.JTable();
        btnIniciarAtribuicao1 = new javax.swing.JButton();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cboPeriodoLetivo, org.jdesktop.beansbinding.ELProperty.create("${selectedItem}"), turma, org.jdesktop.beansbinding.BeanProperty.create("periodoLetivo"));
        bindingGroup.addBinding(binding);

        setFrameIcon(Utils.getDefaultImageIcon());
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cboPeriodoLetivo, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.toString}"), this, org.jdesktop.beansbinding.BeanProperty.create("title"), "titleBinding");
        bindingGroup.addBinding(binding);

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        paneltitulo.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Atribuição de Aulas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        paneltitulo.add(lblTitulo, gridBagConstraints);

        lblSelecionePeriodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSelecionePeriodo.setText("Selecione o período letivo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        paneltitulo.add(lblSelecionePeriodo, gridBagConstraints);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listPeriodoLetivo, cboPeriodoLetivo);
        bindingGroup.addBinding(jComboBoxBinding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 390;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        paneltitulo.add(cboPeriodoLetivo, gridBagConstraints);

        lblSelecionePeriodo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSelecionePeriodo1.setText("Selecione a turma:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        paneltitulo.add(lblSelecionePeriodo1, gridBagConstraints);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedItem.turmaList}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cboPeriodoLetivo, eLProperty, cboTurma);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, turma, org.jdesktop.beansbinding.ObjectProperty.create(), cboTurma, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 390;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 0, 0);
        paneltitulo.add(cboTurma, gridBagConstraints);

        btnIniciarAtribuicao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIniciarAtribuicao.setText("Iniciar Atribuição!");
        btnIniciarAtribuicao.setActionCommand("iniciarAtribuicao");
        btnIniciarAtribuicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarAtribuicaoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 20, 0);
        paneltitulo.add(btnIniciarAtribuicao, gridBagConstraints);

        getContentPane().add(paneltitulo);

        panelDados.setLayout(new java.awt.GridBagLayout());

        tableAtribuicao.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tableAtribuicao.setColumnSelectionAllowed(true);
        tableAtribuicao.setIntercellSpacing(new java.awt.Dimension(2, 4));
        tableAtribuicao.setMaximumSize(new java.awt.Dimension(815, 0));
        tableAtribuicao.setMinimumSize(new java.awt.Dimension(815, 0));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listAtribuicao, tableAtribuicao);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${disciplina}"));
        columnBinding.setColumnName("Componente");
        columnBinding.setColumnClass(br.com.etec.model.Disciplina.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cargaHorariaAtribuida}"));
        columnBinding.setColumnName("C.H.");
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoAtribuicao}"));
        columnBinding.setColumnName("Atribuição");
        columnBinding.setColumnClass(br.com.etec.model.TipoAtribuicao.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${professor}"));
        columnBinding.setColumnName("Professor");
        columnBinding.setColumnClass(br.com.etec.model.Professor.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hasSubstituicao}"));
        columnBinding.setColumnName("Substitução?");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${atribuicaoSubstituicao.professor}"));
        columnBinding.setColumnName("Substituto");
        columnBinding.setColumnClass(br.com.etec.model.Professor.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tableAtribuicao);
        tableAtribuicao.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableAtribuicao.getColumnModel().getColumn(0).setMinWidth(250);
        tableAtribuicao.getColumnModel().getColumn(0).setPreferredWidth(250);
        tableAtribuicao.getColumnModel().getColumn(1).setResizable(false);
        tableAtribuicao.getColumnModel().getColumn(1).setPreferredWidth(10);
        tableAtribuicao.getColumnModel().getColumn(2).setResizable(false);
        tableAtribuicao.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableAtribuicao.getColumnModel().getColumn(3).setMinWidth(225);
        tableAtribuicao.getColumnModel().getColumn(3).setPreferredWidth(225);
        tableAtribuicao.getColumnModel().getColumn(3).setCellEditor(new br.com.etec.util.view.ProfessorCellEditor());
        tableAtribuicao.getColumnModel().getColumn(4).setResizable(false);
        tableAtribuicao.getColumnModel().getColumn(4).setPreferredWidth(55);
        tableAtribuicao.getColumnModel().getColumn(5).setMinWidth(225);
        tableAtribuicao.getColumnModel().getColumn(5).setPreferredWidth(225);
        tableAtribuicao.getColumnModel().getColumn(5).setCellEditor(new br.com.etec.util.view.ProfessorCellEditor());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 957;
        gridBagConstraints.ipady = 388;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 10);
        panelDados.add(jScrollPane1, gridBagConstraints);

        btnIniciarAtribuicao1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIniciarAtribuicao1.setText("Encerrar Atribuição");
        btnIniciarAtribuicao1.setActionCommand("iniciarAtribuicao");
        btnIniciarAtribuicao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarAtribuicao1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 25, 0);
        panelDados.add(btnIniciarAtribuicao1, gridBagConstraints);

        getContentPane().add(panelDados);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarAtribuicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarAtribuicaoActionPerformed
        try {
            this.turma = ((Turma) cboTurma.getSelectedItem());
            this.periodoLetivo = ((PeriodoLetivo) cboPeriodoLetivo.getSelectedItem());

            List<Atribuicao> listExistente = atrDao.listAllByTurmaPeriodoLetivo(turma, periodoLetivo);

            this.listAtribuicao.clear();

            //Se o par turma / período letivo possui uma atribuição válida.
            if (listExistente != null && listExistente.size() > 0) {
                this.listAtribuicao.addAll(this.alinharAtribuicao(listExistente));
                this.operacao = Operacao.ALTERAR;
            } else {
                List<Disciplina> disciplinas = disDao.obterDisciplinasPorModulo(turma.getModulo());

                if (disciplinas == null || disciplinas.size() <= 0) {
                    throw new EtecAbException("Não existem componentes associados. Tente novamente!");
                }

                for (Disciplina d : disciplinas) {
                    criarAtribuicoesPorDisciplina(d);
                }
                this.operacao = Operacao.INCLUIR;
            }



            habilitarInicioAtribuicao(false);
        } catch (EtecAbException ex) {
            Logger.getLogger(PrincipalAtribuicaoView.class.getName()).log(Level.WARN, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciarAtribuicaoActionPerformed

    private void btnIniciarAtribuicao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarAtribuicao1ActionPerformed
        try {
            validarAtribuicao();
            if (operacao == Operacao.INCLUIR) {
                atrDao.createAll(listAtribuicao);
            } else {
                atrDao.updateAll(listAtribuicao);
            }
        } catch (EtecAbException ex) {
            Logger.getLogger(PrincipalAtribuicaoView.class.getName()).log(Level.WARN, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciarAtribuicao1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalAtribuicaoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalAtribuicaoView(new PeriodoLetivoDao().listAllActive()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarAtribuicao;
    private javax.swing.JButton btnIniciarAtribuicao1;
    private javax.swing.JComboBox cboPeriodoLetivo;
    private javax.swing.JComboBox cboTurma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSelecionePeriodo;
    private javax.swing.JLabel lblSelecionePeriodo1;
    private javax.swing.JLabel lblTitulo;
    private java.util.List<Atribuicao> listAtribuicao;
    private java.util.List<PeriodoLetivo> listPeriodoLetivo;
    private javax.swing.JPanel panelDados;
    private javax.swing.JPanel paneltitulo;
    private br.com.etec.model.PeriodoLetivo periodoLetivo;
    private javax.swing.JTable tableAtribuicao;
    private br.com.etec.model.Turma turma;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void initPeriodosLetivos(List<PeriodoLetivo> periodosLetivos) {
        if (periodosLetivos == null || periodosLetivos.size() <= 0) {
            throw new NullPointerException("Não há períodos letivos vigentes. Impossível iniciar atribuição");
        }
        this.listPeriodoLetivo = ObservableCollections.observableList(periodosLetivos);
    }

    private void habilitarInicioAtribuicao(Boolean flag) {
        this.paneltitulo.setEnabled(flag);
        this.btnIniciarAtribuicao.setEnabled(flag);
        this.cboPeriodoLetivo.setEnabled(flag);
        this.cboTurma.setEnabled(flag);
    }

    private void validarAtribuicao() throws EtecAbException {
        String errors = "";
        int quantidade = 0;
        for (Atribuicao atr : listAtribuicao) {
            if (atr.getProfessor() == null) {
                errors += "\n\t- " + "O componente \"" + atr.getDisciplina() + "\" (" + atr.getTipoAtribuicao().getNome() + ") não possui professor atribuído";
                quantidade++;
            }
            if (atr.hasSubstituicao() && atr.getAtribuicaoSubstituicao().getProfessor() == null) {
                errors += "\n\t- " + "O componente \"" + atr.getDisciplina() + "\" (" + atr.getTipoAtribuicao().getNome() + ") foi sinalizado como SUBSTITUIÇÃO e não possui professor substituto atribuído";
                quantidade++;
            }
            if (atr.getProfessor() != null && atr.getProfessor().getMatricula() == 0 && atr.hasSubstituicao()) {
                errors += "\n\t- " + "O componente \"" + atr.getDisciplina() + "\" (" + atr.getTipoAtribuicao().getNome() + ") foi sinalizado como sem professor e possui substituição de aula";
                quantidade++;
            }
        }
        if (quantidade > 0) {
            String numeroS = quantidade > 1 ? "s" : "";
            throw new EtecAbException("Erro" + numeroS + " ao salvar a atribuição:\n" + errors);
        }
    }

    private void criarAtribuicoesPorDisciplina(final Disciplina d) throws EtecAbException {
        criarAtribuicaoTitular(d);
        if (d.hasDivisao()) {
            criarAtribuicaoDivisao(d);
        }
    }

    private void criarAtribuicaoDivisao(final Disciplina d) throws EtecAbException {
        Atribuicao atrDiv = new Atribuicao();
        atrDiv.setDisciplina(d);
        atrDiv.setPeriodoLetivo(periodoLetivo);
        atrDiv.setTurma(turma);
        atrDiv.setTipoAtribuicao(TipoAtribuicaoBuilder.getTipoAtribuicaoDivisao());
        atrDiv.setHasSubstituicao(Boolean.FALSE);
        atrDiv.setCargaHorariaAtribuida(d.getCargaHorariaDivisao());
        this.listAtribuicao.add(atrDiv);
    }

    private void criarAtribuicaoTitular(Disciplina d) throws EtecAbException {
        Atribuicao atr = new Atribuicao();
        atr.setDisciplina(d);
        atr.setPeriodoLetivo(periodoLetivo);
        atr.setTurma(turma);
        atr.setTipoAtribuicao(TipoAtribuicaoBuilder.getTipoAtribuicaoPrincipal());
        atr.setHasSubstituicao(Boolean.FALSE);
        atr.setCargaHorariaAtribuida(d.getCargaHoraria());
        this.listAtribuicao.add(atr);
    }

    private List<Atribuicao> alinharAtribuicao(List<Atribuicao> listExistente) {
        List<Atribuicao> listAux = new ArrayList<>();
        listAux.addAll(listExistente);
        for(Atribuicao atribuicao: listExistente){
            for(Atribuicao atribuicao1: listExistente){
                if (atribuicao1.hasSubstituicao() == null || !atribuicao1.hasSubstituicao()) {
                    continue;
                }
                if (atribuicao.equals(atribuicao1.getAtribuicaoSubstituicao())) {
                    listAux.remove(atribuicao);
                }
            }
        }
        return listAux;
    }
}
