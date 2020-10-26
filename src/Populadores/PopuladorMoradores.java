package Populadores;

import Colecoes.ListaMoradores;
import Entities.Morador;

public class PopuladorMoradores {
    private final ListaMoradores listaMoradores;

    public PopuladorMoradores() {
        this.listaMoradores = new ListaMoradores();
        String[] nomes = {"Joao Souza", "Cleber Silva", "Maria Lucia", "Alberto Altoe", "Alice Batista", "Julia Borges", "Bernardo Campos", "Pedro Campos", "Benjamin Costa", "Lucas Dias"};
        //Padrao apartamentos: 10, 11, 12, 13 ...
        //Padrao rg: 0000000010, 0000000011, 0000000012 ...
        Morador morador;
        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i];
            morador = new Morador("00000000".concat(String.valueOf(i +10)),nome,i + 10);
            listaMoradores.addMorador(morador);
        }
    }

    public ListaMoradores getListaMoradores() {
        return listaMoradores;
    }
}
