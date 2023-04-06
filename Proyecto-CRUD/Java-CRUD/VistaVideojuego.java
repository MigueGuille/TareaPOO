import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.Cursor;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaVideojuego extends JFrame {

	private JPanel contentPane;
	private JTextField txt_idVj;
	private JTextField txt_nombreVj;
	private JTextField txt_generoVj;
	private JTextField txt_yearVj;
	private JTable ListaJv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVideojuego frame = new VistaVideojuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaVideojuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 211, 481);
		panel.setBorder(new TitledBorder(null, "Datos Videojuego", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("\r\n");
		panel.setForeground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 52, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 21, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Genero:");
		lblNewLabel_2.setBounds(10, 88, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Año:");
		lblNewLabel_3.setBounds(10, 124, 46, 14);
		panel.add(lblNewLabel_3);
		
		txt_idVj = new JTextField();
		txt_idVj.setBounds(88, 18, 86, 20);
		panel.add(txt_idVj);
		txt_idVj.setColumns(10);
		
		txt_nombreVj = new JTextField();
		txt_nombreVj.setBounds(88, 49, 86, 20);
		panel.add(txt_nombreVj);
		txt_nombreVj.setColumns(10);
		
		txt_generoVj = new JTextField();
		txt_generoVj.setBounds(88, 85, 86, 20);
		panel.add(txt_generoVj);
		txt_generoVj.setColumns(10);
		
		txt_yearVj = new JTextField();
		txt_yearVj.setBounds(88, 121, 86, 20);
		panel.add(txt_yearVj);
		txt_yearVj.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clase_Videojuego objetoInsertar = new Clase_Videojuego();
				objetoInsertar.InsertarVideojuego(txt_nombreVj, txt_generoVj, txt_yearVj);
				objetoInsertar.MostrarVideojuegos(ListaJv);
			}
		});
		btnNewButton.setBounds(10, 162, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clase_Videojuego objetoEliminar = new Clase_Videojuego();
				objetoEliminar.EliminarVideojuego(txt_idVj);
				objetoEliminar.MostrarVideojuegos(ListaJv);
			}
		});
		btnNewButton_1.setBounds(63, 196, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clase_Videojuego objetoActualizar = new Clase_Videojuego();
				objetoActualizar.ActualizarVideojuego(txt_idVj,txt_nombreVj, txt_generoVj, txt_yearVj);
				objetoActualizar.MostrarVideojuegos(ListaJv);
			}
		});
		btnNewButton_2.setBounds(109, 162, 89, 23);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 34, 498, 435);
		contentPane.add(scrollPane);
		
		ListaJv = new JTable();
		ListaJv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clase_Videojuego objetoSeleccion = new Clase_Videojuego();
				objetoSeleccion.SeleccionarVideoJuego(ListaJv,txt_idVj,txt_nombreVj, txt_generoVj, txt_yearVj);
			}
		});
		ListaJv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(ListaJv);
		
//		ConexBDD_Videojuego ObjetoConex = new ConexBDD_Videojuego();
//		ObjetoConex.ConexionDirecta();
		
		Clase_Videojuego objetoVideojuego = new Clase_Videojuego();
		objetoVideojuego.MostrarVideojuegos(ListaJv);
		txt_idVj.setEnabled(false);
	}
}
