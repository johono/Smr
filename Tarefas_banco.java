/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rotinas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan.alves
 */
public class Tarefas_banco {
    private static Connection con;
    private static Statement st;
    
    
    public Connection getCon(){
        return con;
    }    
    public Statement getSt(){
        return st;
    }
    public void AbreConexao() throws IOException, SQLException{
        try {
            Class.forName(Parametros.getDriver());
            con = (Connection) DriverManager.getConnection(Parametros.getSt_con(), Parametros.getUsuario(), Parametros.getSenha());
            st = (Statement) getCon().createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao realizar a conexão com o banco");
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "USUÁRIO, SENHA OU SERVIDOR INCORRETO!", "Informacao", 1);
        }        
    }
    public void FechaConexao(){
        try {
            getSt().close();
            getCon().close();
        } catch (SQLException ex) {
            System.out.println("Erro ao finalizar a conexão com o banco.");
        }
    }
}
