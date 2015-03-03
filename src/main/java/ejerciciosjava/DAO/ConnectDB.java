package ejerciciosjava.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class ConnectDB 
{    private String username;
    private String password;
    private static String DB = "employee";
    static String url = "jdbc:mysql://localhost/" + DB;
    private Connection conn = null;
    public ConnectDB()
    {
    	try
    	{
    		Class.forName("com.mysql.jdbc.Connectio");
    		conn = (Connection) DriverManager.getConnection(url, username, password);
    		if (conn!=null)
    		{
    			System.out.println("Conexión a base de datos : " +DB+ "realizada con éxito");
    		}
    	}catch(SQLException e)
    	{
    		System.out.println("Se ha producido  un error al connectarse a : " +url);
    	}catch(ClassNotFoundException e)
    	{
    		System.out.println("Error :  "+e);
    	}
    }
    public ResultSet GetQuery(String query)
    {
    	Statement state = null;
    	ResultSet resultado = null;
    	try
    	{
    		state = (Statement) conn.createStatement();
    		resultado = state.executeQuery(query);
    	}catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return resultado;
    }
    public void SetQuery(String query)
    {
    	Statement state = null;
    	try {
    		state=(Statement) conn.createStatement();
    		state.execute(query);
    	}catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
}
