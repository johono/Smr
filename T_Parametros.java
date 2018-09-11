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
public class T_Parametros {
    Tarefas_banco tarefas = new Tarefas_banco();
    
    public void Altera_Param(String nom_pref, String respons, String resp_cargo, String lei_munic, String comp_mes, String comp_ano){
        try {
            this.tarefas.AbreConexao();
            String sql = "UPDATE tb_paramentos set nom_pref ='" + nom_pref + "',respons ='"+ respons + "', resp_cargo ='"+ resp_cargo +"', lei_munic = '"
                    + lei_munic +"', comp_mes = '"+ comp_mes + "', comp_ano ='"+ comp_ano + "' where (codigo = 1);";
            
            int rs = this.tarefas.getSt().executeUpdate(sql);
            this.tarefas.FechaConexao();
            JOptionPane.showMessageDialog(null, "PARAMETROS ALTERADOS COM SUCESSO!", "Informacao", 1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISS~]AO PARA ALTERAÇÃO!", "Informacao", 1);
        } catch (SQLException ex) {
            Logger.getLogger(T_Parametros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet Ler_Param(){
        try {
            this.tarefas.AbreConexao();
            String sql = "select * from tb_parametros;";
            return this.tarefas.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO.", "Informacao", 1);
        }
this.tarefas.FechaConexao();
        return null;
    }
}
