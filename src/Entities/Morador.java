package Entities;

public class Morador {
    private String registoGeral;
    private String nome;
    private String apto;

    public Morador(String registoGeral, String nome, String apto) {
        setRegistoGeral(registoGeral);
        setNome(nome);
        setApto(apto);
    }

    public String getRegistoGeral() {
        return registoGeral;
    }

    public void setRegistoGeral(String registoGeral) {
        if(registoGeral.length() == 10 && registoGeral.matches("[0-9]*")){
            this.registoGeral = registoGeral;
        }

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
                }
            }
        }
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
       // if(!nome.isBlank() && !nome.isEmpty()) {
            this.apto = apto;
        //}
    }
}