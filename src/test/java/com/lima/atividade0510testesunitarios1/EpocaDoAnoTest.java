package com.lima.atividade0510testesunitarios1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EpocaDoAnoTest {

    @Test
    void retornarMensagemVerao() {

        //Arrange
        int estacao = 1;

        //Act
        String resultado = EpocaDoAno.obterEstacao(estacao);

        //Assert
        Assertions.assertThat(resultado).isEqualTo("É verão\ne o tempo está quente.");

        /*
        Meu código --->
        String resultado = EpocaDoAno.obterEstacao(1);
        Assertions.assertThat(resultado).isEqualTo("É verão\ne o tempo está quente.");
        */
    }

    @Test
    void retornarMensagemOutono() {
        String resultado = EpocaDoAno.obterEstacao(2);
        Assertions.assertThat(resultado).isEqualTo("É outono\ne as folhas caem.");
    }

    @Test
    void retornarMensagemInverno() {
        String resultado = EpocaDoAno.obterEstacao(3);
        Assertions.assertThat(resultado).isEqualTo("É inverno\ne está frio.");
    }

    @Test
    void retornarMensagemPrimavera() {
        String resultado = EpocaDoAno.obterEstacao(4);
        Assertions.assertThat(resultado).isEqualTo("É primavera\ne as flores desabrocham.");
    }

    @Test
    void retornaEstacaoInvalidaMaiorQueCinco() {
        int estacao = 5;
        Assertions.assertThatThrownBy(
                () -> EpocaDoAno.obterEstacao(estacao))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Estação inválida! Informe um número entre 1 e 4.");
    }

    @Test
    void retornaEstacaoInvalidaMenorQueUm() {
        int estacao = 0;
        Assertions.assertThatThrownBy(
                        () -> EpocaDoAno.obterEstacao(estacao))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Estação inválida! Informe um número entre 1 e 4.");
    }

}
