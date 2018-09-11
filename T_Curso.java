/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rotinas;

/**
 *
 * @author jonathan.alves
 */

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class T_Curso {

    Tarefas_banco tarefas = new Tarefas_banco();

    public void Gravar_Curso(String curso) {
        try {
            this.tarefas.AbreConexao();
            String sql = "insert into tb_cursos values(0, '" + curso + "')";
            int rs = this.tarefas.getSt().executeUpdate(sql);
            this.tarefas.FechaConexao();
            JOptionPane.showMessageDialog(null, "CIDADE CADASTRADA COM SUCESSO!", "Informcao", 1);
        } catch (IOException ex) {
            Logger.getLogger(Tarefas_banco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NÃO TEM PERMISSÃO PARA GRAVAÇÃO!", "Informacao", 1);
        }
    }

    public void Altera_Curso(String cod, String curso) {
        try {
            if (!"00000".equals(cod)) {
                this.tarefas.AbreConexao();
                String sql = "update tb_cursos set nome_curso = '" + curso + "' where cod_curso ='" + cod + "'";

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

    public ResultSet Ler_Curso() {
        try {
            this.tarefas.AbreConexao();
            String sql = "select * from tb_cursos order by nome_curso";
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

    public ResultSet Ler_Curso(String curso, int teste) {
        try {
            this.tarefas.AbreConexao();
            String sql;
            if (teste == 1) {
                sql = "select * from tb_curso where nome_curso ='" + curso + "' or cod_curso ='" + curso + "'";
            } else {
                if (teste == 2) {
                    sql = "select * from tb_cursos where cod_curso > '" + curso + "'";
                } else {
                    sql = "select * from tb_cursos where cod_curso < '" + curso + "'";
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

    public void Apagar_Curso(String cod_curso) {
        try {
            if (!"00000".equals(cod_curso)) {
                this.tarefas.AbreConexao();
                String sql = "delete from tb_curso where cod_curso = '" + cod_curso + "'";
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
