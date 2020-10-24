package Populadores;

import Colecoes.ListaOperadores;
import Entities.Operador;

public class PopuladorOperadores {
    ListaOperadores listaOperadores;

    public PopuladorOperadores() {
        this.listaOperadores = new ListaOperadores();
        Operador operador0 = new Operador("David Gilmour");
        Operador operador1 = new Operador("Robert Plant");
        Operador operador2 = new Operador("Jose Gomes");
        Operador operador3 = new Operador("Pedro Almeida");
        Operador operador4 = new Operador("Regerio Aguas");
        listaOperadores.addOperador(operador0);
        listaOperadores.addOperador(operador1);
        listaOperadores.addOperador(operador2);
        listaOperadores.addOperador(operador3);
        listaOperadores.addOperador(operador4);
    }

    public Operador getOperador(String iniciais) {
        return listaOperadores.getOperador(iniciais);
    }
}