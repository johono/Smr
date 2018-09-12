/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rotinas;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.alves
 */
public class T_Aluno {
    Tarefas_banco tarefas = new Tarefas_banco();
    T_Cidade tcidade = new T_Cidade();
    T_Curso tcurso = new T_Curso();
    T_Empresas tempresa = new T_Empresas();
    T_UndEnsino tund = new T_UndEnsino();
    
    public void Grava_Altera_Aluno(String cod, String aluno, String endereco, String fone, String rg, String cpf,
            String obs, String valor, String valor_ext, String pai, String mae, String data_ini, String data_fim,
            String cidade, String und, String curso, String empresa, String teste){
        String cod_cidade;
        String cod_empresa;
        String cod_und;
        String cod_curso;
        String cod_preco = null;
        
        try{
            ResultSet rs1 = this.tcidade.Ler_Cidade(cidade);
            rs1.first();
            cod_cidade = rs1.getString("COD_CIDADE");
            
            ResultSet rs2 = this.tempresa.Ler_Empresa(empresa);
            rs2.first();
            cod_empresa = rs2.getString("COD_EMPRESA");
            
            ResultSet rs3 = this.tund.Ler_UndEnsino(und);
            rs3.first();
            cod_und = rs3.getString("COD_UND");
            
            ResultSet rs4 = this.tcurso.Ler_Curso(curso);
            rs4.first();
            cod_curso = rs4.getString("COD_CURSO");
            
            this.tarefas.AbreConexao();
            
            String sql1 = "select cod_preco, preco_extenso from tb_precos where preco='"+valor+"' and cod_cidade='"+cod_cidade+"' and cod_empresa='"+cod_empresa+"'";
            ResultSet rs5 = this.tarefas.getSt().executeQuery(sql1);
            
            while(rs5.next()){
                if(rs5.getString("preco").equals(valor)){
                    cod_preco = rs5.getString("cod_preco");
                }
            }
            int rs8;
            if("".equals(cod_preco)){
                String sql2 = "insert into tb_precos values(0,'"+cod_cidade+"','"+cod_empresa+"','"+valor+"','"+valor_ext+"')";
                
                int rs6 = this.tarefas.getSt().executeUpdate(sql2);
                rs5 = this.tarefas.getSt().executeQuery(sql1);
                rs5.first();
                cod_preco = rs5.getString("cod_preco");
            }else{
                String sql0 = "update tb_precos set preco_extenso ='"+valor_ext+"' where cod_preco ='"+cod_preco+"'";
                rs8 = this.tarefas.getSt().executeUpdate(sql0);
            }
            
            String sql3 = "";
            if("grava".equals(teste)){
                sql3 = "insert into tb_alunos values (0, '"+aluno+"', '"+endereco+"','" +fone+"','"+rg+"','"+ cpf+"', '"+obs+"', '"+cod_preco+"', '"+pai+"', '"+mae+"', '"+data_ini+"','"+data_fim+"','"+cod_cidade+"','"+cod_und+"','"+cod_curso+"','"+cod_empresa+"')";
            } else {
                sql3 = "update tb_alunos set nom_aluno = '"+aluno+"',endereco='"+endereco+"',fone='" +fone+"',rg='"+rg+"',cpf='"+ cpf+"',obs= '"+obs+"', cod_preco='"+cod_preco+"',nome_pai= '"+pai+"',nome_mae= '"+mae+"',data_cad= '"+data_ini+"',data_fim='"+data_fim+"',cod_cidade='"+cod_cidade+"',cod_und='"+cod_und+"',cod_curso ='"+cod_curso+"',cod_empresa='"+cod_empresa+"' where cod_aluno ='"+cod+"')";
            }
            int rs7 = this.tarefas.getSt().executeUpdate(sql3);
            this.tarefas.FechaConexao();
            if("grava".equals(teste)){
                JOptionPane.showMessageDialog(null, "ALUNO CADASTRADO COM SUCESSO", "Informacao", 1);
            } else {
                JOptionPane.showMessageDialog(null, "ALUNO ALTERADO COM SUCESSO!", "Informacao", 1);
            }
            this.tarefas.FechaConexao();
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA GRAVAÇÃO", "Informacao", 1);
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR OS DADOS NO BANCO DE DADOS", "Informacao", 1);
        }
    }
    
    public ResultSet Ler_Aluno(){
        try{
            this.tarefas.AbreConexao();
            try{
                String sql = "select * from tb_alunos order by nom_aluno";
                return this.tarefas.getSt().executeQuery(sql);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
                try {
                    this.tarefas.FechaConexao();
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR A CONEXAO COM O BANCO", "Informacao", 1);
                }
                return null;
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(T_Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet Ler_Aluno(String aluno){
        try {
            this.tarefas.AbreConexao();
            String sql;
            
                sql = "select * from vw_alunos where NOM_ALUNO ='"+aluno+"' or COD_ALUNO='"+aluno+"'";
                
               
                return this.tarefas.getSt().executeQuery(sql);
           
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        
        }
        try {
            this.tarefas.FechaConexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR A CONEXAO COM O BANCO", "Informacao", 1);
        }
        return null;
    }
    
    public ResultSet Ler_Aluno_Pesq(String campo, String nome){
        try {
            this.tarefas.AbreConexao();
            String sql = "select cod_aluno, nom_aluno from tb_alunos where "+campo+" like '%"+nome+"%' order by nom_aluno;";
            return this.tarefas.getSt().executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
            this.tarefas.FechaConexao();
            
            
        } catch (IOException ex) {
            Logger.getLogger(T_Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
}
    
    public void Apagar_Aluno(String cod_aluno){
        try{
            if(!"00000".equals(cod_aluno)){
            this.tarefas.AbreConexao();
            String sql = "delete from tb_alunos where cod_aluno ='"+cod_aluno+"'";
            int rs = this.tarefas.getSt().executeUpdate(sql);
            this.tarefas.FechaConexao();
            JOptionPane.showMessageDialog(null, "REGISTRO EXCLUIDO COM SUCESSO!", "Informacao", 1);
        } else {
                JOptionPane.showMessageDialog(null, "SELECIONE O ALUNO A SER EXCLUIDO", "Informacao", 1);
            }
    }   catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUARIO NAO TEM PERMISSÃO PARA EXCLUSÃO!", "Informacao", 1);
        }
}
}
