/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rotinas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

/**
 *
 * @author jonathan.alves
 */
public class Consistencias {
    public boolean isCPF(String strCpf){
        int d2;
        int d1 = d2 = 0;
        int digito2; 
        int digito1 = digito2 = 0;
        
        
        for(int nCount = 1; nCount < strCpf.length() - 1; nCount++){
            int digitoCPF = Integer.parseInt(strCpf.substring(nCount -1, nCount));
            
            d1 +=(11 - nCount)* digitoCPF;
            
            d2 +=(12 - nCount)* digitoCPF;
        }
        int resto = d1 % 11;
        
        if(resto < 2){
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        
        d2 += 2* digito1;
        
        resto = d2 % 11;
        
        if(resto < 2){
            digito2 = 0;
        }else{
            digito2 = 11 - resto;
        }
        
        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());
        
        String nDigResult = String.valueOf(digito1)+String.valueOf(digito2);
        
        return nDigVerific.equals(nDigResult);
    }
    
    public boolean isCNPJ(String cnpj){
        if((cnpj.equals("00000000000000"))||(cnpj.equals("11111111111111"))||(cnpj.equals("22222222222222"))||
                (cnpj.equals("33333333333333"))||(cnpj.equals("44444444444444"))||(cnpj.equals("555555555555555"))||
                (cnpj.equals("66666666666666"))||(cnpj.equals("77777777777777"))||(cnpj.equals("88888888888888"))||
                (cnpj.equals("99999999999999"))||(cnpj.length()!=14)){
            return false;
        }
        try {
            int sm = 0;
            int peso =2;
            for(int i = 11; i>=0; i--){
                int num = cnpj.charAt(i)-'0';
                sm += num*peso;
                peso += 1;
                if(peso == 10){
                    peso = 2;
                }
            }
            int r = sm % 11;
            char dig13;
            if((r == 0) || (r == 1)){
                dig13 = '0';
            }else{
                dig13 = (char)(11-r+48);
            }
            
            sm = 0;
            peso = 2;
            for(int i = 12; i>=0; i--){
                int num = cnpj.charAt(i)-'0';
                sm += num*peso;
                peso += 1;
                if(peso == 10){
                    peso = 2;
                }
            }
            
            r = sm % 11;
            char dig14;
            if((r == 0)||(r == 1)){
                dig14 = '0';
            } else {
                dig14 = (char)(11 - r + 48);
            }
            
            if((dig13 == cnpj.charAt(12))&&(dig14 == cnpj.charAt(13))){
                return true;
            }
            return false;
        } catch (InputMismatchException erro) {
            return false;
        }
    }
    
    public String desmascaraCNPJ(String cnpj){
        if(cnpj.length() == 18){
            return cnpj.substring(0,2)+cnpj.substring(3, 6)+cnpj.substring(7, 10)+cnpj.substring(11, 15)+cnpj.substring(16, 18);
        }
        return "00000000000000";
    }
    
    public String desmascaraIE(String ie){
        if(ie.length() == 15){
            return ie.substring(0, 3)+ie.substring(4, 7)+ie.substring(8, 11)+ie.substring(12, 15);
        }
        return ie;
    }
    
    public String desmascaraTel(String tel){
        if(tel.length() == 13){
            return tel.substring(1, 3)+tel.substring(4, 8)+tel.substring(9, 13);
        }
        return tel;
    }    
    public String mascaraTel(String tel){
        if(tel.length() == 10){
            return "("+tel.substring(0, 2)+")"+tel.substring(2, 6)+"-"+tel.substring(6, 10);
        }
        return tel;
    }
    
    public String desmascaraCpf(String cpf){
        if(cpf.length() == 14){
            return cpf.substring(0, 3)+cpf.substring(4, 7)+cpf.substring(8, 11)+cpf.substring(12, 14);
        }
        return cpf;
    }
    public String mascaraCpf(String cpf){
        if(cpf.length() == 11){
            return cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9)+"-"+cpf.substring(9, 11);
        }
        return cpf;
    }
    
    public String dataexibe(String data){
        if(data.length() == 10){
            return data.substring(8, 10)+"/"+data.substring(5, 7)+"/"+data.substring(0, 4);
        }
        return data;
    }
    public String databanco(String data){
        if(data.length() == 10){
            return data.substring(6, 10)+"/"+data.substring(3, 5)+"/"+data.substring(0, 2);
        }
        return data;
    }
    public boolean testa_data(String data){
        String s = data;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            df.parse(s);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public String corrige_valor(String valor){
        String valor2="";
        StringBuilder sb = new StringBuilder();
        int teste2 = 0;
        int i = 0;
        int teste = 0;
        if(!"".equals(valor)){
            for (i = 0; i<valor.length();i++){
                int asc = valor.charAt(i);
                if((asc<48)||(asc>57)){
                    teste += 1;
                }
                if((",".equals(valor.substring(i, i+1)))||(".".equals(valor.substring(i, i+1)))){
                    valor2 = valor2+".";
                    teste-=1;
                    teste2+=1;
                } else {
                    valor2 = valor2+valor2.substring(i, i+1);
                }
            }
        }
        if((teste>0)||(teste2>1)){
            return "0";
        }
            if(teste2 == 0){
                return valor2 + "00";
            }
            return valor2;
        }
    }
    

