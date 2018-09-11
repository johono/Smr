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
public class Parametros {
    
    private static String driver = "com.mysql.jdbc.Driver";
    private static String banco = "smreembolso";
    private static String host;
    private static String st_con;
    private static String usuario = "46";
    private static String senha = "46";
    private static String dirrel = "C:\\Program Files\\SMReembolso\\";
    
    private static String cod_aluno;

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String aDriver) {
        driver = aDriver;
    }

    public static String getBanco() {
        return banco;
    }

    public static void setBanco(String aBanco) {
        banco = aBanco;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String aHost) {
        host = aHost;
    }

    public static String getSt_con() {
        st_con = "jdbc:mysql://" + host + ":3306/" + banco;
        return st_con;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String aSenha) {
        senha = aSenha;
    }

    public static String getDirrel() {
        return dirrel;
    }

    public static void setDirrel(String aDirrel) {
        dirrel = aDirrel;
    }

    public static String getCod_aluno() {
        return cod_aluno;
    }

    public static void setCod_aluno(String cod_aluno) {
        cod_aluno = cod_aluno;
    }
    
    
}
