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
public class T_Cidade {
    Tarefas_banco tarefas = new Tarefas_banco();
    
    public void Gravar_Cidade(String cidade){
        try {
            this.tarefas.AbreConexao();
            String sql = "insert into tb_cidades values(0, '"+cidade+"')";
            int rs = this.tarefas.getSt().executeUpdate(sql);
            this.tarefas.FechaConexao();
            JOptionPane.showMessageDialog(null, "CIDADE CADASTRADA COM SUCESSO!", "Informcao", 1);
        } catch (IOException ex) {
            Logger.getLogger(Tarefas_banco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA GRAVAÇÃO!", "Informacao", 1);
        }
    }
    
    public void Altera_Cidade(String cod, String cidade){
        try {
            if (!"00000".equals(cod)) {
                this.tarefas.AbreConexao();
                String sql = "update tb_cidades set nome_cidade = '" + cidade + "' where cod_cidade ='" + cod + "'";
                
                int rs = this.tarefas.getSt().executeUpdate(sql);
                this.tarefas.FechaConexao();
                JOptionPane.showMessageDialog(null, "CIDADE ALTERADA COM SUCESSO!", "Informcao", 1);
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONE A CIDADE A SER ALTERADA", "Informacao", 1);
            }
        } catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR OS DADOS DO BANCO", "Informacao", 1);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA ALTERAÇÃO!", "Informacao", 1);
        }
    }
    
    public ResultSet Ler_Cidade(){
        try {
            this.tarefas.AbreConexao();
            String sql = "select * from tb_cidades order by nome_cidade";
            return this.tarefas.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO.", "Informacao", 1);
        }
        try {
            this.tarefas.FechaConexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR CONEXÃO COM O BANCO DE DADOS", "Informacao", 1);
        }
        return null;
    }
    
    public ResultSet Ler_Cidade(String cidade, int teste){
        try {
            this.tarefas.AbreConexao();
            String sql;
            if(teste ==1){
                sql = "select * from tb_cidade where nome_cidade ='"+cidade+"' or cod_cidade ='"+cidade+"'";
            } else {
                if(teste == 2){
                    sql = "select * from tb_cidades where cod_cidade > '"+cidade+"'";
                } else {
                    sql = "select * from tb_cidades where cod_cidade < '"+cidade+"'";
                }
                return this.tarefas.getSt().executeQuery(sql);
            }
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        try {
            this.tarefas.FechaConexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR O BANCO DE DADOS", "Informcao", 1);
        }
        return null;
    }
    
    public void Apagar_Cidade(String cod_cidade){
        try {
            if (!"00000".equals(cod_cidade)) {
                this.tarefas.AbreConexao();
                String sql = "delete from tb_cidade where cod_cidade = '" + cod_cidade + "'";
                int rs = this.tarefas.getSt().executeUpdate(sql);
                this.tarefas.FechaConexao();
                JOptionPane.showMessageDialog(null, "CIDADE EXCLUIDA COM SUCESSO", "Informacao", 1);
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONE A CIDADE A SER EXCLUIDA.", "Informacao", 1);
            }
        } catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO.", "Informacao", 1);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA EXCLUSÃO!", "Informacao", 1);
        }
    }
}