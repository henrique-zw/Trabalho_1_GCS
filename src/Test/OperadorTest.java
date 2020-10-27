/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Colecoes.ListaMoradores;
import Entities.Entrega;
import Entities.Morador;
import Entities.Operador;
import java.util.List;
import static java.util.Objects.isNull;

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
            System.out.println(test + "ERROR\n" + e.getMessage());
            for (StackTraceElement el: e.getStackTrace()) {
                System.out.println(el.toString());
            }
        }
    }
    
    public static void registrarRetiradaDePacote() {
        String test = "Registrar Retirada de Pacote - ";
        try {
            Operador currOperador = Test.currOperador;
            
            ListaMoradores listaMoradores = Test.listaMoradores;
            
            if (!currOperador.registraEntrega(70, "A bcdef 123")) {
                System.out.println(test + "Registro de Entrega: FAIL");
            } else {
                System.out.println(test + "Registro de Entrega: OK");
                
                Integer id = currOperador.getListaEntregas().getSize() - 1;
                
                Entrega target = currOperador.getListaEntregas().getEntrega(id);
                
                if (isNull(target)) {
                    System.out.println(test + "Procura Entrega por Id: FAIL");
                } else {
                    System.out.println(test + "Procura Entrega por Id: OK");
                    
                    Morador newMorador = new Morador("0000000012", "Maria Moradora", 70);
                    listaMoradores.addMorador(newMorador);
                    
                    Morador morador = listaMoradores.getMorador("0000000012");
                    if (isNull(morador)) {
                        System.out.println(test + "Inserir morador: FAIL");
                    } else if (target.getDataRetirada() != null){
                        System.out.println(test + "Não foi retirada anteriormente: FAIL");
                    } else {
                        System.out.println(test + "Inserir morador: OK");
                        System.out.println(test + "Não foi retirada anteriormente: OK");
                        
                        if (!target.getApto().equals(morador.getApto())) {
                            System.out.println(test + "Carga pertence ao morador: FAIL");
                        } else {
                            System.out.println(test + "Carga pertence ao morador: OK");
                            
                            currOperador.registrarRetirada(morador, id);
                            target = currOperador.getListaEntregas().getEntrega(id);
                            
                            if (target != null && target.getDataRetirada() != null) {
                                System.out.println(test + "Registro de retirada de pacote: OK");
                            } else {
                                System.out.println(test + "Registro de retirada de pacote: FAIL");
                            }
                        }
                    }
                }
                    
            }
        } catch (Exception e) {
            System.out.println(test + "ERROR\n" + e.getMessage());
            for (StackTraceElement el: e.getStackTrace()) {
                System.out.println(el.toString());
            }
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
            System.out.println(test + "ERROR\n" + e.getMessage());
            for (StackTraceElement el: e.getStackTrace()) {
                System.out.println(el.toString());
            }
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
            System.out.println(test + "ERROR\n" + e.getMessage());
            for (StackTraceElement el: e.getStackTrace()) {
                System.out.println(el.toString());
            }
        }
    }
}
