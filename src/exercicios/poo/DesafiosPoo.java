package exercicios.poo;

import exercicios.poo.models.BankAccount;
import exercicios.poo.service.Bank;

import java.util.Scanner;

public class DesafiosPoo {
    /*
    Todos os exercícios devem ter um menu interativo para chamar as funções
     e ter uma opção de sair para finalizar a execução
     */
    Bank bank = new Bank();
    BankAccount account = new BankAccount();
    Scanner scan = new Scanner(System.in);

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
        int op = 0;
        double novosaldo;
        double valor;
        boolean continuar = true;
        boolean prg = true;
        account.setIsoverdraft(false);

        while (prg) {
            if (account.getUser() == null) {
                bank.CreateUser();
            }
            //account.setIsoverdraft(false);
            System.out.printf("\n==========MENU BANCO==========" +
                    ((account.getUser() == null) ? ("\nSeja bem-vindo(a)") : ("\nSeja bem-vindo(a), %s!\n")), account.getUser());
            System.out.println("\nConsultar saldo[1]          " + "Consultar cheque especial[2]" +
                    "\nDepositar dinheiro[3]       " + "Sacar dinheiro[4]" +
                    "\nPagar um boleto[5]          " + "Verificar se conta está usando cheque especial[6]" +
                    "\nSair[0]\n");
            System.out.print("Digite sua opção: ");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    bank.CheckBalance();
                    break;

                case 2:
                    bank.CheckOverdraft();
                    break;

                case 3:
                    bank.Deposit();
                    break;

                case 4:
                    do {
                        do {
                            System.out.println("\nDigite o saldo a ser retirado (maior que 0): ");
                            valor = scan.nextDouble();
                            if (valor <= 0) {
                                System.out.println("O valor deve ser maior que 0!");
                            } else if (valor > account.getValue()) {
                                System.out.println("O valor excede seu saldo atual!!");
                            }
                        } while (valor <= 0 || valor > account.getValue());
                        novosaldo = account.getValue() - valor;
                        account.setValue(novosaldo);
                        System.out.printf("\nVocê sacou R$ %.2f com sucesso!", valor);
                        System.out.println("\nDeseja retornar?" +
                                "\nSim[1]" +
                                "\nNão[2] ");
                        op = scan.nextInt();
                    } while (op != 1);
                    break;

                case 5:
                    do {
                        do {
                            System.out.println("\nDigite o valor do boleto: ");
                            valor = scan.nextDouble();
                            if (valor <= 0) {
                                System.out.println("O valor deve ser maior que 0!");
                            } else if (valor > account.getValue()) {
                                System.out.println("O valor excede seu saldo atual!!");
                            }
                        } while (valor <= 0 || valor > account.getValue());
                        novosaldo = account.getValue() - valor;
                        account.setValue(novosaldo);
                        System.out.printf("\nVocê pagou o boleto no valor de R$ %.2f com sucesso!", valor);
                        System.out.println("\nDeseja retornar?" +
                                "\nSim[1]" +
                                "\nNão[2] ");
                        op = scan.nextInt();
                    } while (op != 1);
                    break;

                case 6:
                    while (true) {
                        System.out.println(account.isIsoverdraft() ? ("\nVocê está utilizando o crédito especial da sua conta.") :
                                ("\nVocê não está utilizando o crédito especial."));
                        if (!account.isIsoverdraft()) {
                            System.out.printf("Deseja utilizar o crédito especial da sua conta, no valor de R$%.2f ?" +
                                    "\nSim[1]" +
                                    "\nNão[2]", account.getOverdraft());
                            op = scan.nextInt();
                            switch (op) {
                                case 1:
                                    account.setIsoverdraft(true);
                                    System.out.println("\nAgora você está utilizando o crédito especial em conta.");
                                    break;
                                case 2:
                                    account.setIsoverdraft(false);
                                    System.out.println("\nVocê não utilizando o crédito especial em conta.");
                                    break;
                                default:
                                    System.out.println("\nOpção inválida!");
                            }
                        } else {
                            System.out.printf("Deseja parar de utilizar o crédito especial da sua conta, no valor de R$%.2f ?" +
                                    "\nSim[1]" +
                                    "\nNão[2]", account.getOverdraft());
                            switch (op) {
                                case 1:
                                    account.setIsoverdraft(false);
                                    System.out.println("\nVocê não utilizando o crédito especial em conta.");
                                    break;
                                case 2:
                                    account.setIsoverdraft(true);
                                    System.out.println("\nAgora você está utilizando o crédito especial em conta.");
                                    break;
                                default:
                                    System.out.println("\nOpção inválida!");
                            }
                        }
                        System.out.println("\nDeseja retornar?" +
                                "\nSim[1]" +
                                "\nNão[2] ");
                        op = scan.nextInt();
                        if (op == 1) {
                            break;
                        }
                    }
                    break;

                case 0:
                    prg = false;
                    break;
            }
        }

    }
}
