package com.lima.atividade0510testesunitarios1;

public class EpocaDoAno {
    public static String obterEstacao(int estacao) {
        return switch (estacao){
            case 1 -> "É verão\ne o tempo está quente.";
            case 2 -> "É outono\ne as folhas caem.";
            case 3 -> "É inverno\ne está frio.";
            case 4 -> "É primavera\ne as flores desabrocham.";
            default -> throw new IllegalArgumentException("Estação inválida! Informe um número entre 1 e 4.");
        };
    }

    /*
    * professor
    *
    * public static String obterEstacao(int estacao) {

        if (estacao <= 0 || estacao >= 5){
            throw new RuntimeException("Estação inválida! Informe um número entre 1 e 4.");
        }
        String texto =  switch (estacao){
            case 1 -> "É verão\ne o tempo está quente.";
            case 2 -> "É outono\ne as folhas caem.";
            case 3 -> "É inverno\ne está frio.";
            case 4 -> "É primavera\ne as flores desabrocham.";
            default -> null;
        };
        return texto;
    }
    * */
}
