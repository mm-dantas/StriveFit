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


//deve nao estar funcionando pq vc nao colocou isso: <dependency>
//    <groupId>mysql</groupId>
//    <artifactId>mysql-connector-java</artifactId>
//    <version>8.0.33</version>
//</dependency>