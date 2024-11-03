package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperaConexao() {
        try {
            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/note_treino_teste?user=root&password=1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
