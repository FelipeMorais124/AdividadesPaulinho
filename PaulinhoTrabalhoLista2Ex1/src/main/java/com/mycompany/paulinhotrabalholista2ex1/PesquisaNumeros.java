/*Desenvolva um programa que solicite ao 
usuário para informar a quantidade de números 
que irá cadastrar, após solicite para informar os 
mesmos. Nesse aplicativo deverá ter um menu 
para selecionar o tipo de pesquisa que deseja 
fazer, linear ou binária. Para efetuar a pesquisa 
solicite qual número a ser pesquisado, coloque-os 
em ordem crescente e faça a pesquisa seleciona e 
exiba para o usuário o resultado*/


package com.mycompany.paulinhotrabalholista2ex1;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

public class PesquisaNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números a serem cadastrados: ");
        int quantidade = scanner.nextInt();

        int[] numeros = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o número #" + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        Arrays.sort(numeros);

        System.out.println("\nNúmeros cadastrados em ordem crescente: " + Arrays.toString(numeros));

        System.out.print("\nDigite o número a ser pesquisado: ");
        int numeroPesquisado = scanner.nextInt();

        int resultado = Arrays.binarySearch(numeros, numeroPesquisado);

        if (resultado >= 0) {
            System.out.println("O número " + numeroPesquisado + " foi encontrado na posição " + resultado + ".");
        } else {
            System.out.println("O número " + numeroPesquisado + " não foi encontrado na lista.");
        }

        scanner.close();
    }
}
