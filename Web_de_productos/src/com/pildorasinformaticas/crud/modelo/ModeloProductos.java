package com.pildorasinformaticas.crud.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class ModeloProductos {

	private DataSource origenDatos;

	public ModeloProductos(DataSource origenDatos) {
		
		this.origenDatos=origenDatos;
	}

	public List<Productos> getProductos() throws Exception{
		
		List<Productos> productos = new ArrayList<>();
		
		//Crear Conexion BBDD
		
		Connection miConexion = null;		
				
		Statement miStatement = null;
				
		ResultSet miResul = null;
		
		
		miConexion = origenDatos.getConnection();
		
		String sql = "SELECT * FROM Productos";
		
		miStatement = miConexion.createStatement();
		
		miResul = miStatement.executeQuery(sql);
		
		while(miResul.next()) {
			
			String codigoArt = miResul.getString(1);
			String seccion = miResul.getString(2);
			String nombreArti = miResul.getString(3);
			Double precio = miResul.getDouble(4);
			Date fecha = miResul.getDate(5);
			String importado = miResul.getString(6);
			String paisOrigen = miResul.getString(7);
			
			Productos producto = new Productos(codigoArt, seccion, nombreArti, precio, fecha, importado, paisOrigen);
			
			productos.add(producto);
		}
		
		return productos;
		
	}

}
