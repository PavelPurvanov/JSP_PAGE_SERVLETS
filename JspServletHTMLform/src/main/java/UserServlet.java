
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBean;
import repository.UserRepository;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		Integer id;
		id = (Integer) request.getSession().getAttribute("id");

		String action = request.getParameter("action");

		UserBean user = repository.UserRepository.getUserByID(id);

		request.setAttribute("user", user);

		String page = (action != null && !action.isEmpty() && action.equals("edit")) ? "EditProfilePage.jsp"
				: "ProfilePage.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		final Integer id = (Integer) request.getSession().getAttribute("id");
		final String firstName = request.getParameter("firstName");
		final String job = request.getParameter("job");
		final String email = request.getParameter("email");
		final String city = request.getParameter("city");
		final String phone = request.getParameter("phone");
		final String street = request.getParameter("street");
		final String info = request.getParameter("info");
		final String password = request.getParameter("password");

		String action = request.getParameter("action");
		UserBean newUser = new UserBean() {
			{
				setId(id);
				setFirstName(firstName);
				setJob(job);
				setEmail(email);
				setCity(city);
				setPhone(phone);
				setStreet(street);
				setPassword(password);
				setInfo(info);

			}
		};

		UserBean user = repository.UserRepository.getUserByID(id);

		UserRepository.update(newUser);

		request.setAttribute("user", user);

		String page = (action != null && !action.isEmpty() && action.equals("edit")) ? "EditProfilePage.jsp"
				: "ProfilePage.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
