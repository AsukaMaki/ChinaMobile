package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jdbc.util.ServiceFactory;

import dao.MobileDao;
import dao.MobileDaoImpl;
import vo.User;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/user.do")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mobile_number=request.getParameter("mobileNumber");
		String status=request.getParameter("status");
		String level=request.getParameter("level");
		int id=Integer.parseInt(request.getParameter("userId"));
		User u=new User(0,mobile_number,status,level,id,"Y");
		
		MobileDao md=ServiceFactory.getObject(MobileDaoImpl.class);
		md.newUser(u);
		md.alterMobile(mobile_number);
		
		int isAdmin=(int) request.getSession().getAttribute("isAdmin");
		if(isAdmin==1) {
			response.sendRedirect("saveInfo.jsp");
		}else {
			response.sendRedirect("saveInfoNotAdmin.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
