/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Rotinas.Consistencias;
import Rotinas.Parametros;
import Rotinas.T_Aluno;
import Rotinas.T_Cidade;
import Rotinas.T_Curso;
import Rotinas.T_Empresas;
import Rotinas.T_UndEnsino;
import Rotinas.Tarefas_banco;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.alves
 */
public class Alunos extends javax.swing.JFrame {
    T_Aluno taluno = new T_Aluno();
    T_Cidade tcidade = new T_Cidade();
    T_Curso tcurso = new T_Curso();
    T_Empresas tempresas = new T_Empresas();
    T_UndEnsino tundensino = new T_UndEnsino();
    Tarefas_banco tarefas = new Tarefas_banco();
    Consistencias cons = new Consistencias();
    Parametros parametros = new Parametros();
    
    private void Atualiza_Cidade(String cod){
        try {
            int elemento = 0;
            int i = 0;
            this.cbCidade.removeAllItems();
            ResultSet rs = this.tcidade.Ler_Cidade();
            if(rs.next()){
                rs.previous();
                while(rs.next()){
                    this.cbCidade.addItem(rs.getString("nome_cidade"));
                    if(rs.getString("cod_cidade").equals(cod)){
                        elemento = i;
                    }
                    i++;
                }
            }
            this.cbCidade.addItem("");
            this.cbCidade.setSelectedIndex(elemento);
        
        } catch (SQLException ex) {
            Logger.getLogger(Alunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void Atualiza_Empresa(String cod){
        try{
            int elemento = 0;
            int i = 0;
            this.cbEmpresa.removeAllItems();
            ResultSet rs = this.tempresas.Ler_Empresa();
            if(rs.next()){
                rs.previous();
                while(rs.next()){
                    this.cbEmpresa.addItem(rs.getString("razao_empresa"));
                    if(rs.getString("cod_empresa").equals(cod)){
                        elemento = i;
                    }
                    i++;
                }
            }
            this.cbEmpresa.addItem("");
            this.cbEmpresa.setSelectedIndex(elemento);
        } catch (SQLException ex) {
            Logger.getLogger(Alunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void Atualiza_Und(String cod){
        try{
            int elemento = 0;
            int i = 0;
            this.cbUnd.removeAllItems();
            ResultSet rs = this.tundensino.Ler_UndEnsino();
            if(rs.next()){
                rs.previous();
                while(rs.next()){
                    this.cbUnd.addItem(rs.getString("nome_und"));
                    if(rs.getString("cod_und").equals(cod)){
                        elemento = i;
                    }
                    i++;
                }
            }
            this.cbUnd.addItem("");
            this.cbUnd.setSelectedIndex(elemento);
        } catch (SQLException ex) {
            Logger.getLogger(Alunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void Atualiza_Curso(String cod){
        try{
            int elemento = 0;
            int i = 0;
            this.cbCurso.removeAllItems();
            ResultSet rs = this.tcurso.Ler_Curso();
            if(rs.next()){
                rs.previous();
                while(rs.next()){
                    this.cbCurso.addItem(rs.getString("nome_curso"));
                    if(rs.getString("cod_curso").equals(cod)){
                        elemento = i;
                    }
                    i++;
                }
            }
            this.cbCurso.addItem("");
            this.cbCurso.setSelectedIndex(elemento);
        } catch (SQLException ex) {
            Logger.getLogger(Alunos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void Atualiza_Aluno(){
    try{
      this.cbAluno.removeAllItems();
      ResultSet rs = this.taluno.Ler_Aluno();
      if (rs.next()) {
        rs.previous();
        while (rs.next()) {
          this.cbAluno.addItem(rs.getString("NOM_ALUNO"));
        }
      }
      this.cbAluno.addItem("");
      
      if ("0".equals(Rotinas.Parametros.getCod_aluno())){
        this.jPesquisa.setText("");
        this.jCod.setText("00000");
        this.jNome.setText("");
        this.jEnd.setText("");
        this.jFone.setText("");
        this.jRg.setText("");
        this.jCpf.setText("");
        this.jObs.setText("");
        this.jValor.setText("");
        this.jValor_ext.setText("");
        this.jPai.setText("");
        this.jMae.setText("");
        this.jDt_Vig.setText(getDate());
        this.jDt_Cad.setText("");
        this.cbCidade.setSelectedIndex(0);
        this.cbUnd.setSelectedIndex(0);
        this.cbEmpresa.setSelectedIndex(0);
        this.cbCurso.setSelectedIndex(0);
      }else{
        rs = this.taluno.Ler_Aluno(Rotinas.Parametros.getCod_aluno(), 1);
        if (rs != null){
          rs.first();
          this.jCod.setText(rs.getString("COD_ALUNO"));
          this.jNome.setText(rs.getString("NOM_ALUNO"));
          this.jEnd.setText(rs.getString("ENDERECO"));
          this.jFone.setText(rs.getString("FONE"));
          this.jRg.setText(rs.getString("RG"));
          this.jCpf.setText(rs.getString("CPF"));
          this.jObs.setText(rs.getString("OBS"));
          this.jValor.setText(rs.getString("PRECO"));
          this.jValor_ext.setText(rs.getString("PRECO_EXTENSO"));
          this.jPai.setText(rs.getString("NOME_PAI"));
          this.jMae.setText(rs.getString("NOME_MAE"));
          this.jDt_Vig.setText(this.cons.dataexibe(rs.getString("DATA_CAD")));
          this.jDt_Cad.setText(this.cons.dataexibe(rs.getString("DATA_FIM")));
          Atualiza_Cidade(rs.getString("COD_CIDADE"));
          Atualiza_Und(rs.getString("COD_UND"));
          Atualiza_Empresa(rs.getString("COD_EMPRESA"));
          Atualiza_Curso(rs.getString("COD_CURSO"));
        }
      }
    }catch (SQLException ex){
      Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
  }
    
    /**
     * Creates new form NewJFrame
     */
    public Alunos() {
        initComponents();
        Atualiza_Aluno();
        Atualiza_Cidade("0");
        Atualiza_Curso("0");
        Atualiza_Empresa("0");
        Atualiza_Und("0");
        
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
        jSeparator1 = new javax.swing.JSeparator();
        btPesq_Av = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbAluno = new javax.swing.JComboBox<>();
        btPesq = new javax.swing.JButton();
        jPesquisa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCod = new javax.swing.JLabel();
        jNome = new javax.swing.JTextField();
        jEnd = new javax.swing.JTextField();
        jFone = new javax.swing.JTextField();
        jRg = new javax.swing.JTextField();
        jCpf = new javax.swing.JTextField();
        jObs = new javax.swing.JTextField();
        jValor = new javax.swing.JTextField();
        jValor_ext = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jDt_Cad = new javax.swing.JLabel();
        jPai = new javax.swing.JTextField();
        jMae = new javax.swing.JTextField();
        jDt_Vig = new javax.swing.JTextField();
        cbCidade = new javax.swing.JComboBox<>();
        cbUnd = new javax.swing.JComboBox<>();
        cbEmpresa = new javax.swing.JComboBox<>();
        cbCurso = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        btVoltar = new javax.swing.JButton();
        btAnterior = new javax.swing.JButton();
        btProximo = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btPesq_Av.setText("Pesquisa Avançada");
        btPesq_Av.setNextFocusableComponent(cbAluno);

        jLabel1.setText("Nome:");

        jLabel2.setText("Código:");

        cbAluno.setNextFocusableComponent(jPesquisa);

        btPesq.setText("Pesquisar");
        btPesq.setNextFocusableComponent(jNome);
        btPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesqActionPerformed(evt);
            }
        });

        jPesquisa.setNextFocusableComponent(btPesq);

        jLabel3.setText("Código:");

        jLabel4.setText("Nome:");

        jLabel5.setText("Endereço:");

        jLabel6.setText("Fone:");

        jLabel7.setText("RG:");

        jLabel8.setText("CPF:");

        jLabel9.setText("Observação:");

        jLabel10.setText("Valor:");

        jLabel11.setText("R$");

        jCod.setText("00000");

        jNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jNome.setNextFocusableComponent(jEnd);

        jEnd.setNextFocusableComponent(jFone);

        jFone.setNextFocusableComponent(jRg);

        jRg.setNextFocusableComponent(jCpf);

        jCpf.setNextFocusableComponent(jObs);

        jObs.setNextFocusableComponent(jValor);

        jValor.setNextFocusableComponent(jValor_ext);

        jValor_ext.setNextFocusableComponent(jPai);

        jLabel13.setText("Nome do Pai:");

        jLabel14.setText("Nome da Mãe:");

        jLabel15.setText("Data de Cadastro:");

        jLabel16.setText("Vigência:");

        jLabel17.setText("Cidade:");

        jLabel18.setText("Und. Escolar:");

        jLabel19.setText("Empresa:");

        jLabel20.setText("Cursos:");

        jPai.setNextFocusableComponent(jMae);

        jMae.setNextFocusableComponent(jDt_Vig);

        jDt_Vig.setNextFocusableComponent(cbCidade);

        cbCidade.setNextFocusableComponent(cbUnd);

        cbUnd.setNextFocusableComponent(cbEmpresa);

        cbEmpresa.setNextFocusableComponent(cbCurso);

        cbCurso.setNextFocusableComponent(btVoltar);

        btVoltar.setText("VOLTAR");
        btVoltar.setNextFocusableComponent(btAnterior);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        btVoltar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btVoltarKeyPressed(evt);
            }
        });

        btAnterior.setText("ANTERIOR");
        btAnterior.setEnabled(false);
        btAnterior.setNextFocusableComponent(btProximo);

        btProximo.setText("PRÓXIMO");
        btProximo.setEnabled(false);
        btProximo.setNextFocusableComponent(btLimpar);

        btLimpar.setText("LIMPAR");
        btLimpar.setNextFocusableComponent(btGravar);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btGravar.setText("GRAVAR");
        btGravar.setNextFocusableComponent(btAlterar);
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btAlterar.setText("ALTERAR");
        btAlterar.setNextFocusableComponent(btExcluir);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("EXCLUIR");
        btExcluir.setNextFocusableComponent(btPesq_Av);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btPesq_Av)
                        .addGap(308, 308, 308)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesq))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCod)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jValor, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jValor_ext, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jNome)
                            .addComponent(jEnd)
                            .addComponent(jFone)
                            .addComponent(jRg)
                            .addComponent(jCpf)
                            .addComponent(jObs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbUnd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCurso, 0, 299, Short.MAX_VALUE)
                            .addComponent(jDt_Vig)
                            .addComponent(jDt_Cad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jMae)
                            .addComponent(jPai)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btVoltar)
                        .addGap(43, 43, 43)
                        .addComponent(btAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btProximo)
                        .addGap(43, 43, 43)
                        .addComponent(btLimpar)
                        .addGap(43, 43, 43)
                        .addComponent(btGravar)
                        .addGap(43, 43, 43)
                        .addComponent(btAlterar)
                        .addGap(43, 43, 43)
                        .addComponent(btExcluir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btPesq_Av))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btPesq)
                            .addComponent(jPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCod, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jDt_Cad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jDt_Vig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbUnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(cbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValor_ext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btAnterior)
                    .addComponent(btProximo)
                    .addComponent(btLimpar)
                    .addComponent(btGravar)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addContainerGap(33, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btVoltarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btVoltarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btVoltarActionPerformed(null);
        }
    }//GEN-LAST:event_btVoltarKeyPressed

    private void btPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesqActionPerformed
        ResultSet rs;
        if("".equals(this.jPesquisa.getText())){
            rs = this.taluno.Ler_Aluno(this.cbAluno.getSelectedItem().toString(), 1);
        }else{
            rs = this.taluno.Ler_Aluno(this.jPesquisa.getText(), 1);
        }
        if(rs !=null){
            try{
                rs.first();
                this.jCod.setText(rs.getString("COD_ALUNO"));
                this.jNome.setText(rs.getString("NOM_ALUNO"));
                this.jRg.setText(rs.getString("RG"));
                this.jCpf.setText(rs.getString("CPF"));
                this.jFone.setText(rs.getString("FONE"));
                this.jEnd.setText(rs.getString("ENDERECO"));
                this.jObs.setText(rs.getString("OBS"));
                this.jValor.setText(rs.getString("PRECO"));
                this.jValor_ext.setText(rs.getString("PRECO_EXTENSO"));
                this.jPai.setText(rs.getString("NOME_PAI"));
                this.jMae.setText(rs.getString("NOME_MAE"));
                this.jDt_Cad.setText(this.cons.dataexibe(rs.getString("DATA_CAD")));
                this.jDt_Vig.setText(this.cons.dataexibe(rs.getString("DATA_FIM")));
                Atualiza_Cidade(rs.getString("COD_CIDADE"));
                Atualiza_Empresa(rs.getString("COD_EMPRESA"));
                Atualiza_Und(rs.getString("COD_UND"));
                Atualiza_Curso(rs.getString("COD_CURSO"));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO.", "Informacao", 1);
            }
        }else{
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO.", "Informacao", 1);
        }
    }//GEN-LAST:event_btPesqActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        Parametros.setCod_aluno("0");
        this.taluno.Apagar_Aluno(this.jCod.getText());
        Atualiza_Aluno();
        Atualiza_Cidade("0");
        Atualiza_Curso("0");
        Atualiza_Empresa("0");
        Atualiza_Und("0");
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        Parametros.setCod_aluno("0");
        Atualiza_Aluno();
        Atualiza_Cidade("0");
        Atualiza_Curso("0");
        Atualiza_Empresa("0");
        Atualiza_Und("0");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        Parametros.setCod_aluno("0");
        Grava_Altera_Aluno("grava");
    }//GEN-LAST:event_btGravarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if(!"00000".equals(this.jCod.getText())){
            Parametros.setCod_aluno("0");
            Grava_Altera_Aluno("altera");
        }else{
            JOptionPane.showMessageDialog(null, "SELECIONE O ALUNO A SER ALTERADO", "Informacao", 1);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private String getDate(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        return df.format(date);
    }
    
    private void Grava_Altera_Aluno(String teste){
        if(!"".equals(this.jRg.getText())){
            if(!"".equals(this.cbUnd.getSelectedItem().toString())){
                if(!"".equals(this.cbEmpresa.getSelectedItem().toString())){
                    if(!"".equals(this.cbCurso.getSelectedItem().toString())){
                        if(!"".equals(cbCidade.getSelectedItem().toString())){
                            if(!"".equals(this.jValor.getText())){
                                if(("00000".equals(this.jCod.getText()))|| ("altera".equals(teste))){
                                    if(!"  /  /    ".equals(this.jDt_Vig.getText())){
                                        if(!"   .   .   -  ".equals(this.jCpf.getText())){
                                            if(!"  .   .   - ".equals(this.jRg.getText())){
                                                if(!"".equals(this.jNome.getText())){
                                                    if(this.cons.isCPF(this.cons.desmascaraCpf(this.jCpf.getText()))){
                                                        String cod = this.jCod.getText();
                                                        String nome = this.jNome.getText();
                                                        String rg = this.jRg.getText();
                                                        String cpf = this.cons.desmascaraCpf(this.jCpf.getText());
                                                        String endereco = this.jEnd.getText();
                                                        String fone = this.cons.desmascaraTel(this.jFone.getText());
                                                        String obs = this.jObs.getText();
                                                        String valor = this.cons.corrige_valor(this.jValor.getText());
                                                        String valor_ext = this.jValor_ext.getText();
                                                        String pai = this.jPai.getText();
                                                        String mae = this.jMae.getText();
                                                        String data = this.cons.databanco(this.jDt_Cad.getText());
                                                        String data_fim = this.cons.databanco(this.jDt_Vig.getText());
                                                        String cidade = this.cbCidade.getSelectedItem().toString();
                                                        String empresa = this.cbEmpresa.getSelectedItem().toString();
                                                        String und = this.cbUnd.getSelectedItem().toString();
                                                        String curso = cbCurso.getSelectedItem().toString();
                                                        this.taluno.Grava_Altera_Aluno(cod, und, endereco, fone, rg, cpf, obs, valor, valor_ext, pai, mae, data_fim, data_fim, cidade, und, curso, empresa, teste);
                                                        Atualiza_Aluno();
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "CPF INVÁLIDO", "Informacao", 1);
                                                    }
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "PREENCHA O NOME", "Informacao", 1);  
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "PREENCHA O RG", "Informacao", 1);
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "PREENCHA CPF", "Informacao", 1);
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "VIGÊNCIA", "Informacao", 1);
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "ALUNO JÁ CADASTRADO", "Informacao", 1);
                                }
                        }else{
                                JOptionPane.showMessageDialog(null, "FALTA VALOR", "Informacao", 1);
                            }
                    }else{
                            JOptionPane.showMessageDialog(null, "SELECIONE UMA CIDADE", "Informacao", 1);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "SELECIONE UM CURSO", "Informacao", 1);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "SELECIONE UMA EMPRESA", "Informacao", 1);
                }
            }else{
                JOptionPane.showMessageDialog(null, "SELECIONE UMA UNIDADE DE ENSINO", "Informacao", 1);
            }
        }else{
            JOptionPane.showMessageDialog(null, "UM RG DEVE SER CADASTRADO", "Informacao", 1);
        }
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
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btAnterior;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesq;
    private javax.swing.JButton btPesq_Av;
    private javax.swing.JButton btProximo;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbAluno;
    private javax.swing.JComboBox<String> cbCidade;
    private javax.swing.JComboBox<String> cbCurso;
    private javax.swing.JComboBox<String> cbEmpresa;
    private javax.swing.JComboBox<String> cbUnd;
    private javax.swing.JLabel jCod;
    private javax.swing.JTextField jCpf;
    private javax.swing.JLabel jDt_Cad;
    private javax.swing.JTextField jDt_Vig;
    private javax.swing.JTextField jEnd;
    private javax.swing.JTextField jFone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jMae;
    private javax.swing.JTextField jNome;
    private javax.swing.JTextField jObs;
    private javax.swing.JTextField jPai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPesquisa;
    private javax.swing.JTextField jRg;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jValor;
    private javax.swing.JTextField jValor_ext;
    // End of variables declaration//GEN-END:variables
}
