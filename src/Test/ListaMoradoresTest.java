/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Colecoes.ListaMoradores;

/**
 *
 * @author johnb
 */
public class ListaMoradoresTest {    
    public static void listarMoradores() {
        String test = "Listar Moradores - ";
        try {
            ListaMoradores listaMoradores = Test.listaMoradores;

            String target = listaMoradores.toString();
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
