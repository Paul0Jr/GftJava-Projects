package exercises.syntax.fundamentals;

import java.util.Scanner;

public class ExFup {
    /*Escreva um código que receba o nome e o ano de nascimento de alguém e imprima
    na tela a seguinte mensagem: Olá "Fulano", você tem X anos.
     */
    public void pessoa(String name, int age) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite seu nome: ");
        name = scanner.next();
        System.out.print("\nDigite sua idade: ");
        age = scanner.nextInt();
        System.out.printf("\nOlá %s, você tem %d!", name, age);
    }

    /* Escreva um código que receba o tamanho do lado de um quadrado, calcule sua área
    e exiba na tela */
    public void Area(double x) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o tamanho do lado do quadrado: ");
        x = scanner.nextDouble();
        double area = x * x;
        System.out.printf("\nA área do seu quadrado de lado %.1f é: %.1f", x, area);
    }

    /* Escreva um código que receba a base e altura de um retângulo calcule sua área
  e exiba na tela */
    public void Retangulo(double base, double altura) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite a base do seu retângulo: ");
        base = scanner.nextDouble();
        System.out.print("\nAgora digite a altura do seu retângulo: ");
        altura = scanner.nextDouble();
        System.out.printf("\nA área do seu retângulo com base %.1f e altura %f é: %.1f", base, altura, base * altura);
    }

    /* Escreva um código que receba o nome e idade de 2 pessoas e imprima
    a diferença de idade entre elas */

    public void diferenca(String n1, String n2, int i1, int i2) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o nome do primeiro usuário: ");
        n1 = scanner.next();
        System.out.printf("\nDigite a idade de %s: ", n1);
        i1 = scanner.nextInt();
        System.out.print("\nDigite o nome do segundo usuário: ");
        n2 = scanner.next();
        System.out.printf("\nDigite a idade de %s: ", n2);
        i2 = scanner.nextInt();
        int calculo = 0;
        if (i1 >= i2) {
            calculo = i1 - i2;
        } else {
            calculo = i2 - i1;
        }
        System.out.printf("\nA diferença de idade entre %s e %s é de: %d ano(s)", n1, n2, calculo);

    }
}
