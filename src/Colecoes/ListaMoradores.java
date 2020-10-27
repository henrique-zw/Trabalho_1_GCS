package Colecoes;

import Entities.Morador;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

public class ListaMoradores {
    private final List<Morador> listaMoradores;

    public ListaMoradores() {
        this.listaMoradores = new ArrayList<>();
    }

    public boolean addMorador(Morador morador){
        try {
            if (!isNull(morador) && !isNull(morador.getNome()) && !isNull(morador.getRegistoGeral())) {
                listaMoradores.add(morador);
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
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

    public int getSize(){
        return listaMoradores.size();
    }

    @Override
    public String toString() {
        StringBuilder lista = new StringBuilder("R. GERAL   - NOME COMPLETO\n");
        for (Morador mo: listaMoradores) {
            String s = String.format("%s - %s  - APTO: %s\n", mo.getRegistoGeral(), mo.getNome(), mo.getApto());
            lista.append(s);
        }
        return lista.toString();
    }
}
