public class Exercicio4 {
    public static void main(String[] args) {
        double soma = 0.0;
        int numerador = 1000;

        for (int i = 1; i <= 50; i++) {
            double termo = (double) numerador / i;

            // Alterna sinal: se i é ímpar, soma; se par, subtrai
            if (i % 2 == 1) {
                soma += termo;
            } else {
                soma -= termo;
            }

            numerador -= 3;
        }

        System.out.println("A soma dos 50 primeiros termos da série é: " + soma);
    }
}

