package Exercicio7;

public class Produto {
    private int codigo;
    private String nome;
    private double valorUnitario;
    private String tipoUnidade;

    public Produto(int codigo, String nome, double valorUnitario, String tipoUnidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.tipoUnidade = tipoUnidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Valor: R$" + valorUnitario + ", Unidade: " + tipoUnidade;
    }
}

