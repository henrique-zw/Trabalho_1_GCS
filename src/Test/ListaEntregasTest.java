package Test;

import Entities.Entrega;
import java.util.List;
import static java.util.Objects.isNull;

/**
 * @author johnb
 */
public class ListaEntregasTest {

    public static void listarEntregasNaoRetiradas() {
        String test = "Listar Entregas Nao Retiradas - ";
        try {            
            List<Entrega> target = Test.currOperador.getListaEntregas().getNaoRetiradas();
            
            if (isNull(target)) {
                System.out.println(test + "Lista nula: FAIL");
            } else if (target.size() == 0) {
                System.out.println(test + "Lista vazia: OK");
            } else if (target.get(0).toString() != null && !target.get(0).toString().isBlank()) {
                System.out.println(test + "Retorno da string com listagem: OK");
            } else {
                System.out.println(test + "Retorno da string com listagem: FAIL");
            }
        } catch (Exception e) {
            System.out.println(test + "ERROR\n" + e.getMessage() + "\n" + e.getStackTrace());
        }
    }
    
}
