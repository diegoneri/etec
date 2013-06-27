/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.view;

import br.com.etec.dao.CategoriaProfessorDao;
import br.com.etec.model.CategoriaProfessor;
import br.com.etec.util.Operacao;
import br.com.etec.util.view.Utils;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author dfelix3
 */
public class CategoriaProfessorView extends javax.swing.JFrame {

    /**
     * Método construtor da classe PrincipalAtribuicaoView
     */
    private CategoriaProfessorDao dao = new CategoriaProfessorDao();
    private Integer PAGE = 1;
    private Integer TOTAL_RECORDS = dao.getCount();
    private Operacao operacao = Operacao.NENHUM;

    public CategoriaProfessorView() {
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

        return bd.intValue() > 0 ? bd.intValue() : 1;
    }

    private void doPagination(int page) {
        this.PAGE = page;
        this.listCategorias.clear();
        this.listCategorias.addAll(dao.listAll(Utils.PAGE_SIZE, page));
        String texto = "Página " + page + " de " + getLastPage()
                + "\nTotal de " + TOTAL_RECORDS + " Tipos de Contrato cadastrados";
        this.lblRecordInfo.setText(texto);
        this.tbCategorias.setRowSelectionInterval(0, 0);
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

        listCategorias = ObservableCollections.observableList(dao.listAll());
        categoriaBean = new br.com.etec.model.CategoriaProfessor();
        paneltitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        tbCategorias = new javax.swing.JTable();
        tbCategorias.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (tbCategorias.getSelectedRow() != -1) {
                    categoriaBean = listCategorias.get(tbCategorias.getSelectedRow());
                    btnAlterar.setEnabled(Boolean.TRUE);
                    btnExcluir.setEnabled(Boolean.TRUE);
                } else {
                    categoriaBean = null;
                    btnAlterar.setEnabled(Boolean.FALSE);
                    btnExcluir.setEnabled(Boolean.FALSE);
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
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        btnIncluir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        paneltitulo.setPreferredSize(new java.awt.Dimension(1198, 40));
        paneltitulo.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Categorias");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        paneltitulo.add(lblTitulo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(paneltitulo, gridBagConstraints);

        panelTable.setLayout(new java.awt.GridBagLayout());

        tbCategorias.setColumnSelectionAllowed(true);
        tbCategorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listCategorias, tbCategorias);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTable.setViewportView(tbCategorias);
        tbCategorias.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbCategorias.getColumnModel().getColumn(0).setResizable(false);
        tbCategorias.getColumnModel().getColumn(1).setResizable(false);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 160;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelTable.add(scrollTable, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        getContentPane().add(panelTable, gridBagConstraints);

        btnPrimeiro.setText("|<<");
        btnPrimeiro.setToolTipText("Primeiro Registro");
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

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

        btnUltimo.setText(">>|");
        btnUltimo.setToolTipText("Último Registro");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        lblRecordInfo.setEditable(false);
        lblRecordInfo.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        lblRecordInfo.setColumns(20);
        lblRecordInfo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblRecordInfo.setLineWrap(true);
        lblRecordInfo.setRows(2);
        lblRecordInfo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblRecordInfo.setEnabled(false);
        jScrollPane2.setViewportView(lblRecordInfo);

        lblId.setText("Código:");
        lblId.setToolTipText("");

        txtId.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tbCategorias, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.id}"), txtId, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblNome.setText("Nome:");

        btnAlterar.setText("Alterar");
        btnAlterar.setActionCommand("ListarCargoView.alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setActionCommand("ListarCargoView.salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("ListarCargoView.cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tbCategorias, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txtNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        btnIncluir.setText("Incluir");
        btnIncluir.setActionCommand("incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setActionCommand("ListarCargoView.excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(65, 23));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDadosLayout = new javax.swing.GroupLayout(panelDados);
        panelDados.setLayout(panelDadosLayout);
        panelDadosLayout.setHorizontalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(lblId)
                .addGap(5, 5, 5)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblNome)
                .addGap(5, 5, 5)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelDadosLayout.setVerticalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 20, 20);
        getContentPane().add(panelDados, gridBagConstraints);

        bindingGroup.bind();

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-610)/2, (screenSize.height-576)/2, 610, 576);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta =
        JOptionPane.showConfirmDialog(this, "Deseja excluir a Categoria " + categoriaBean.getNome() + "?", "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                dao.getEntityManager().getTransaction().begin();
                dao.delete(categoriaBean);
                dao.getEntityManager().getTransaction().commit();
                this.listCategorias.remove(categoriaBean);
                this.initFields(-1, Operacao.NENHUM);
            } catch (Exception ex) {
                Logger.getLogger(CategoriaProfessorView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        this.listCategorias.add(new CategoriaProfessor());
        this.initFields(this.listCategorias.size() - 1, Operacao.INCLUIR);// TODO add your handling code here:
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dao.getEntityManager().getTransaction().begin();
        dao.refresh(categoriaBean);
        dao.getEntityManager().getTransaction().commit();
        this.initFields(-1, Operacao.NENHUM);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        dao.getEntityManager().getTransaction().begin();
        switch(operacao){
            case INCLUIR:
            dao.create(categoriaBean);
            break;
            case ALTERAR:
            dao.update(categoriaBean);
            break;
            default:
            throw new RuntimeException("Erro ao persistir dados: Não há operação definida");
        }
        dao.getEntityManager().getTransaction().commit();

        this.initFields(-1, Operacao.NENHUM);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        this.initFields(tbCategorias.getSelectedRow(), Operacao.ALTERAR);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        this.lastPage();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        this.nextPage();
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        this.previousPage();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        this.firstPage();
    }//GEN-LAST:event_btnPrimeiroActionPerformed

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
            java.util.logging.Logger.getLogger(CategoriaProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CategoriaProfessorView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private br.com.etec.model.CategoriaProfessor categoriaBean;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextArea lblRecordInfo;
    private javax.swing.JLabel lblTitulo;
    private java.util.List<CategoriaProfessor> listCategorias;
    private javax.swing.JPanel panelDados;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel paneltitulo;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tbCategorias;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void initFields(int row, Operacao operacao) {
        this.operacao = operacao;
        if (operacao == Operacao.NENHUM) {
            //SALVAR, CANCELAR, EXCLUIR, ATUALIZAR
            int index = tbCategorias.getSelectedRow();
            tbCategorias.getSelectionModel().clearSelection();
            clearFields();
            if (index < 0) {
                index = 0;
            }
            this.tbCategorias.setRowSelectionInterval(index,index);
            this.TOTAL_RECORDS = dao.getCount();
            this.doPagination(PAGE);
            this.enableFields(false);
        } else {
            //INCLUIR E ALTERAR
            tbCategorias.setRowSelectionInterval(row, row);
            tbCategorias.scrollRectToVisible(tbCategorias.getCellRect(row, 0, true));
            this.enableFields(true);
        }
    }

    private void clearFields() {
        this.txtId.setText("");
        this.txtNome.setText("");
    }

    private void enableFields(boolean flag) {
        this.txtId.setEnabled(flag);
        this.txtNome.setEnabled(flag);

        if (flag) {
            this.txtId.requestFocus();
        }

        this.tbCategorias.setEnabled(!flag);

        this.btnIncluir.setEnabled(!flag);
        this.btnAlterar.setEnabled(!flag);
        this.btnExcluir.setEnabled(!flag);

        this.btnSalvar.setEnabled(flag);
        this.btnCancelar.setEnabled(flag);
        
        this.validarBotoesNavegacao(!flag);
    }
}
