package Colecoes;

import Entities.Morador;
import Entities.Operador;

import java.util.ArrayList;
import java.util.List;

public class ListaMoradores {
    public List<Morador> listaMoradores;

    public ListaMoradores() {
        this.listaMoradores = new ArrayList<>();
    }

    public void addMorador(Morador morador){
        listaMoradores.add(morador);
    }

    public Morador getMorador(String rg){
        Morador mAux = null;


        for(int i =0;i<listaMoradores.size();i++){
            Morador mo = listaMoradores.get(i);
            if (mo.getRegistoGeral().equals(rg)){

                mAux=mo;
            }

        }

        return mAux;
    }

    public int getSize(){return this.listaMoradores.size();}

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
