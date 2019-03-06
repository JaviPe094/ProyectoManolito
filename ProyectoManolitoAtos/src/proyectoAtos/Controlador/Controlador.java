package proyectoAtos.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyectoAtos.Entidades.Empleados;
import proyectoAtos.Entidades.Estado;
import proyectoAtos.Modelo.EmpleadoDAO;
import proyectoAtos.Modelo.EmpleadoDAOImpl;
import proyectoAtos.Modelo.EstadoDAO;
import proyectoAtos.Modelo.EstadoDAOImpl;
import proyectoAtos.recursos.Recursos;

/**
 * Servlet implementation class Controlador
 * 
 */

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpleadoDAO dao;
	Empleados userLogin;

	EstadoDAO estadoDAO;
	Estado estado;

	/* Contructor de Controlador */
	
	public Controlador() {
		
		super();

		dao = new EmpleadoDAOImpl();

		userLogin = new Empleados();

		estadoDAO = new EstadoDAOImpl();

	}

	/* 
	 * Tanto doPost como doGet son necesarios. En este caso, por evitar que los datos de formulario
	 * salgan en la barra de direcciones se ha optado por doPost. doGet queda vacío.
	 * 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	/* 
	 * La funcionalidad se encuentra en el método doPost. Se ha optado por el enfoque de
	 * un servlet encargado de las funcionalidades frente a varios servlets, con el objetivo
	 * de unificar las operaciones
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// leer comando del formulario
		String comando = request.getParameter("instruccion");
		
		request.getSession().setMaxInactiveInterval(10);
		//request.getSession().on

		// Salida rápida en caso de que se produzca un error en el comando
		
		if (comando == null) {

			System.out.println("El comando esta vacio");

			response.sendRedirect("formulario_login2.html");
			
			return;

		}

		switch (comando) {
		
			case "validar":
				
				validarLogin(request, response);
				break;
	
			case "usuarioAceptado":
	
				if (cambiarPass(request, response)) {
					
					if (userLogin.getPermiso().getNombre().equals("admin")) 
						enviarInfoPanelAdmin(request, response);
					
					else
						enviarInfoPanelUser(request, response);
	
				} 
				
				else {
					System.out.println("FALLO AL CAMBIAR PASSWORD");
				}
				
				break;
				
			case "logout":
				
				onLogOut(request, response);
				
				break;

			default:
				break;
				
		}
		
	}

	private void enviarInfoPanelUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String das = userLogin.getDas();
		String nombre = userLogin.getNombre();
		String apellido = userLogin.getApellido();
		String email = userLogin.getEmail();

		request.setAttribute("das", das);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		request.setAttribute("email", email);

		RequestDispatcher requesDis = request.getRequestDispatcher("panel_usuario.jsp");
		requesDis.forward(request, response);

	}

	private boolean cambiarPass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pass = request.getParameter("contrasena");
		
		userLogin.setEstado(estadoDAO.read('a'));
		
		userLogin.setPassword(pass);
		dao.update(userLogin);
		
		return userLogin.getPassword().equals(pass);
		
	}

	public boolean validarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recuperamos los parametros
		String user = request.getParameter("usuario");
		String pass = request.getParameter("contra");
		
		try {

			userLogin = dao.read(user);
			
			if (userLogin != null && userLogin.getPassword().equals(pass)) {

				if ((userLogin.getPermiso().getNombre()).equals("admin")) {
					esAdmin(request, response);
				}
				
				else if((userLogin.getPermiso().getNombre()).equals("basico")) {
					
					if ((userLogin.getEstado().getEstado()) == Recursos.NUEVO) {

						response.sendRedirect("nueva_contrasena.html");
						
					} 
					
					else {
						
						enviarInfoPanelUser(request, response);
					}
				}
					
			} 
			
			else {
				
				System.out.println("FALLO EN EL LOGIN");
				request.getSession().setAttribute("msg", "Oops.Login incorrecto");
				response.sendRedirect("formulario_login2.jsp");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return user.equals(pass);

	}

	private void esAdmin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		if ((userLogin.getEstado().getEstado()) == Recursos.NUEVO) {

			response.sendRedirect("nueva_contrasena.html");

		} else {
			enviarInfoPanelAdmin(request, response);
		}

	}

	private void enviarInfoPanelAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String das = userLogin.getDas();
		String nombre = userLogin.getNombre();
		String apellido = userLogin.getApellido();
		String email = userLogin.getEmail();

		request.setAttribute("das", das);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		request.setAttribute("email", email);

		RequestDispatcher requesDis = request.getRequestDispatcher("panel_administrador.jsp");
		requesDis.forward(request, response);

	}
	
	private void onLogOut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getSession().invalidate();
		response.sendRedirect("formulario_login.jsp");
		
	}

	private void anadirUsuario(HttpServletRequest request) {
	
		String das = (String) request.getAttribute("das");
		String password = (String) request.getAttribute("password");
		String nombre = (String) request.getAttribute("nombre");
		String apellido = (String) request.getAttribute("apellido");
		String email = (String) request.getAttribute("email");
		Estado est=estadoDAO.read('n');
		String permiso = (String) request.getAttribute("permiso");
		
	
	}
	
}
