package Entities;

import Colecoes.ListaEntregas;
import Utils.ManipuladorDeDatas;
import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

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
                sAux.append(Character.toUpperCase(s.charAt(0)));
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
//        TODO: REALIZAR VALIDAÇÕES E PASSOS NECESSÁRIOS DO MÉTODO
        try {
            if (isNull(morador)) {
                throw new Exception("Morador não encontrado");
            }
            if (listaEntregas.getSize() == 0) {
                throw new Exception("Não há entregas a serem retirada");
            }
            if (id <= 0 || isNull(listaEntregas.getEntrega(id))) {
                throw new Exception("Entrega não localizada");
            }
            getListaEntregas().getEntrega(id).setMorador(morador);
            getListaEntregas().getEntrega(id).setDataRetirada(Date.from(Instant.now()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    public void registraEntrega(Integer apto, String descricao){
        //TODO: REALIZAR VALIDAÇÕES E PASSOS NECESSÁRIOS DO MÉTODO
        try {
            if (isNull(apto) || apto <= 0) {
                throw new Exception("Necessário informar um apartamento existente");
            }
            if (isNull(descricao)) {
                throw new Exception("Necessário informar uma descrição");
            }

            Operador operador = new Operador(getNome());
            Date dataRecebimento = Date.from(Instant.now());
            Entrega entrega = new Entrega(operador, apto, descricao, dataRecebimento);
            getListaEntregas().addEntrega(entrega);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Entrega> procuraEntregaPorDescricao (String descricao){
            List<Entrega> subList = new ArrayList<>();
            for (int i = 1; i <= getListaEntregas().getSize(); i++) {
                Entrega enAux = getListaEntregas().getEntrega(i);
                if(enAux.getDescricao().contains(descricao.toUpperCase())){
                    subList.add(enAux);
                }
            }
            return subList.size() > 0 ? subList : null;
    }

    public String getRelatorio(String dataInicial, String dataFinal){
        //TODO: CRIAR UM PACKAGE E UMA CLASSE UTIL COM MÉTODOS PARA TRABALHAR COM DATE
        try {
            Date dataIni = ManipuladorDeDatas.StringToDate(dataInicial);
            Date dataFim = ManipuladorDeDatas.StringToDate(dataFinal);

            StringBuilder lista = new StringBuilder();
            String s = "Entrega | Data/hora | Descrição                | Apto | Operador | Retirada | Morador \n";
            lista.append(s);

            for (int i = 1; i < getListaEntregas().getSize()+1; i++) {

                Date dataRecebimento = getListaEntregas().getEntrega(i).getDataRecebimento();
                Date dataRetirada = null;

                if (getListaEntregas().getEntrega(i).getDataRetirada() != null)
                    dataRetirada = getListaEntregas().getEntrega(i).getDataRetirada();

                if((dataRecebimento.after(dataIni) || dataRecebimento.equals(dataIni)) &&
                        (dataRecebimento.before(dataFim) || dataRecebimento.equals(dataFim))){
                    String sDataRecebimento = ManipuladorDeDatas.dateToString(dataRecebimento);
                    String sDataRetirada = dataRetirada != null ? ManipuladorDeDatas.dateToString(dataRecebimento) : "-";
                    String sMorador = getListaEntregas().getEntrega(i).getMorador() != null ? getListaEntregas().getEntrega(i).getMorador().getNome() : "-";
                    s = String.format("   %d    | %s | %s          | %s | %s | %s | %s\n",
                            getListaEntregas().getEntrega(i).getId(), sDataRecebimento,getListaEntregas().getEntrega(i).getDescricao(), getListaEntregas().getEntrega(i).getApto(), getListaEntregas().getEntrega(i).getOperador().getIniciais(),
                            sDataRetirada, sMorador);
                    lista.append(s);
                    lista.append("\n");
                }
            }
            return lista.toString();
        }
        catch (Exception e){
            return e.toString();
        }
        //return null;
    }
}