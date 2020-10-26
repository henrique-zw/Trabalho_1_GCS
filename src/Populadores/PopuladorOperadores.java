package Populadores;

import Colecoes.ListaEntregas;
import Colecoes.ListaMoradores;
import Colecoes.ListaOperadores;
import Entities.Entrega;
import Entities.Morador;
import Entities.Operador;

import java.util.Date;

public class PopuladorOperadores {
    private final ListaOperadores listaOperadores;
    private final ListaEntregas listaEntregas;

    public PopuladorOperadores() {
        this.listaOperadores = new ListaOperadores();
        this.listaEntregas = new ListaEntregas();

        Operador operador0 = new Operador("David Gilmour");
        listaOperadores.addOperador(operador0);

        Operador operador1 = new Operador("Robert Plant");
        listaOperadores.addOperador(operador1);

        Operador operador2 = new Operador("Jose Gomes");
        listaOperadores.addOperador(operador2);

        Operador operador3 = new Operador("Pedro Almeida");
        listaOperadores.addOperador(operador3);

        Operador operador4 = new Operador("Regerio Aguas");
        listaOperadores.addOperador(operador4);
    }

    public Operador getOperador(String iniciais) {
        Operador operador = getListaOperadores().getOperador(iniciais);

        try{
            operador.setListaEntregas(getListaEntregas());
        } catch (Exception e){
            throw new RuntimeException("Operador nao localizado");
        }
        return operador;
    }

    public ListaOperadores getListaOperadores() {
        return listaOperadores;
    }

    public void addOperador (String nomeOperador) {
        Operador preVerificacao = new Operador(nomeOperador);
        String inicialDoPre = preVerificacao.getIniciais();
        Operador existe = listaOperadores.getOperador(inicialDoPre);
        if (existe == null) {
            listaOperadores.addOperador(preVerificacao);
            System.out.println("Operador Adicionado");
        } else {
            System.out.println("Ja existe um operador com as mesmas iniciais");
        }

    }

    private ListaEntregas getListaEntregas() {
        return listaEntregas;
    }

    public void populaEntregas(ListaMoradores listaMoradores) {
        Morador morador1 = listaMoradores.getMorador("0000000010");
        Morador morador2 = listaMoradores.getMorador("0000000011");
        Morador morador3 = listaMoradores.getMorador("0000000012");
        Morador morador4 = listaMoradores.getMorador("0000000013");
        Entrega entrega;
        entrega = new Entrega(listaOperadores.getOperador("DG"), morador1.getApto(), "Caixa", new Date());
        listaEntregas.addEntrega(entrega);
        entrega = new Entrega(listaOperadores.getOperador("DG"), morador2.getApto(), "Encomenda Merdado Livre", new Date("10/09/2020"));
        listaEntregas.addEntrega(entrega);
        entrega = new Entrega(listaOperadores.getOperador("DG"), morador4.getApto(), "IFood",new Date("18/09/2020"));
        listaEntregas.addEntrega(entrega);
        entrega = new Entrega(listaOperadores.getOperador("RP"), morador1.getApto(), "Caixa dell notebook", new Date("30/09/2020"));
        listaEntregas.addEntrega(entrega);
        entrega = new Entrega(listaOperadores.getOperador("RP"), morador3.getApto(), "Multa Detran", new Date("22/09/2020"));
        listaEntregas.addEntrega(entrega);
    }
}