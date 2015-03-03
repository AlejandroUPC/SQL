package ejerciciosjava.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {

	private int SSN;
	private static ConnectDB con = new ConnectDB();
	public static void main(String[] args){
		Employee e = new Employee();
		e=getEmployee(123234877);
		deleteEmployee(123234877);
		Employee empleado = new Employee();
		empleado.setSSN(671202623);
		empleado.setName("Torbe");
		empleado.set_lastName("LaCerda");
		empleado.set_Department("37");
		updateEmployee(empleado);
		
		//Recoger personas en una lista
		ArrayList<Employee> AllEmployees = getAllEmployees();
		//Validamos que hemos obtenido algo
		if(AllEmployees.size() > 0){
			int numeroPersona = 0;
			//Recorrer lista
			for (int i = 0; i < AllEmployees.size(); i++)
			{
				numeroPersona++;
				e=AllEmployees.get(i);//NO ENTENDER
				System.out.println(">>Persona Número : " +numeroPersona);
				System.out.println("SSN: " +e.getSSN());
				System.out.println("Name: " +e.getName());
				System.out.println("Last Name: " +e.getlastName());
				System.out.println("Department : " +e.getDepartment());
				System.out.println("^*^*^*^*^*^*^*^*^*^*^*^\n");
			}
		}
			else{
				System.out.println("No hay empleados en la lista");
			}
		}
	private static Employee getEmployee(int SSN)
	{
		ConnectDB conn = new ConnectDB();
		ResultSet resultado;
		Employee d = new Employee();
		resultado = conn.GetQuery("SELECT * FROM Employees WHERE SSN='"+SSN+"'");
		try
		{
			while(resultado.next())
			{
				d.setSSN(Integer.parseInt(resultado.getString("SSN")));
				System.out.println("Id Persona: " + d.getSSN());
				d.setName(resultado.getString("Name"));
				System.out.println("Name: " + d.getName());
				d.set_lastName(resultado.getString("LastName"));
				System.out.println("LastName: " + d.getlastName());
				d.set_Department(resultado.getString("Department"));
				System.out.println("Department: " + d.getDepartment());
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return d;
		}
		public static ArrayList<Employee> getAllEmployees()
		{
			ArrayList<Employee> lista = new ArrayList<Employee>();
			ConnectDB conn = new ConnectDB();
			ResultSet resultado;
			resultado = conn.GetQuery("SELECT * FROM Employees");
			try
			{
				while(resultado.next())
				{
					Employee e = new Employee();
					e.setSSN(Integer.parseInt(resultado.getString("SSN")));
					e.setName(resultado.getString("Name"));
					e.set_lastName(resultado.getString("LastName"));
					e.set_Department(resultado.getString("Department"));
					lista.add(e);
				}
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return lista;
		}
		public static void deleteEmployee(int SSN)
		{
			ConnectDB conn = new ConnectDB();
			conn.SetQuery("DELETE FROM Employees WHERE SSN='"+SSN+"'");
			
		}
		public static void updateEmployee(Employee employee)
		{
			ConnectDB conn = new ConnectDB();
			ResultSet resultado;
			int id;
			String n,ln,d;
			id=employee.getSSN();
			n = employee.getName();
			ln =  employee.getlastName();
			d= employee.getDepartment();
			String nombre ="INSERTO INTO Employees(SSN,Name,LastName,Department) VALUES ('"+id+",'"+n+"','"+ln+"','"+d+"')";
			System.out.println("Name : "+nombre);
			conn.SetQuery("INSERT INTO Employees(SSN,Name,LastName,Department) VALUES ('"
			+ id + "', '" + n + "', '" + ln + "', " + d + ")");
		}
	}
	

