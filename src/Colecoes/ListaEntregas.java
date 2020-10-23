package Colecoes;

import Entities.Entrega;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListaEntregas {

    private List<Entrega> listaEntregas;

    public ListaEntregas() {
        this.listaEntregas = new ArrayList<>();
    }

    public void addEntrega(Entrega entrega){
        listaEntregas.add(entrega);
    }

    public Entrega getEntrega(int id) {
        for (Entrega en: listaEntregas) {
            if (en.getId() == id) return en;
        }
        return null;
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

    public List<Entrega> getNaoRetiradas(){
        Predicate<Entrega> naoRetiradas = entrega -> !entrega.foiRetirada();
        return listaEntregas.stream().filter(naoRetiradas).collect(Collectors.toList());
    }

    public void atualizarEntrega(Entrega entrega) {
        int indice = listaEntregas.indexOf(entrega);
        listaEntregas.set(indice, entrega);
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
