package pilhaDinamicaParImpar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pilha pilhaPar = new Pilha();
        Pilha pilhaImpar = new Pilha();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite valores inteiros entre -127 e 128 (digite 0 para finalizar): ");

        while (true) {
            try {
                int valor = scanner.nextInt();
                if (valor == 0) {
                    break;
                }
                if (ePar(valor)) {
                    pilhaPar.empilhar(valor);
                } else {
                    pilhaImpar.empilhar(valor);
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }

        if (pilhaPar.isEmpty() && pilhaImpar.isEmpty()) {
            System.out.println("Nenhum valor foi inserido.");
        } else {
            System.out.println("Retirando elementos das pilhas alternadamente... ");
            removerAlternadamente(pilhaPar, pilhaImpar);
        }

        scanner.close();
    }

    public static boolean ePar(int numero) {
        return numero % 2 == 0;
    }

    public static void removerAlternadamente(Pilha pilhaPar, Pilha pilhaImpar) {
        boolean removerDaImpar = true;

        while (!pilhaPar.isEmpty() || !pilhaImpar.isEmpty()) {
            if (removerDaImpar && !pilhaImpar.isEmpty()) {
                Integer valorImpar = pilhaImpar.remover();
                if (valorImpar != null) {
                    System.out.println("Retirado da PILHA ÍMPAR: " + valorImpar);
                }
            } else if (!pilhaPar.isEmpty()) {
                Integer valorPar = pilhaPar.remover();
                if (valorPar != null) {
                    System.out.println("Retirado da PILHA PAR: " + valorPar);
                }
            }
            removerDaImpar = !removerDaImpar;
        }

        if (!pilhaImpar.isEmpty()) {
            System.out.println("A pilha ímpar ainda possui " + pilhaImpar.tamanho() + " elementos: ");
            pilhaImpar.imprimirPilha();
        } else if (!pilhaPar.isEmpty()) {
            System.out.println("A pilha par ainda possui " + pilhaPar.tamanho() + " elementos: ");
            pilhaPar.imprimirPilha();
        } else {
            System.out.println("Ambas as pilhas estão vazias.");
        }
    }
}
