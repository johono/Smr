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
public class T_UndEnsino {
    Tarefas_banco tarefas = new Tarefas_banco();
    
    public void Grava_UndEnsino(String und){
        try {
            this.tarefas.AbreConexao();
            String sql = "insert into tb_undensino values(0, '" + und +"')";
            int rs = this.tarefas.getSt().executeUpdate(sql);
            this.tarefas.FechaConexao();
            JOptionPane.showMessageDialog(null, "UNIDADE DE ENSINO CADASTRADA COM SUCESSO", "Informacao", 1);
        } catch (IOException ex) {
            Logger.getLogger(Tarefas_banco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA GRAVAÇÃO!", "Informacao", 1);
        }
    }
    
    public void Altera_Und(String cod, String und){
        try {            
            if(!"00000".equals(cod)){            
                this.tarefas.AbreConexao();
                String sql = "update tb_undensino set nome_und='"+ und + "' where cod_und ='"+ cod +"'";
                int rs = this.tarefas.getSt().executeUpdate(sql);
                this.tarefas.FechaConexao();
                JOptionPane.showMessageDialog(null, "UNIDADE DE ENSINO ALTERADA COM SUCESSO", "Informacao", 1);
            }else{
                    JOptionPane.showMessageDialog(null, "SELECIONE A UNIDADE DE ENSINO A SER ALTERADA", "Informacao", 1);                   
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR OS DADOS DO BANCO!", "Informacao", 1);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA GRAVAÇÃO", "Informacao", 1);
            }
        }
    
    public ResultSet Ler_UndEnsino(){
        try {
            this.tarefas.AbreConexao();
            String sql = "select * from tb_undensino order by nome_und";
            return this.tarefas.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO.", "Informacao", 1);
        }
        this.tarefas.FechaConexao();
        return null;
    }
    
    public ResultSet Ler_UndEnsino(String und){
        try {
            this.tarefas.AbreConexao();
            String sql;
                sql = "select * from tb_undensino where nome_und = '"+und+"' or cod_und = '"+und+"'";
        
            return this.tarefas.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        this.tarefas.FechaConexao();
        return null;
        }
    
    public void Apagar_UndEnsino(String cod_und){
        try {
            if (!"00000".equals(cod_und)) {
                this.tarefas.AbreConexao();
                String sql = "delete from tb_undensino where cod_und = '" + cod_und + "'";
                int rs = this.tarefas.getSt().executeUpdate(sql);
                this.tarefas.FechaConexao();
                JOptionPane.showMessageDialog(null, "REGISTRO EXCLUÍDO COM SUCESSO.", "Informacao", 1);
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONE A UNIDADE DE ENSINO A SER EXCLUIDA.", "Informacao", 1);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO IOException - " + ex, "Informacao", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUARIO NÃO TEM PERMISSÃO PARA EXCLUSÃO!", "Informcao", 1);
        }
    }
    }