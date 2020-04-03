import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import repository.UserRepository;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserBean user = logInValidation(email, password);
		Integer id;
		id = user.getId();

		request.getSession().setAttribute("id", id);

		response.sendRedirect("UserServlet");
	}

	public UserBean logInValidation(String email, String password) {
		UserBean user = new UserBean(email, password);
		user = UserRepository.getUser(user);
		return user;
	}
}