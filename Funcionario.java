package Teste_02;
import java.util.List;

public class Funcionario {



    private String nome;
    private String cargo;
    private String dataContratacao;

    // Construtor
    public Funcionario(String nome, String cargo, String dataContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }
}
