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
import vo.Charge;

/**
 * Servlet implementation class ChargeServlet
 */
@WebServlet("/charge.do")
public class ChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Charge charge=new Charge();
		charge.setCharge_code(request.getParameter("chargeCode"));
		charge.setCharge(Double.valueOf(request.getParameter("charges")));
		
		MobileDao md=ServiceFactory.getObject(MobileDaoImpl.class);
		md.alterCharge(charge);
		
		response.sendRedirect("chargeComplete.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
