package persistance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David Ramírez
 */
public class DataBaseConnect {
    private Connection connection;
    private Statement statement;

    public DataBaseConnect() {
        System.out.println(startConnection()?"Conectado":"Sin conexión");
    }
    
    private boolean startConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","velo","A123");
            this.statement = connection.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error: "+ex.getMessage());
            return false;
        }
    }
    
    public ResultSet sendSentence(String query){
        ResultSet result = null;
        try {
            result = statement.executeQuery(query);              
        } catch (SQLException ex) {
            System.err.println("Error en uso de sentencia: "+ex.getMessage());
        }        
        return result;
    }
    
    public boolean commit(){
        try {
            connection.commit();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error en el envío de transacción: "+ex.getMessage());
            return false;
        }
    }
    
    public boolean closeConnection(){
        try {
            this.connection.close();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error en cierre de conección: "+ex.getMessage());
            return false;
        }
    }
}
