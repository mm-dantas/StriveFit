package conta;

import conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Cadastro {
    private String nome;
    private String sobrenome;
    private int idade;
    private String email;
    private String senha;

    private ConnectionFactory connection;
    private static Scanner leitor = new Scanner(System.in);

    // Construtor para inicializar a connection
    public Cadastro() {
        this.connection = new ConnectionFactory(); // Inicializa a conexão aqui
    }

    public void DadosDoUsuario(){
        System.out.println("Digite seu nome: ");
        nome = leitor.nextLine();

        System.out.println("Digite seu sobrenome: ");
        sobrenome = leitor.nextLine();

        System.out.println("Digite sua idade: ");
        idade = leitor.nextInt();
        leitor.nextLine(); // Consome a quebra de linha após o nextInt()

        System.out.println("Crie seu email: ");
        email = leitor.nextLine();

        System.out.println("Crie uma senha: ");
        senha = leitor.nextLine();

        Cadastrar();
    }


    private void Cadastrar() {
    String sql = "INSERT INTO usuario (email, senha, nome, sobrenome, idade)" +
            "VALUES (?, ?, ?, ?, ?)";
    Connection conn = connection.recuperaConexao();
        try {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, senha);
        preparedStatement.setString(3, nome);
        preparedStatement.setString(4, sobrenome);
        preparedStatement.setInt(5, idade);

        preparedStatement.execute();
    } catch (
    SQLException e) {
        throw new RuntimeException(e);
    }
    }
}
