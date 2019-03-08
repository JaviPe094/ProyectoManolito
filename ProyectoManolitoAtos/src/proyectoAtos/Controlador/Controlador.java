package proyectoAtos.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyectoAtos.Entidades.Empleados;
import proyectoAtos.Entidades.Estado;
import proyectoAtos.Entidades.Tareas;
import proyectoAtos.Modelo.EmpleadoDAO;
import proyectoAtos.Modelo.EmpleadoDAOImpl;
import proyectoAtos.Modelo.EstadoDAO;
import proyectoAtos.Modelo.EstadoDAOImpl;
import proyectoAtos.Modelo.PermisosDAOImpl;
import proyectoAtos.Modelo.TareasDAO;
import proyectoAtos.Modelo.TareasDAOImpl;
import proyectoAtos.recursos.EmpleadoUtil;
import proyectoAtos.recursos.Recursos;


/**
 * Servlet implementation class Controlador
 * 
 */

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpleadoDAO dao;
	TareasDAO tareasDAO;
	Empleados userLogin;

	EstadoDAO estadoDAO;
	Estado estado;

	/* Contructor de Controlador */

	public Controlador() {

		super();

		dao = new EmpleadoDAOImpl();

		userLogin = new Empleados();

		estadoDAO = new EstadoDAOImpl();

		tareasDAO = new TareasDAOImpl();

	}

	/*
	 * Tanto doPost como doGet son necesarios. En este caso, por evitar que los
	 * datos de formulario salgan en la barra de direcciones se ha optado por
	 * doPost. doGet queda vacío.
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/*
	 * La funcionalidad se encuentra en el método doPost. Se ha optado por el
	 * enfoque de un servlet encargado de las funcionalidades frente a varios
	 * servlets, con el objetivo de unificar las operaciones
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// leer comando del formulario
		String comando = request.getParameter("instruccion");

		request.getSession().setMaxInactiveInterval(10);
		// Salida rápida en caso de que se produzca un error en el comando

		if (comando == null) {

			System.out.println("El comando esta vacio");

			response.sendRedirect("formulario_login.jsp");

			return;

		}

		switch (comando) {

		case "validar":

			validarLogin(request, response);
			break;

		case "usuarioAceptado":

			if (cambiarPass(request, response)) {

				if ((userLogin.getPermiso().getNombre()).equals("admin"))
					enviarInfoPanelAdmin(request, response);

				else
					enviarInfoPanelUser(request, response);

			}

			else {
				
				System.out.println("FALLO AL CAMBIAR PASSWORD");
				request.getSession().setAttribute("msg", "Disculpe, esta clave no es válida");
				response.sendRedirect("nueva_contrasena.jsp");
				
			}

			break;

		case "listarEmpleados":
			try {

				enviarInfoPanel(request, response);

				List<Empleados> listaEmpleados = dao.seleccionaTodos();

				request.setAttribute("LISTAREMPLEADOS", listaEmpleados);

				RequestDispatcher miDispa = request.getRequestDispatcher("/panel_admin_usuarios.jsp");

				miDispa.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "listarTareas":
			try {
				//enviarInfoPanel(request, response);
				
				String das = userLogin.getDas();
				String nombre = userLogin.getNombre();
				String apellido = userLogin.getApellido();
				String email = userLogin.getEmail();

				request.setAttribute("das", das);
				request.setAttribute("nombre", nombre);
				request.setAttribute("apellido", apellido);
				request.setAttribute("email", email);

				List<Tareas> listaTareas = tareasDAO.seleccionaTodos();

				System.out.println(listaTareas);

				request.setAttribute("LISTARTAREAS", listaTareas);

				RequestDispatcher miDispaTareas = request.getRequestDispatcher("/panel_admin_tareas.jsp");

				miDispaTareas.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "insertar_usuario":
			
			String das = request.getParameter("das");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellidos");
			String email = request.getParameter("email");
			String per = request.getParameter("permisos");
			System.out.println(per);
		
			Empleados test = new EmpleadoDAOImpl().read(das);
		
			if (test == null) {
			
				Empleados newEmpleado = new Empleados(das, EmpleadoUtil.generatePass(8), nombre, apellido, 
						email, new EstadoDAOImpl().read('n'), new PermisosDAOImpl().read(per));
				
				dao.create(newEmpleado);
				
				enviarInfoPanelAdmin(request, response);
				
			}
			
			else {
				
				request.getSession().setAttribute("msg", "Lo lamentamos, este DAS ya está en uso");
				response.sendRedirect("insercion_usuarios.jsp");
				
			}
			
			break;
			
		case "insertar_tarea":
			
			
			String nomb = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			char estado = request.getParameter("estado").charAt(0);

			Tareas testTarea = new TareasDAOImpl().read(nomb);
			
			if (testTarea == null) {
			
				Tareas newTareas = new Tareas(nomb, descripcion, new EstadoDAOImpl().read(estado));
				
				tareasDAO.create(newTareas);
				
				// Refactorizar este código!
				
				try {
					enviarInfoPanel(request, response);

					List<Tareas> listaTareas = tareasDAO.seleccionaTodos();

					System.out.println(listaTareas);

					request.setAttribute("LISTARTAREAS", listaTareas);

					RequestDispatcher miDispaTareas = request.getRequestDispatcher("/panel_admin_tareas.jsp");

					miDispaTareas.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//response.sendRedirect("panel_admin_tareas.jsp");
				
			}
			
			else {
				
				request.getSession().setAttribute("msg", "Lo lamentamos, este nombre de tarea ya está en uso");
				response.sendRedirect("insercion_tareas.jsp");
				
			}
			
			break;
			
		case "logout":
			
			onLogOut(request, response);
			
			break;

		default:
			break;

		}

	}

	private void enviarInfoPanel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String das = userLogin.getDas();
		String nombre = userLogin.getNombre();
		String apellido = userLogin.getApellido();
		String email = userLogin.getEmail();

		request.setAttribute("das", das);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		request.setAttribute("email", email);
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
		
		List<Tareas> listaTareas = tareasDAO.seleccionaTodos();

		//System.out.println(listaTareas);

		request.setAttribute("LISTARTAREAS", listaTareas);

		RequestDispatcher requesDis = request.getRequestDispatcher("panel_usuario.jsp");
		requesDis.forward(request, response);

	}

	private boolean cambiarPass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pass = request.getParameter("contrasena");

		if (pass.isEmpty()) {
			
			return false;
			
		}
		
		userLogin.setEstado(estadoDAO.read('a'));

		userLogin.setPassword(EmpleadoUtil.crearSHA1(pass));
		dao.update(userLogin);

		return userLogin.getPassword().equals(EmpleadoUtil.crearSHA1(pass));

	}

	public boolean validarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recuperamos los parametros
		String user = request.getParameter("usuario");
		String pass = request.getParameter("contra");

		try {

			userLogin = dao.read(user);

			if (userLogin != null) {
				
				if (userLogin.getEstado().getEstado() == Recursos.NUEVO) {
					
					if (userLogin.getPassword().equals(pass)) {
						
						loginComun(request, response);
						
					}
					
					else {
						
						request.getSession().setAttribute("msg", "Credencias incorrectas");
						response.sendRedirect("formulario_login.jsp");
						
					}
					
				}
				
				else {
					
					if (userLogin.getPassword().equals(EmpleadoUtil.crearSHA1(pass))) {
						
						loginComun(request, response);
						
					}
					
					else {
						
						request.getSession().setAttribute("msg", "Credencias incorrectas");
						response.sendRedirect("formulario_login.jsp");
						
					}
					
				}

			}

			else {

				System.out.println("FALLO EN EL LOGIN");
				request.getSession().setAttribute("msg", "Login erróneo");
				response.sendRedirect("formulario_login.jsp");
			

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return user.equals(pass);

	}

	private void esAdmin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		if ((userLogin.getEstado().getEstado()) == Recursos.NUEVO) {

			response.sendRedirect("nueva_contrasena.jsp");

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
		
		List<Tareas> listaTareas = tareasDAO.seleccionaTodos();

		//System.out.println(listaTareas);

		request.setAttribute("LISTARTAREAS", listaTareas);

		RequestDispatcher requesDis = request.getRequestDispatcher("/panel_admin_tareas.jsp");
		requesDis.forward(request, response);
		

	}
	
	private void onLogOut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getSession().invalidate();
		//request.getSession().setAttribute("msg", "Sesión cerrada");
		response.sendRedirect("formulario_login.jsp");
		
	}
	
	private void loginComun(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		
		if ((userLogin.getPermiso().getNombre()).equals("admin")) {
			esAdmin(request, response);
		}

		else if ((userLogin.getPermiso().getNombre()).equals("basico")) {

			if ((userLogin.getEstado().getEstado()) == Recursos.NUEVO) {

				response.sendRedirect("nueva_contrasena.jsp");

			}

			else {

				enviarInfoPanelUser(request, response);
			}
		}
		
	}

}