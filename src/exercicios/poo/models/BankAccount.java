package exercicios.poo.models;

import java.util.Scanner;

public class BankAccount {
    Scanner scan = new Scanner(System.in);
    private String user;
    private double balance;
    private double overdraft;
    private boolean isoverdraft;

    //Variaveis dispensáveis
    private double value;
    private boolean keep;
    private double newvalue;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public boolean isIsoverdraft() {
        return isoverdraft;
    }

    public void setIsoverdraft(boolean isoverdraft) {
        this.isoverdraft = isoverdraft;
    }

    public void CreateUser() {
        System.out.println("\nÉ necessário criar uma conta!");
        System.out.print("Insira seu nome: ");
        scan.next();
        do {
            System.out.println("\nDigite o saldo a ser depositado (maior que 0): ");
            value = scan.nextDouble();
            if (value <= 0) {
                System.out.println("O valor deve ser maior que 0!");
            }
        } while (value <= 0);

        setBalance(value);
        if (value >= 500) {
            setOverdraft(getBalance() * 0.5);
            System.out.printf("Parabéns, seu novo cheque especial é de R$ %.2f", getOverdraft());
        } else {
            setOverdraft(50);
        }
        scan.close();
    }

    public void CheckBalance() {
        do {
            System.out.printf("\nOlá %s, seu saldo atual é de R$ %.2f", getUser(), getBalance());
            System.out.println("\nDeseja retornar ao menu?" +
                    "\nSim[1]" +
                    "\nNão[2] ");
            scan.nextInt();
            switch (scan.nextInt()) {
                case 1:
                    keep = false;
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (keep);
        scan.close();
    }

    public void CheckOverdraft() {
        do {
            System.out.printf("\nAtualmente seu cheque especial é de R$ %.2f", getOverdraft());
            System.out.println("\nDeseja retornar ao menu?" +
                    "\nSim[1]" +
                    "\nNão[2] ");
            scan.nextInt();
            switch (scan.nextInt()) {
                case 1:
                    keep = false;
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (keep);
        scan.close();
    }

    public void Deposit() {
        do {
            do {
                System.out.println("\nDigite o saldo a ser depositado (maior que 0): ");
                value = scan.nextDouble();
                if (value <= 0) {
                    System.out.println("O valor deve ser maior que 0!");
                }
            } while (value <= 0);
            newvalue = getBalance() + value;
            setBalance(newvalue);
            System.out.printf("\nVocê depositou R$ %.2f com sucesso!", value);
            System.out.println("\nDeseja retornar ao menu?" +
                    "\nSim[1]" +
                    "\nNão[2] ");
            scan.nextInt();
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
        scan.close();
    }

    public void Cashout() {
        do {
            do {
                System.out.println("\nDigite o saldo a ser retirado (maior que 0): ");
                value = scan.nextDouble();
                if (value <= 0) {
                    System.out.println("O valor deve ser maior que 0!");
                } else if (value > getBalance()) {
                    System.out.println("O valor excede seu saldo atual!!");
                }
            } while (value <= 0 || value > getBalance());
            newvalue = getBalance() - value;
            setBalance(newvalue);
            System.out.printf("\nVocê sacou R$ %.2f com sucesso!", value);
            System.out.println("\nDeseja retornar ao menu?" +
                    "\nSim[1]" +
                    "\nNão[2] ");
            scan.nextInt();
            switch (scan.nextInt()) {
                case 1:
                    keep = false;
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (keep);
        scan.close();
    }

    public void Bills() {
        do {
            do {
                System.out.println("\nDigite o valor do boleto: ");
                value = scan.nextDouble();
                if (value <= 0) {
                    System.out.println("O valor deve ser maior que 0!");
                } else if (value > getBalance()) {
                    System.out.println("O valor excede seu saldo atual!!");
                }
            } while (value <= 0 || value > getBalance());
            newvalue = getBalance() - value;
            setBalance(newvalue);
            System.out.printf("\nVocê pagou o boleto no valor de R$ %.2f com sucesso!", value);
            System.out.println("\nDeseja retornar?" +
                    "\nSim[1]" +
                    "\nNão[2] ");
            scan.nextInt();
            switch (scan.nextInt()) {
                case 1:
                    keep = false;
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (keep);
        scan.close();
    }

    public void OverDraft() {
        while (keep) {
            System.out.println(isIsoverdraft() ? ("\nVocê está utilizando o crédito especial da sua conta.") :
                    ("\nVocê não está utilizando o crédito especial."));
            if (!isIsoverdraft()) {
                System.out.printf("Deseja utilizar o crédito especial da sua conta, no valor de R$%.2f ?" +
                        "\nSim[1]" +
                        "\nNão[2]", getOverdraft());
                scan.nextInt();
                switch (scan.nextInt()) {
                    case 1:
                        setIsoverdraft(true);
                        System.out.println("\nAgora você está utilizando o crédito especial em conta.");
                        break;
                    case 2:
                        setIsoverdraft(false);
                        System.out.println("\nVocê não utilizando o crédito especial em conta.");
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                }
            } else {
                System.out.printf("Deseja parar de utilizar o crédito especial da sua conta, no valor de R$%.2f ?" +
                        "\nSim[1]" +
                        "\nNão[2]", getOverdraft());
                scan.nextInt();
                switch (scan.nextInt()) {
                    case 1:
                        setIsoverdraft(false);
                        System.out.println("\nVocê não utilizando o crédito especial em conta.");
                        break;
                    case 2:
                        setIsoverdraft(true);
                        System.out.println("\nAgora você está utilizando o crédito especial em conta.");
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                }
            }
            System.out.println("\nDeseja retornar?" +
                    "\nSim[1]" +
                    "\nNão[2] ");
            scan.nextInt();
            switch (scan.nextInt()) {
                case 1:
                    keep = false;
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
    }
}

