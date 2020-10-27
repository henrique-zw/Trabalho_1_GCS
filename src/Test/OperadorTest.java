/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entities.Entrega;
import Entities.Operador;
import Populadores.PopuladorOperadores;
import java.util.List;

/**
 *
 * @author johnb
 */
public class OperadorTest {
    public static void registrarEntrega() {
        String test = "Registrar Entrega - ";
        try {
            Operador currOperador = Test.currOperador;
            
            Integer apto = 12;
            String desc = "A bcdef ghijk lm";
            if(currOperador.registraEntrega(apto, desc)){
                System.out.println(test + "Teste com valor válido: OK");
            } else {
                System.out.println(test + "Teste com valor válido: FAIL");
            }
            
            apto = 0;
            desc = "A bcdef ghijk lm A bcdef ghijk lm A bcdef ghijk lm";
            if(currOperador.registraEntrega(apto, desc)){
                System.out.println(test + "Teste com valor inválido: FAIL");
            } else {
                System.out.println(test + "Teste com valor inválido: OK");
            }
        } catch (Exception e) {
            System.out.println(test + "ERROR\n" + e.getMessage() + "\n" + e.getStackTrace());
        }
    }
    
    public static void procuraEntregaPorDescricao() {
        String test = "Procura Entrega por Descricao - ";
        try {
            Operador currOperador = Test.currOperador;
            
            if (!currOperador.registraEntrega(12, "A bcdef ghij")) {
                System.out.println(test + "Registro de Entrega: FAIL");
            } else {
                System.out.println(test + "Registro de Entrega: OK");
                
                List<Entrega> target = currOperador.procuraEntregaPorDescricao("A bcdef ghij");
                if(target != null){
                    System.out.println(test + "Teste com valor válido: OK");
                } else {
                    System.out.println(test + "Teste com valor válido: FAIL");
                }

                target = currOperador.procuraEntregaPorDescricao("A bcdef ghijk lm A bcdef ghijk lm A bcdef ghijk lm");
                if(target != null){
                    System.out.println(test + "Teste com valor inválido: FAIL");
                } else {
                    System.out.println(test + "Teste com valor inválido: OK");
                }
            }
        } catch (Exception e) {
            System.out.println(test + "ERROR\n" + e.getMessage() + "\n" + e.getStackTrace());
        }
    }
    
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
