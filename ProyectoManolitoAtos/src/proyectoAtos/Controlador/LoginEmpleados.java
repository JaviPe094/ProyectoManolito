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
import javax.servlet.http.HttpSession;

import proyectoAtos.Entidades.Empleados;
import proyectoAtos.Modelo.EmpleadoDAO;
import proyectoAtos.Modelo.EmpleadoDAOImpl;
import proyectoAtos.recursos.Recursos;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		// Recuperamos los parametros
		String user = request.getParameter("usuario");
		String pass = request.getParameter("contra"); 

		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(60);
		
		EmpleadoDAO dao =  new EmpleadoDAOImpl();
		
		Empleados userLogin = dao.read(user);
		
		if (userLogin == null) {
			
			request.setAttribute("msg", "Datos incorrectos");
			response.sendRedirect("formulario_login.html");
			
		}
		
		if (validarLogin(userLogin.getDas(), pass)) {
			
			if (userLogin.getEstado() == Recursos.NUEVO) {
				
				request.setAttribute("user", userLogin);
				response.sendRedirect("cambio_clave.jsp");
				
			}
			else {
				response.sendRedirect("Login_Correcto.jsp");
			}
		} else {
			request.setAttribute("msg", "Datos incorrectos");
			response.sendRedirect("formulario_login.html");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);
	}
	
	
	public boolean validarLogin(String user, String pass) {

		return user.equals(pass);
		
	}
		
}

