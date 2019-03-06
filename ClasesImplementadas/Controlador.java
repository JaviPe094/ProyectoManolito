package proyectoAtos.Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import proyectoAtos.Recursos.Recursos;

/**
 * Servlet implementation class LoginEmpleados
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpleadoDAO dao;
	Empleados userLogin;

	EstadoDAO estadoDAO;
	Estado estado;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();

		dao = new EmpleadoDAOImpl();

		userLogin = new Empleados();

		estadoDAO = new EstadoDAOImpl();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// response.setContentType("text/html;charset=UTF-8");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// leer parametro del formulario
		String comando = request.getParameter("instruccion");

		if (comando == null) {

			System.out.println("El comando esta vacio");

			response.sendRedirect("formulario_login2.html");

		}

		switch (comando) {
		case "validar":
			validarLogin(request, response);
			break;

		case "usuarioAceptado":

			if ((userLogin.getPer().getNombre()).equals("admin")) {
				estado = new Estado();
				estado = estadoDAO.read('a');
				userLogin.setEstado(estado);

				enviarInfoPanelAdmin(request, response);
				
			} else if (cambiarPass(request, response)) {
				estado = new Estado();
				estado = estadoDAO.read('a');
				userLogin.setEstado(estado);

				enviarInfoPanelUser(request, response);

				// response.sendRedirect("panel_usuario.html");
			} else {
				System.out.println("FALLO AL CAMBIAR PASSWORD");
			}

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

		userLogin.setPassword(pass);
		dao.update(userLogin);
		if (userLogin.getPassword().equals(pass))
			return true;

		else
			return false;

	}

	public boolean validarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recuperamos los parametros
		String user = request.getParameter("usuario");
		String pass = request.getParameter("contra");
		try {
			// System.out.println(user + "," + pass);

			userLogin = dao.read(user);

			if ((userLogin.getPer().getNombre()).equals("admin")) {
				esAdmin(request, response);
			}else if (userLogin.getDas().equals(user)) {
				System.out.println("LA COMPRACION ES CORRECTA");
				if ((userLogin.getEstado().getEstado()) == Recursos.NUEVO) {

					response.sendRedirect("nueva_contrasena.html");

				} else {
					enviarInfoPanelUser(request, response);
				}
			} else {
				System.out.println("FALLO EN EL LOGIN");
				response.sendRedirect("Login_Incorrecto.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Ha llegado hasta el final del metodo");
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

}
