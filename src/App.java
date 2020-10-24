import Colecoes.ListaMoradores;
import Entities.Entrega;
import Entities.Morador;
import Entities.Operador;
import Populadores.PopuladorOperadores;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
      
      Scanner inputInt = new Scanner(System.in);
      Scanner inputString = new Scanner(System.in);
      
      // TODO: SÓ PARA TESTES INICIAS
      final ListaMoradores Moradores = new ListaMoradores();

      Morador morador01 = new Morador("1234567890", "morador teste", 123);
      Moradores.addMorador(morador01);
      ///////////////////////////////
      
      PopuladorOperadores populadorOperadores = new PopuladorOperadores();
      
      // TODO:currOperador deve receber o operador do método de seleção de operadores
      Operador currOperador = populadorOperadores.getOperador("DG");
        int op = 0;
        while (op >= 0) {
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
            op = inputInt.nextInt();
            switch (op) {
                case -1: // SAIR
                    System.out.println("Saindo");
                    break;
                case 1: // ESCOLHER OPERADOR
                    System.out.println("Entre com as inciais do operador: ");
                    String iniciais = inputString.nextLine();
                    currOperador = populadorOperadores.getOperador(iniciais);
                    System.out.println("Operador selecionado: " + currOperador.getNome());
                    break;
                case 2: // INCLUIR NOVO OPERADOR
                    System.out.println("PRECISA SER FEITO!");
                    break;
                case 3: // INCLUIR MORADOR
                    System.out.print("\nNome completo do novo morador: ");
                    String nomeMorador = inputString.nextLine();
                    String rg = null;
                    do {
                        System.out.print("\nNumero Registro Geral: ");
                        rg = inputString.nextLine();
                    } while (rg.length()!=10);
                    System.out.print("\nNumero apartamento: ");
                    int ape = inputInt.nextInt();

                    Morador newMorador = new Morador(rg, nomeMorador, ape);
                    Moradores.addMorador(newMorador);
                    break;
                case 4: // LISTAR MORADORES
                    System.out.println(Moradores.toString());
                    break;
                case 5: // REGISTRAR NOVA ENTREGA
                    System.out.println("Informe o apartamento de destino da entrega");
                    int aptoTemp = inputInt.nextInt();

                    System.out.println("Informe uma breve descrição da entrega");
                    String descTemp = inputString.nextLine();
                
                    currOperador.registraEntrega(aptoTemp,descTemp);
                    break;
                case 6: // REGISTRAR RETIRADA DE PACOTE
                    try {
                        System.out.println("Insira o número da entrega que desejas retirar");
                        int idEntrega = inputInt.nextInt();

                        System.out.println("Insira o RG do morador que vai realizar a retirada");
                        String rgMorador = inputString.nextLine();

                        if (rgMorador == null || rgMorador.trim().isEmpty()) {
                            throw new Exception("Registro Geral inválido");
                        }

                        Morador morador = Moradores.getMorador(rgMorador);
                        if (morador == null) {
                            throw new Exception("Morador não encontrado");
                        }

                        Entrega entrega = currOperador.getListaEntregas().getEntrega(idEntrega);

                        if (entrega == null) {
                            throw new Exception("Entrega não encontrada");
                        }

                        if (entrega.getDataRetirada() != null) {
                            throw new Exception("Esta entrega já foi retirada");
                        }

                        if (entrega.getApto().equals(morador.getApto())) {
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
                    List<Entrega> list = currOperador.procuraEntregaPorDescricao(descricao);
                    if(list != null){
                        System.out.println("Entregas encontradas: ");
                        System.out.println(list.toString());
                    }
                    else {
                        System.out.println("Nada consta.");
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

                    System.out.println("Insira a data final (EX: 01/01/2001): ");
                    String dataFim = inputString.nextLine();

                    String relatorio = currOperador.getRelatorio(dataIni, dataFim);
                    System.out.println(relatorio);
                    break;
                default:
                    System.out.println("Opção não encontrada, tente novamente.");
            }
        }
    }
}
