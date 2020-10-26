package Entities;

public class Morador {
    private String registoGeral;
    private String nome;
    private Integer apto;

    public Morador(String registoGeral, String nome, Integer apto) {
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
        if(nome != null && !nome.trim().isEmpty()){
            if(nome.matches("^[a-zA-Z\\s]+$")){
                String[] sNome = nome.trim().split(" ");
                if(sNome.length >= 2){
                    this.nome = nome;
                }
            }
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

    @Override
    public String toString() {
        StringBuilder lista = new StringBuilder("R. GERAL   - NOME COMPLETO\n");
            String s = String.format("%s - %s  - APTO: %s\n", getRegistoGeral(), getNome(), getApto());
            lista.append(s);
        return lista.toString();
    }
}