package impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;


   // all the time call user servlet using this / (/)
@WebServlet("/")
public class UserServlet extends HttpServlet {
	
	private UserDao userDao;
	
       

  @Override
  public void init() throws ServletException {
      userDao = new UserDao();
}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		String action = request.getServletPath();
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertUSer(request, response);
			break;
			
		case "/delete":	
			deleteUser(request, response);
			break;
			
		case "/edit":
			showEditUser(request, response);
			break;
			
		case "/update":	
			
			try {
				updateUserForm(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
			
			default :
				listUser(request, response);
				break;
		}
		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_Form.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	private void insertUSer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User newUser = new User(name, email,country);
		
		userDao.insertUser(newUser);
		response.sendRedirect("list");
		
		
		
	}
	
	// delete user
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			userDao.deleteUser(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.sendRedirect("list");
		
	}
	

	// Edit user
	
	private void showEditUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser;
		
		try {
			existingUser = userDao.selectUSer(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_Form.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	// update user
	
	private void updateUserForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		User newUser = new User(id, name, email,country);
		
		userDao.updateUser(newUser);
		response.sendRedirect("list");
		
	}
	
	// default 
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		
		try {
			List<User> listUser= userDao.selectAllUser();
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("userlist_Form.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
