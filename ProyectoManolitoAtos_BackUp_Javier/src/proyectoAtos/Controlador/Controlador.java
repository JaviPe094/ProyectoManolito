package proyectoAtos.Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyectoAtos.Entidades.EmpTareas;
import proyectoAtos.Entidades.EmpTareasId;
import proyectoAtos.Entidades.Empleados;
import proyectoAtos.Entidades.Estado;
import proyectoAtos.Entidades.GruposUsuario;
import proyectoAtos.Entidades.Permisos;
import proyectoAtos.Entidades.Tareas;
import proyectoAtos.Modelo.EmpTareasDAOImpl;
import proyectoAtos.Modelo.EmpleadoDAO;
import proyectoAtos.Modelo.EmpleadoDAOImpl;
import proyectoAtos.Modelo.EstadoDAO;
import proyectoAtos.Modelo.EstadoDAOImpl;
import proyectoAtos.Modelo.PermisosDAO;
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
	Empleados emple;
	EstadoDAO estadoDAO;
	Estado est;
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
			//String pass = request.getParameter("password");
			//System.out.println(per);
		
			Empleados test = new EmpleadoDAOImpl().read(das);
			
			if (test == null) {
			
				Empleados newEmpleado = new Empleados(das, EmpleadoUtil.generatePass(8), nombre, apellido, 
						email, new EstadoDAOImpl().read('n'), new PermisosDAOImpl().read(per), new GruposUsuario());
				
				dao.create(newEmpleado);
				
				//userLogin=dao.read(newEmpleado.getDas());
				
				mostrar_informacion(request,response,newEmpleado);
					
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
			
		case "enviarInfoUsuarios":
			
			enviarInfoOperacionUsuarios(request,response);
			
			break;
			
		case "enviarInfo":	
					
			enviarInfoOperacionTareas(request,response);
			
			break;
	
		case "funcion_actualizar_emple":
			
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
			
			das = userLogin.getDas();
			nombre = userLogin.getNombre();
			apellido = userLogin.getApellido();
			email = userLogin.getEmail();

			request.setAttribute("das", das);
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.setAttribute("email", email);
			
			List<Tareas> listaTareas2 = tareasDAO.seleccionaTodos();

			//System.out.println(listaTareas);

			request.setAttribute("LISTARTAREAS", listaTareas2);

			RequestDispatcher requesDis = request.getRequestDispatcher("/panel_admin_tareas.jsp");
			requesDis.forward(request, response);
			
			break;
			
		case "funcion_actualizar_tareas":
			
			String nombre_As = request.getParameter("nombre");
			String descripcion_A = request.getParameter("descripcion");
			char estado_Aa = request.getParameter("estado").charAt(0);
		
			
			
			Estado esta= estadoDAO.read(estado_Aa);
			tareas=tareasDAO.read(nombre_As);
			
			tareas.setNombre(nombre_As);
			tareas.setDescripcion(descripcion_A);
			tareas.setEstado(esta);
				
		
			tareasDAO.update(tareas);
			
			enviarInfoPanel(request, response);

			List<Tareas> listaTareas = tareasDAO.seleccionaTodos();

			System.out.println(listaTareas);

			request.setAttribute("LISTARTAREAS", listaTareas);

			RequestDispatcher miDispaTareas = request.getRequestDispatcher("/panel_admin_tareas.jsp");

			miDispaTareas.forward(request, response);
			
			break;
			
		case "asignar_tarea_usuario" : 
			
			String aux_tar=request.getParameter("tarea_aux");
			String aux_user=request.getParameter("usuario");
			
			new EmpTareasDAOImpl().create(new EmpTareas(new EmpTareasId(aux_tar,aux_user)));
			
			break;
			
		case "asignar_tarea_grupo" : 
			
			String aux_tar2=request.getParameter("tarea_aux");
			String aux_group=request.getParameter("grupo");
			
			new EmpTareasDAOImpl().createByGroup(aux_tar2, aux_group);;
			
			break;
			
		case "logout":
			
			onLogOut(request, response);
			
			break;

		default:
			break;

		}

	}
	
	private void mostrar_informacion(HttpServletRequest request, HttpServletResponse response,Empleados emp) throws ServletException, IOException {

		
		String das_1 = emp.getDas();
		String pass = emp.getPassword();
		String nombre_1 = emp.getNombre();
		String apellido_1 = emp.getApellido();
		String email_1 = emp.getEmail();
		String permisos = emp.getPermiso().getNombre();

		request.setAttribute("das", das_1);
		request.setAttribute("pass", pass);			
		request.setAttribute("nombre", nombre_1);
		request.setAttribute("apellido", apellido_1);
		request.setAttribute("email", email_1);
		request.setAttribute("permisos", permisos);
		

		RequestDispatcher requesDis = request.getRequestDispatcher("/mostrar_informacion.jsp");
		requesDis.forward(request, response);
		
	}

	private void enviarInfoOperacionTareas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cod = request.getParameter("actualizar");

		System.out.println("HA LLEGADO AQUI Y EL NOMBRE ES: "+cod);
		
		
		if (cod != null) {

			tareas = tareasDAO.read(cod);
			
			String nombre = tareas.getNombre();
			String descripcion = tareas.getDescripcion();
			char esta = tareas.getEstado().getEstado();

			request.setAttribute("nombre", nombre);
			request.setAttribute("descripcion", descripcion);
			request.setAttribute("estado", esta);

			RequestDispatcher requesDis = request.getRequestDispatcher("actualizar_tareas.jsp");
			requesDis.forward(request, response);

		} else {
			BorrarTareas(request, response);
		}

	}
	
	private void BorrarTareas(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String cod = request.getParameter("borrar");

		tareasDAO.delete(cod);

		List<Tareas> listaTareas = tareasDAO.seleccionaTodos();

		request.setAttribute("LISTARTAREAS", listaTareas);

		RequestDispatcher miDispa = request.getRequestDispatcher("/panel_admin_tareas.jsp");

		miDispa.forward(request, response);
	}
	
	private void enviarInfoOperacionUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String cod= request.getParameter("actualizar");
		
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
			
			//enviarInfoPanel(request, response);
			
			String das = userLogin.getDas();
			String nombre = userLogin.getNombre();
			String apellido = userLogin.getApellido();
			String email = userLogin.getEmail();

			request.setAttribute("das", das);
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.setAttribute("email", email);
			
			Borrar(request,response);
		}

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

		// Código repetido. Refactorizar. Utilizar enviarInfoPanel normal + listar tareas
		
		enviarInfoPanel(request, response);
		
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