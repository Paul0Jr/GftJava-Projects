package exercises.poo.abstraction.controller;

import exercises.poo.abstraction.models.CarFunctions;

import java.util.Scanner;

public class Car {
    CarFunctions function = new CarFunctions();
    Scanner scanner = new Scanner(System.in);
    private int op = 0;
    private boolean keep = true;
    /*
    Escreva um código onde controlamos as funções de um carro, ele deve ter as seguintes funções:
        * Ligar o carro;
        * Desligar o carro;
        * Acelerar;
        * Diminuir velocidade;
        * Virar para esquerda/direita
        * Verificar velocidade;
        * Trocar a marcha;

    Siga as seguintes regras na implementação:
        * Quando o carro for criado ele deve começar desligado, em ponto morto e com sua velocidade em 0
        * O carro desligado não pode realizar nenhuma função;
        * Quando o carro for acelerado ele deve incrementar 1km em sua velocidade (pode chegar no máximo a 120km);
        * Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua velocidade (pode chegar no mínimo a 0km);
        * O carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no carro;
        * A velocidade do carro deve respeitar os seguintes limites para cada velocidade
        * Se o carro estiver na marcha 0 (ponto morto) ele não pode acelerar
        * Se estiver na 1ª marcha, sua velocidade pode estar entre 0km e 20km
        * Se estiver na 2ª marcha, sua velocidade pode estar entre 21km e 40km
        * Se estiver na 3ª marcha, sua velocidade pode estar entre 41km e 60km
        * Se estiver na 4ª marcha, sua velocidade pode estar entre 61km e 80km
        * Se estiver na 5ª marcha, sua velocidade pode estar entre 81km e 100km
        * Se estiver na 6ª marcha, sua velocidade pode estar entre 101km e 120km
        * O carro poderá ser desligado se estiver em ponto morto (marcha 0) e sua velocidade em 0 km
        * O carro só pode virar para esquerda/direita se sua velocidade for de no mínimo 1km e no máximo 40km;
     */

    public void Carro() {
        function.setOnOff(false);
        function.setSpeed(0);
        function.setGear(0);
        while (keep) {
            System.out.print("\n\n==========MENU CARRO==========");
            System.out.println("" +
                    "\nLigar carro[1]             " + "Desligar carro[2]" +
                    "\nAcelerar[3]                " + "Diminuir velocidade[4]" +
                    "\nTrocar a marcha[5]         " + "Virar para a esquerda/direita[6] " +
                    "\nVerificar status[7]    " + "Sair do carro[8]\n");
            System.out.print("Digite sua opção: ");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    function.TurnOn();
                    break;
                case 2:
                    function.TurnOff();
                    break;
                case 3:
                    function.SpeedUp();
                    break;
                case 4:
                    function.SpeedDown();
                    break;
                case 5:
                    function.ChangeGear();
                    break;
                case 6:
                    function.TurnLR();
                    break;
                case 7:
                    function.Status();
                    break;
                case 8:
                    if (!function.isOnOff()) {
                        keep = false;
                    } else {
                        System.out.println("Desligue o carro para sair!");
                    }
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        }
    }
}