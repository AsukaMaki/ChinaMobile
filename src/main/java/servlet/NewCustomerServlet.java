package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

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
 * Servlet implementation class NewCustomerServlet
 */
@WebServlet("/newCustomer.do")
public class NewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id_type=request.getParameter("idType");
		String id_number=request.getParameter("idNumber");
		String customer_name=request.getParameter("customerName");
		String customer_sex=request.getParameter("customerSex");
		DateFormat df=DateFormat.getDateInstance();
		Date customer_birthday=null;
		try {
			customer_birthday = df.parse(request.getParameter("customerBirthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String customer_address=request.getParameter("customerAddress");
		Customer c=new Customer(0,id_type,id_number,customer_name,customer_birthday,customer_sex,customer_address);
		
		MobileDao md=ServiceFactory.getObject(MobileDaoImpl.class);
		md.newCustomer(c);
		
		c=md.getCustomer(id_type, id_number);
		request.setAttribute("userId",c.getCustomer_id());
		
		int isAdmin=(int) request.getSession().getAttribute("isAdmin");
		if(isAdmin==1) {
			request.getRequestDispatcher("newUser.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("newUserNotAdmin.jsp").forward(request, response);
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
