package Entities;

import Colecoes.ListaEntregas;
import Utils.Tools;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

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

    public void registrarRetirada(Morador morador, int id){
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

    public boolean registraEntrega(Integer apto, String descricao){
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
            return true;
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
        try {
            Date dataIni = Tools.StringToDate(dataInicial);
            Date dataFim = Tools.addOneDay(Tools.StringToDate(dataFinal));

            StringBuilder lista = new StringBuilder();
            StringBuilder descricao = new StringBuilder();
            StringBuilder apto = new StringBuilder();
            StringBuilder dtRetirada = new StringBuilder();
            StringBuilder stbMorador = new StringBuilder();

            String s = "ENTREGA |      DATA/HORA      |             DESCRIÇÃO              | APTO | OPERADOR |      RETIRADA       | MORADOR \n\n";
            lista.append(s);

            for (int i = 1; i < getListaEntregas().getSize()+1; i++) {

                Date dataRecebimento = getListaEntregas().getEntrega(i).getDataRecebimento();
                Date dataRetirada = null;

                if (getListaEntregas().getEntrega(i).getDataRetirada() != null) {
                    dataRetirada = getListaEntregas().getEntrega(i).getDataRetirada();
                }
                else {
                    dtRetirada.append(" ".repeat(Math.max(0, 19 - descricao.length())));
                }

                if((dataRecebimento.after(dataIni) || dataRecebimento.equals(dataIni)) &&
                        (dataRecebimento.before(dataFim) || dataRecebimento.equals(dataFim))){
                    descricao.append(getListaEntregas().getEntrega(i).getDescricao().trim());
                    descricao.append(" ".repeat(Math.max(0, 35 - descricao.length())));
                    apto.append(getListaEntregas().getEntrega(i).getApto().toString());

                    for (int j = apto.length() ; j <4 ; j++){
                        apto.insert(0,"0");
                    }

                    String sDataRecebimento = Tools.dateToString(dataRecebimento);
                    String sDataRetirada = dataRetirada != null ? Tools.dateToString(dataRecebimento) : dtRetirada.toString();
                    String sMorador = getListaEntregas().getEntrega(i).getMorador() != null ? getListaEntregas().getEntrega(i).getMorador().getNome() : stbMorador.append(" ".repeat(Math.max(0, 35 - descricao.length()))).toString();

                    s = String.format("   %d    | %s | %s| %s |    %s    | %s | %s\n",
                            getListaEntregas().getEntrega(i).getId(), sDataRecebimento, descricao.toString(), apto, getListaEntregas().getEntrega(i).getOperador().getIniciais(),
                            sDataRetirada, sMorador);
                    lista.append(s);
                    lista.append("\n");
                    descricao.delete(0,descricao.length());
                    apto.delete(0,apto.length());
                    dtRetirada.delete(0,dtRetirada.length());
                    stbMorador.delete(0,stbMorador.length());
                }
            }
            if(lista.length() > 1){
                return lista.toString();
            }
            else{
                return "Nenhuma entrega registrada nesse período";
            }

        } catch (Exception e){
            return e.toString();
        }
    }
}