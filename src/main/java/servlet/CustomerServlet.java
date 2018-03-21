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
import vo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customer.do")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id_type=request.getParameter("id_type");
		String id_number=request.getParameter("id_number");
		
		MobileDao mb=ServiceFactory.getObject(MobileDaoImpl.class);
		Customer c=mb.getCustomer(id_type, id_number);
		if(c==null) {
			c=new Customer();
			c.setId_number(id_number);
			c.setId_type(id_type);
		}
		
		request.setAttribute("customer", c);
		int isAdmin=(int) request.getSession().getAttribute("isAdmin");
		if(isAdmin==1) {
			request.getRequestDispatcher("newCustomer1.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("newCustomer1NotAdmin.jsp").forward(request, response);
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
