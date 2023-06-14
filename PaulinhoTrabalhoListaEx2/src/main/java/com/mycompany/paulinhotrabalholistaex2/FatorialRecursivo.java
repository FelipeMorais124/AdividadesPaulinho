
package com.mycompany.paulinhotrabalholistaex2;


//Desenvolva um método que o usuário informe um número e calcule o fatorial
//desse número.
//Fórmula fatorial: n! = n . (n - 1)! 


import java.util.Scanner;

import java.util.Scanner;

public class FatorialRecursivo {
    public static int calcularFatorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * calcularFatorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        int fatorial = calcularFatorial(numero);
        System.out.println("O fatorial de " + numero + " é: " + fatorial);

        scanner.close();
    }
}
