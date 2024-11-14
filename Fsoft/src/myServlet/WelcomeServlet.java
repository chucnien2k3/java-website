package myServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html"); //nhan dang html
		
		
		response.getWriter().append("Served at: ").append("VKU_Fsoft");
		response.getWriter().append("<br>");
		
		String errorMg = (String) request.getAttribute("errorMessage");
		if(errorMg != null && !"".equals(errorMg)) {
			response.getWriter().append("<h3 style=background-color: red>").append(errorMg).append("</h3>");
		}
		
		response.getWriter().append("<form action='LoginServlet' method='post'>User: <input type='text' name='user'> <br>");
		response.getWriter().append("mk: <input type='text' name='password'> <br>");
		response.getWriter().append("<input type='submit' value='login'></form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
