package com.lima.atividade0510testesunitarios1;

public class Atleta {

    private String nome;
    private int idade;
    private double altura;
    private double peso;

    public Atleta(String nome, int idade, double altura, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String obterCategoriaPorIdade() {
        if (idade >= 5 && idade <= 7) return "pré-mirim";
        if (idade >= 8 && idade <= 10) return "mirim";
        if (idade >= 11 && idade <= 13) return "infantil";
        if (idade >= 14 && idade <= 17) return "infanto-juvenil";
        if (idade >= 18 && idade <= 20) return "juvenil";
        if (idade >= 21) return "adulto";
        throw new IllegalArgumentException("Idade abaixo do limite permitido (mínimo 5 anos).");
    }

    public double calcularIMC() {
        if (altura <= 0) {
            throw new IllegalArgumentException("A altura deve ser maior que zero.");
        }
        return peso / (altura * altura);
    }

    public String classificarIMC() {
        double imc = calcularIMC();

        if (imc < 18.5) return "Magreza";
        if (imc <= 24.9) return "Saudável";
        if (imc <= 29.9) return "Sobrepeso";
        if (imc <= 34.9) return "Obesidade Grau I";
        if (imc <= 39.9) return "Obesidade Grau II (severa)";
        return "Obesidade Grau III (morbida)";
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
}