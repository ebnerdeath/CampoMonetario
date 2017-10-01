/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacao;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Usuario
 */
public class CampoMonetario extends PlainDocument {
    
     @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{    
        super.insertString(offset, str.replaceAll("[^0-9|^,|^R$ ]",""), attr);   
    }    
 
    public void replace(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{    
        super.insertString(offset, str.replaceAll("[^0-9|^,|^R$ ]",""), attr);   
    }
    
    //ESSE MÉTODO FAZ A VERIFICAÇÃO DE UM CAMPO MONETÁRIO E RETORNA TRUE OU FALSE CASO O CAMPO ESTEJA TUDO CERTO
    public  boolean verificaVirgulas(String valor){
        int contador = 0;//CONTADOR DAS VIRGULAS
        int tamanhoString = valor.length();//VARIÁVEL QUE RECEBE O TAMANHO DA STRING
        int indiceVirgula = -1;//VARIÁVEL QUE RECEBE SE TIVER QUAL É O ÍNDICE DA STRING QUE A VÍRGULA ESTÁ
        int casasdecimais = 0;
        
        if(!valor.equals("")){//SE O CAMPO NÃO FOR VAZIO
            //CONTANDO AS VÍRGULAS
            for(int i=0;i<tamanhoString;i++){//ESSE FOR PERCORRE MINHA STRING CARACTERE POR CARACTERE
                if(valor.charAt(i) == ','){//SE NO ÍNDICE DO FOR TIVER UMA VÍRGULA
                    contador++;//INCREMENTA NO CONTADOR
                    indiceVirgula = i;//A VARIÁVEL INDICEVIRGULA RECEBE O INDICE DA STRING QUE ESTÁ A NOSSA VÍRGULA
                }
            }
            //APÓS CAPTURAR OS DADOS DEPENDENDO DA STRING, VAMOS AS VALIDAÇÕES
            if(contador<2){//SE NÃO EXISTE VÍRGULA OU SE EXISTE SOMENTE 1 VÍRGULA, ENTRA NO IF...
                if(indiceVirgula!= -1){//SE CONTER VÍRGULA NA NOSSA STRING
                    casasdecimais =(tamanhoString-1)-indiceVirgula;//A VARIÁVEL CASAS DECIMAIS RECEBE QUANTAS CASAS DECIMAIS TEM APÓS A VÍRGULA
                }
   
                if(indiceVirgula == 0 || indiceVirgula==tamanhoString -1){//SE A VÍRGULA ESTIVER NO PRIMEIRO OU ÚLTIMO ÍNDICE DA STRING EX: ,150 OU 150, ISSO É UM VALOR FALSO
                    return false; //ENTÃO NOSSA FUNÇÃO RETORNA FALSO.
                }else if(casasdecimais > 2 || casasdecimais == 1){//SE O NÚMERO DE CASAS DECIMAIS FOR MAIOR QUE 2 OU FOR IGUAL A 1 É UM VALOR INVÁLIDO
                    return false;//RETORNA FALSO
                }else{//SE NÃO
                    return true;//RETORNA VERDADEIRO
                }
            }else{//SE CONTER MAIS QUE 1 VÍRGULA NA STRING
                return false;//RETORNA FALSO
            }
        }else{//SE O CAMPO FOR VAZIO
            return false;//RETORNA FALSO
        }
    }
}
