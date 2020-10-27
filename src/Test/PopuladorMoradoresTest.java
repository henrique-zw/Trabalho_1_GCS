/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Colecoes.ListaMoradores;
import Entities.Morador;

/**
 *
 * @author johnb
 */
public class PopuladorMoradoresTest {
    public static void incluirMorador() {
        String test = "Incluir Morador - ";
        try {            
            ListaMoradores listaMoradores = Test.listaMoradores;
            
            Morador newMorador = new Morador("0000000012", "Maria Moradora", 99);

            if(listaMoradores.addMorador(newMorador)){
                System.out.println(test + "Teste com valor válido: OK");
            } else {
                System.out.println(test + "Teste com valor válido: FAIL");
            }
            
            newMorador = new Morador("a000000012", "0ria Moradora", 0);
            
            if(listaMoradores.addMorador(newMorador)){
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
