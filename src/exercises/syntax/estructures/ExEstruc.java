package exercises.syntax.estructures;

import java.util.Scanner;

public class ExEstruc {
    Scanner scanner = new Scanner(System.in);

    public void tabuada(int x) {
        /* Escreva um código onde o usuário entra com um número
        e seja gerada a tabuada de 1 até 10 desse número */

        System.out.print("\nDigite um número: ");
        x = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.printf("\n%d * %d = %d", x, i, x * i);
        }
    }

    public void imc(double peso, double altura) {
        /* Escreva um código onde o usuário entra com sua altura e peso,
        seja feito o calculo do seu IMC(IMC = peso/(altura * altura))
        e seja exibida a mensagem de acordo com o resultado:
            Se for menor ou igual a 18,5 "Abaixo do peso";
            se for entre 18,6 e 24,9 "Peso ideal";
            Se for entre 25,0 e 29,9 "Levemente acima do peso";
            Se for entre 30,0 e 34,9 "Obesidade Grau I";
            Se for entre 35,0 e 39,9 "Obesidade Grau II (Severa)";
            Se for maior ou igual a 40,0 "Obesidade III (Mórbida)"; */

        System.out.print("\nDigite sua altura (em Cm): ");
        altura = scanner.nextDouble();
        System.out.print("\nDigite seu peso (em Kg): ");
        peso = scanner.nextDouble();
        double imc = peso / (altura * altura);
        switch (imc) {
            case double v when v <= 18.25 -> System.out.print("\nAbaixo do peso");
            case double v when 18.6 <= v && v <= 24.9 -> System.out.print("\nPeso ideal");
            case double v when 25.0 <= v && v <= 29.9 -> System.out.print("\nLevemente acima do peso");
            case double v when 30 <= v && v <= 34.9 -> System.out.print("\nObesidade Grau I");
            case double v when 35.0 <= v && v <= 39.9 -> System.out.print("\nObesidade Grau II (Severa)");
            default -> System.out.print("\nObesidade III (Mórbida)");
        }
    }

    public void parimpar(int n1, int n2, String option) {
        /* Escreva um código que o usuário entre com um primeiro número, um segundo número maior que o primeiro
        e escolhe entre a opção par e ímpar, com isso o código deve informar todos os números
        pares ou ímpares (de acordo com a seleção inicial) no intervalo de números informados,
        incluindo os números informados e em ordem decrescente */

        System.out.print("\nDigite o primeiro número: ");
        n1 = scanner.nextInt();
        do {
            System.out.print("\nDigite o segundo número: ");
            n2 = scanner.nextInt();
        } while (n2 < n1);

        do {
            System.out.print("\nEscolha Par ou Ímpar (p/i): ");
            option = scanner.next().toLowerCase();
        } while (!(option.equals("p") || (option.equals("i"))));
        int i = n2;
        if (option.equals("p")) {
            System.out.printf("\nLista dos pares de %d a %d\n", n2, n1);
            for (i = n2; i >= n1; i--) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.printf("\nLista dos ímpares de %d a %d\n", n2, n1);
            for (i = n2; i >= n1; i--) {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        }
    }

    public void difzero() {
        /* Escreva um código onde o usuário informa um número inicial, posteriormente irá informar outros N números,
           a execução do código irá continuar até que o número informado dividido pelo primeiro número tenha resto
           diferente de 0 (números menores que o primeiro devem ser ignorados) */

        System.out.print("\nDigite o primeiro número: ");
        int n1 = scanner.nextInt();
        int n2 = 0;
        do {
            do {
                System.out.printf("\nDigite um número maior que %d: ", n1);
                n2 = scanner.nextInt();
            } while (n2 < n1);
            System.out.printf("\n%d %% %d = %d", n2, n1, n2 % n1);
        } while (n2 % n1 != 0);
    }
}
