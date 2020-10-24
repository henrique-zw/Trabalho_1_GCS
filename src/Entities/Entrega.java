package Entities;

import Utils.ManipuladorDeDatas;

import java.text.ParseException;
import java.util.Date;

public class Entrega {
    private Integer id;
    private Operador operador;
    private Morador morador;
    private Integer apto;
    private String descricao;
    private Date dataRecebimento;
    private Date dataRetirada;

    public Entrega(Operador operador, Integer apto, String descricao, Date dataRecebimento) {
        setOperador(operador);
        setApto(apto);
        setDescricao(descricao);
        setDataRecebimento(dataRecebimento);
        this.morador = null;
        this.dataRetirada = null;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Operador getOperador() {
        return operador;
    }
    public void setOperador(Operador operador) {
        if (operador != null){
            this.operador = operador;
        }
    }

    public Morador getMorador() {
        return morador;
    }
    public void setMorador(Morador morador) {
        if (morador != null) {
            this.morador = morador;
        }
    }

    public Integer getApto() {
        return apto;
    }
    public void setApto(Integer apto) {
        if(apto != null) {
            this.apto = apto;
        }
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.trim().isEmpty()) {
            this.descricao = descricao.toUpperCase();
        }
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }
    public void setDataRecebimento(Date dataRecebimento) {
        if(dataRecebimento != null){
            this.dataRecebimento = dataRecebimento;
        }
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        if(dataRetirada != null) {
            this.dataRetirada = dataRetirada;
        }
    }

    @Override
    public String toString() {
        String dataRecebimento = null;
        String dataRetirada = null;

        try {
            dataRecebimento = ManipuladorDeDatas.dateToString(getDataRecebimento());
            dataRetirada = getDataRetirada() == null ? "-" : ManipuladorDeDatas.dateToString(getDataRetirada());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return String.format("ID: %d\nDESCRIÇÃO: %s\nAPTO: %s\nRECEBIMENTO: %s\nENTREGA: %s\n",
                getId(), getDescricao(), getApto(), dataRecebimento, dataRetirada);
    }
}
