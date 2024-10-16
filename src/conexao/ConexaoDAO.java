package conexao;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDAO {

    public Connection conectaBD(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password";
            conn = DriverManager.getConnection(url);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        return conn;
    }
}
