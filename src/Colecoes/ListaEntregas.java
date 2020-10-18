package Colecoes;

import Entities.Entrega;
import Entities.Morador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaEntregas {
    private final List<Entrega> listaEntregas;
    private int count;

    public ListaEntregas() {
        this.listaEntregas = new ArrayList<>();
        this.count = 1;
    }

    public void addEntrega(Entrega entrega){
        entrega.setId(count);
        listaEntregas.add(entrega);
        count++;
    }

    public Entrega getEntrega(int id){
        Entrega eAux = null;
        for (Entrega en: listaEntregas) {
            if(en.getId() == id){
                eAux = en;
            }
        }
        return eAux;
    }

    public List<Entrega> getEntregas(String descricao){
        List<Entrega> subList = new ArrayList<>();
        for (Entrega en: listaEntregas) {
            if(en.getDescricao().contains(descricao)){
                subList.add(en);
            }
        }
        return subList;
    }
    //TODO: VERIFICAR PORQUE NULL É SEMPRE FALSO
    public List<Entrega> getNaoRetiradas(){
        List<Entrega> subList = new ArrayList<>();
        for (Entrega en: listaEntregas) {
            if(en.getDataRetirada().equals(null)){
                subList.add(en);
            }
        }
        return subList;
    }
    //TODO: CRIAR UMA CLASSE UTIL COM MÉTODOS PARA TRABALHAR COM DATE
    public String getRelatorio(Date dataInicial, Date dataFinal){
        StringBuilder lista = new StringBuilder();
        String s = String.format("Entrega | Data/hora | Descrição                | Apto | Operador | Retirada | Morador ");
        lista.append(s);
        for (Entrega en: listaEntregas) {
            if((en.getDataRecebimento().after(dataInicial) || en.getDataRecebimento().equals(dataInicial)) &&
               (en.getDataRecebimento(). before(dataFinal) || en.getDataRecebimento().equals(dataInicial))){
                s = String.format("%d | %S | %s | %s | %s | %s | %s",
                        en.getId(), en.getDataRecebimento(),en.getDescricao(), en.getApto(), en.getOperador().getIniciais(),
                        en.getDataRetirada(), en.getMorador().getNome());
                lista.append(s);
            }
        }
        return lista.toString();
    }
}
