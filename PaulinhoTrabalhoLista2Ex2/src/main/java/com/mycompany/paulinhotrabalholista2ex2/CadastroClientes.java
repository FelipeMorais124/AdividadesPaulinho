
package com.mycompany.paulinhotrabalholista2ex2;

/*Crie um aplicativo de cadastro de clientes, 
deve-se armazenar o código, Nome, data de 
nascimento e cpf. Faça com que o usuário informe 
esses dados, o aplicativo deverá ordenar os 
clientes pelo código. Faça com que o aplicativo 
solicite ao usuário informar o código do cliente 
efetue uma pesquisa binária para localizar o 
cliente e exibir na tela os seus dados*/

 import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CadastroClientes {
    private List<Cliente> clientes;

    public CadastroClientes() {
        clientes = new ArrayList<>();
    }

    public static void main(String[] args) {
        CadastroClientes cadastro = new CadastroClientes();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastro.adicionarCliente(scanner);
                    break;
                case 2:
                    cadastro.listarClientes();
                    break;
                case 3:
                    cadastro.pesquisarCliente(scanner);
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n*** Cadastro de Clientes ***");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Pesquisar Cliente");
        System.out.println("4. Sair");
        System.out.print("Opção: ");
    }

    private void adicionarCliente(Scanner scanner) {
        System.out.print("Digite o código do cliente: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento do cliente (DD/MM/AAAA): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
        clientes.add(cliente);

        ordenarClientesPorCodigo();
        System.out.println("Cliente adicionado com sucesso.");
    }

    private void listarClientes() {
        System.out.println("\nLista de Clientes:");

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private void pesquisarCliente(Scanner scanner) {
        System.out.print("Digite o código do cliente: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 

        int indice = pesquisaBinaria(codigo);

        if (indice != -1) {
            Cliente cliente = clientes.get(indice);
            System.out.println("\nCliente encontrado:");
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void ordenarClientesPorCodigo() {
        Collections.sort(clientes, Comparator.comparingInt(Cliente::getCodigo));
    }

    private int pesquisaBinaria(int codigo) {
        int inicio = 0;
        int fim = clientes.size() - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            Cliente cliente = clientes.get(meio);
            int codigoCliente = cliente.getCodigo();

            if (codigo == codigoCliente) {
                return meio; 
            } else if (codigo < codigoCliente) {
                fim = meio - 1; 
            } else {
                inicio = meio + 1; 
            }
        }

        return -1; 
    }
}

class Cliente {
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String cpf;

    public Cliente(int codigo, String nome, String dataNascimento, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Nome: " + nome +
                ", Data de Nascimento: " + dataNascimento +
                ", CPF: " + cpf;
    }
}
