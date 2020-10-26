package Colecoes;

import Entities.Operador;
import java.util.ArrayList;
import java.util.List;

public class ListaOperadores {
    private final List<Operador> listaOperadores;

    public ListaOperadores() {
        this.listaOperadores = new ArrayList<>();
    }

    public void addOperador(Operador operador){
        listaOperadores.add(operador);
    }

    public Operador getOperador(String inicias){
        Operador oAux = null;
        for (Operador op: listaOperadores) {
            if(op.getIniciais().equals(inicias)){
                oAux = op;
            }
        }
        return oAux;
    }

    @Override
    public String toString() {
        StringBuilder lista = new StringBuilder("INICIAS  -   NOME\n");
        for (Operador op: listaOperadores) {
            String s = String.format("  %s     -   %s\n", op.getIniciais(), op.getNome());
            lista.append(s);
        }
        return lista.toString();
    }
}