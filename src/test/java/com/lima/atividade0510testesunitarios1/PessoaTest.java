package com.lima.atividade0510testesunitarios1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PessoaTest {

    @Test
    @DisplayName("Deve gerar o nome completo de Star Wars corretamente")
    void deveGerarNomeStarWarsComSucesso() {
        // Sobrenome: Silveira (Sil) + Nome: Lucas (Lu) = Sillu
        // Sobrenome Mãe: Santos (Sa) + Cidade: Blumenau (Blu) = Sablu
        Pessoa pessoa = new Pessoa("Lucas", "Silveira", "Santos", "Blumenau");

        String resultado = pessoa.gerarNomeStarWars();

        assertEquals("Sillu Sablu", resultado);
    }

    @Test
    @DisplayName("Deve manter a formatação correta mesmo com entradas em minúsculas ou maiúsculas")
    void deveFormatarCaixaDasLetrasCorretamente() {
        // Sobrenome: FERREIRA (Fer) + Nome: ana (An) = Feran
        // Sobrenome Mãe: almeida (Al) + Cidade: CURITIBA (Cur) = Alcur
        Pessoa pessoa = new Pessoa("ana", "FERREIRA", "almeida", "CURITIBA");

        String resultado = pessoa.gerarNomeStarWars();

        assertEquals("Feran Alcur", resultado);
    }

    @Test
    @DisplayName("Deve lançar exceção quando o nome tiver menos de 2 caracteres")
    void deveLancarExcecaoQuandoNomeForCurto() {
        Pessoa pessoa = new Pessoa("A", "Silva", "Santos", "Blumenau");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                pessoa::gerarNomeStarWars
        );
        assertEquals("O nome deve ter pelo menos 2 caracteres.", excecao.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando o sobrenome tiver menos de 3 caracteres")
    void deveLancarExcecaoQuandoSobrenomeForCurto() {
        Pessoa pessoa = new Pessoa("Ana", "Li", "Santos", "Blumenau");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                pessoa::gerarNomeStarWars
        );
        assertEquals("O sobrenome deve ter pelo menos 3 caracteres.", excecao.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando o sobrenome da mãe tiver menos de 2 caracteres")
    void deveLancarExcecaoQuandoSobrenomeMaeForCurto() {
        Pessoa pessoa = new Pessoa("Ana", "Silva", "S", "Blumenau");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                pessoa::gerarNomeStarWars
        );
        assertEquals("O sobrenome de solteira da mãe deve ter pelo menos 2 caracteres.", excecao.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando a cidade natal tiver menos de 3 caracteres")
    void deveLancarExcecaoQuandoCidadeForCurta() {
        Pessoa pessoa = new Pessoa("Ana", "Silva", "Santos", "SP");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                pessoa::gerarNomeStarWars
        );
        assertEquals("A cidade natal deve ter pelo menos 3 caracteres.", excecao.getMessage());
    }
}
