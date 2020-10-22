package Entities;

public class Operador {
    private String nome;
    private String iniciais;

    public Operador(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        setIniciais(nome);
    }

    public String getIniciais() {
        return iniciais;
    }

    //TODO: CRIAR MÉTODOS NECESSÁRIOS
    public void setIniciais(String nome){
        if(nome != null){
            String aux = "";
            String[] nomes = getNome().split(" ");
            char inicial;
            for (int i = 0; i < nomes.length; i++){
                inicial = nomes[i].charAt(0);
                aux += inicial;
            }
            this.iniciais = aux;
        }
    }
}