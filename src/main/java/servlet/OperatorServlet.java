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
import vo.Operator;

/**
 * Servlet implementation class OperatorServlet
 */
@WebServlet("/newOperator.do")
public class OperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("operatorId");
		String name=request.getParameter("operatorName");
		String password=request.getParameter("password");
		String[] isAdmin=request.getParameterValues("isAdmin");
		int ia=Integer.parseInt(isAdmin[0]);
		Operator o=new Operator(id,name,password,ia);
		
		MobileDao md=ServiceFactory.getObject(MobileDaoImpl.class);
		md.newOperator(o);
		
		response.sendRedirect("operatorComplete.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
