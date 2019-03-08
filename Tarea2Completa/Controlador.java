	package proyectoAtos.Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyectoAtos.Entidades.Empleados;
import proyectoAtos.Entidades.Estado;
import proyectoAtos.Entidades.Permisos;
import proyectoAtos.Entidades.Tareas;
import proyectoAtos.Modelo.EmpleadoDAO;
import proyectoAtos.Modelo.EmpleadoDAOImpl;
import proyectoAtos.Modelo.EstadoDAO;
import proyectoAtos.Modelo.EstadoDAOImpl;
import proyectoAtos.Modelo.PermisosDAO;
import proyectoAtos.Modelo.PermisosDAOImpl;
import proyectoAtos.Modelo.TareasDAO;
import proyectoAtos.Modelo.TareasDAOImpl;
import proyectoAtos.Recursos.EmpleadoUtil;
import proyectoAtos.Recursos.Recursos;

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
	Empleados emple;
	EstadoDAO estadoDAO;
	Estado estado;
	PermisosDAO pdao;
	Tareas tareas;

	/* Contructor de Controlador */

	public Controlador() {

		super();

		dao = new EmpleadoDAOImpl();

		userLogin = new Empleados();

		estadoDAO = new EstadoDAOImpl();

		tareasDAO = new TareasDAOImpl();
		
		pdao=new PermisosDAOImpl();
		
		tareas = new Tareas();
		
	}

	/*
	 * Tanto doPost como doGet son necesarios. En este caso, por evitar que los
	 * datos de formulario salgan en la barra de direcciones se ha optado por
	 * doPost. doGet queda vac�o.
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/*
	 * La funcionalidad se encuentra en el m�todo doPost. Se ha optado por el
	 * enfoque de un servlet encargado de las funcionalidades frente a varios
	 * servlets, con el objetivo de unificar las operaciones
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// leer comando del formulario
		String comando = request.getParameter("instruccion");

		request.getSession().setMaxInactiveInterval(10);
		// Salida r�pida en caso de que se produzca un error en el comando
		
		
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
				enviarInfoPanel(request, response);

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
			
			Empleados newEmpleado = new Empleados(das, EmpleadoUtil.generatePass(8), nombre, apellido, email, new Estado('n'), new Permisos(per));
			
			dao.create(newEmpleado);
			
			break;
			
		case "insertar_tarea":
			
			
			String nomb = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			char estado = request.getParameter("estado").charAt(0);
			
			
			Tareas newTareas = new Tareas(nomb, descripcion,new Estado(estado));
			
			tareasDAO.create(newTareas);
			
		break;
		case "enviarInfoUsuarios":
		
			enviarInfoOperacionUsuarios(request,response);
			
			break;
			
		case "enviarInfoTareas":	
					
			enviarInfoActualizarTareas(request,response);
			
			break;
	
		case "funcion_actualizar":
			
			String das_A = request.getParameter("das");
			String nombre_A = request.getParameter("nombre");
			String apellido_A = request.getParameter("apellidos");
			String email_A = request.getParameter("email");
			char estado_A = request.getParameter("estado").charAt(0);
			String per_A = request.getParameter("permisos");
			
			Permisos perm=pdao.read(per_A);
			Estado est = estadoDAO.read(estado_A);
			emple=dao.read(das_A);
			
			emple.setDas(das_A);
			emple.setNombre(nombre_A);
			emple.setApellido(apellido_A);
			emple.setEmail(email_A);
			emple.setPermiso(perm);
			emple.setEstado(est);	
			
			
			dao.update(emple);
			
			
			
		case "logout":
			
			onLogOut(request, response);
			
			break;

		default:
			break;

		}

	}
	private void enviarInfoActualizarTareas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String nombre = tareas.getNombre();
		String descripcion = tareas.getDescripcion();
		char estado = tareas.getEstado().getEstado();
		
		nombre = request.getParameter("nombre");
		descripcion = request.getParameter("descripcion");
		estado = request.getParameter("estado").charAt(0);
		
		RequestDispatcher reDis = request.getRequestDispatcher("/actualizar_tareas.jsp");
		
		reDis.forward(request, response);
		
		
	}

	private void enviarInfoOperacionUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HA LLEGADO AQUI");
		String cod= request.getParameter("actualizar");
		System.out.println("HA LLEGADO AQUI, el das es "+cod);
		if(cod!=null)
		{
			userLogin = dao.read(cod);
			String codigo = userLogin.getDas();
			String nombre = userLogin.getNombre();
			String apellido = userLogin.getApellido();
			String email = userLogin.getEmail();
			char estado = userLogin.getEstado().getEstado();
			String permisos = userLogin.getPermiso().getNombre();
			request.setAttribute("das", codigo);
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.setAttribute("email", email);
			request.setAttribute("estado", estado);
			request.setAttribute("permisos", permisos);
			
			RequestDispatcher requesDis = request.getRequestDispatcher("actualizar_usuario.jsp");
			requesDis.forward(request, response);
		}else {
			Borrar(request,response);
		}
//		String cod  = request.getParameter("actualizar");
		
//		cod=request.getParameter("borrar");
//		String aux= request.getParameter("borrar");
//		System.out.println(aux);
//		aux= request.getParameter("actualizar");
//		System.out.println(aux);
//		userLogin = dao.read(cod);
//		
//		String codigo = userLogin.getDas();
//		String nombre = userLogin.getNombre();
//		String apellido = userLogin.getApellido();
//		String email = userLogin.getEmail();
//		char estado = userLogin.getEstado().getEstado();
//		String permisos = userLogin.getPermiso().getNombre();
//		request.setAttribute("das", codigo);
//		request.setAttribute("nombre", nombre);
//		request.setAttribute("apellido", apellido);
//		request.setAttribute("email", email);
//		request.setAttribute("estado", estado);
//		request.setAttribute("permisos", permisos);
//		
//		RequestDispatcher requesDis = request.getRequestDispatcher("actualizar_usuario.jsp");
//		requesDis.forward(request, response);
	}
	

	private void Borrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		String cod = request.getParameter("borrar");
		
		dao.delete(cod);
		
		List<Empleados> listaEmpleados = dao.seleccionaTodos();

		request.setAttribute("LISTAREMPLEADOS", listaEmpleados);

		RequestDispatcher miDispa = request.getRequestDispatcher("/panel_admin_usuarios.jsp");

		miDispa.forward(request, response);
		
		//response.sendRedirect("panel_admin_usuarios.jsp");
		
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

				else if ((userLogin.getPermiso().getNombre()).equals("basico")) {

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
				response.sendRedirect("Login_Incorrecto.jsp");

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

}