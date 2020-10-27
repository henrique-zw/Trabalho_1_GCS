/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Colecoes.ListaMoradores;
import Entities.Operador;

/**
 *
 * @author johnb
 */
public class OperadorTest {
    public static void gerarRelatorio() {
        String test = "Gerar Relatorio - ";
        try {
            Operador currOperador = Test.currOperador;
            
            String target = currOperador.getRelatorio("01/01/2000", "12/12/2020");
            if(target != null && target.length() > 0){
                System.out.println(test + "Retorno da string com listagem: OK");
            } else {
                System.out.println(test + "Retorno da string com listagem: FAIL");
            }
        } catch (Exception e) {
            System.out.println(test + "ERROR\n" + e.getMessage() + "\n" + e.getStackTrace());
        }
    }
}
