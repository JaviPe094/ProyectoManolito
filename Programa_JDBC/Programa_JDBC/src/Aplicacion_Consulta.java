
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame mimarco = new Marco_Aplicacion();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame {

	public Marco_Aplicacion() {

		setTitle("Consulta BBDD");

		setBounds(500, 300, 550, 400);

		setLayout(new BorderLayout());

		JPanel menus = new JPanel();

		menus.setLayout(new FlowLayout());

		marcas = new JComboBox();

		marcas.setEditable(false);

		marcas.addItem("Todos");

		tipo = new JComboBox();

		tipo.setEditable(false);

		tipo.addItem("Todos");

		resultado = new JTextArea(4, 50);

		resultado.setEditable(false);

		add(resultado);

		menus.add(marcas);

		menus.add(tipo);

		add(menus, BorderLayout.NORTH);

		add(resultado, BorderLayout.CENTER);

		JButton botonConsulta = new JButton("Consulta");

		botonConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ejecutaConsulta();
				
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establecemos la conexion
			 conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendajuegos","juancarlos","nosequeponer93");
			Statement sentencia = conexion.createStatement();
			//System.out.println("Conexion realizada con exito");
			
			String consulta = "SELECT distinct marca FROM productos";
			
			ResultSet rs = sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				
				marcas.addItem(rs.getString(1));
			}
			
			rs.close();
			
			 consulta = "SELECT distinct tipo FROM productos";
			
			 rs = sentencia.executeQuery(consulta);
			
			while(rs.next()) {
				
				tipo.addItem(rs.getString(1));
			}
			
			rs.close();
			
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	

	}
	
	private void ejecutaConsulta() {
		
		ResultSet rs = null;
		
		resultado.setText("");
		
		try {
			
			String seleccion = (String)marcas.getSelectedItem();
			
			String tipos=(String) tipo.getSelectedItem();
			
			if(!seleccion.equals("Todos") && tipos.equals("Todos")) {
			enviarConsultaMarcas = conexion.prepareStatement(consultaSelectMarcas);
			
			enviarConsultaMarcas.setString(1, seleccion);
			
			rs = enviarConsultaMarcas.executeQuery();
			
			}else if(seleccion.equals("Todos") && !tipos.equals("Todos")){
				
				enviarConsultaTipos = conexion.prepareStatement(consultaSelecTipos);
				
				enviarConsultaTipos.setString(1, tipos);
				
				rs = enviarConsultaTipos.executeQuery();
				
			}
			
			while(rs.next()) {
				
				resultado.append(rs.getString(1));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(2));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(3));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(4));
				
				resultado.append(", ");

				resultado.append(rs.getString(5));
				
				resultado.append(", ");
				
				resultado.append(rs.getString(6));
				
				resultado.append("\n");
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private Connection conexion;
	
	private PreparedStatement enviarConsultaMarcas;
	
	private PreparedStatement enviarConsultaTipos;
	
	private PreparedStatement enviarConsultaTodos;
	
	private final String consultaSelectMarcas = "SELECT nombre, marca, precio, descripcion, cantidad, tipo FROM productos WHERE marca =?";
	
	private final String consultaSelecTipos = "SELECT nombre, marca, precio, descripcion, cantidad, tipo FROM productos WHERE tipo =?";
	
	private final String consultaTodos = "SELECT nombre, marca, precio, descripcion, cantidad, tipo FROM productos";
	
	private JComboBox marcas;

	private JComboBox tipo;

	private JTextArea resultado;

}
