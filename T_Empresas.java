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
public class T_Empresas {
    Tarefas_banco tar = new Tarefas_banco();
    
    public void Grava_Empresa(String razao,String fantasia,String cnpj,String ie,String im,String fone,String endereco,String obs,String cod_cidade){
        try {
            this.tar.AbreConexao();
            String sql = "insert into tb_empresas values (0,'+razao+','+fantasia+','+cnpj+','+ie+','+im+','+fone+','+endereco+','+obs+','+cod_cidade+')";
            int rs = this.tar.getSt().executeUpdate(sql);
            this.tar.FechaConexao();
            JOptionPane.showMessageDialog(null, "EMPRESA CADASTRADA COM SUCESSO!", "Informacao", 1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR OS DADOS NO BANCO!", "Informacao", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA GRAVAÇÃO", "Informacao", 1);
        }
    }
    public void Alterar_Empresa(String cod, String razao,String fantasia,String cnpj,String ie,String im,String fone,String endereco,String obs,String cod_cidade){
        try {
            this.tar.AbreConexao();
            String sql = "update tb_empresas set razao_emresa ='"+razao+"', nome_empresa = '"+fantasia+"', cnpj_empresa ='"+cnpj+"', ie_empresa ='"+ie+"',im_empresa = '"+im+"', fone_empresa = '"+fone+"'.end_empresa='"+endereco+"', obs_empresa ='"+obs+"', cod_cidade ='"+cod_cidade+"' where cod_emrpesa ='"+cod+"'";
            int rs = this.tar.getSt().executeUpdate(sql);
            this.tar.FechaConexao();
            JOptionPane.showMessageDialog(null, "EMPRESA ALTERADA COM SUCESSO!", "Informacao", 1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR OS DADOS NO BANCO!", "Informacao", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA ALTERAÃO", "Informacao", 1);
        }
    }
    public ResultSet Ler_Empresa(){
        try {
            this.tar.AbreConexao();
            String sql = "select * from tb_empresas order by nome_empresa";
            return this.tar.getSt().executeQuery(sql);
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        this.tar.FechaConexao();
        return null;
    }
    public ResultSet Ler_Empresa(String empresa, int teste){    
        try {
            this.tar.AbreConexao();
            String sql;
            if(teste == 1){
                sql = "select * from tb_empresas where razao_empresa = '"+empresa+"' or cod_empresa ='" +empresa+ "' or cnpj_empresa ='" +empresa + "'";
            } else {
                if(teste == 2){
                    sql = "select * from tb_empresas where cod_empresa >'"+empresa+"'";
                } else {
                    sql = "select * from tb_empresas where cod_empresa <'"+empresa+"'";
                }
                return this.tar.getSt().executeQuery(sql);
            }
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        }
        this.tar.FechaConexao();
        return null;
    }
    public void Apagar_empresa(String cod_empresa){     
        try {
            if (!"00000".equals(cod_empresa)) {
                this.tar.AbreConexao();
                String sql = "delete from tb_empresas where cod_empresa ='" + cod_empresa + "'";
                int rs = this.tar.getSt().executeUpdate(sql);
                this.tar.FechaConexao();
                JOptionPane.showMessageDialog(null, "REGISTRO EXCLUIDO COM SUCESSO", "Informacao", 1);
            } else {
                JOptionPane.showMessageDialog(null, "SELECIONE A EMPRESA A SER EXCLUÍDA", "Informacao", 1);
            }
        } catch (IOException ex) {            
            JOptionPane.showMessageDialog(null, "NENHUM REGISTRO ENCONTRADO", "Informacao", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO SEM PREMISSÃO PARA EXCLUSÃO!", "Informacao", 1);
        }
    }
    
}
