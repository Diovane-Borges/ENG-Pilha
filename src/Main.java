import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


         resolverEx1(sc);
         resolverEx2(sc);
         resolverEx3(sc);

        sc.close();
    }


    public static void resolverEx1(Scanner sc) {
        System.out.println("\nPar e Ímpar ");

        PilhaInt pilhaPar = new PilhaInt(10);
        PilhaInt pilhaImpar = new PilhaInt(10);

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            int numero = sc.nextInt();

            if (numero == 0) {
                Integer desempPar = pilhaPar.desempilhar();
                Integer desempImpar = pilhaImpar.desempilhar();

                if (desempPar == null) {
                    System.out.println("Pilha par está vazia!");
                } else {
                    System.out.println("Desempilhado da pilha par: " + desempPar);
                }

                if (desempImpar == null) {
                    System.out.println("Pilha ímpar está vazia!");
                } else {
                    System.out.println("Desempilhado da pilha ímpar: " + desempImpar);
                }
            } else if (numero % 2 == 0) {
                pilhaPar.empilhar(numero);
            } else {
                pilhaImpar.empilhar(numero);
            }
        }

        System.out.println("\nPilha par desempilhada :");
        while (!pilhaPar.estaVazia()) {
            System.out.println(pilhaPar.desempilhar());
        }

        System.out.println("\nPilha ímpar desempilhada :");
        while (!pilhaImpar.estaVazia()) {
            System.out.println(pilhaImpar.desempilhar());
        }
    }


    public static void resolverEx2(Scanner sc) {
        System.out.println("\nPalíndromo");
        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();


        String normalizada = palavra.replaceAll("\\s+", "").toLowerCase();

        PilhaInt pilhaChars = new PilhaInt(normalizada.length());
        for (int i = 0; i < normalizada.length(); i++) {
            pilhaChars.empilhar(normalizada.charAt(i));
        }

        StringBuilder invertida = new StringBuilder();
        while (!pilhaChars.estaVazia()) {
            invertida.append((char) pilhaChars.desempilhar().intValue());
        }

        if (normalizada.equals(invertida.toString())) {
            System.out.println("É palíndromo!");
        } else {
            System.out.println("Não é palíndromo!");
        }
    }


    public static void resolverEx3(Scanner sc) {
        System.out.println("\nParênteses Balanceados");
        System.out.print("Digite uma expressão: ");
        String expressao = sc.nextLine();

        PilhaInt pilhaParenteses = new PilhaInt(expressao.length());
        boolean balanceado = true;

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(') {
                pilhaParenteses.empilhar(c);
            } else if (c == ')') {
                if (pilhaParenteses.desempilhar() == null) {
                    balanceado = false;
                    break;
                }
            }
        }

        if (!pilhaParenteses.estaVazia()) {
            balanceado = false;
        }

        if (balanceado) {
            System.out.println("Expressão balanceada!");
        } else {
            System.out.println("Expressão não balanceada!");
        }
    }
}


