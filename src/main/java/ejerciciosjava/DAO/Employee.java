package ejerciciosjava.DAO;

public class Employee {
	public Employee(int sSN, String name, String lastName, String department)
	{
		super();
		SSN = sSN;
		Name = name;
		LastName = lastName;
		Department = department;
	}
	public Employee()
	{
		SSN= 0;
		Name = " ";
		LastName = " ";
		Department = " ";
		
	}
	
	public int SSN;
	public int getSSN()
	{
		return SSN;
	}
	public void setSSN(int sSN)
	{
		SSN = sSN;
	}
	public String getName()
	{
		return Name;
	}
	public void  setName(String name)
	{
		Name = name;
	}
	public String getlastName()
	{
		return LastName;
	}
	public void set_lastName(String lastname)
	{
		LastName = lastname;
	}
	public String getDepartment()
	{
		return Department;
	}
	public void set_Department(String department)
	{
		Department = department;
	}
	public String Name;
	public String LastName;
	public String Department;
}
