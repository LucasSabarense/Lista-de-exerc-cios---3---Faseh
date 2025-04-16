package Exercicio7;

import java.util.*;

public class LojinhaSrAbu {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- Lojinha do Sr. Abu ---");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Realizar Venda");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> alterarProduto();
                case 3 -> excluirProduto();
                case 4 -> realizarVenda();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Cadastro
    public static void cadastrarProduto() {
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Valor unitário: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // limpar buffer
        System.out.print("Tipo de unidade (ex: kg, un): ");
        String unidade = scanner.nextLine();

        produtos.add(new Produto(codigo, nome, valor, unidade));
        System.out.println("Produto cadastrado com sucesso!");
    }

    // Alteração
    public static void alterarProduto() {
        System.out.print("Informe o código do produto: ");
        int codigo = scanner.nextInt();
        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto != null) {
            scanner.nextLine(); // limpar buffer
            System.out.print("Novo nome: ");
            produto.setNome(scanner.nextLine());
            System.out.print("Novo valor: ");
            produto.setValorUnitario(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Nova unidade: ");
            produto.setTipoUnidade(scanner.nextLine());
            System.out.println("Produto atualizado!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Exclusão
    public static void excluirProduto() {
        System.out.print("Informe o código do produto: ");
        int codigo = scanner.nextInt();
        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Venda
    public static void realizarVenda() {
        double total = 0;
        String continuar;
        do {
            System.out.print("Código do produto: ");
            int codigo = scanner.nextInt();
            Produto produto = buscarProdutoPorCodigo(codigo);
            if (produto != null) {
                System.out.print("Quantidade: ");
                int qtd = scanner.nextInt();
                double subtotal = produto.getValorUnitario() * qtd;
                total += subtotal;
                System.out.println("Adicionado: " + produto.getNome() + " - Subtotal: R$" + subtotal);
            } else {
                System.out.println("Produto não encontrado.");
            }
            System.out.print("Deseja adicionar outro produto? (s/n): ");
            continuar = scanner.next();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.printf("Total da compra: R$ %.2f\n", total);
        escolherFormaPagamento(total);
    }

    // Buscar produto
    public static Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }

    // Pagamento
    public static void escolherFormaPagamento(double total) {
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1. Pix");
        System.out.println("2. Cartão");
        System.out.println("3. Dinheiro");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> System.out.println("Código Pix: abc123xyz456 (copie e cole no app do banco)");
            case 2 -> {
                scanner.nextLine();
                System.out.print("Crédito ou Débito? ");
                String tipoCartao = scanner.nextLine();
                System.out.print("Número do cartão: ");
                String numero = scanner.nextLine();
                System.out.println(tipoCartao + " autorizado. Compra de R$" + total + " aprovada.");
            }
            case 3 -> {
                System.out.print("Valor pago: R$ ");
                double pago = scanner.nextDouble();
                if (pago >= total) {
                    double troco = pago - total;
                    System.out.printf("Troco: R$ %.2f\n", troco);
                } else {
                    System.out.println("Valor insuficiente!");
                }
            }
            default -> System.out.println("Forma de pagamento inválida.");
        }
    }
}

