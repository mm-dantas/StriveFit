package musculacao;

import conexao.ConnectionFactory;
import musculacao.treinos.Treino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class InserirTreino {
    private ConnectionFactory connection;

    //lista na qual os exercícios que o usuário realizou são armazenados
    ArrayList<String> listaDeExercicios = new ArrayList<>();

    public void inserirTreino(){
        this.connection = new ConnectionFactory();
        Scanner exercicios = new Scanner(System.in);

        // esse bloco de código é responsavel para o usuário colocar todos os exercícios que ele fez no dia na academia
        while (true) {
            System.out.println("Digite o exercício realizado ou 'fim' para terminar: ");
            String nomeDoExercicio = exercicios.nextLine();
            if (nomeDoExercicio.equalsIgnoreCase("fim")){
                break;
            }
            listaDeExercicios.add(nomeDoExercicio);
        }

        Scanner leitor = new Scanner(System.in);

        //percorre cada item da lista para colocar os dados de cada exercício
        for (String exercicio : listaDeExercicios) {
            Treino treino = new Treino();
            inserirDadosTreino(leitor, treino, exercicio);
        }

        leitor.close();
    }

    public void inserirDadosTreino(Scanner leitor, Treino treino, String exercicio){

        System.out.println("Exercício de " + exercicio + ":");
        treino.setNomeExercicio(exercicio);
        System.out.println("Quantas series você realiza nesse exercício?");
        treino.setNumeroSeries(leitor.nextInt());

        for (int i = 1; i <= treino.getNumeroSeries(); i++){
            System.out.println("Digite quantos quilos você pega na " + i + "ª série");
            treino.addPeso(leitor.nextDouble());
            leitor.nextLine();
            System.out.println("Digite o número de repetições da " + i + "ª série: ");
            treino.addNumeroRepeticoes(leitor.nextInt());
            leitor.nextLine();
        }
        System.out.println(treino.MostrarDadosExercicio());


        //adiciona os dados do exercício na tabela
        String sql = "INSERT INTO treino (nome_treino, nome_musculo, qtd_serie)" +
                "VALUES (?, ?, ?)";
        Connection conn = connection.recuperaConexao();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, treino.getNomeExercicio());
            preparedStatement.setString(2, treino.getNomeMusculo());
            preparedStatement.setInt(3, treino.getNumeroSeries());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
