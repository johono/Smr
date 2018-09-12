/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JFrames;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.alves
 */
public class PesquisaAluno extends javax.swing.JFrame {
    Rotinas.T_Aluno taluno = new Rotinas.T_Aluno();
    Rotinas.Parametros par = new Rotinas.Parametros();
    JFrames.Alunos al;
    
    

    /** Creates new form PesquisaAluno */
    public PesquisaAluno() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btVoltar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        rg = new javax.swing.JTextField();
        pai = new javax.swing.JTextField();
        mae = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btVoltar.setText("VOLTAR");
        btVoltar.setMaximumSize(new java.awt.Dimension(89, 23));
        btVoltar.setMinimumSize(new java.awt.Dimension(89, 23));
        btVoltar.setPreferredSize(new java.awt.Dimension(89, 23));
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btLimpar.setText("LIMPAR");
        btLimpar.setEnabled(false);
        btLimpar.setMaximumSize(new java.awt.Dimension(89, 23));
        btLimpar.setMinimumSize(new java.awt.Dimension(89, 23));
        btLimpar.setPreferredSize(new java.awt.Dimension(89, 23));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btPesquisar.setText("PESQUISAR");
        btPesquisar.setEnabled(false);
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("NOME:");

        jLabel2.setText("CPF:");

        jLabel3.setText("RG:");

        jLabel4.setText("PAI:");

        jLabel5.setText("MÃE:");

        nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeFocusLost(evt);
            }
        });

        cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cpfFocusLost(evt);
            }
        });

        rg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rgFocusLost(evt);
            }
        });

        pai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                paiFocusLost(evt);
            }
        });

        mae.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                maeFocusLost(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PESQUISA AVANÇADA");
        jLabel6.setOpaque(true);

        resultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(resultado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btPesquisar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cpf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rg, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pai, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mae))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addGap(26, 26, 26))
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
        try {
            setVisible(false);
            Alunos al = new Alunos();
            al.setVisible(true);
        } catch (Throwable e) {
            Logger.getLogger(Alunos.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        ArrayList<String> lista = new ArrayList();
        this.resultado.removeAll();
        java.util.Iterator it = lista.iterator();
        DefaultListModel model = new DefaultListModel();
        this.resultado.setModel(model);
        this.nome.setText("");
        this.cpf.setText("");
        this.rg.setText("");
        this.pai.setText("");
        this.mae.setText("");
        this.nome.requestFocus();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        String aluno = cod_aluno();
        if(!"0".equals(aluno)){
            Rotinas.Parametros.setCod_aluno(aluno);
            btVoltarActionPerformed(evt);
        }else{
            Rotinas.Parametros.setCod_aluno("0");
            JOptionPane.showMessageDialog(null, "NENHUM ALUNO SELECIONADO!", "Informacao", 1);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void resultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultadoMouseClicked
        if(evt.getClickCount() == 2){
            btPesquisarActionPerformed(null);
        }
    }//GEN-LAST:event_resultadoMouseClicked

    private void nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeFocusLost
        try{
            if(!"".equals(this.nome.getText())){
                ArrayList<String> lista = new ArrayList();
                this.resultado.removeAll();
                Iterator it = lista.iterator();
                DefaultListModel model = new DefaultListModel();
                this.resultado.setModel(model);
                ResultSet rs = this.taluno.Ler_Aluno_Pesq("nom_aluno", this.nome.getText());
                if(rs.next()){
                    rs.previous();
                while(rs.next()){
                    String itemLista = rs.getString("nom_aluno")+" - "+rs.getString("cod_aluno");
                    model.addElement(itemLista);
                }
            }else{
                    String itemLista = "Nenhum registro encontrado.";
                    model.addElement(itemLista);}
                    this.cpf.setText("");
                    this.rg.setText("");
                    this.pai.setText("");
                    this.mae.setText("");
            
                
            }
        }catch (SQLException ex) {
            Logger.getLogger(Alunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nomeFocusLost

    private void cpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cpfFocusLost
        try{
            if(!"".equals(this.cpf.getText())){
                ArrayList<String> lista = new ArrayList();
                this.resultado.removeAll();
                Iterator it = lista.iterator();
                DefaultListModel model = new DefaultListModel();
                this.resultado.setModel(model);
                ResultSet rs = this.taluno.Ler_Aluno_Pesq("cpf", this.cpf.getText());
                if(rs.next()){
                    rs.previous();
                while(rs.next()){
                    String itemLista = rs.getString("nom_aluno")+"-"+rs.getString("cod_aluno");
                    model.addElement(itemLista);
                }
            }else{
            String itemLista = "Nenhum registro encontrado.";
            model.addElement(itemLista);}
            
            this.nome.setText("");
            this.rg.setText("");
            this.pai.setText("");
            this.mae.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cpfFocusLost

    private void rgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rgFocusLost
        try{
            if(!"".equals(this.rg.getText())){
                ArrayList<String> lista = new ArrayList();
                this.resultado.removeAll();
                Iterator it = lista.iterator();
                DefaultListModel model = new DefaultListModel();
                this.resultado.setModel(model);
                ResultSet rs = this.taluno.Ler_Aluno_Pesq("rg", this.rg.getText());
                if(rs.next()){
                    rs.previous();
                while(rs.next()){
                    String itemLista = rs.getString("nom_aluno")+"-"+rs.getString("cod_aluno");
                    model.addElement(itemLista);
                }
            }else{
            String itemLista = "Nenhum registro encontrado.";
            model.addElement(itemLista);
                }
            this.cpf.setText("");
            this.nome.setText("");
            this.pai.setText("");
            this.mae.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rgFocusLost

    private void paiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_paiFocusLost
        try{
            if(!"".equals(this.pai.getText())){
                ArrayList<String> lista = new ArrayList();
                this.resultado.removeAll();
                Iterator it = lista.iterator();
                DefaultListModel model = new DefaultListModel();
                this.resultado.setModel(model);
                ResultSet rs = this.taluno.Ler_Aluno_Pesq("nome_pai", this.pai.getText());
                if(rs.next()){
                    rs.previous();
                while(rs.next()){
                    String itemLista = rs.getString("nom_aluno")+"-"+rs.getString("cod_aluno");
                    model.addElement(itemLista);
                }
            }else{
            String itemLista = "Nenhum registro encontrado.";
            model.addElement(itemLista);
                }
            this.cpf.setText("");
            this.rg.setText("");
            this.nome.setText("");
            this.mae.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_paiFocusLost

    private void maeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maeFocusLost
        try{
            if(!"".equals(this.mae.getText())){
                ArrayList<String> lista = new ArrayList();
                this.resultado.removeAll();
                Iterator it = lista.iterator();
                DefaultListModel model = new DefaultListModel();
                this.resultado.setModel(model);
                ResultSet rs = this.taluno.Ler_Aluno_Pesq("nome_mae", this.mae.getText());
                if(rs.next()){
                    rs.previous();
                while(rs.next()){
                    String itemLista = rs.getString("nom_aluno")+"-"+rs.getString("cod_aluno");
                    model.addElement(itemLista);
                }
            }else{
            String itemLista = "Nenhum registro encontrado.";
            model.addElement(itemLista);
                }
            this.cpf.setText("");
            this.rg.setText("");
            this.pai.setText("");
            this.nome.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisaAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_maeFocusLost

    private String cod_aluno(){
        if(this.resultado.isSelectionEmpty() != true){
            String aluno = (String)this.resultado.getSelectedValue();
            int contador = aluno.length();
            String cod = "0";
            for(int i =0; i<contador; i++){
                if(aluno.substring(i, i+1).equals("-")){
                    int posicao = i+2;
                    cod = aluno.substring(1+2, contador);
                }
            }
            return cod;
        }
        return "0";
    }
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
            java.util.logging.Logger.getLogger(PesquisaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JTextField cpf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField mae;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField pai;
    private javax.swing.JList<String> resultado;
    private javax.swing.JTextField rg;
    // End of variables declaration//GEN-END:variables

}
