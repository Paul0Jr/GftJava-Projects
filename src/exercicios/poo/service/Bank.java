package exercicios.poo.service;

import exercicios.poo.models.BankAccount;

import java.util.Scanner;

public class Bank {
    BankAccount account = new BankAccount();
   // private String name;
    private boolean keep = true;
    private double valor;
    double newvalue;
    private Scanner scan = new Scanner(System.in);


    public void CreateUser() {
        System.out.println("\nÉ necessário criar uma conta!");
        System.out.print("Insira seu nome: ");
        account.setUser(scan.next());
        do {
            System.out.println("\nDigite o saldo a ser depositado (maior que 0): ");
            valor = scan.nextDouble();
            if (valor <= 0) {
                System.out.println("O valor deve ser maior que 0!");
            }
        } while (valor <= 0);

        account.setValue(valor);
        if (valor >= 500) {
            account.setOverdraft(account.getValue() * 0.5);
            System.out.printf("Parabéns, seu novo cheque especial é de R$ %.2f", account.getOverdraft());
        } else {
            account.setOverdraft(50);
        }
    }

    public void CheckBalance() {
        do {
            System.out.printf("\nOlá %s, seu saldo atual é de R$ %.2f", account.getUser(), account.getValue());
            System.out.println("\nDeseja retornar?" +
                    "\nSim[1]" +
                    "\nNão[2] ");
            valor = scan.nextInt();
        } while (valor != 1);
    }

    public void CheckOverdraft(){
        do {
            System.out.printf("\nAtualmente seu cheque especial é de R$ %.2f", account.getOverdraft());
            System.out.println("\nDeseja retornar?" +
                    "\nSim[1]" +
                    "\nNão[2] ");
            valor = scan.nextInt();
        } while (valor != 1);

    }

    public void Deposit(){
        do {
            do {
                System.out.println("\nDigite o saldo a ser depositado (maior que 0): ");
                valor =scan.nextDouble();
                if (valor <= 0) {
                    System.out.println("O valor deve ser maior que 0!");
                }
            } while (valor <= 0);
            newvalue = account.getValue() + valor;
            account.setValue(newvalue);
            System.out.printf("\nVocê depositou R$ %.2f com sucesso!", valor);
            System.out.println("\nDeseja retornar ao menu?" +
                    "\nSim[1]" +
                    "\nNão[2] ");
            switch (scan.nextInt()) {
                case 1:
                    keep = false;
                    break;
                case 2:
                    continue;
                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (keep);
    }
}
