package proyectoAtos.Controlador;


import java.io.IOException;


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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				
			request.setAttribute("msg", "Campos inválidos");
			response.sendRedirect("formulario_login.jsp");
			return;
			
		}
		
		if (userLogin.getPassword().equals(pass)) {
			
			if (userLogin.getEstado().getEstado() == Recursos.NUEVO) {
				
				request.setAttribute("user", userLogin);
				response.sendRedirect("cambio_clave.jsp");
				
			}
			else {
				response.sendRedirect("usuario.jsp");
			}
		} else {
			request.setAttribute("msg", "Datos incorrectos");
			response.sendRedirect("formulario_login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}

