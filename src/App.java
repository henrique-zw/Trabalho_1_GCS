import Colecoes.ListaEntregas;
import Colecoes.ListaMoradores;
import Colecoes.ListaOperadores;
import Entities.Entrega;
import Entities.Morador;
import Entities.Operador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args){


        Scanner in = new Scanner(System.in);


        // Operador temporário, ainda é preciso inserir operador.
        Operador currOperador = new Operador("Bira Leibe");


        //CRIANDO MORADORES TEMPORARIOS

        Morador umMorador = new Morador("1111111111","Marcio Pereira","202");

        Morador doisMorador = new Morador("2222222222","Jorge Freitas","302");

        Morador tresMorador = new Morador("3333333333","Clara Silva","402");

        Morador quatroMorador = new Morador("4444444444","Laura Cardoso","502");

        System.out.println("RG TESTE : "+umMorador.getRegistoGeral());


        Date umaData = new Date();

        String dataAux1 = "25/12/2018"; // FELIZ NATAL


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            umaData = formatter.parse(dataAux1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //CRIANDO ENTREGAS FANTASIAS
        Entrega umaEntrega = new Entrega(currOperador,"202","Pelo Cheiro é dr0ga.",umaData);
        Entrega duasEntrega = new Entrega(currOperador,"502","Hoe Hoe Hoe.",umaData);
        Entrega tresEntrega = new Entrega(currOperador,"202","Na caixa tá escrito C4.",umaData);
        Entrega quatroEntrega = new Entrega(currOperador,"402","Pede pra nerfar noob",umaData);
        Entrega cincoEntrega = new Entrega(currOperador,"302","Uma Caixa fragil.Reclamou do ar-condicionado",umaData);
        //LISTA DE TESTE
        ListaEntregas EntregasMarotas = new ListaEntregas();
        //ADICIONANDO AS ENTREGAS NA LISTA FAKE
        EntregasMarotas.addEntrega(umaEntrega);
        EntregasMarotas.addEntrega(duasEntrega);
        EntregasMarotas.addEntrega(tresEntrega);
        EntregasMarotas.addEntrega(quatroEntrega);
        EntregasMarotas.addEntrega(cincoEntrega);






        ListaOperadores Operadores = new ListaOperadores();
        ListaMoradores  Moradores  = new ListaMoradores();
        ListaEntregas   Entregas   = new ListaEntregas();


        //INSERINDO MORADORES FANTASIA PARA TESTE.
        Moradores.addMorador(umMorador);
        Moradores.addMorador(doisMorador);
        Moradores.addMorador(tresMorador);
        Moradores.addMorador(quatroMorador);

        //INSERINDO O OPERADOR ATUAL NA LISTA DE OPERADORES
        Operadores.addOperador(currOperador);




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
                    "9) Listar Entregas Retiradas\n" +
                    "10) Gerar Relatório\n\n" +
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
                    String descTemp = in.nextLine();
                    descTemp = in.nextLine();


                    System.out.println("Informe a Data da Entrega (dd/MM/yyyy)");
                    String dataTemp = in.next();




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
                    System.out.println("PRECISA SER FEITO!");

                    System.out.println("Informe o ID do Pacote a ser Retirado");

                    int idTemp = in.nextInt();

                    System.out.println("Informe o RG do Morador que retirou o Pacote");

                    String RgTemp = in.next();


                    EntregasMarotas = retiraPacote(idTemp,RgTemp,EntregasMarotas,Moradores);

                    break;

                case 7:     // PROCURAR ENTREGA VIA DESCRICAO
                    System.out.println("PRECISA SER FEITO!");

                    break;

                case 8:     // LISTAR ENTREGAS NAO RETIRADAS

                    //e preciso trocar isso aqui entre as duas listas.

                    System.out.println("----------------MAROTAS-------------------------");
                    listaEntregasNaoColetadas(EntregasMarotas);
                    //listaEntregasNaoColetadas(Entregas);

                    System.out.println("-----------------------------------------");

                    break;

                case 9:     // LISTAR ENTREGAS RECEBIDAS
                    System.out.println("PRECISA SER FEITO!");

                    System.out.println("-----------------------------------------");
                    listaEntregasColetadas(EntregasMarotas);

                    //listaEntregasColetadas(Entregas);
                    System.out.println("-----------------------------------------");



                    break;

                case 10:     // GERAR RELATÓRIO
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

    public static ListaEntregas retiraPacote(int id,String Rg,ListaEntregas entregas,ListaMoradores moradores){



            if(moradores.getMorador(Rg).getRegistoGeral().equals(Rg)) { // CHECA SE O RG EXISTE



                Morador morAx = moradores.getMorador(Rg);
                System.out.println("Chega Aqui");
                if(entregas.getEntrega(id).getId() == id){ //CHECA SE O ID EXISTE

                    entregas.retiraPacote(id,morAx);

                }else{
                    System.out.println("Entrega nao existe");
                }

            }else{
                System.out.println("RG nao existe.");
            }


    return entregas;
    }



    public static void listaEntregasNaoColetadas(ListaEntregas ListaEntregas){

        System.out.println("\nEncomendas ainda não retiradas\n");

        for(int i=0;i<ListaEntregas.getSizeNaoRetiradas();i++){
            System.out.println(ListaEntregas.getNaoRetiradas().get(i).toString());
        }
    }

    public static void listaEntregasColetadas(ListaEntregas ListaEntregas){

        System.out.println("\nEncomendas retiradas\n");

        for(int i=0;i<ListaEntregas.getRetiradas().size();i++){
            System.out.println(ListaEntregas.getRetiradas().get(i).toString());
        }
    }





}
