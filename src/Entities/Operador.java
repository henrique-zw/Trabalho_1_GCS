package Entities;

import Colecoes.ListaEntregas;

import java.time.Instant;
import java.util.Date;

public class Operador {
    private String nome;
    private String iniciais;
    private ListaEntregas listaEntregas;

    public Operador(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty() && !nome.trim().isEmpty()){
            if(nome.matches("^[a-zA-Z\\s]+$")){
                String[] sNome = nome.trim().split(" ");
                if(sNome.length >= 2){
                    this.nome = nome;
                    setIniciais(sNome);
                }
            }
        }
    }

    public String getIniciais() {
        return iniciais;
    }
    public void setIniciais(String[] nome){
        StringBuilder sAux = new StringBuilder();;
        for (String s : nome) {
            if(!s.equalsIgnoreCase("de") &&
                    !s.equalsIgnoreCase("da") &&
                    !s.equalsIgnoreCase("das") &&
                    !s.equalsIgnoreCase("do") &&
                    !s.equalsIgnoreCase("dos")){
                sAux.append(s.charAt(0));
            }
        }
        this.iniciais = sAux.toString();
    }

    public ListaEntregas getListaEntregas() {
        return listaEntregas;
    }
    public void setListaEntregas(ListaEntregas listaEntregas) {
        this.listaEntregas = listaEntregas;
    }

    //TODO: CRIAR MÉTODOS NECESSÁRIOS
    //TODO: ESTÁ CLASSE NÃO IMPRIME NADA EM TELA, MENSAGENS DEVEM SER INFORMADAS ATRÁVES DA CLASSE APP

    public void registrarRetirada(Morador morador, int id){
        //TODO: REALIZAR VALIDAÇÕES E PASSOS NECESSÁRIOS DO MÉTODO
        try{
            getListaEntregas().getEntrega(id).setMorador(morador);
            getListaEntregas().getEntrega(id).setDataRetirada(Date.from(Instant.now()));
        }
        catch (Exception e){
            //TODO
        }

    }
    public void registraEntrega(Integer apto, String descricao){
        //TODO: REALIZAR VALIDAÇÕES E PASSOS NECESSÁRIOS DO MÉTODO
        try{
            Operador operador = new Operador(getNome());
            Date dataRecebimento = Date.from(Instant.now());
            Entrega entrega = new Entrega(operador, apto, descricao, dataRecebimento);
            getListaEntregas().addEntrega(entrega);
        }
        catch (Exception e){
            //TODO
        }
    }

    public String getRelatorio(Date dataInicial, Date dataFinal){
        //TODO: CRIAR UM PACKAGE E UMA CLASSE UTIL COM MÉTODOS PARA TRABALHAR COM DATE
        StringBuilder lista = new StringBuilder();
        String s = "Entrega | Data/hora | Descrição                | Apto | Operador | Retirada | Morador ";
        lista.append(s);
        for (int i = 0; i < getListaEntregas().getSize(); i++) {
            if((getListaEntregas().getEntrega(i).getDataRecebimento().after(dataInicial) || getListaEntregas().getEntrega(i).getDataRecebimento().equals(dataInicial)) &&
                    (getListaEntregas().getEntrega(i).getDataRecebimento(). before(dataFinal) || getListaEntregas().getEntrega(i).getDataRecebimento().equals(dataInicial))){
                s = String.format("%d | %S | %s | %s | %s | %s | %s",
                        getListaEntregas().getEntrega(i).getId(), getListaEntregas().getEntrega(i).getDataRecebimento(),getListaEntregas().getEntrega(i).getDescricao(), getListaEntregas().getEntrega(i).getApto(), getListaEntregas().getEntrega(i).getOperador().getIniciais(),
                        getListaEntregas().getEntrega(i).getDataRetirada(), getListaEntregas().getEntrega(i).getMorador().getNome());
                lista.append(s);
            }
        }
        return lista.toString();
    }
}