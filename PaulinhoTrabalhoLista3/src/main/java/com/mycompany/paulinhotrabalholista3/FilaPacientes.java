/*Uma clínica precisa de um sistema para organizar a fila de pacientes, para cada dia 
é disponibilizado 20 senhas para consulta. Eles necessitam de um sistema onde é 
informado o nome do paciente em ordem de chegada e uma opção para chamar o 
próximo paciente. Desenvolva um algoritmo de Fila, contendo um menu com as 
opções: 1 - Adicionar paciente, 2 - Chamar próximo paciente. A opção 1 deverá exibir 
um campo para informar o nome do paciente assim que ele chega no consultório, e a 
opção 2, ao selecionar deverá exibir o nome do próximo paciente na fila. 
*/

package com.mycompany.paulinhotrabalholista3;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaPacientes {
    private Queue<String> fila;
    private int senhaAtual;

    public FilaPacientes() {
        fila = new LinkedList<>();
        senhaAtual = 1;
    }

    public static void main(String[] args) {
        FilaPacientes filaPacientes = new FilaPacientes();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    filaPacientes.adicionarPaciente(scanner);
                    break;
                case 2:
                    filaPacientes.chamarProximoPaciente();
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n*** Fila de Pacientes ***");
        System.out.println("1. Adicionar Paciente");
        System.out.println("2. Chamar Próximo Paciente");
        System.out.println("3. Sair");
        System.out.print("Opção: ");
    }

    private void adicionarPaciente(Scanner scanner) {
        if (fila.size() >= 20) {
            System.out.println("A fila está cheia. Aguarde o atendimento ou volte em outro dia.");
        } else {
            System.out.print("Digite o nome do paciente: ");
            String nome = scanner.nextLine();
            fila.offer(nome);
            System.out.println("Paciente " + nome + " adicionado à fila.");
        }
    }

    private void chamarProximoPaciente() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia. Não há pacientes para chamar.");
        } else {
            String proximoPaciente = fila.poll();
            System.out.println("Próximo paciente: " + proximoPaciente);
        }
    }
}
