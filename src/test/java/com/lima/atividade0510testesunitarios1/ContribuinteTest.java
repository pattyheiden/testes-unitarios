package com.lima.atividade0510testesunitarios1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContribuinteTest {

    @Test
    @DisplayName("Deve isentar (0%) para renda até R$ 4.000,00")
    void deveCalcularImpostoFaixaIsencao() {
        Contribuinte c1 = new Contribuinte("João", "111.111.111-11", "PR", 0.00);
        Contribuinte c2 = new Contribuinte("Maria", "222.222.222-22", "SC", 4000.00);

        assertEquals(0.00, c1.calcularImposto(), 0.001);
        assertEquals(0.00, c2.calcularImposto(), 0.001);
    }

    @Test
    @DisplayName("Deve aplicar 5,8% para renda de R$ 4.001,00 a R$ 9.000,00")
    void deveCalcularImpostoFaixa58Porcento() {
        // 5000 * 0.058 = 290.00
        Contribuinte c1 = new Contribuinte("Lucas", "333.333.333-33", "RS", 5000.00);
        // 9000 * 0.058 = 522.00
        Contribuinte c2 = new Contribuinte("Ana", "444.444.444-44", "PR", 9000.00);

        assertEquals(290.00, c1.calcularImposto(), 0.001);
        assertEquals(522.00, c2.calcularImposto(), 0.001);
    }

    @Test
    @DisplayName("Deve aplicar 15% para renda de R$ 9.001,00 a R$ 25.000,00")
    void deveCalcularImpostoFaixa15Porcento() {
        // 10000 * 0.15 = 1500.00
        Contribuinte c1 = new Contribuinte("Carlos", "555.555.555-55", "SC", 10000.00);
        // 25000 * 0.15 = 3750.00
        Contribuinte c2 = new Contribuinte("Beatriz", "666.666.666-66", "RS", 25000.00);

        assertEquals(1500.00, c1.calcularImposto(), 0.001);
        assertEquals(3750.00, c2.calcularImposto(), 0.001);
    }

    @Test
    @DisplayName("Deve aplicar 27,5% para renda de R$ 25.001,00 a R$ 35.000,00")
    void deveCalcularImpostoFaixa275Porcento() {
        // 30000 * 0.275 = 8250.00
        Contribuinte c1 = new Contribuinte("Marcos", "777.777.777-77", "PR", 30000.00);
        // 35000 * 0.275 = 9625.00
        Contribuinte c2 = new Contribuinte("Juliana", "888.888.888-88", "SC", 35000.00);

        assertEquals(8250.00, c1.calcularImposto(), 0.001);
        assertEquals(9625.00, c2.calcularImposto(), 0.001);
    }

    @Test
    @DisplayName("Deve aplicar 30% para renda acima de R$ 35.000,00 (Exemplo do enunciado)")
    void deveCalcularImpostoFaixa30Porcento() {
        // 40000 * 0.30 = 12000.00 (Exemplo fornecido na folha de exercícios)
        Contribuinte c1 = new Contribuinte("João da Silva", "123.456.789-00", "PR", 40000.00);
        // 50000 * 0.30 = 15000.00
        Contribuinte c2 = new Contribuinte("Paula", "999.999.999-99", "RS", 50000.00);

        assertEquals(12000.00, c1.calcularImposto(), 0.001);
        assertEquals(15000.00, c2.calcularImposto(), 0.001);
    }

    @Test
    @DisplayName("Deve lançar exceção para renda anual negativa")
    void deveLancarExcecaoParaRendaNegativa() {
        Contribuinte c = new Contribuinte("Invalido", "000.000.000-00", "PR", -500.00);

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                c::calcularImposto
        );
        assertEquals("A renda anual não pode ser negativa.", excecao.getMessage());
    }
}