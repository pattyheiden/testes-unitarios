package com.lima.atividade0510testesunitarios1;

public class Contribuinte {

    private String nome;
    private String cpf;
    private String uf;
    private double rendaAnual;

    public Contribuinte(String nome, String cpf, String uf, double rendaAnual) {
        this.nome = nome;
        this.cpf = cpf;
        this.uf = uf;
        this.rendaAnual = rendaAnual;
    }

    public double calcularImposto() {
        if (rendaAnual < 0) {
            throw new IllegalArgumentException("A renda anual não pode ser negativa.");
        }

        double aliquota;

        if (rendaAnual <= 4000.00) {
            aliquota = 0.0;
        } else if (rendaAnual <= 9000.00) {
            aliquota = 0.058;
        } else if (rendaAnual <= 25000.00) {
            aliquota = 0.15;
        } else if (rendaAnual <= 35000.00) {
            aliquota = 0.275;
        } else {
            aliquota = 0.30;
        }

        return rendaAnual * aliquota;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public double getRendaAnual() { return rendaAnual; }
    public void setRendaAnual(double rendaAnual) { this.rendaAnual = rendaAnual; }
}
