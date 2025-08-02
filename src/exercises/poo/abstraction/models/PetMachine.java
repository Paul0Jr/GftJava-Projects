package exercises.poo.abstraction.models;

import java.util.Scanner;

public class PetMachine {
    Scanner scanner = new Scanner(System.in);
    private int water = 0;
    private int shampoo = 0;
    private boolean petmachine;
    private boolean cleanmachine;
    private int waterlimit = 0;
    private int shampoolimit = 0;

    private int value = 0;

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public void setShampoo(int shampoo) {
        this.shampoo = shampoo;
    }

    public boolean isPetmachine() {
        return petmachine;
    }

    public void setPetmachine(boolean petmachine) {
        this.petmachine = petmachine;
    }

    public boolean isCleanmachine() {
        return cleanmachine;
    }

    public void setCleanmachine(boolean cleanmachine) {
        this.cleanmachine = cleanmachine;
    }

    public void WashPet() {
        if (!isPetmachine()) {
            System.out.println("A máquina está vazia!");
            return;
        }
        if (!isCleanmachine()) {
            System.out.println("\nA máquina não está limpa!");
            return;
        }
        if (getWater() >= 10 && shampoo >= 2) {
            System.out.println("\nLimpando pet");
            setCleanmachine(false);
            setPetmachine(true);
            setWater(getWater() - 10);
            setShampoo(getShampoo() - 2);
        } else {
            System.out.println("\nNão há shampoo ou água o suficiente para o banho.");
        }
    }

    public void CheckPet() {
        System.out.println((!isPetmachine()) ? "\nNão há pets no banho." : "\nA máquina está ocupada.");
    }

    public void PetIn() {
        if (!isPetmachine()) {
            if (isCleanmachine()) {
                setPetmachine(true);
                System.out.println("\nO pet está dentro da máquina.");
            } else {
                System.out.println("\nA máquina está suja.");
            }
        } else {
            System.out.println("\nA máquina está ocupada.");
        }
    }

    public void PetOut() {
        if (!isPetmachine()) {
            System.out.println("\nA máquina se encontra vazia.");
            return;
        } else {
            setPetmachine(false);
            System.out.println("\nO pet foi retirado da máquina.");
            setCleanmachine(false);
        }
    }

    public void CleanMachine() {
        if (isPetmachine()) {
            System.out.println("\nA máquina está ocupada.");
            return;
        }
        if (isCleanmachine()) {
            System.out.println("\nA máquina já está limpa.");
            return;
        }
        if (getWater() >= 3 && shampoo >= 1) {
            System.out.println("\nLimpando a máquina");
            setCleanmachine(true);
            setWater(getWater() - 3);
            setShampoo(getShampoo() - 1);
        } else {
            System.out.println("\nNão há shampoo ou água o suficiente para a limpeza da máquina.");
        }
    }

    public void CheckWater() {
        System.out.printf((water > 0) ? "\nÁgua disponível: %dL" : "\nNão há água disponível!", getWater());
    }

    public void CheckShampoo() {
        System.out.printf((water > 0) ? "\nShampoo disponível: %dL" : "\nNão há shampoo disponível!", getShampoo());
    }

    public void SupplyWater() {
        if (isPetmachine()) {
            System.out.println("\nRetire o pet da máquina para fazer o abastecimento de água.");
            return;
        }
        if (getWater() < 30) {
            do {
                System.out.printf("\nDigite a quantidade de água a ser colocada na máquina(atual = %d): ", getWater());
                value = scanner.nextInt();
                if (value > 30) {
                    System.out.println("\nA máquina suporta apenas 30L.");
                }
                waterlimit = getWater() + value;
                if (waterlimit > 30) {
                    System.out.printf("\nA máquina suporta apenas %d litros de água a mais", 30 - getWater());
                }
            } while (waterlimit > 30);
            setWater(getWater() + value);

        } else {
            System.out.println("\nA máquina já está cheia de água!");
        }
    }

    public void SupplyShampoo() {
        if (isPetmachine()) {
            System.out.println("\nRetire o pet da máquina para fazer o abastecimento de shampoo.");
            return;
        }
        if (getShampoo() < 10) {
            do {
                System.out.printf("\nDigite a quantidade de shampoo a ser colocada na máquina (atual = %d): ", getShampoo());
                value = scanner.nextInt();
                if (value > 10) {
                    System.out.println("\nA máquina suporta apenas 10L.");
                }
                shampoolimit = getShampoo() + value;
                if (shampoolimit > 10) {
                    System.out.printf("\nA máquina suporta apenas %d litros de shampoo a mais", 10 - getShampoo());
                }
            } while (shampoolimit > 10);
            setShampoo(getShampoo() + value);
        } else {
            System.out.println("\nA máquina já está cheia de shampoo!");
        }
    }
}
