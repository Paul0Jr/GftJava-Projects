package desafios;

import java.util.Scanner;

public class DesafiosSintaxe {
    Scanner scanner = new Scanner(System.in);

    public void CalculoFreteRapido() {
        /* Descrição
    Uma empresa de logística precisa calcular o valor total de um frete com base no peso da carga e no valor do frete por quilo.

    Entrada
    A entrada deve conter:
        O peso em quilos (double).
        O valor do frete por quilo (double).

    Saída
    O programa deverá retornar o valor total do frete, formatado com duas casas decimais.
    Retorno numérico formatado.  */

        double peso = scanner.nextDouble();
        double frete = scanner.nextDouble();

        System.out.printf("\n%.2f", peso * frete);
        scanner.close();
    }

    public void DescontoInteligente() {
        /* Descrição
    Uma loja online deseja calcular o valor final de um produto após aplicar um desconto percentual.

    Entrada
    A entrada deve conter:
        O valor original do produto (double).
        A porcentagem de desconto (double).

    Saída
    Deverá retornar o valor final do produto, formatado com duas casas decimais.
     Caso a porcentagem de desconto seja inválida (menor que 0 ou maior que 100),
     deverá retornar a mensagem Desconto invalido.

    Retorno numérico formatado ou mensagem de erro: Desconto invalido.
         */
        double valor = scanner.nextDouble();
        double porcentagem = scanner.nextDouble();
        if (porcentagem < 0 || porcentagem > 100) {
            System.out.print("\nDesconto inválido");
        } else {
            double calcporcent = valor - (valor * (porcentagem / 100));
            System.out.printf("\n%.2f", calcporcent);
        }
        scanner.close();
    }
}
