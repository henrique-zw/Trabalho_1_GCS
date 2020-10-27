
import Colecoes.ListaMoradores;
import Entities.Operador;
import Populadores.PopuladorMoradores;
import Populadores.PopuladorOperadores;
import Test.ListaEntregasTest;
import Test.ListaMoradoresTeste;
import Test.PopuladorOperadoresTest;
import java.util.Scanner;

/**Testes foram feitos sem jUnit ou outro pacote externo
 *
 * @author johnb
 */
public class Test {
    public static PopuladorOperadores populadorOperadores;
    public static ListaMoradores listaMoradores;
    public static Operador currOperador;
    public static void main(String[] args) {

        Scanner inputInt = new Scanner(System.in);

        populadorOperadores = new PopuladorOperadores();
        listaMoradores = new PopuladorMoradores().getListaMoradores();

        populadorOperadores.populaEntregas(listaMoradores);
        currOperador = populadorOperadores.getOperador("DG");

        int op = 0;

        while (op >= 0) {
            System.out.println("Tastar:\n\n" +
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
                    PopuladorOperadoresTest.escolheOperador();
                    
                    break;
                case 2: // INCLUIR NOVO OPERADOR
                    PopuladorOperadoresTest.incluirOperador();
                    
                    break;
                case 3: // INCLUIR MORADOR
                    //todo

                    break;
                case 4: // LISTAR MORADORES
                    ListaMoradoresTeste.listarMoradores();

                    break;
                case 5: // REGISTRAR NOVA ENTREGA
                    //todo

                    break;
                case 6: // REGISTRAR RETIRADA DE PACOTE
                    //todo

                    break;
                case 7: // PROCURAR ENTREGA VIA DESCRICAO
                    //todo

                    break;
                case 8: // LISTAR ENTREGAS NAO RETIRADAS
                    ListaEntregasTest.listarEntregasNaoRetiradas();
                    
                    break;
                case 9: // GERAR RELATÓRIO
                    //todo

                    break;
                default:
                    System.out.println("Opção não encontrada, tente novamente.");
            }
        }
    }
}
