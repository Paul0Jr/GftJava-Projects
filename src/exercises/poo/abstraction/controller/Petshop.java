package exercises.poo.abstraction.controller;

import exercises.poo.abstraction.models.PetMachine;

import java.util.Scanner;

public class Petshop {
    Scanner scan = new Scanner(System.in);
    PetMachine pet = new PetMachine();

    private boolean keep = true;
    private int op;

    /*
    Escreva um código onde temos o controle de banho de um petshop, a maquina de banhos dos pets deve ter as seguintes operações:
Dar banho no pet;
Abastecer com água;
Abastecer com shampoo;
verificar nível de água;
verificar nível de shampoo;
verificar se tem pet no banho;
colocar pet na máquina;
retirar pet da máquina;
limpar máquina.

Siga as seguintes regras para implementação:
A maquina de banho deve permitir somente 1 pet por vez;
Cada banho realizado irá consumir 10 litros de água e 2 litros de shampoo;
A máquina tem capacidade máxima de 30 litros de água e 10 litros de shampoo;
Se o pet for retirado da máquina sem estar limpo será necessário limpar a máquina para permitir a entrada de outro pet;
A limpeza da máquina irá consumir 3 litros de água e 1 litro de shampoo;
O abastecimento de água e shampoo deve permitir 2 litros por vez que for acionado;
     */

    public void PetShop() {
        pet.setPetmachine(false);
        pet.setCleanmachine(true);
        while (keep) {
            System.out.print("\n==========MENU PET SHOP==========");
            System.out.println("" +
                    "\nDar banho no pet[1]               " + "Verificar se tem pet no banho[2]" +
                    "\nColocar pet na máquina[3]         " + "Retirar pet da máquina[4]" +
                    "\nLimpar máquina[5]                 " + "Verificar nível da água[6] " +
                    "\nVerificar nível de shampoo[7]     " + "Abastecer água[8]" +
                    "\nAbastecer shampoo[9]              " + "Sair[0]\n");
            System.out.print("Digite sua opção: ");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    pet.WashPet();
                    break;
                case 2:
                    pet.CheckPet();
                    break;
                case 3:
                    pet.PetIn();
                    break;
                case 4:
                    pet.PetOut();
                    break;
                case 5:
                    pet.CleanMachine();
                    break;
                case 6:
                    pet.CheckWater();
                    break;
                case 7:
                    pet.CheckShampoo();
                    break;
                case 8:
                    pet.SupplyWater();
                    break;
                case 9:
                    pet.SupplyShampoo();
                    break;
                case 0:
                    if (!pet.isPetmachine()) {
                        System.out.println("\nEncerrando as atividades do petshop.");
                        keep = false;
                    } else {
                        System.out.println("\nAinda há um pet na máquina!");
                    }
                    break;
                default:
                    System.out.println("\nOpção inválida");
            }
        }
    }
}
