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
        if(nome != null && !nome.isBlank() && !nome.trim().isEmpty()){
            if(nome.matches("^[a-zA-Z\\s]+$")){
                String[] sNome = nome.trim().split(" ");
                if(sNome.length >= 2){
                    this.nome = nome;
                    this.iniciais = (sNome[0].substring(1)).concat(sNome[1].substring(1));
                }
            }
        }
    }

    public String getIniciais() {
        return iniciais;
    }

    //TODO: CRIAR MÉTODOS NECESSÁRIOS
}
