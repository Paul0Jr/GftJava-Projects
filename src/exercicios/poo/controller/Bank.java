package exercicios.poo.controller;

import exercicios.poo.models.BankAccount;

import java.util.Scanner;

public class Bank {
    /*
    Todos os exercícios devem ter um menu interativo para chamar as funções
     e ter uma opção de sair para finalizar a execução
     */
    BankAccount account = new BankAccount();
    Scanner scanner = new Scanner(System.in);
    int op = 0;

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

        boolean prg = true;
        account.setIsoverdraft(false);

        while (prg) {
            if (account.getUser() == null) {
                account.CreateUser();
            }
            System.out.printf("\n==========MENU BANCO==========" +
                    ((account.getUser() == null) ? ("\nSeja bem-vindo(a)") : ("\nSeja bem-vindo(a), %s!\n")), account.getUser());
            System.out.println("\nConsultar saldo[1]          " + "Consultar cheque especial[2]" +
                    "\nDepositar dinheiro[3]       " + "Sacar dinheiro[4]" +
                    "\nPagar um boleto[5]          " + "Verificar se conta está usando cheque especial[6]" +
                    "\nSair[0]\n");
            System.out.print("Digite sua opção: ");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    account.CheckBalance();
                    continue;

                case 2:
                    account.CheckOverdraft();
                    continue;

                case 3:
                    account.Deposit();
                    continue;

                case 4:
                    account.Cashout();
                    continue;
                case 5:
                    account.Bills();
                    continue;
                case 6:
                    account.OverDraft();
                    continue;
                case 0:
                    prg = false;
                    break;
            }
        }
        scanner.close();
    }
}
