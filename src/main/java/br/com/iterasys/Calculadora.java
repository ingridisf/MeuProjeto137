// 1 - Pacote: conjunto de classes
package br.com.iterasys;

// 2 - Bibliotecas


// 3 - Classe: nome de classe é sempre um substantivo, por exemplo "cliente"

public class Calculadora {
    // 3.1 Atributos - quais são os atributos, caracteristicas e adjetivos de uma classe

    // 3.2 Funções e Métodos
    public static double somarDoisNumeros(double num1, double num2) {
        return num1 + num2;
    }
    // ToDo: Criar o código para subtrair, multiplicar e dividir

    // Exercicio Subtrair
    // na função eu preciso dizer se ela é publica ou privada
    // No método, neste caso, escolhemos o DOUBLE/NUMERO GRANDE, para fazer somas em grande quantidade
    // O nome para o método DOUBLE, neste caso, é somarDoisNumeros
    // () o parenteses serve para receber e enviar/ conexão/portal
    // criar "envelopes" ou seja variáveis dentro do parenteses para receber cada um dos números
    // informe o tipo de método para cada variável, exemplo : double num1, double num2)
    // Após o parenteses com as variavéis, inserir as chaves
    // {} as chaves significa começo e fim/ função de retorno
    // dentro das chaves {} inserir novamente as váriaveis num1 e num2 criadas para ter o retorno do cálculo
    // para gerar o resultado é preciso criar a variável RESULTADO junto com as variveis num1 e num2, por exemplo
    // return num1 e num2
    // otimização, melhor desempenho > STATIC > Informação preservada na memória

    public static double subtrairDoisNumeros(double num1, double num2) { // inicio da função
        return num1 - num2;

    } // final da função

    public static double multiplicarDoisNumeros(double num1, double num2) { // inicio da função
        return num1 * num2;
    } // final da função

   public static String dividirDoisNumerosInteiros ( int numA, int numB) {
        // método try catch - try > tentativa
       try {
           // para fazer a conversão de um número int dentro de um variável string temos que usar a função
           // String.valueOf ()
           return String.valueOf(numA / numB);
       }
       // catch será a correção se caso tenha dado errado (plano b)
       // para montar o catch é catch (exepetion e) e dentro de chaves inserir o retorno que será preciso {}
       catch ( Exception e) {
           return "Não é possível dividir por zero";

       }


   }

    public static double dividirDoisNumeros(double num1, double num2) { // inicio da função dividir
        try{
            if (num1/num2 < Double.MAX_VALUE && num1/num2 > Double.MIN_VALUE){
                return num1 / num2;
            } else {
                System.out.println("Não foi possível dividir por zero!");
                return 0;
            }
        }
        catch (RuntimeException e){
            System.out.println("Não foi possível dividir por zero");
            return 0;
        }

    } // final da função dividir

} // final da classe







