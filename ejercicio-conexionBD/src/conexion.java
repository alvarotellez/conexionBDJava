import java.sql.*;
public class conexion {
	public static void main(String[] args) {
		try{
			String miConsulta;
			
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
				//Le metemos un espacio para que no nos muestre todo junto
				System.out.println(numFilas.getString("nombre" + " ")+numFilas.getString("apellidos"+" ")+numFilas.getString("fechaNac"+" "));
			}
			
			miConexion.close();
		}catch(Exception e){
			System.out.print("No se puede conectar");
			e.printStackTrace();
		}
	}
}
