/*Um banco necessita de uma sistema para controlar a fila de pagamentos no caixa. 
Para o atendimento é obedecido a lei de prioridade, onde a cada 2 clientes prioritários, 
um cliente normal é atendido. Desenvolva um algoritmo para controlar a fila de 
atendimento, para isso deverá ser criado 2 filas, uma de atendimento prioritário e outra 
de atendimento normal. Na fila será cadastrado os seguintes dados do cliente: 
Cliente 
- int senha; 
- String nome; 
- int anoNascimento; 
Deverá ser determinado pela a idade qual fila será inserido o cliente, acima de 65 anos 
fila prioritária, os demais na fila normal. Crie um menu com uma opção para adicionar o 
cliente, e outra para chamar o cliente. Lembre-se deverá seguir a regra de ao ser 
atendido 2 clientes prioritários será atendido um cliente normal.*/

package com.mycompany.paulinhotrabalholista3ex1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ControleFilaCaixa {
    private static final int LIMITE_PRIORITARIOS = 2;

    private Queue<Cliente> filaPrioritaria;
    private Queue<Cliente> filaNormal;
    private int atendidosDesdeUltimoNormal;

    public ControleFilaCaixa() {
        filaPrioritaria = new LinkedList<>();
        filaNormal = new LinkedList<>();
        atendidosDesdeUltimoNormal = 0;
    }

    public static void main(String[] args) {
        ControleFilaCaixa controleFila = new ControleFilaCaixa();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    controleFila.adicionarCliente(scanner);
                    break;
                case 2:
                    controleFila.chamarCliente();
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
        System.out.println("\n*** Controle de Fila de Atendimento no Caixa ***");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Chamar Cliente");
        System.out.println("3. Sair");
        System.out.print("Opção: ");
    }

    private void adicionarCliente(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o ano de nascimento do cliente: ");
        int anoNascimento = scanner.nextInt();
        scanner.nextLine(); 

        int senha = proximaSenha();

        Cliente cliente = new Cliente(senha, nome, anoNascimento);
        if (cliente.isPrioritario()) {
            filaPrioritaria.add(cliente);
        } else {
            filaNormal.add(cliente);
        }

        System.out.println("Cliente adicionado com sucesso. Senha: " + senha);
    }

    private int proximaSenha() {
        return filaPrioritaria.size() + filaNormal.size() + 1;
    }

    private void chamarCliente() {
        if (!filaPrioritaria.isEmpty()) {
            Cliente cliente = filaPrioritaria.poll();
            System.out.println("\nChamando cliente prioritário:");
            exibirDadosCliente(cliente);
            atendidosDesdeUltimoNormal++;
        } else if (!filaNormal.isEmpty() && atendidosDesdeUltimoNormal >= LIMITE_PRIORITARIOS) {
            Cliente cliente = filaNormal.poll();
            System.out.println("\nChamando cliente normal:");
            exibirDadosCliente(cliente);
            atendidosDesdeUltimoNormal = 0;
        } else {
            System.out.println("Não há clientes para chamar.");
        }
    }

    private void exibirDadosCliente(Cliente cliente) {
        System.out.println("Senha: " + cliente.getSenha());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Ano de Nascimento: " + cliente.getAnoNascimento());
    }
}

class Cliente {
    private int senha;
    private String nome;
    private int anoNascimento;

    public Cliente(int senha, String nome, int anoNascimento) {
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public int getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public boolean isPrioritario() {
        return (2023 - anoNascimento) > 65;
    }
}
