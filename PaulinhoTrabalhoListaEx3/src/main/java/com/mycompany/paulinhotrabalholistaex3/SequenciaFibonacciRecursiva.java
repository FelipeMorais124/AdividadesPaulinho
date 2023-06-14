//Desenvolva um método que mostre a sequência Fibonacci de um número.
//Sequencia Fibonacci: 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610,
//987, 1597, 2584, ...
package com.mycompany.paulinhotrabalholistaex3;

public class SequenciaFibonacciRecursiva {
    public static void mostrarSequenciaFibonacci(int numero) {
        for (int i = 0; i <= numero; i++) {
            System.out.print(calcularFibonacci(i) + " ");
        }
    }

    public static int calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int limite = 1000;

        System.out.println("Sequência de Fibonacci até " + limite + ":");
        mostrarSequenciaFibonacci(limite);
    }
}

