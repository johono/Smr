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
public class T_Usuarios {
    Tarefas_banco t = new Tarefas_banco();
    Parametros p = new Parametros();
    
    public void Grava_Usuario(String usuario, String senha, String confirma, int privilegio){
        try {
            this.t.AbreConexao();
            ResultSet rs = Ler_Usuario(usuario);
            if(!rs.first()){
                String sql2 = "";
                String sql1 = "insert into tb_usuarios values(0,'"+usuario+"','"+senha+"',"+privilegio+")";
                int rs1 = this.t.getSt().executeUpdate(sql1);
                if(privilegio == 1){
                    sql2 = "grant all privileges\n on *.*\nto'"+usuario+"' identified by '"+ senha +"' \n with grant option;";
                }
                else
                {
                    sql2 = "grant select on *.* to '"+usuario+"' identified by '"+ senha+"'";
                }
                int rs2 = this.t.getSt().executeUpdate(sql2);
                int rs3 = this.t.getSt().executeUpdate("FLUSH PRIVILEGES");
                this.t.FechaConexao();
                JOptionPane.showMessageDialog(null, "USUARIO CADASTRADO COM SUCESSO!", "Informacao", 1);
            } else {
                JOptionPane.showMessageDialog(null, "USUÁRIO JÁ EXISTE NO SISTEMA", "Informacao", 1);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA GRAVAÇÃO", "Informacao", 1);
        } catch (SQLException ex) {
            Logger.getLogger(Tarefas_banco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Alterar_Usuario(String usuario, String senha, String confirma, int privilegio){
        try {
            this.t.AbreConexao();
            String sql = "update tb_usuarios set senha = '"+senha+"', permicoes = '"+privilegio+"' where login = '"+usuario+"'";
            int rs = this.t.getSt().executeUpdate(sql);
            sql = "revoke all on *.* from '" + usuario +"'@'%'";
            rs = this.t.getSt().executeUpdate(sql);
            sql = "set password for '"+usuario+"' =password('"+senha+"')";
            rs = this.t.getSt().executeUpdate(sql);
            if(privilegio == 1){
                sql = "grant all privileges on *.* to '"+usuario+"' identified by '"+senha+"' with grant option;";
            }else{
                sql = "grant select on *.* to '"+usuario+"' identified by '"+senha+"'";
            }
            rs = this.t.getSt().executeUpdate(sql);
            rs = this.t.getSt().executeUpdate("FLUSH PRIVILEGES");
            this.t.FechaConexao();
            JOptionPane.showMessageDialog(null, "USUÁRIO ALTERADO COM SUCESSO", "Informacao", 1);
        } catch (IOException ex) {
            Logger.getLogger(Tarefas_banco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA ALTERAÇÃO!", "Informacao", 1);
        }
    }

    public ResultSet Ler_Usuario(String usuario) {
        try {
            this.t.AbreConexao();
            String sql = "select * from tb_usuarios where login = '"+usuario+"'";
            return this.t.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO.", "Informacao", 1);
        }
        this.t.FechaConexao();
        return null;
    }
    public ResultSet Ler_Usuario(String usuario, String senha) {
        try {
            this.t.AbreConexao();
            String sql = "select * from tb_usuarios where login = '"+usuario+"' and senha ='"+senha+"'";
            return this.t.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO.", "Informacao", 1);
        }
        this.t.FechaConexao();
        return null;
    }
    
    public void Apagar_Usuario(String usuario){
        try {
            this.t.AbreConexao();
            ResultSet rs = Ler_Usuario(usuario);
            if(rs.first()){
                String sql1 = "delete from tb_usuarios where login ='"+usuario+"'";
                String sql2 = "drop user '"+usuario+"'";
                int rs1 = this.t.getSt().executeUpdate(sql1);
                int rs2 = this.t.getSt().executeUpdate(sql2);
                this.t.FechaConexao();
                JOptionPane.showMessageDialog(null, "USUÁRIO EXCLUÍDO COM SUCESSO.", "Informacao", 1);
            } else {
                JOptionPane.showMessageDialog(null, "USUÁRIO INEXISTENTE!", "Informacao", 1);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO.", "Informacao", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMIÇÃO DE EXCLUSÃO!", "Informacao", 1);
        }
    }
}
