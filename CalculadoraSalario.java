package Teste_02;

import java.util.List;
public class CalculadoraSalario {

    // Método para calcular o total pago somente em salários no mês
    public static double calcularSalariosNoMes(List<Funcionario> funcionarios, int mes, int ano) {
        double totalSalarios = 0;

        for (Funcionario funcionario : funcionarios) {
            String[] dataContratacaoSplit = funcionario.getDataContratacao().split("/");
            int mesContratacao = Integer.parseInt(dataContratacaoSplit[0]);
            int anoContratacao = Integer.parseInt(dataContratacaoSplit[1]);

            if (mes == mesContratacao && ano == anoContratacao) {
                if (funcionario.getCargo().equals("Secretário")) {
                    totalSalarios += 7000; // Salário base

                    // Adiciona o benefício por ano de serviço
                    int anosContratado =  ano - anoContratacao;
                    totalSalarios += anosContratado * 1000;

                    // Adiciona 20% sobre o salário
                    totalSalarios *= 1.20;
                } else if (funcionario.getCargo().equals("Vendedor")) {
                    totalSalarios += 12000; // Salário base

                    // Adiciona o benefício por ano de serviço
                    int anosContratado =  ano - anoContratacao;
                    totalSalarios += anosContratado * 1800;
                } else if (funcionario.getCargo().equals("Gerente")) {
                    totalSalarios += 20000; // Salário base
                }
            }
        }

        return totalSalarios;
    }

    // Método main para testar a implementação
    public static void main(String[] args) {
        Funcionario jorge = new Funcionario("Jorge Carvalho", "Secretário", "01/2018");
        Funcionario maria = new Funcionario("Maria Souza", "Secretário", "12/2015");
        Funcionario ana = new Funcionario("Ana Silva", "Vendedor", "12/2021");
        Funcionario joao = new Funcionario("João Mendes", "Vendedor", "12/2021");
        Funcionario juliana = new Funcionario("Juliana Alves", "Gerente", "07/2017");
        Funcionario bento = new Funcionario("Bento Albino", "Gerente", "03/2014");

        List<Funcionario> funcionarios = List.of(jorge, maria, ana, joao, juliana, bento);

        // Testando o método calcularSalariosNoMes para o mês 12 de 2021
        double totalSalariosDezembro2021 = calcularSalariosNoMes(funcionarios, 12, 2021);
        System.out.println("Total pago somente em salários em dezembro de 2021: R$" + totalSalariosDezembro2021);
    }
}