package com.pildorasinformaticas.crud.Controlador;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.pildorasinformaticas.crud.modelo.ModeloProductos;
import com.pildorasinformaticas.crud.modelo.Productos;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloProductos modeloProductos;
	
	@Resource(name="jdbc/Productos") 
	private DataSource miPool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProductos() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
		modeloProductos = new ModeloProductos(miPool);
		
		}catch (Exception e) {
			
			throw new ServletException(e);
			
			// TODO: handle exception
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Productos> productos;
		
		try {
			
			productos = modeloProductos.getProductos();
			
			request.setAttribute("listadoproductos", productos);
			
			
			RequestDispatcher miRD = request.getRequestDispatcher("/ListaProductos.jsp");
			
			miRD.forward(request, response);
			
			
			
		}catch (Exception e) {
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
