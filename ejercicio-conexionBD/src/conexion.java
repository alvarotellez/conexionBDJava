import java.sql.*;
import java.util.Scanner;
public class conexion {
	public static void main(String[] args) {
		try{
			//Entorno:
			String miConsulta;
			String nombre;
			String apellidos;
			Scanner sc = new Scanner(System.in);
			
			
			//Algoritmo:
			//PARA HACER EL SELECT
			//Ruta de acceso, en localhost metemos el puerto
			String source = "jdbc:sqlserever://localhost";
			//Nombre de usuario
			String usuario = "pepito";
			//Contraseña del usuario
			String password="qq";
			//1.Creamos una conexion para conectarnos a la base de datos
			Connection miConexion = DriverManager.getConnection(source,usuario,password);
			//2.Crear el statement
			Statement sentenciaSelect = miConexion.createStatement();
			//3.Ejecutar la sentencia sql
			miConsulta = "select idEmpleado,nombre,apellidos,fechanac FROM EMPLEADOS";
			ResultSet numFilas = sentenciaSelect.executeQuery(miConsulta);
			
			//4.Mostrar el resultado
			
			while(numFilas.next()){
				//Le metemos un espacio para que no nos muestre todo 
				System.out.println(numFilas.getString("nombre" + " ")+numFilas.getString("apellidos"+" ")+numFilas.getString("fechaNac"+" "));
			}
			
			//PARA HACER EL INSERT
			System.out.println("Introduzca el nombre del empleado: ");
			nombre = sc.nextLine();
			
			System.out.println("Introduzca los apellidos del empleado: ");
			apellidos = sc.nextLine();
			
			PreparedStatement stmt = miConexion.prepareStatement("INSERT INTO empleados VALUES(?,?)");	
			stmt.setString(1, nombre);
			stmt.setString(2, apellidos);
			
			stmt.executeUpdate();
			miConexion.close();
		}catch(SQLException sqle){
			System.err.println(sqle);
			
		}
	}
}
