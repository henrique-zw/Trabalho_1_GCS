package Colecoes;

import Entities.Morador;
import Entities.Operador;

import java.util.ArrayList;
import java.util.List;

public class ListaMoradores {
    private List<Morador> listaMoradores;

    public ListaMoradores() {
        this.listaMoradores = new ArrayList<>();
    }

    public void addMorador(Morador morador){
        listaMoradores.add(morador);
    }

    public Morador getMorador(String rg){
        Morador mAux = null;
        for (Morador mo: listaMoradores) {
            if(mo.getRegistoGeral().equals(rg)){
                mAux = mo;
            }
        }
        return mAux;
    }

    @Override
    public String toString() {
        StringBuilder lista = new StringBuilder();
        for (Morador mo: listaMoradores) {
            String s = String.format("Nome: %s / Apto: %s\n",mo.getNome(),mo.getApto());
            lista.append(s);
        }
        return lista.toString();
    }
}
