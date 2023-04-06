import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexBDD_Videojuego {

	Connection Conectar = null;
	
	String Usuario = "postgres";
	String Contraseña = "miguel";
	String BD = "Bd_Videojuegos";
	String Ip = "localhost";
	String port = "5432";
	
	String Cadena = "jdbc:postgresql://"+Ip+":"+port+"/"+BD;
	
	public Connection ConexionDirecta() {
		try {
		Class.forName("org.postgresql.Driver");
		
		Conectar = DriverManager.getConnection(Cadena,Usuario,Contraseña);
		JOptionPane.showMessageDialog(null, "Se Conecto a la base de datos");
		
	} catch(Exception e){
		JOptionPane.showMessageDialog(null, "ERROR:"+ e.toString());
		}
	return Conectar;

	}
}
