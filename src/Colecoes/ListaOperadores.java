package Colecoes;

import Entities.Operador;

import java.util.ArrayList;
import java.util.List;

public class ListaOperadores {
    private List<Operador> listaOperadores;

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
}