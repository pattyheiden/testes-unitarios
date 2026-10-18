package com.lima.atividade0510testesunitarios1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumeroTest {

    @Test
    @DisplayName("O número é par")
    void deveRetornarTrueParaNumerosPares() {

        //Arrange
        double numPar = 2;

        //Act
        boolean resultado = Numero.ehPar(numPar);

        //Assert
        Assertions.assertThat(resultado).isTrue();

        //Assertions.assertTrue(Numero.ehPar(10));
    }

    @Test
    @DisplayName("O número é impar")
    void deveRetornarFalseParaNumerosImpares() {

        //Arrange
        double numPar = 1;

        //Act
        boolean resultado = Numero.ehPar(numPar);

        //Assert
        Assertions.assertThat(resultado).isFalse();

        //Assertions.assertTrue(Numero.ehPar(10));

        //Assertions.assertFalse(Numero.ehPar(9));
    }
}
