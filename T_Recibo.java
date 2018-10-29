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
public class T_Recibo {
    Tarefas_banco tarefas = new Tarefas_banco();
    
    public void Grava_Rec(String compet_mes, String compet_ano,String cod_aluno, String data, String valor, String valor_ext){
        try {
            this.tarefas.AbreConexao();
            
            ResultSet rs1 = Ler_Param();
            rs1.first();
            String nom_pref = rs1.getString("nom_pref");
            String respons = rs1.getString("respons");
            String resp_cargo = rs1.getString("resp_cargo");
            String lei_munic = rs1.getString("lei_munic");
            ResultSet rs2 = Ler_Aluno(cod_aluno);
            String nom_aluno = rs2.getString("nom_aluno");
            String cpf = rs2.getString("cpf");
            String rg = rs2.getString("rg");
            String sql = "insert into tb_rec_pref values (0,'"+compet_mes+"','"+compet_mes+"','"+cod_aluno+"','"+data+"','"+valor+"','"+valor_ext+"','"+nom_pref+"','"+respons+"','"+resp_cargo+"','"+lei_munic+"','"+nom_aluno+"','"+rg+"','"+cpf+"')";
            
            int rs3 = this.tarefas.getSt().executeUpdate(sql);
            this.tarefas.FechaConexao();
            JOptionPane.showMessageDialog(null, "RECIBO CADASTRADO COM SUCESSO", "Informacao", 1);
        } catch (IOException ex) {
            Logger.getLogger(Tarefas_banco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUARIO NÃO TEM PERMISSÃO PARA GRAVAÇÃO", "Informacao", 1);
        }
    }
    
    public ResultSet Ler_Rec(String cod_aluno){
        try {
            this.tarefas.AbreConexao();
            String sql = "select * from vw_recibos where cod_aluno = '"+cod_aluno+"'";
            return this.tarefas.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        try {
            this.tarefas.FechaConexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR CONEXÃO COM O BANCO", "Informacao", 1);
        }
        return null;
    }
    
    public ResultSet Ler_Param(){
        try {
            this.tarefas.AbreConexao();
            String sql = "select * from tb_parametros";
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
    
    public ResultSet Ler_Aluno(String cod){
        try {
            this.tarefas.AbreConexao();
            String sql = "select nom_aluno, rg, cpf from tb_alunos where cod_aluno = '"+cod+"'";
            return this.tarefas.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        try {
            this.tarefas.FechaConexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR A CONEXAO COM O BANCO", "Informcao", 1);
        }
        return null;
    }
    
    public ResultSet Ler_Rec(String cod_aluno, String compet_mes, String compet_ano){
        try {
            this.tarefas.AbreConexao();
            String sql ="select * from tb_rec_pref where cod_aluno ='"+cod_aluno+"' and compet_rec='"+compet_mes+"' and compet_ano='"+compet_ano+"'";
            return this.tarefas.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        try {
            this.tarefas.FechaConexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR CONEXAO COM O BANCO", "Informacao", 1);
        }
        return null;
    }
}
