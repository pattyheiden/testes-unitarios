package com.lima.atividade0510testesunitarios1;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private String sobrenomeSolteiraMae;
    private String cidadeNatal;

    public Pessoa(String nome, String sobrenome, String sobrenomeSolteiraMae, String cidadeNatal) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sobrenomeSolteiraMae = sobrenomeSolteiraMae;
        this.cidadeNatal = cidadeNatal;
    }

    public String gerarNomeStarWars() {
        if (sobrenome == null || sobrenome.length() < 3) {
            throw new IllegalArgumentException("O sobrenome deve ter pelo menos 3 caracteres.");
        }
        if (nome == null || nome.length() < 2) {
            throw new IllegalArgumentException("O nome deve ter pelo menos 2 caracteres.");
        }
        if (sobrenomeSolteiraMae == null || sobrenomeSolteiraMae.length() < 2) {
            throw new IllegalArgumentException("O sobrenome de solteira da mãe deve ter pelo menos 2 caracteres.");
        }
        if (cidadeNatal == null || cidadeNatal.length() < 3) {
            throw new IllegalArgumentException("A cidade natal deve ter pelo menos 3 caracteres.");
        }

        // Primeiro nome: 3 primeiras do sobrenome + 2 primeiras do nome
        String primeiroNomeSW = sobrenome.substring(0, 3) + nome.substring(0, 2);

        // Sobrenome: 2 primeiras do sobrenome da mãe + 3 primeiras da cidade natal
        String sobrenomeSW = sobrenomeSolteiraMae.substring(0, 2) + cidadeNatal.substring(0, 3);

        return formatar(primeiroNomeSW) + " " + formatar(sobrenomeSW);
    }

    private String formatar(String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    // Getters e Setters caso precise
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public String getSobrenomeSolteiraMae() { return sobrenomeSolteiraMae; }
    public void setSobrenomeSolteiraMae(String sobrenomeSolteiraMae) { this.sobrenomeSolteiraMae = sobrenomeSolteiraMae; }
    public String getCidadeNatal() { return cidadeNatal; }
    public void setCidadeNatal(String cidadeNatal) { this.cidadeNatal = cidadeNatal; }
}