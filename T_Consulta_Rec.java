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
public class T_Consulta_Rec {
    Tarefas_banco taresfas = new Tarefas_banco();

    public ResultSet Ler_Rec_Aluno(String rec, String num_rec, String cod_aluno, int teste){
        try {
            this.taresfas.AbreConexao();
            String sql;
            if(teste == 1){
                sql = "select * from "+rec+" where num_rec > '"+num_rec+"' and cod_aluno ='" +cod_aluno+"' order by num_rec";
            } else{
                sql = "select * from "+rec+" where num_rec < '"+num_rec+"' and cod_aluno ='" +cod_aluno+"' order by num_rec";
            }
            
            System.out.println(sql);
            return this.taresfas.getSt().executeQuery(sql);
            
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        try {
            this.taresfas.FechaConexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR A CONEXAO COM O BANCO", "Informacao", 1);
        }
        return null;
    }
    
    public ResultSet Ler_Rec_Aluno_Com(String rec, String num_rec, String compet, int teste){
        try {
            this.taresfas.AbreConexao();
            String sql;
            if(teste == 1){
                sql = "select * from "+rec+" where num_rec > '"+num_rec+"' and compet_rec = '"+ compet+ "' order by num_rec";
            } else{
                sql = "select * from "+rec+" where num_rec < '"+num_rec+"' and compet_rec = '"+ compet+ "' order by num_rec";
            }
            return this.taresfas.getSt().executeQuery(sql);
            } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        try {
            this.taresfas.FechaConexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR A CONEXAO COM O BANCO", "Informacao", 1);
        }
        return null;
    }
    
    public ResultSet Ler_Rec_Aluno(String rec, String num_rec, String cod_aluno, String compet, int teste){
        try {
            this.taresfas.AbreConexao();
            String sql;
            if(teste == 1){
                sql = "select * from "+rec+" where num_rec >'"+num_rec+"' and cod_aluno ='"+cod_aluno+"' and compet_rec ='"+compet+"' order by num_rec";
            } else {
                sql = "select * from "+rec+" where num_rec <'"+num_rec+"' and cod_aluno ='"+cod_aluno+"' and compet_rec ='"+compet+"' order by num_rec";
            }
            return this.taresfas.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        try {
            this.taresfas.FechaConexao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR A CONEXAO COM O BANCO", "Informacao", 1);
        }
        return null;
    }
    
    public ResultSet Ler_Rec(String rec, String num_rec, int teste){
        try {
            this.taresfas.AbreConexao();
            String sql;
            if(teste == 0){
                sql = "select * from "+rec+" where num_rec = '"+num_rec+"' order by num_rec";
            } else {
                if(teste == 1){
                    sql = "select * from "+rec+" where num_rec >'"+num_rec+"' order by num_rec";
                } else {
                    sql = "select * from "+rec+" where num_rec <'"+num_rec+"' order by num_rec";
                }
            }
            return this.taresfas.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        try {
            this.taresfas.FechaConexao();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FINALIZAR A CONEXAO COM O BANCO", "Informacao", 1);
        }
        return null;
    }
    
    public void Apagar_Recibo(String rec, String num_rec){
        try {
            this.taresfas.AbreConexao();
            String sql = "delete from "+rec+" where num_rec ='"+num_rec+"'";
            int rs = this.taresfas.getSt().executeUpdate(sql);
            this.taresfas.FechaConexao();
            JOptionPane.showMessageDialog(null, "REGISTRO EXCLUIDO COM SUCESSO", "Informacao", 1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUARIO NÃO TEM PERMISSÃO PARA EXCLUASÃO", "Informacao", 1);
        }
    }
}
