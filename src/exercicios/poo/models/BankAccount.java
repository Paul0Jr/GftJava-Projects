package exercicios.poo.models;

import java.util.Scanner;

public class BankAccount {
    Scanner scan = new Scanner(System.in);
    private String user;
    private double value;
    private double overdraft;
    private boolean isoverdraft;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getValue() {
        return value;
    }

    public boolean isIsoverdraft() {
        return isoverdraft;
    }


    public void setValue(double value) {
        this.value = value;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public void setIsoverdraft(boolean isoverdraft) {
        this.isoverdraft = isoverdraft;
    }

}
