import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variáveis para contar pessoas por canal
        int pessoasCanal4 = 0;
        int pessoasCanal5 = 0;
        int pessoasCanal7 = 0;
        int pessoasCanal12 = 0;

        // Total de pessoas que assistiram TV
        int totalPessoas = 0;

        while (true) {
            System.out.print("Digite o número do canal (4, 5, 7, 12) ou 0 para sair: ");
            int canal = scanner.nextInt();

            if (canal == 0) {
                break; // Encerra o loop
            }

            System.out.print("Digite o número de pessoas assistindo: ");
            int pessoas = scanner.nextInt();

            // Acumula os dados conforme o canal informado
            switch (canal) {
                case 4:
                    pessoasCanal4 += pessoas;
                    break;
                case 5:
                    pessoasCanal5 += pessoas;
                    break;
                case 7:
                    pessoasCanal7 += pessoas;
                    break;
                case 12:
                    pessoasCanal12 += pessoas;
                    break;
                default:
                    System.out.println("Canal inválido. Dados ignorados.");
                    continue;
            }

            totalPessoas += pessoas; // Soma no total geral
        }

        // Exibe o resultado com porcentagens
        if (totalPessoas > 0) {
            System.out.println("\nPorcentagem de audiência por canal:");
            System.out.printf("Canal 4: %.2f%%\n", (pessoasCanal4 * 100.0) / totalPessoas);
            System.out.printf("Canal 5: %.2f%%\n", (pessoasCanal5 * 100.0) / totalPessoas);
            System.out.printf("Canal 7: %.2f%%\n", (pessoasCanal7 * 100.0) / totalPessoas);
            System.out.printf("Canal 12: %.2f%%\n", (pessoasCanal12 * 100.0) / totalPessoas);
        } else {
            System.out.println("Nenhum dado de audiência foi inserido.");
        }

        scanner.close();
    }
}
