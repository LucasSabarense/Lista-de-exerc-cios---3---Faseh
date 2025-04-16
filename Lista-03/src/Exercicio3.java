import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] idades = new int[10];
        double[] pesos = new double[10];
        double[] alturas = new double[10];

        int somaIdades = 0;
        int contadorPesoAltura = 0;
        int contadorAltos = 0;
        int contadorAltosEntre10e30 = 0;

        // Coleta de dados
        for (int i = 0; i < 10; i++) {
            System.out.println("Pessoa " + (i + 1) + ":");
            System.out.print("Idade: ");
            idades[i] = scanner.nextInt();

            System.out.print("Peso (kg): ");
            pesos[i] = scanner.nextDouble();

            System.out.print("Altura (m): ");
            alturas[i] = scanner.nextDouble();

            somaIdades += idades[i];

            if (pesos[i] > 90 && alturas[i] < 1.50) {
                contadorPesoAltura++;
            }

            if (alturas[i] > 1.90) {
                contadorAltos++;
                if (idades[i] >= 10 && idades[i] <= 30) {
                    contadorAltosEntre10e30++;
                }
            }

            System.out.println();
        }

        // Cálculos e resultados
        double mediaIdades = (double) somaIdades / 10;
        double porcentagemAltosEntre10e30 = contadorAltos > 0 ?
                (double) contadorAltosEntre10e30 / contadorAltos * 100 : 0;

        System.out.println("=== RESULTADOS ===");
        System.out.printf("Média das idades: %.2f anos\n", mediaIdades);
        System.out.println("Total de pessoas com mais de 90 kg e menos de 1.50 m: " + contadorPesoAltura);
        System.out.printf("Porcentagem de pessoas entre 10 e 30 anos com mais de 1.90 m: %.2f%%\n", porcentagemAltosEntre10e30);

        // Exibindo todos os dados coletados
        System.out.println("\n=== DADOS COLETADOS ===");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Pessoa %d - Idade: %d, Peso: %.2f kg, Altura: %.2f m\n",
                    i + 1, idades[i], pesos[i], alturas[i]);
        }

        scanner.close();
    }
}

