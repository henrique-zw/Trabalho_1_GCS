package Colecoes;

import Entities.Entrega;
import Entities.Morador;
import Entities.Operador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaEntregas {
    private List<Entrega> listaEntregasNaoRetiradas;
    private List<Entrega> listaEntregasRetiradas;
    private int count;

    public ListaEntregas() {
        this.listaEntregasNaoRetiradas = new ArrayList<>();
        this.listaEntregasRetiradas = new ArrayList<>();
        this.count = 1;
    }

    public void addEntrega(Entrega entrega){
        //entrega.setId(count);
        listaEntregasNaoRetiradas.add(entrega);
        count++;
    }

    public int getSizeNaoRetiradas(){
        return listaEntregasNaoRetiradas.size();
    }

    public Entrega getEntrega(int id){
        Entrega eAux = null;
        for (Entrega en: listaEntregasNaoRetiradas) {
            if(en.getId() == id){
                eAux = en;
            }
        }
        return eAux;
    }

    public List<Entrega> getEntregas(String descricao){
        List<Entrega> subList = new ArrayList<>();
        for (Entrega en: listaEntregasNaoRetiradas) {
            if(en.getDescricao().contains(descricao)){
                subList.add(en);
            }
        }
        return subList;
    }

    //TODO: VERIFICAR PORQUE NULL É SEMPRE FALSO

    public List<Entrega> getNaoRetiradas(){

        return listaEntregasNaoRetiradas;

    }

    public List<Entrega> getRetiradas(){

        return listaEntregasRetiradas;

    }

    public void retiraPacote(int id, Morador umMorador){


        for (int i=0;i<listaEntregasNaoRetiradas.size()-1;i++){

            if(listaEntregasNaoRetiradas.get(i).getId() == id){


                Entrega enAux = listaEntregasNaoRetiradas.remove(i);
                enAux.setMorador(umMorador);
                Date date = new Date();
                enAux.setDataRetirada(date);

                System.out.println("Pacote: "+enAux.toString());

                System.out.println("\nRetirado com Sucesso");

                listaEntregasRetiradas.add(enAux);

            }

        }

    }


    //TODO: CRIAR UMA CLASSE UTIL COM MÉTODOS PARA TRABALHAR COM DATE
    public String getRelatorio(Date dataInicial, Date dataFinal){
        StringBuilder lista = new StringBuilder();
        String s = String.format("Entrega | Data/hora | Descrição                | Apto | Operador | Retirada | Morador ");
        lista.append(s);
        for (Entrega en: listaEntregasNaoRetiradas) {
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
