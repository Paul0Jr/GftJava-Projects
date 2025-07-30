package desafios.poo;

import desafios.models.BankAccount;

import java.util.Scanner;

public class DesafiosPoo {
    /*
    Todos os exercícios devem ter um menu interativo para chamar as funções
     e ter uma opção de sair para finalizar a execução
     */
    BankAccount account = new BankAccount();
    Scanner scan = new Scanner(System.in);
    int op = 0;
    double novosaldo;
    double valor;

    public void ContaBancaria() {
        /*
        Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
            Consultar saldo
            consultar cheque especial
            Depositar dinheiro;
            Sacar dinheiro;
            Pagar um boleto.
            Verificar se a conta está usando cheque especial.

        Siga as seguintes regras para implementar
            A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
            O valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
            Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
            Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
            Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
         */


        while (true) {
            if (account.getUser() == null) {
                Conta();
            } else {
                System.out.printf("\n==========MENU BANCO==========" +
                        ((account.getUser() == null) ? ("\nSeja bem-vindo(a)") : ("\nSeja bem-vindo(a), %s!\n")), account.getUser());
                System.out.println("\nConsultar saldo[1]" +
                        "\nConsultar cheque especial[2]" +
                        "\nDepositar dinheiro[3]" +
                        "\nSacar dinheiro[4]" +
                        "\nPagar boleto[5]" +
                        "\nOutros[6]" +
                        "\nSair[0]\n");
                System.out.print("Digite sua opção: ");
                op = scan.nextInt();
                if (op == 0) {
                    break;
                } else {
                    switch (op) {
                        case 1:
                            do {
                                System.out.printf("\nOlá %s, seu saldo atual é de R$ %.2f", account.getUser(), account.getValue());
                                System.out.println("\nDeseja retornar?" +
                                        "\nSim[1]" +
                                        "\nNão[2] ");
                                op = scan.nextInt();
                            } while (op != 1);
                            break;
                        case 2:
                            do {
                                System.out.printf("\nAtualmente seu cheque especial é de R$ %.2f", account.getOverdraft());
                                System.out.println("Deseja retornar?" +
                                        "\nSim[1]" +
                                        "\nNão[2] ");
                                op = scan.nextInt();
                            } while (op != 1);
                            break;
                        case 3:
                            do {
                                System.out.println("\nDigite o saldo a ser depositado (maior que 0): ");
                                valor = scan.nextDouble();
                                if (valor <= 0) {
                                    System.out.println("O valor deve ser maior que 0!");
                                }
                            } while (valor <= 0);
                            novosaldo = account.getValue() + valor;
                            account.setValue(novosaldo);
                            break;
                        case 4:
                            do {
                                System.out.println("\nDigite o saldo a ser retirado (maior que 0): ");
                                valor = scan.nextDouble();
                                if (valor <= 0) {
                                    System.out.println("O valor deve ser maior que 0!");
                                }else if(valor > account.getValue()){
                                    System.out.println("O valor excede seu saldo atual!!");
                                }
                            } while (valor <= 0 || valor > account.getValue());
                            novosaldo = account.getValue() - valor;
                            account.setValue(novosaldo);
                            break;
                        case 6:
                            do {
                                System.out.println("\nVerificar se conta está usando cheque especial[1]" +
                                        "\nVoltar menu[2]\n");
                                System.out.print("\nDigite sua opção: ");

                                op = scan.nextInt();
                                if (op == 2) {
                                    break;
                                } else {

                                }
                            } while (op != 1 || op != 2);
                            break;
                        default:
                            System.out.println("\nOpção inválida!");

                    }
                }

            }
        }
    }

    public void Conta() {
        System.out.println("\nÉ necessário criar uma conta!");
        System.out.print("Insira seu nome: ");
        account.setUser(scan.next());
        do {
            System.out.println("\nDigite o saldo a ser depositado (maior que 0): ");
            account.setValue(scan.nextDouble());
            if (account.getValue() <= 0) {
                System.out.println("O valor deve ser maior que 0!");
            }
        } while (account.getValue() <= 0);

        if (account.getValue() >= 500) {
            account.setOverdraft(account.getValue() * 0.5);
            System.out.printf("Parabéns, seu novo cheque especial é de R$ %.2f", account.getOverdraft());
        } else {
            account.setOverdraft(50);
        }
    }
}
