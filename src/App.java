import Colecoes.ListaMoradores;
import Entities.Entrega;
import Entities.Morador;
import Entities.Operador;
import Populadores.PopuladorMoradores;
import Populadores.PopuladorOperadores;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner inputInt = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);

        PopuladorOperadores populadorOperadores = new PopuladorOperadores();
        ListaMoradores listaMoradores = new PopuladorMoradores().getListaMoradores();

        populadorOperadores.populaEntregas(listaMoradores);
        Operador currOperador = populadorOperadores.getOperador("DG");

        int operacao = 0;

        while (operacao >= 0) {
            System.out.println("Operações:\n\n" +
                    "1) Escolher Operador\n" +
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
            operacao = inputInt.nextInt();

            switch (operacao) {
                case -1: // SAIR
                    System.out.println("Saindo");

                    break;
                case 1: // ESCOLHER OPERADOR
                    System.out.println(populadorOperadores.listarOperadores());

                    System.out.println("Entre com as inciais do operador: ");
                    String iniciais = inputString.nextLine();
                    inputString = new Scanner(System.in).reset();

                    if(populadorOperadores.getOperador(iniciais) != null){
                        currOperador = populadorOperadores.getOperador(iniciais);
                    }
                    else {
                        System.out.println("Operador não encontrado, tente novamente.\n\n");
                    }

                    System.out.println("Operador atual: " + currOperador.getNome());

                    break;
                case 2: // INCLUIR NOVO OPERADOR
                    System.out.print("\nNome completo do novo operador: ");
                    String nomeOperador = inputString.nextLine();
                    inputString = new Scanner(System.in);

                    while (nomeOperador.length() > 35) {
                        System.out.println("O nome deve conter no máximo 35 caractéres.\nTente novamente:");
                        nomeOperador = inputString.nextLine();
                        inputString = new Scanner(System.in);
                    }

                    break;
                case 3: // INCLUIR MORADOR
                    System.out.print("\nNome completo do novo morador: ");
                    String nomeMorador = inputString.nextLine();
                    inputString = new Scanner(System.in);

                    while (nomeMorador.length() > 35) {
                        System.out.println("O nome deve conter no máximo 35 caractéres.\nTente novamente:");
                        nomeMorador = inputString.nextLine();
                        inputString = new Scanner(System.in);

                    }

                    System.out.print("\nNumero Registro Geral: ");
                    String rg = inputString.nextLine();
                    inputString = new Scanner(System.in);

                    while (rg.length()!=10) {
                        System.out.println("O RG é composto por 10 dígitos.\nTente novamente:");
                        rg = inputString.nextLine();
                        inputString = new Scanner(System.in);
                    }

                    System.out.print("\nNumero apartamento: ");
                    int ape = inputInt.nextInt();

                    Morador newMorador = new Morador(rg, nomeMorador, ape);

                    if(listaMoradores.addMorador(newMorador)){
                        System.out.println("Morador adicionado com sucesso.\n");
                        System.out.println(listaMoradores.getMorador(rg));
                    }
                    else {
                        System.out.println("Algo deu errado, por favor tente novamente.");
                    }

                    break;
                case 4: // LISTAR MORADORES
                    if(listaMoradores.getSize() > 0){
                        System.out.println(listaMoradores.toString());
                    }
                    else {
                        System.out.println("Não existem moradores registrados.");
                    }

                    break;
                case 5: // REGISTRAR NOVA ENTREGA
                    System.out.println("Informe o apartamento de destino da entrega:");
                    int aptoTemp;

                    try {
                        aptoTemp = inputInt.nextInt();

                    }catch (InputMismatchException e){
                        System.out.println("Número inválido, operação encerrada.");
                        return;
                    }

                    System.out.println("Informe uma breve descrição da entrega:");
                    String descTemp = inputString.nextLine();
                    inputString = new Scanner(System.in);

                    while (descTemp.length() > 35){
                        System.out.println("A descrição deve conter no máximo 35 caractéres.\nTente novamente:");
                        descTemp = inputString.nextLine();
                        inputString = new Scanner(System.in);
                    }

                    try {
                        if(currOperador.registraEntrega(aptoTemp, descTemp)){
                            int id = currOperador.getListaEntregas().getSize();
                            System.out.println("Entrega registrada:");
                            System.out.println(currOperador.getListaEntregas().getEntrega(id));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6: // REGISTRAR RETIRADA DE PACOTE
                    try {
                        System.out.println("informe a descrição do objeto a ser retirado:");
                        String descricao = inputString.nextLine();

                        List<Entrega> listAux = currOperador.procuraEntregaPorDescricao(descricao);
                        for (Entrega en : listAux){
                            System.out.println(en);
                        }

                        System.out.println("Insira o número da entrega que desejas retirar:");
                        int idEntrega = inputInt.nextInt();

                        System.out.println("Insira o RG do morador que vai realizar a retirada:");
                        String rgMorador = inputString.nextLine();
                        inputString = new Scanner(System.in);

                        if (rgMorador == null || rgMorador.trim().isEmpty()) {
                            throw new Exception("Registro Geral inválido.");
                        }

                        Morador morador = listaMoradores.getMorador(rgMorador);
                        if (morador == null) {
                            throw new Exception("Morador não encontrado.");
                        }

                        Entrega entrega = currOperador.getListaEntregas().getEntrega(idEntrega);

                        if (entrega == null) {
                            throw new Exception("Entrega não encontrada");
                        }

                        if (entrega.getDataRetirada() != null) {
                            throw new Exception("Esta entrega já foi retirada");
                        }

                        if (!entrega.getApto().equals(morador.getApto())) {
                            throw new Exception("O morador de retirada não pertence ao apto da entrega");
                        }

                        currOperador.registrarRetirada(morador,idEntrega);
                        System.out.println("Retirada registrada com sucesso!");

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case 7: // PROCURAR ENTREGA VIA DESCRICAO
                    System.out.println("Informe a descrição da entrega que deseja encontrar: ");
                    String descricao = inputString.nextLine();
                    inputString = new Scanner(System.in);

                    List<Entrega> list = currOperador.procuraEntregaPorDescricao(descricao);

                    if(list != null){
                        System.out.println("Entregas encontradas: ");
                        System.out.println(list.toString());
                    }
                    else {
                        System.out.println("Nenhuma entrega encontrada coma descrição informada.");
                    }

                    break;
                case 8: // LISTAR ENTREGAS NAO RETIRADAS
                    if (currOperador.getListaEntregas().getNaoRetiradas().size() == 0) {
                        System.out.println("Não há entregas a serem retiradas");
                    }

                    currOperador.getListaEntregas().getNaoRetiradas().forEach(e -> System.out.println(e.toString()));

                    break;
                case 9: // GERAR RELATÓRIO
                    System.out.println("Insira a data inicial (EX: 01/01/2001): ");
                    String dataIni = inputString.nextLine();
                    inputString = new Scanner(System.in);

                    System.out.println("Insira a data final (EX: 01/01/2001): ");
                    String dataFim = inputString.nextLine();
                    inputString = new Scanner(System.in);

                    String relatorio = currOperador.getRelatorio(dataIni, dataFim);
                    System.out.println(relatorio);

                    break;
                default:
                    System.out.println("Opção não encontrada, tente novamente.");
            }
        }
    }
}
