import Colecoes.ListaEntregas;
import Colecoes.ListaMoradores;
import Colecoes.ListaOperadores;
import Entities.Operador;

import java.util.Scanner;

public class App {
    public static void main(String[] args){

        ListaOperadores Operadores = new ListaOperadores();
        ListaMoradores  Moradores  = new ListaMoradores();
        ListaEntregas   Entregas   = new ListaEntregas();
        //populando...
        Operador operador0 = new Operador("David Gilmour");
        Operador operador1 = new Operador("Maria Silva Oliveira");
        Operador operador2 = new Operador("Robert Plant");
        Operadores.addOperador(operador0);
        Operadores.addOperador(operador1);

        Operador operadorAtual;
        int escolha = 0;
        Operador atual;
        String aux;
        do{
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
            Scanner input = new Scanner(System.in);
            escolha = input.nextInt();
            switch (escolha){
                case 1:
                    Scanner input1 = new Scanner(System.in);
                    System.out.println("Entre com as iniciais do operador");
                    aux = input1.nextLine();
                    operadorAtual = Operadores.getOperador(aux);
                    System.out.println("Operador selecionado: " + operadorAtual.getNome());
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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