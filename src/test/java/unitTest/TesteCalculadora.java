package unitTest;

// Bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe - substativo - dentro da classe teremos os atributos/funções e os métodos

public class TesteCalculadora {
    // Atributos

    // Funções e Métodos

    // Agora faremos uma função que fara um teste com a calculadora que foi criada em dev main
    // o Junit trabalha com anotações que são precedidos pelo @ antes da frase > @Test
    // lembrando que será preciso talvez baixar a biblioteca para usar o Junit
    // em testes usaremos na maioria das vezes o método VOID
    // ficando public VOID
    // De um nome para o método VOID, neste caso, testeSomarDoisNumeros, por exemplo
    // Após isso abrir os parenteses () porém, não será preciso receber valores
    // continunando ... devido ao método VOID que não devolve resultado
    // após isso abrir chaves {} porém, não será preciso receber valores, por causa do método VOID;
    // todo teste é composto por três partes: Configura > executa e valida
    // Configuração: valores de entrada das variáveis que foram criadas no dev, exemplo num1 e num2
    // Configuração: Valores de saída também da variável resultado, exemplo double resultadoEsperado
    // Em executa é a linha que executa a calculadora
    // validar > assertEquals com o resultado atual com o esperado

    @Test
    public void testeSomarDoisNumeros() { // inicio do teste somar
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 12;

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoAtual, resultadoEsperado);
    } // final do teste do somar


   // Montando o teste com uma lista de valores, para fazer esse teste, será preciso usar a biblioteca Parametrizado
    // ao invés de @Test que é um teste simples, agora será o teste @ParameterizedTest
    // CSV > texto separado por vírgula
    // este é um teste de unidade data driven - direcionado por dados
    @ParameterizedTest
    @CsvSource (value = {
            "7,5,12.0",
            "56,44,100.0",
            "10,0,10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0"
    }, delimiter = ',')
    // inserir a lista dentro do parensetes do teste somar dois numeros
    public void testeSomarDoisNumerosLendoLista( String txtNum1, String txtNum2, String resultadoEsperado) { // inicio do teste somar
        //Confugura
        // Os dados de entrada e o resultado esperado vem da lista do parametizado

        // EXECUTA
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    } // final do teste somar

    @ParameterizedTest
    @CsvFileSource (resources = "csv/massaSomar.csv",numLinesToSkip = 1, delimiter = ',')
    // inserir a lista dentro do parensetes do teste somar dois numeros
    public void testeSomarDoisNumerosLendoArquivo( String txtNum1, String txtNum2, String resultadoEsperado) { // inicio do teste somar
        //Confugura
        // Os dados de entrada e o resultado esperado vem da lista do parametizado

        // EXECUTA
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    } // final do teste somar


    @Test
        public static void testeSubtrairDoisNumeros() {
        double num1 = 4;
        double num2 = 3;
        double resultadoEsperado = 1;

        //executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);

        //valida
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public static void testeMultiplicarDoisNumeros() {
        double num1 = 2;
        double num2 = 6;
        double resultadoEsperado = 12;

        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num2, num2);

        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeDividirDoisNumeros () { // inicio do teste
        // Configura
        double num1 = 10;
        double num2 = 4;
        double resultadoEsperado = 2.5;
        // executa
        double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);
        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    } // final do teste dividir

@Test
    public void testeDividirDoisNumerosInteiros () { // inicio do teste dividir inteiro
         //Configura
         int numA = 42;
         int numB = 0;
         String resultadoEsperado = "Não é possível dividir por zero";

        //executa
    String resultadoAtual = Calculadora.dividirDoisNumerosInteiros( numA, numB);

       // valida - "AssertEquals" é que fará a validação/comparação do resultado esperdo com o resultado atual
    assertEquals(resultadoEsperado, resultadoAtual);
    // elemento System objetivo do sistema para controlar sistema operacional
    // out controla as saídas do sistemas
    // println - escrever uma linha e pular
    System.out.println( numA + " / " + numB +" = " + resultadoAtual);
    System.out.println("O resultado esperado: " + resultadoEsperado);

} // fim do teste dividir inteiro

    // exercício
    // Montando o teste com uma lista de valores, para fazer esse teste, será preciso usar a biblioteca Parametrizado
    // ao invés de @Test que é um teste simples, agora será o teste @ParameterizedTest
    // CSV > texto separado por vírgula
    // este é um teste de unidade data driven - direcionado por dados
    @ParameterizedTest
    @CsvSource (value = {
            "10, -5, 5",
            "30, -15, 15",
    }, delimiter = ',')
    // dentro do parenteses será preciso informar que o método é um String, Pois os valores foram inseridos entre ""
    public void exercicioTesteSubtrairNumeros ( String txtNum3, String txtNum4, String resultadoEsperado)
    {
        double resultadoAtual = Calculadora.subtrairDoisNumeros(Integer.valueOf(txtNum3), Integer.valueOf(txtNum4));

    }

    // exercicio multiplicar lista
    @ParameterizedTest
    @CsvSource (value = {
            "5, 2, 10",
            "2, 6, 12"
    }, delimiter = ',')
    // dentro do parenteses será preciso informar que o método é um String, Pois os valores foram inseridos entre ""
    public void exercicioTesteMultiplicarNumeros ( String txtNum1, String txtNum2, String resultadoEsperado)
    {
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

    }


}
