
package com.mycompany.paulinhotrabalholista;


//Desenvolva um método que faça a soma de 0 a 50;   

    public class SomaRecursiva {

        public static int somaRecursiva(int n) {
            if (n == 0) {
                return 0;
            } else {
                return n + somaRecursiva(n - 1);
            }
        }

        public static void main(String[] args) {
            int resultado = somaRecursiva(50);
            System.out.println("A soma de 0 a 50 é: " + resultado);
        }
    }



