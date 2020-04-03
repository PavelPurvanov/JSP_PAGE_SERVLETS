import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import repository.UserRepository;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Integer ID = 0;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
	
		ID = ID + 1;

		String firstName = "defaultName";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String info = "defaultInfo";
		String job = "defaultJob";
		String phone = "defaultPhone";
		String city = "defaultCity";
		String street = "defaultStreet";

		UserBean user = new UserBean(ID, firstName, email, password, info, job, phone, city, street);

		if (!UserRepository.contains(user) && password2.equals(password) && Integer.parseInt(password) > 7) {

			UserRepository.addUser(user);

			response.sendRedirect("LoginIndex.html");

		} else {
			response.sendRedirect("Failed.html");
		}
	}

}
