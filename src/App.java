import Colecoes.ListaEntregas;
import Colecoes.ListaMoradores;
import Colecoes.ListaOperadores;
import Entities.Morador;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        ListaOperadores Operadores = new ListaOperadores();
        ListaMoradores  Moradores  = new ListaMoradores();
        ListaEntregas   Entregas   = new ListaEntregas();
        int escolha = 0;
        do{
            System.out.println("Sistema de entregas em condominio");
            System.out.println("Escolha um numero");
            System.out.println("1 - Escolher operador");
            System.out.println("2 - Inserir novo operador");
            System.out.println("3 - Registrar entrega");
            System.out.println("4 - Incluir novo morador");
            System.out.println("5 - Registrar retirada de entrega");
            System.out.println("6 - Listar moradores");
            System.out.println("7 - Listar entregas não retiradas");
            System.out.println("8 - Procurar entrega pela descricao");
            System.out.println("9 - Gerar relatorio");
            System.out.println("0 - Sair");
            escolha = input.nextInt();
            switch (escolha){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                        System.out.print("\nNome do novo morador: ");
                        String nome = inputString.nextLine();
                        String rg = null;
                        do {
                            System.out.print("\nNumero Registro Geral: ");
                            rg = inputString.nextLine();
                        } while (rg.length()!=10);
                        System.out.print("\nNumero apartamento: ");
                        String ape = inputString.nextLine();

                        Morador newMorador = new Morador(rg, nome, ape);
                        Moradores.addMorador(newMorador);

                        System.out.println(Moradores.toString());
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }while (escolha!=0);

    }
}
