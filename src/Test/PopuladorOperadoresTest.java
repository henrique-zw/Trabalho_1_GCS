/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entities.Operador;
import Populadores.PopuladorOperadores;

/**
 *
 * @author johnb
 */
public class PopuladorOperadoresTest {
    public static void escolheOperador() {
        String test = "Escolher Operador - ";
        try {
            PopuladorOperadores populadorOperadores = Test.populadorOperadores;

            Operador target = populadorOperadores.getOperador("JG");
            if(target != null){
                Test.currOperador = target;
                System.out.println(test + "Teste com valor válido: OK");
            } else {
                System.out.println(test + "Teste com valor válido: FAIL");
            }
            
            target = populadorOperadores.getOperador("X");
            if(target != null){
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

    public static void incluirOperador() {
        String test = "Incluir Operador - ";
        try {
            PopuladorOperadores populadorOperadores = Test.populadorOperadores;

            populadorOperadores.addOperador("Maria Testadora");
            Operador target = populadorOperadores.getOperador("MT");
            if(target != null){
                System.out.println(test + "Teste com valor válido: OK");
            } else {
                System.out.println(test + "Teste com valor válido: FAIL");
            }
            
            populadorOperadores.addOperador("Aristedes");
            target = populadorOperadores.getOperador("A");
            if(target != null){
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
}
