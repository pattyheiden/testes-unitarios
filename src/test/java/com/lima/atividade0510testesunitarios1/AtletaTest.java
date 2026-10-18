package com.lima.atividade0510testesunitarios1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AtletaTest {

    @Test
    @DisplayName("Deve categorizar corretamente os atletas em cada faixa etária")
    void deveCategorizarAtletaPorFaixaEtaria() {
        Atleta preMirim = new Atleta("Lucas", 6, 1.20, 22.0);
        assertEquals("pré-mirim", preMirim.obterCategoriaPorIdade());

        Atleta mirim = new Atleta("Lucas", 9, 1.35, 30.0);
        assertEquals("mirim", mirim.obterCategoriaPorIdade());

        Atleta infantil = new Atleta("Lucas", 12, 1.50, 42.0);
        assertEquals("infantil", infantil.obterCategoriaPorIdade());

        Atleta infantoJuvenil = new Atleta("Lucas", 15, 1.65, 55.0);
        assertEquals("infanto-juvenil", infantoJuvenil.obterCategoriaPorIdade());

        Atleta juvenil = new Atleta("Lucas", 19, 1.75, 68.0);
        assertEquals("juvenil", juvenil.obterCategoriaPorIdade());

        Atleta adulto = new Atleta("Lucas", 25, 1.80, 75.0);
        assertEquals("adulto", adulto.obterCategoriaPorIdade());
    }

    @Test
    @DisplayName("Deve lançar exceção para idade abaixo de 5 anos")
    void deveLancarExcecaoParaIdadeInvalida() {
        Atleta atleta = new Atleta("Lucas", 4, 1.00, 16.0);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                atleta::obterCategoriaPorIdade
        );
        assertEquals("Idade abaixo do limite permitido (mínimo 5 anos).", excecao.getMessage());
    }

    @Test
    @DisplayName("Deve calcular o valor numérico do IMC com precisão")
    void deveCalcularIMCComSucesso() {
        // IMC = 80 / (2.0 * 2.0) = 80 / 4 = 20.0
        Atleta atleta = new Atleta("Lucas", 22, 2.00, 80.0);
        assertEquals(20.0, atleta.calcularIMC(), 0.001);
    }

    @Test
    @DisplayName("Deve lançar exceção ao calcular IMC com altura menor ou igual a zero")
    void deveLancarExcecaoParaAlturaInvalida() {
        Atleta atleta = new Atleta("Lucas", 22, 0.0, 70.0);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                atleta::calcularIMC
        );
        assertEquals("A altura deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    @DisplayName("Deve classificar todas as faixas da tabela de IMC corretamente")
    void deveClassificarFaixasDeIMC() {
        // Magreza: IMC < 18.5 (~16.33)
        Atleta magreza = new Atleta("Lucas", 22, 1.75, 50.0);
        assertEquals("Magreza", magreza.classificarIMC());

        // Saudável: 18.5 - 24.9 (~21.22)
        Atleta saudavel = new Atleta("Lucas", 22, 1.75, 65.0);
        assertEquals("Saudável", saudavel.classificarIMC());

        // Sobrepeso: 25.0 - 29.9 (~26.12)
        Atleta sobrepeso = new Atleta("Lucas", 22, 1.75, 80.0);
        assertEquals("Sobrepeso", sobrepeso.classificarIMC());

        // Obesidade Grau I: 30.0 - 34.9 (~31.02)
        Atleta grau1 = new Atleta("Lucas", 22, 1.75, 95.0);
        assertEquals("Obesidade Grau I", grau1.classificarIMC());

        // Obesidade Grau II (severa): 35.0 - 39.9 (~35.92)
        Atleta grau2 = new Atleta("Lucas", 22, 1.75, 110.0);
        assertEquals("Obesidade Grau II (severa)", grau2.classificarIMC());

        // Obesidade Grau III (morbida): > 40.0 (~42.45)
        Atleta grau3 = new Atleta("Lucas", 22, 1.75, 130.0);
        assertEquals("Obesidade Grau III (morbida)", grau3.classificarIMC());
    }
}