package proyectoAtos.Controlador;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyectoAtos.Entidades.Empleados;
import proyectoAtos.Modelo.EmpleadoDAO;
import proyectoAtos.Modelo.EmpleadoDAOImpl;

/**
 * Servlet implementation class LoginEmpleados
 */
@WebServlet("/login.html")
public class LoginEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEmpleados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		// Recuperamos los parametros
		String user = request.getParameter("usuario");
		String pass = request.getParameter("contra"); 

		System.out.println(user+","+pass);
		
		EmpleadoDAO dao =  new EmpleadoDAOImpl();
		
		Empleados userLogin = dao.read(user);
		 
		
		if (validarLogin(userLogin.getDas(), pass)) {
			
			if (userLogin.getEstado() == 'i') {
				
				response.sendRedirect("cambio_clave.jsp");
				
			}
			else {
				response.sendRedirect("Login_Correcto.jsp");
			}
		} else {
			response.sendRedirect("Login_Incorrecto.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public boolean validarLogin(String user, String pass) {

		return user.equals(pass);
		
	}
		
}

