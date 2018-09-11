/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rotinas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.print.PrintService;

/**
 *
 * @author jonathan.alves
 */
public class Recibo_Prefeitura {
    private static PrintService impressora;
    
    private String data_atual(){
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }
    
    public void gera_arq(String recibo, String valor, String valor_ext, String compet, String nome, String cod, String rg, String cpf, String end, String tel, String destino, String und, String curso, String emp, String data_rec){
        T_Parametros t_parametros = new T_Parametros();
        String texto = "";
        
        try {
            ResultSet rs = t_parametros.Ler_Param();
            rs.first();
            
            PrintWriter escritor = new PrintWriter(new FileWriter(Parametros.getDirrel() + "Recibo.txt"));
            
            escritor.println("");
            escritor.println("Recibo Nº:" + recibo + "             Valor:R$ " + valor);
            escritor.println("");
            escritor.println("Nome:  " + nome);
            escritor.println("");
            escritor.println("");
            escritor.println(" Recebi da PREFEITURA MUNICIPAL DE SÃO MANUEL (SP),");
            escritor.println("a importância de (" + valor_ext + ") referente ao");
            escritor.println("príodo de " + compet + "concedida pela Lei Municipal nº ");
            escritor.println(rs.getString("LEI_MUNIC") + ".'");
            escritor.println("");
            escritor.println(" São Manuel, " + data_rec);
            escritor.println("");
            escritor.println("");
            
            escritor.println("");
            escritor.println("    Assinatura:__________________________________");
            
            escritor.println("");
            escritor.println(" Código:          " + cod);
            escritor.println(" RG:              " + rg);
            escritor.println(" CPF:             " + cpf);
            escritor.println(" Endereço:        " + end);
            escritor.println(" Telefone:        " + tel);
            escritor.println(" Destino:         " + destino);
            escritor.println(" Und. de Ensino:  " + und);
            escritor.println(" Curso:           " + curso);
            escritor.println(" Empresa:         " + emp);
            escritor.println("");
            
            escritor.println("Autorizado em " + data_rec);
            escritor.println("");
            escritor.println("");
            
            escritor.println("");
            escritor.println("___________________________");
            escritor.println(rs.getString("RESPONS"));
            escritor.println("RESPONSÁVEL CONTROLE");
            
            escritor.flush();
            escritor.close();
            
            
            }catch (IOException | SQLException ex) {
            java.util.logging.Logger.getLogger(Recibo_Prefeitura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
