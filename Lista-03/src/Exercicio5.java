public class Exercicio5 {
    private String nome;
    private String crm;
    private String especialidade;

    // Construtor
    public Exercicio5(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    // Método para exibir informações do médico
    @Override
    public String toString() {
        return "Nome: " + nome + ", CRM: " + crm + ", Especialidade: " + especialidade;
    }
}

