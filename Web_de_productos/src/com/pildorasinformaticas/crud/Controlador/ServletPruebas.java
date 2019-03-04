package com.pildorasinformaticas.crud.Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Definir o establecer el DataSource
	
	@Resource(name="jdbc/Productos")
       
	private DataSource miPool;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Crear objeto PrintWriter
		
		PrintWriter salida = response.getWriter();
		
		response.setContentType("text/plain");
		
		//Crear Conexion BBDD
		
		Connection miConexion = null;
		
		Statement miStatement = null;
		
		ResultSet miResul = null;
		
		
		try {
			
			miConexion = miPool.getConnection();
			String sql = "SELECT * FROM productos";
			miStatement = miConexion.createStatement();
			
			miResul = miStatement.executeQuery(sql);
			
			while(miResul.next()) {
				
				String nombre_articulo = miResul.getString(3);
				
				salida.println(nombre_articulo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
