/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.view;

import br.com.etec.dao.CategoriaProfessorDao;
import br.com.etec.dao.ProfessorDao;
import br.com.etec.dao.TipoContratoDao;
import br.com.etec.model.CategoriaProfessor;
import br.com.etec.model.Professor;
import br.com.etec.model.TipoContrato;
import br.com.etec.util.view.Utils;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author dfelix3
 */
public class ProfessorView extends javax.swing.JFrame {

    /**
     * Método construtor da classe PrincipalAtribuicaoView
     */
    private ProfessorDao dao = new ProfessorDao();
    private Integer PAGE = 1;
    private Integer TOTAL_RECORDS = dao.getCount();

    public ProfessorView() {
        initProfessores();
        initComponents();
        firstPage();
        enableFields(false);
    }

    private void firstPage() {
        this.doPagination(1);
    }

    private void previousPage() {
        this.doPagination(--PAGE);
    }

    private void nextPage() {
        this.doPagination(++PAGE);
    }

    private void lastPage() {
        this.doPagination(getLastPage());
    }

    private Integer getLastPage() {
        BigDecimal bd = new BigDecimal(TOTAL_RECORDS)
                .divide(new BigDecimal(Utils.PAGE_SIZE))
                .setScale(0, BigDecimal.ROUND_HALF_UP);

        return bd.intValue();
    }

    private void doPagination(int page) {
        this.PAGE = page;
        this.listProfessores.clear();
        this.listProfessores.addAll(dao.listAll(Utils.PAGE_SIZE, page));
        String texto = "Página " + page + " de " + getLastPage()
                + "\nTotal de " + TOTAL_RECORDS + " professores cadastrados";
        this.lblRecordInfo.setText(texto);
        this.tableProfessores.setRowSelectionInterval(0, 0);
        this.validarBotoesNavegacao(true);
    }

    private void validarBotoesNavegacao(boolean flag) {
        this.btnPrimeiro.setEnabled(flag ? PAGE > 1 : flag);
        this.btnAnterior.setEnabled(flag ? PAGE > 1 : flag);
        this.btnProximo.setEnabled(flag ? PAGE < getLastPage() : flag);
        this.btnUltimo.setEnabled(flag ? PAGE < getLastPage() : flag);
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

        listProfessores = listProfessores;
        listCategorias = ObservableCollections.observableList(new CategoriaProfessorDao().listAll());
        listTipoContrato = ObservableCollections.observableList(new TipoContratoDao().listAll());
        professorBean = new br.com.etec.model.Professor();
        paneltitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSelecionePeriodo = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        tableProfessores = new javax.swing.JTable();
        tableProfessores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (tableProfessores.getSelectedRow() != -1) {
                    professorBean = listProfessores.get(tableProfessores.getSelectedRow());
                    btnAlterar.setEnabled(Boolean.TRUE);
                } else {
                    professorBean = null;
                    btnAlterar.setEnabled(Boolean.FALSE);
                }
            }
        });
        panelDados = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblRecordInfo = new javax.swing.JTextArea();
        lblRG = new javax.swing.JLabel();
        txtRG = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        lblTipoContrato = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        cbTipoContrato = new javax.swing.JComboBox();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        paneltitulo.setPreferredSize(new java.awt.Dimension(1198, 40));
        paneltitulo.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("Cadastro de Professores");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        paneltitulo.add(lblTitulo, gridBagConstraints);

        lblSelecionePeriodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSelecionePeriodo.setForeground(new java.awt.Color(204, 51, 0));
        lblSelecionePeriodo.setText("Atenção: não se pode criar um professor pelo Sistema de Carga Horária, somente a inclusão de dados relativos à Atribuição de aulas.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 20, 20);
        paneltitulo.add(lblSelecionePeriodo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 10, 20);
        getContentPane().add(paneltitulo, gridBagConstraints);

        panelTable.setLayout(new java.awt.GridBagLayout());

        tableProfessores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listProfessores, tableProfessores);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${matricula}"));
        columnBinding.setColumnName("Matrícula");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cpf}"));
        columnBinding.setColumnName("CPF");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rg}"));
        columnBinding.setColumnName("RG");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${categoriaProfessor}"));
        columnBinding.setColumnName("Categoria");
        columnBinding.setColumnClass(br.com.etec.model.CategoriaProfessor.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoContrato}"));
        columnBinding.setColumnName("Tipo de Contrato");
        columnBinding.setColumnClass(br.com.etec.model.TipoContrato.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTable.setViewportView(tableProfessores);
        tableProfessores.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableProfessores.getColumnModel().getColumn(0).setResizable(false);
        tableProfessores.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableProfessores.getColumnModel().getColumn(1).setResizable(false);
        tableProfessores.getColumnModel().getColumn(1).setPreferredWidth(70);
        tableProfessores.getColumnModel().getColumn(2).setMinWidth(250);
        tableProfessores.getColumnModel().getColumn(2).setPreferredWidth(250);
        tableProfessores.getColumnModel().getColumn(3).setMinWidth(100);
        tableProfessores.getColumnModel().getColumn(3).setPreferredWidth(100);
        tableProfessores.getColumnModel().getColumn(3).setCellEditor(new br.com.etec.util.view.ProfessorCellEditor());
        tableProfessores.getColumnModel().getColumn(4).setMinWidth(90);
        tableProfessores.getColumnModel().getColumn(4).setPreferredWidth(90);
        tableProfessores.getColumnModel().getColumn(5).setMinWidth(80);
        tableProfessores.getColumnModel().getColumn(5).setPreferredWidth(80);
        tableProfessores.getColumnModel().getColumn(5).setCellEditor(new br.com.etec.util.view.ProfessorCellEditor());
        tableProfessores.getColumnModel().getColumn(6).setMinWidth(100);
        tableProfessores.getColumnModel().getColumn(6).setPreferredWidth(100);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1000;
        gridBagConstraints.ipady = 160;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelTable.add(scrollTable, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(panelTable, gridBagConstraints);

        panelDados.setLayout(new java.awt.GridBagLayout());

        btnPrimeiro.setText("|<<");
        btnPrimeiro.setToolTipText("Primeiro Registro");
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 10);
        panelDados.add(btnPrimeiro, gridBagConstraints);

        btnAnterior.setText("<");
        btnAnterior.setToolTipText("Registro Anterior");
        btnAnterior.setMaximumSize(new java.awt.Dimension(53, 23));
        btnAnterior.setMinimumSize(new java.awt.Dimension(53, 23));
        btnAnterior.setPreferredSize(new java.awt.Dimension(53, 23));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelDados.add(btnAnterior, gridBagConstraints);

        btnProximo.setText(">");
        btnProximo.setToolTipText("Próximo Registro");
        btnProximo.setMaximumSize(new java.awt.Dimension(53, 23));
        btnProximo.setMinimumSize(new java.awt.Dimension(53, 23));
        btnProximo.setPreferredSize(new java.awt.Dimension(53, 23));
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelDados.add(btnProximo, gridBagConstraints);

        btnUltimo.setText(">>|");
        btnUltimo.setToolTipText("Último Registro");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 20);
        panelDados.add(btnUltimo, gridBagConstraints);

        lblRecordInfo.setEditable(false);
        lblRecordInfo.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        lblRecordInfo.setColumns(20);
        lblRecordInfo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblRecordInfo.setLineWrap(true);
        lblRecordInfo.setRows(2);
        lblRecordInfo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblRecordInfo.setEnabled(false);
        jScrollPane2.setViewportView(lblRecordInfo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 20, 20);
        panelDados.add(jScrollPane2, gridBagConstraints);

        lblRG.setText("RG:");
        lblRG.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 2);
        panelDados.add(lblRG, gridBagConstraints);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tableProfessores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.rg}"), txtRG, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 5, 20);
        panelDados.add(txtRG, gridBagConstraints);

        lblCategoria.setText("Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 2);
        panelDados.add(lblCategoria, gridBagConstraints);

        lblTipoContrato.setText("Tipo de Contrato:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 2);
        panelDados.add(lblTipoContrato, gridBagConstraints);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listCategorias, cbCategoria);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tableProfessores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.categoriaProfessor}"), cbCategoria, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 20);
        panelDados.add(cbCategoria, gridBagConstraints);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listTipoContrato, cbTipoContrato);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tableProfessores, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tipoContrato}"), cbTipoContrato, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 20);
        panelDados.add(cbTipoContrato, gridBagConstraints);

        btnAlterar.setText("Alterar");
        btnAlterar.setActionCommand("ListarCargoView.alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 2);
        panelDados.add(btnAlterar, gridBagConstraints);

        btnSalvar.setText("Salvar");
        btnSalvar.setActionCommand("ListarCargoView.salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 2);
        panelDados.add(btnSalvar, gridBagConstraints);

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("ListarCargoView.cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 20);
        panelDados.add(btnCancelar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 20, 20);
        getContentPane().add(panelDados, gridBagConstraints);

        bindingGroup.bind();

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1214)/2, (screenSize.height-596)/2, 1214, 596);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        this.firstPage();
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        this.previousPage();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        this.nextPage();
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        this.lastPage();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        this.initFields(tableProfessores.getSelectedRow());
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        dao.getEntityManager().getTransaction().begin();
        dao.update(professorBean);
        dao.getEntityManager().getTransaction().commit();
        this.initFields(-1);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dao.getEntityManager().getTransaction().begin();
        dao.refresh(professorBean);
        dao.getEntityManager().getTransaction().commit();
        this.initFields(-1);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProfessorView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbTipoContrato;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblRG;
    private javax.swing.JTextArea lblRecordInfo;
    private javax.swing.JLabel lblSelecionePeriodo;
    private javax.swing.JLabel lblTipoContrato;
    private javax.swing.JLabel lblTitulo;
    private java.util.List<CategoriaProfessor> listCategorias;
    private java.util.List<Professor> listProfessores;
    private java.util.List<TipoContrato> listTipoContrato;
    private javax.swing.JPanel panelDados;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel paneltitulo;
    private br.com.etec.model.Professor professorBean;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tableProfessores;
    private javax.swing.JTextField txtRG;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void initProfessores() {
        this.listProfessores = ObservableCollections.observableList(new ArrayList<Professor>());
    }

    private void initFields(int row) {
        if (row == -1) {
            //SALVAR, CANCELAR, EXCLUIR, ATUALIZAR
            int index = tableProfessores.getSelectedRow();
            tableProfessores.getSelectionModel().clearSelection();
            clearFields();
            this.tableProfessores.setRowSelectionInterval(index,index);
            this.enableFields(false);
        } else {
            //INCLUIR E ALTERAR
            tableProfessores.setRowSelectionInterval(row, row);
            tableProfessores.scrollRectToVisible(tableProfessores.getCellRect(row, 0, true));
            this.enableFields(true);
        }
    }

    private void clearFields() {
        this.txtRG.setText("");
        this.cbCategoria.setSelectedIndex(-1);
        this.cbTipoContrato.setSelectedIndex(-1);
    }

    private void enableFields(boolean flag) {
        this.txtRG.setEnabled(flag);
        this.cbCategoria.setEnabled(flag);
        this.cbTipoContrato.setEnabled(flag);

        this.tableProfessores.setEnabled(!flag);

        this.btnAlterar.setEnabled(!flag);

        this.btnSalvar.setEnabled(flag);
        this.btnCancelar.setEnabled(flag);
        
        this.validarBotoesNavegacao(!flag);
    }
}
