package conexao;

import javax.swing.JOptionPane;
import java.sql.Connection;

public class ConexaoDAO {

    public Connection conectaBD(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://";
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        return conn;
    }
}
