package Entities;

import java.util.Date;

public class Entrega {
    private int id;
    private Operador operador;
    private Morador morador;
    private String apto;
    private String descricao;
    private Date dataRecebimento;
    private Date dataRetirada;

    public Entrega(int id, Operador operador, String apto, String descricao, Date dataRecebimento) {
        setId(id);
        setOperador(operador);
        setApto(apto);
        setDescricao(descricao);
        setDataRecebimento(dataRecebimento);
        this.morador = null;
        this.dataRetirada = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        if(operador != null){
            this.operador = operador;
        }
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        if(operador != null){
            this.morador = morador;
        }
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao != null && !descricao.isBlank() && !descricao.isEmpty()) {
            if(descricao.length() >= 10){
                this.descricao = descricao;
            }
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
        if(dataRecebimento != null) {
            this.dataRetirada = dataRetirada;
        }
    }
}
