# Testes Unitários com Java

Projeto de exercícios para praticar testes automatizados em Java com JUnit Jupiter e AssertJ, utilizando uma estrutura Spring Boot e Maven.

Os exemplos exploram cálculos, condições, manipulação de strings e validação de entradas, com cenários de sucesso e verificação de exceções.

## Objetivos

- Testar o comportamento de métodos de forma isolada.
- Organizar cenários seguindo o padrão **Arrange, Act, Assert**: preparar, executar e verificar.
- Comparar resultados esperados com os valores retornados.
- Validar exceções e suas mensagens.
- Trabalhar com asserções para strings, booleanos e números decimais.
- Usar `@DisplayName` para descrever cenários de teste.

## Tecnologias

| Tecnologia | Uso no projeto |
| --- | --- |
| Java 17 | Versão configurada no `pom.xml` |
| Spring Boot 4.1.1 | Estrutura da aplicação e teste de contexto |
| JUnit Jupiter | Definição e execução dos testes |
| AssertJ | Asserções fluentes |
| Maven Wrapper | Gerenciamento de dependências e execução do build |

O `pom.xml` também inclui Spring Web MVC, Bean Validation, Springdoc OpenAPI e DevTools. Os exercícios são implementados em classes Java, sem controllers ou endpoints próprios.

## Exercícios implementados

### 1. Verificação de número par — `Numero`

O método estático `ehPar(double numero)` verifica se o resto da divisão por 2 é zero.

```java
Numero.ehPar(2); // true
Numero.ehPar(1); // false
```

Os testes verificam um número par e um número ímpar. Embora o parâmetro seja `double`, os exemplos de paridade utilizam valores inteiros.

### 2. Estações do ano — `EpocaDoAno`

O método estático `obterEstacao(int estacao)` retorna uma mensagem conforme o código informado:

| Código | Mensagem retornada (`\n` representa uma quebra de linha) |
| --- | --- |
| `1` | `É verão\ne o tempo está quente.` |
| `2` | `É outono\ne as folhas caem.` |
| `3` | `É inverno\ne está frio.` |
| `4` | `É primavera\ne as flores desabrocham.` |

Valores fora do intervalo de 1 a 4 lançam `IllegalArgumentException` com a mensagem `Estação inválida! Informe um número entre 1 e 4.`.

### 3. Categoria e IMC de atletas — `Atleta`

A classe recebe nome, idade, altura em metros e peso em quilogramas. Seus métodos permitem:

- `obterCategoriaPorIdade()`: identificar a categoria do atleta.
- `calcularIMC()`: calcular `peso / (altura * altura)`.
- `classificarIMC()`: retornar a classificação definida no exercício a partir do resultado calculado.

| Idade | Categoria |
| --- | --- |
| 5 a 7 anos | pré-mirim |
| 8 a 10 anos | mirim |
| 11 a 13 anos | infantil |
| 14 a 17 anos | infanto-juvenil |
| 18 a 20 anos | juvenil |
| A partir de 21 anos | adulto |

Idades abaixo de 5 anos geram exceção na categorização. Alturas menores ou iguais a zero geram exceção no cálculo do IMC.

```java
Atleta atleta = new Atleta("Lucas", 22, 2.0, 80.0);

atleta.obterCategoriaPorIdade(); // "adulto"
atleta.calcularIMC();           // 20.0
atleta.classificarIMC();        // "Saudável"
```

### 4. Cálculo de imposto — `Contribuinte`

A classe recebe nome, CPF, UF e renda anual. O método `calcularImposto()` aplica uma alíquota sobre o valor total da renda, conforme as regras do exercício:

| Renda anual | Alíquota |
| --- | --- |
| De 0 até 4.000,00 | 0% |
| Acima de 4.000,00 até 9.000,00 | 5,8% |
| Acima de 9.000,00 até 25.000,00 | 15% |
| Acima de 25.000,00 até 35.000,00 | 27,5% |
| Acima de 35.000,00 | 30% |

Rendas negativas lançam `IllegalArgumentException`. CPF e UF são armazenados, mas não participam do cálculo.

```java
Contribuinte contribuinte = new Contribuinte(
    "João da Silva", "123.456.789-00", "PR", 40000.0
);

contribuinte.calcularImposto(); // 12000.0
```

Essa tabela representa a regra didática implementada no projeto, sem cálculo progressivo por faixas ou vínculo com uma tabela tributária oficial.

### 5. Gerador de nome Star Wars — `Pessoa`

O método `gerarNomeStarWars()` monta um nome combinando partes dos dados recebidos:

- **Primeiro nome:** três primeiros caracteres do sobrenome + dois primeiros caracteres do nome.
- **Sobrenome:** dois primeiros caracteres do sobrenome de solteira da mãe + três primeiros caracteres da cidade natal.

Cada parte é formatada com a primeira letra maiúscula e as demais minúsculas. Entradas nulas ou com menos caracteres que o necessário lançam `IllegalArgumentException` ao gerar o nome.

```java
Pessoa pessoa = new Pessoa("Lucas", "Silveira", "Santos", "Blumenau");

pessoa.gerarNomeStarWars(); // "Sillu Sablu"
```

## Como executar os testes

### Pré-requisitos

- JDK 17 ou superior, com `JAVA_HOME` configurado.
- Git para clonar o repositório.
- Acesso à internet na primeira execução para baixar o Maven e as dependências.

O Maven Wrapper está incluído no repositório; não é necessário instalar o Maven separadamente.

### Clonar o repositório

```bash
git clone https://github.com/pattyheiden/testes-unitarios.git
cd testes-unitarios
```

### Executar todos os testes

No Windows (PowerShell):

```powershell
.\mvnw.cmd test
```

No Linux ou macOS:

```bash
chmod +x mvnw
./mvnw test
```

### Executar uma classe específica

No Windows:

```powershell
.\mvnw.cmd "-Dtest=PessoaTest" test
```

No Linux ou macOS:

```bash
./mvnw -Dtest=PessoaTest test
```

Substitua `PessoaTest` por `NumeroTest`, `EpocaDoAnoTest`, `AtletaTest` ou `ContribuinteTest` para executar outro exercício.

O Maven apresenta o resultado no terminal e gera relatórios em `target/surefire-reports/`. Não é necessário iniciar a aplicação manualmente para executar os testes; o teste com `@SpringBootTest` carrega o contexto automaticamente.

## Organização dos testes

| Classe de teste | Cenários presentes |
| --- | --- |
| `NumeroTest` | Retorno para número par e ímpar |
| `EpocaDoAnoTest` | Mensagens das quatro estações e rejeição dos códigos inválidos `0` e `5` |
| `AtletaTest` | Categorias por idade, idade inválida, cálculo e classificação do IMC, altura inválida |
| `ContribuinteTest` | Alíquotas por faixa de renda e rejeição de renda negativa |
| `PessoaTest` | Geração do nome, formatação de letras e campos com tamanho insuficiente |
| `Atividade0510TestesUnitarios1ApplicationTests` | Carregamento do contexto Spring |

As cinco classes de exercícios são testadas diretamente, sem carregar o contexto Spring. O teste `contextLoads()` verifica separadamente a inicialização desse contexto.

Exemplo do padrão Arrange, Act, Assert utilizado no projeto:

```java
@Test
void deveRetornarTrueParaNumerosPares() {
    // Arrange: preparar os dados
    double numero = 2;

    // Act: executar o comportamento
    boolean resultado = Numero.ehPar(numero);

    // Assert: verificar o resultado
    Assertions.assertThat(resultado).isTrue();
}
```

O exemplo utiliza `org.junit.jupiter.api.Test` e `org.assertj.core.api.Assertions`.

## Estrutura do projeto

```text
src/
├── main/
│   ├── java/com/lima/atividade0510testesunitarios1/
│   │   ├── Atividade0510TestesUnitarios1Application.java
│   │   ├── Atleta.java
│   │   ├── Contribuinte.java
│   │   ├── EpocaDoAno.java
│   │   ├── Numero.java
│   │   └── Pessoa.java
│   └── resources/
│       └── application.properties
└── test/java/com/lima/atividade0510testesunitarios1/
    ├── Atividade0510TestesUnitarios1ApplicationTests.java
    ├── AtletaTest.java
    ├── ContribuinteTest.java
    ├── EpocaDoAnoTest.java
    ├── NumeroTest.java
    └── PessoaTest.java
```

## Escopo da suíte

O projeto possui 26 métodos anotados com `@Test`: 25 testes dos exercícios e um teste de carregamento do contexto Spring. Alguns métodos verificam vários exemplos dentro do mesmo teste.

Em `EpocaDoAnoTest`, os cenários com os valores `0` e `5` estão anotados com `@Test` e verificam a exceção e a mensagem para códigos fora do intervalo permitido.

A documentação foi revisada a partir do código atualizado do repositório. A suíte não foi executada durante esta revisão, e não há medição de cobertura configurada no `pom.xml`.
