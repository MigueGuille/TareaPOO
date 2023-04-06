import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Clase_Videojuego {
	
	String name_game;
	String genre_game;
	String year_game;
	
//	GETTER Y SETTER PARA LOS ID
	int Id;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
//	GETTER Y SETTER PARA LOS NOMBRES DE VIDEOJUEGOS
	public String getName_game() {
		return name_game;
	}
	public void setName_game(String name_game) {
		this.name_game = name_game;
	}
	
//	GETTER Y SETTER PARA LOS GENEROS DE VIDEOJUEGOS
	public String getGenre_game() {
		return genre_game;
	}
	public void setGenre_game(String genre_game) {
		this.genre_game = genre_game;
	}
	
//	GETTER Y SETTER PARA EL AÑO DE LOS VIDEOJUEGOS
	public String getYear_game() {
		return year_game;
	}
	public void setYear_game(String year_game) {
		this.year_game = year_game;
	}
//	METODO PARA MOSTRAR LA LISTA DE LOS VIDEOJUEGOS
	public void MostrarVideojuegos (JTable paramTablaVideojuego) {
		
		ConexBDD_Videojuego objetoConex = new ConexBDD_Videojuego();
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		String query = "";
		modelo.addColumn("Id");
		modelo.addColumn("nombre");
		modelo.addColumn("genero");
		modelo.addColumn("año");
		
		paramTablaVideojuego.setModel(modelo);
		query = "SELECT * FROM videojuego;";
		
		String [] datos = new String[4];
		Statement St;
			
			try {
				St = objetoConex.ConexionDirecta().createStatement();
				
				ResultSet res = St.executeQuery(query);
				
				while (res.next()) {
					datos[0] = res.getString(1);
					datos[1] = res.getString(2);
					datos[2] = res.getString(3);
					datos[3] = res.getString(4);
					
					modelo.addRow(datos);
				}
				
				paramTablaVideojuego.setModel(modelo);
				
			} catch(Exception e){
				JOptionPane.showMessageDialog(null,"ERROR:"+e.toString());
			}
	}
	
	//	METODO PARA INSERTAR LOS VIDEOJUEGOS

	public void InsertarVideojuego(JTextField NombreV, JTextField GeneroV, JTextField Anio) {
	
		setName_game(NombreV.getText());
		setGenre_game(GeneroV.getText());
		setYear_game(Anio.getText());
		
		ConexBDD_Videojuego objetoConex = new ConexBDD_Videojuego();
		
		String queryI = "INSERT INTO videojuego (Nombre, Genero, Año)  values (?,?,?);";
		
		try {
			CallableStatement Cs = objetoConex.ConexionDirecta().prepareCall(queryI);
			Cs.setString(1, getName_game());
			Cs.setString(2, getGenre_game());
			Cs.setString(3, getYear_game());
			
			Cs.execute();
			
			JOptionPane.showMessageDialog(null, "Se ha Añadido el VideoJuego");
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR:" +e.toString());
		}
		
	}

	//	METODO PARA SELECCIONAR LOS VIDEOJUEGOS

	public void SeleccionarVideoJuego(JTable Tabla, JTextField Id, JTextField Nombre, JTextField Genero, JTextField Anio) {
		
		try {
			int Fila=Tabla.getSelectedRow();
			if(Fila>=0) {
				
				Id.setText(Tabla.getValueAt(Fila, 0).toString());
				Nombre.setText(Tabla.getValueAt(Fila, 1).toString());
				Genero.setText(Tabla.getValueAt(Fila, 2).toString());
				Anio.setText(Tabla.getValueAt(Fila, 3).toString());
			}else {
				JOptionPane.showMessageDialog(null, "No se ha Seleccionado Ninguna Fila");

			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR:" +e.toString());

		}
	}
	
	//	METODO PARA ACTUALIZAR LOS VIDEOJUEGOS

	public void ActualizarVideojuego(JTextField IdV,JTextField NombreV, JTextField GeneroV, JTextField Anio) {
		
		setId(Integer.parseInt(IdV.getText()));
		setName_game(NombreV.getText());
		setGenre_game(GeneroV.getText());
		setYear_game(Anio.getText());
		
		ConexBDD_Videojuego objetoConex = new ConexBDD_Videojuego();
		
		String queryA = "UPDATE videojuego SET Nombre= ?, Genero= ?,Año=? WHERE videojuego.id = ?;";
		
		try {
			CallableStatement Cs = objetoConex.ConexionDirecta().prepareCall(queryA);
			Cs.setString(1, getName_game());
			Cs.setString(2, getGenre_game());
			Cs.setString(3, getYear_game());
			Cs.setInt(4, getId());
			
			Cs.execute();
			
			JOptionPane.showMessageDialog(null, "Se ha Actualizar el VideoJuego");
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR:" +e.toString());
		}
		
	}
	
	//	METODO PARA ELIMINAR LOS VIDEOJUEGOS

	public void EliminarVideojuego(JTextField IdV) {
		
		setId(Integer.parseInt(IdV.getText()));
		
		ConexBDD_Videojuego objetoConex = new ConexBDD_Videojuego();
		
		String queryE = "DELETE FROM videojuego WHERE videojuego.id = ?;";
		
		try {
			CallableStatement Cs = objetoConex.ConexionDirecta().prepareCall(queryE);
			Cs.setInt(1, getId());
			
			Cs.execute();
			
			JOptionPane.showMessageDialog(null, "Se ha eliminado el VideoJuego");
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR:" +e.toString());
		}
		
	}
	
}
