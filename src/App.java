import Colecoes.ListaEntregas;
import Colecoes.ListaMoradores;
import Colecoes.ListaOperadores;
import Entities.Entrega;
import Entities.Morador;
import Entities.Operador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args){


        Scanner in = new Scanner(System.in);


        Operador currOperador = new Operador("Bira Leibe");


        ListaOperadores Operadores = new ListaOperadores();
        ListaMoradores  Moradores  = new ListaMoradores();
        ListaEntregas   Entregas   = new ListaEntregas();



        int op = 0;


        while (op >=0) {



            System.out.println("Operações:\n" +
                    "\n1) Escolher Operador\n" +
                    "2) Incluir Operador\n" +
                    "3) Incluir Morador\n" +
                    "4) Listar Moradores\n" +
                    "5) Registrar Nova Entrega\n" +
                    "6) Registrar Retirada de Pacote\n" +
                    "7) Procurar Entrega via Descricao\n" +
                    "8) Listar Entregas Não Retiradas\n" +
                    "9) Gerar Relatório\n\n" +
                    "(-1 para Sair)");


            System.out.println("\nInforme uma opcao:\n");


            op = in.nextInt();


            switch (op) {

                case 1:     // ESCOLHER OPERADOR


                    System.out.println("PRECISA SER FEITO!");

                    break;


                case 2:     // INCLUIR NOVO OPERADOR
                    System.out.println("PRECISA SER FEITO!");

                    break;


                case 3:     // INCLUIR MORADOR
                    System.out.println("PRECISA SER FEITO!");

                    break;


                case 4:     // LISTAR MORADORES
                    System.out.println("PRECISA SER FEITO!");

                    break;

                case 5:     // REGISTRAR NOVA ENTREGA

                    System.out.println("SENDO SER FEITO!");

                    System.out.println("Informe o apartamento de destino da Entrega");

                    String aptoTemp = in.next();


                    System.out.println("Informe uma breve descrição da Entrega");
                    String descTemp = "";
                    descTemp = in.next();


                    System.out.println("Informe a Data da Entrega (dd/MM/yyyy)");
                    String dataTemp = in.next();


                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                    Date date = null;

                    try {

                        date = formatter.parse(dataTemp);


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }



                    System.out.println("Informe o horário da Entrega (Hr:Mn)");

                    String horaTemp = in.next();


                    //REGISTRANDO A ENTREGA
                    registraEntrega(Entregas,currOperador,aptoTemp,descTemp,date,horaTemp);

                    break;

                case 6:     // REGISTRAR RETIRADA DE PACOTE
                    try {

                        System.out.println("Digite o número da entrega que desejas retirar");

                        int idEntrega = in.nextInt();

                        System.out.println("Digite o RG do morador que vai realizar a retirada");

                        String rgMorador = in.next();

                        if (rgMorador == null || rgMorador.isEmpty())
                            throw new Exception("RG do morador inválido");

                        Morador morador = Moradores.getMorador(rgMorador);

                        if (morador == null) throw new Exception("Morador não encontrado");

                        Entrega entrega = Entregas.getEntrega(idEntrega);

                        if (entrega == null)
                            throw new Exception("Entrega não encontrada");

                        if (entrega.foiRetirada())
                            throw new Exception("Esta entrega já foi retirada");

                        if (entrega.getApto().equals(morador.getApto()))
                            throw new Exception("O morador de retirada não pertence ao apto da entrega");

                        entrega.registrarRetirada(morador);

                        Entregas.atualizarEntrega(entrega);

                        System.out.println("Retirada registrada com sucesso!");

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;

                case 7:     // PROCURAR ENTREGA VIA DESCRICAO
                    System.out.println("PRECISA SER FEITO!");

                    break;

                case 8:     // LISTAR ENTREGAS NAO RETIRADAS
                    if (Entregas.getNaoRetiradas().size() == 0)
                        System.out.println("Não há entregas a serem retiradas");

                    Entregas.getNaoRetiradas().forEach(e -> System.out.println(e.toString()));

                    break;

                case 9:     // GERAR RELATÓRIO
                    System.out.println("PRECISA SER FEITO!");

                    break;


                    default:
                        System.out.println("Fim do poço amigo, Slender vai te pegar.");



            }


        }

    }

    public static void registraEntrega(ListaEntregas ListaEntregas,Operador operador, String apartamento, String descricao, Date data, String hora){


        //CRIA UMA ENTREGA COM OS ATRIBUTOS
        Entrega umaEntrega = new Entrega(operador,apartamento, descricao,data);



        //ADICIONA A ENTREGA NA LISTA
        ListaEntregas.addEntrega(umaEntrega);

        System.out.println("Entrega registrada com sucesso!\n\n");


    }

}
