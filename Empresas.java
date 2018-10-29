/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Rotinas.Consistencias;
import Rotinas.T_Cidade;
import Rotinas.T_Empresas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.alves
 */
public class Empresas extends javax.swing.JFrame {
    T_Empresas empresas = new T_Empresas();
    T_Cidade cidades = new T_Cidade();
    Consistencias consistencias = new Consistencias();

    
    private void Atualiza_Cidade(String cod){
        int elemento = 0;
        int i = 0;
        this.cbc.removeAllItems();
        ResultSet rs = this.cidades.Ler_Cidade();
        try {
            if(rs.next()){
                rs.previous();
                while(rs.next()){
                    this.cbc.addItem(rs.getString("nome_cidade"));
                    if(rs.getString("cod_cidade").equals(cod)){
                        elemento = i;
                    }
                    i++;
                }
            }
            this.cbc.addItem("");
            this.cbc.setSelectedIndex(elemento);
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void Atualiza_Empresa(){
        this.cb.removeAllItems();
        ResultSet rs = this.empresas.Ler_Empresa();
        try {
            if(rs.next()){
                rs.previous();
                while(rs.next()){
                    this.cb.addItem(rs.getString("razao_empresa"));
                }
            }
            this.cb.addItem("");
            this.codigo.setText("");
            this.codigo.setText("00000");
            this.razao.setText("");
            this.fantasia.setText("");
            this.cnpj.setText("");
            this.fone.setText("");
            this.ie.setText("");
            this.im.setText("");
            this.endereco.setText("");
            this.observacao.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void Grava_Altera_Empresa(String teste){
        boolean cnpj_duplicado = false;
        if("grava".equals(teste)){
            ResultSet rs1 = this.empresas.Ler_Empresa(this.cnpj.getText(), 1);
            try {
                if(rs1.first()){
                    cnpj_duplicado = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Empresas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!"".equals(this.cbc.getSelectedItem().toString())){
            if(!cnpj_duplicado){
                if((this.endereco.getText().length()<=250)&&(this.observacao.getText().length()<=250)){
                    if((this.razao.getText().length()<=50)&&(this.fantasia.getText().length()<=50)){
                        if("".equals(this.razao.getText())){
                            JOptionPane.showMessageDialog(null, "INSIRA A RAZÃO SOCIAL DA EMPRESA.", "Informacao", 1);
                        }else if("".equals(this.fantasia.getText())){
                            JOptionPane.showMessageDialog(null, "INSIRA UM NOME FANTASIA PARA A EMPRESA", "Informacao", 1);
                        }else{
                            String Cnpj = "";
                            if(this.cnpj.getText().length() == 18){
                            Cnpj = this.consistencias.desmascaraCNPJ(this.cnpj.getText());
                            if(this.consistencias.isCNPJ(Cnpj)==true){
                                String st_cod = this.codigo.getText();
                                String st_razao = this.razao.getText();
                                String st_fantasia = this.fantasia.getText();
                                String st_ie = this.ie.getText();
                                String st_im = this.im.getText();
                                String st_fone = this.fone.getText();
                                String st_endereco = this.endereco.getText();
                                String st_obs = this.observacao.getText();
                                String st_cod_cidade = "0";
                                ResultSet rs = this.cidades.Ler_Cidade(cbc.getSelectedItem().toString());
                                try {
                                    rs.first();
                                    st_cod_cidade = rs.getString("COD_CIDADE");                                    
                                } catch (SQLException ex) {
                                    Logger.getLogger(Empresas.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if("altera".equals(teste)){
                                    this.empresas.Alterar_Empresa(st_cod, st_razao, st_fantasia, Cnpj, st_ie, st_im, st_fone, st_endereco, st_obs, st_cod_cidade);
                                }else if("grava".equals(teste)){
                                    this.empresas.Grava_Empresa(st_razao, st_fantasia, Cnpj, st_ie, st_im, st_fone, st_endereco, st_obs, st_cod_cidade);
                                }
                                Atualiza_Empresa();
                                Atualiza_Cidade("0");
                            }else{
                                JOptionPane.showConfirmDialog(null, "INSIRA UM CNPJ VÁLIDO", "Informacao", 1);
                            }
                        }else{
                                JOptionPane.showConfirmDialog(null, "INSIRA UM CNPJ VÁLIDO", "Informacao", 1);
                            }
                        }
                    }else{
                        JOptionPane.showConfirmDialog(null, "OS CAMPOS RAZÃO SOCIAL E NOME FANTASIA NÃO DEVEM CONTER MAIS DE 50 CARACTERES", "Informacao", 1);
                    }
                }else{
                    JOptionPane.showConfirmDialog(null, "OS CAMPOS RAZÃO SOCIAL E NOME FANTASIA NÃO DEVEM CONTER MAIS DE 50 CARACTERES", "Informacao", 1);
                }
            }else{
                JOptionPane.showConfirmDialog(null, "ESSE CNPJ JÁ ESTÁ CADASTRADO!", "Informacao", 1);
            }
        }else{
            JOptionPane.showConfirmDialog(null, "UMA CIDADE DEVE SER SELECIONADA.", "Informacao", 1);
        }
    }
    /**
     * Creates new form Empresas
     */
    public Empresas() {
        initComponents();
        Atualiza_Empresa();
        Atualiza_Cidade("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigo_pesquisa = new javax.swing.JTextField();
        cnpj_pesquisa = new javax.swing.JFormattedTextField();
        cb = new javax.swing.JComboBox<>();
        btPesquisar = new javax.swing.JButton();
        btLimparPesquisa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        razao = new javax.swing.JTextField();
        fantasia = new javax.swing.JTextField();
        cnpj = new javax.swing.JFormattedTextField();
        ie = new javax.swing.JFormattedTextField();
        im = new javax.swing.JFormattedTextField();
        fone = new javax.swing.JTextField();
        cbc = new javax.swing.JComboBox<>();
        endereco = new javax.swing.JTextField();
        observacao = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btVoltar = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Código:");

        jLabel2.setText("CNPJ:");

        jLabel3.setText("Empresa:");

        codigo_pesquisa.setPreferredSize(new java.awt.Dimension(59, 20));

        cnpj_pesquisa.setPreferredSize(new java.awt.Dimension(59, 20));

        cb.setPreferredSize(new java.awt.Dimension(59, 20));

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btLimparPesquisa.setText("Limpar");
        btLimparPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparPesquisaActionPerformed(evt);
            }
        });

        jLabel4.setText("Código:");

        jLabel5.setText("Razão Social:");

        jLabel6.setText("Nome Fantasia:");

        jLabel7.setText("CNPJ: ");

        jLabel8.setText("IE:");

        jLabel9.setText("IM:");

        jLabel10.setText("Telefones:");

        jLabel11.setText("Cidade:");

        jLabel12.setText("Endereço:");

        jLabel13.setText("Observação:");

        codigo.setPreferredSize(new java.awt.Dimension(59, 20));

        cnpj.setPreferredSize(new java.awt.Dimension(59, 20));

        ie.setPreferredSize(new java.awt.Dimension(59, 20));

        im.setPreferredSize(new java.awt.Dimension(59, 20));

        cbc.setPreferredSize(new java.awt.Dimension(59, 20));

        btVoltar.setText("VOLTAR");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btGravar.setText("GRAVAR");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btAlterar.setText("ALTERAR");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btLimpar.setText("LIMPAR");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btExcluir.setText("EXCLUIR");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(codigo_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addComponent(cnpj_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btLimparPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(razao)
                            .addComponent(fantasia)
                            .addComponent(cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(im, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fone)
                            .addComponent(cbc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endereco)
                            .addComponent(observacao)
                            .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluir)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigo_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cnpj_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimparPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(razao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(im, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(observacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btGravar)
                    .addComponent(btAlterar)
                    .addComponent(btLimpar)
                    .addComponent(btExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        Menu menu = new Menu();
        this.dispose();
        menu.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        Grava_Altera_Empresa("grava");
    }//GEN-LAST:event_btGravarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        ResultSet rs;
        if(("".equals(this.codigo_pesquisa.getText())) && ("  .   .   /    -  ".equals(this.cnpj_pesquisa.getText()))){
            rs = this.empresas.Ler_Empresa(cb.getSelectedItem().toString(), 1);
        }else{
            if("".equals(this.codigo_pesquisa.getText())){
                rs = this.empresas.Ler_Empresa(this.consistencias.desmascaraCNPJ(this.cnpj_pesquisa.getText()), 1);
            }else{
                rs = this.empresas.Ler_Empresa(this.codigo_pesquisa.getText(), 1);
            }
            if(rs != null){
                try {
                    rs.first();
                    this.codigo.setText(rs.getString("COD_EMPRESA"));
                    this.razao.setText(rs.getString("RAZAO_EMPRESA"));
                    this.fantasia.setText(rs.getString("NOME_EMPRESA"));
                    this.cnpj.setText(rs.getString("CNPJ_EMPRESA"));
                    this.ie.setText(rs.getString("IE_EMPRESA"));
                    this.im.setText(rs.getString("IM_EMPRESA"));
                    this.fone.setText(rs.getString("FONE_EMPRESA"));
                    this.endereco.setText(rs.getString("END_EMPRESA"));
                    this.observacao.setText(rs.getString("OBS_EMPRESA"));
                    Atualiza_Cidade(rs.getString("COD_CIDADE"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO 1", "Informacao", 1);
                }
            }else{
                JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO 2", "Informacao", 1);
            }
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btLimparPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparPesquisaActionPerformed
        this.codigo_pesquisa.setText("");
        this.cnpj_pesquisa.setText("");
        this.cb.setSelectedIndex(-1);
    }//GEN-LAST:event_btLimparPesquisaActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        Atualiza_Cidade("0");
        Atualiza_Empresa();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        this.empresas.Apagar_empresa(this.codigo.getText());
        Atualiza_Empresa();
        Atualiza_Cidade("0");
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if(!"00000".equals(this.codigo.getText())){
            Grava_Altera_Empresa("altera");
        }else{
            JOptionPane.showMessageDialog(null, "SELECIONE A EMPRESA A SER ALTERADA.", "Informacao", 1);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empresas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btLimparPesquisa;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cbc;
    private javax.swing.JFormattedTextField cnpj;
    private javax.swing.JFormattedTextField cnpj_pesquisa;
    private javax.swing.JLabel codigo;
    private javax.swing.JTextField codigo_pesquisa;
    private javax.swing.JTextField endereco;
    private javax.swing.JTextField fantasia;
    private javax.swing.JTextField fone;
    private javax.swing.JFormattedTextField ie;
    private javax.swing.JFormattedTextField im;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField observacao;
    private javax.swing.JTextField razao;
    // End of variables declaration//GEN-END:variables
}
