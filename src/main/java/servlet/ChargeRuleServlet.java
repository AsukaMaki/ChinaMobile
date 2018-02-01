package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jdbc.util.ServiceFactory;

import dao.MobileDao;
import dao.MobileDaoImpl;
import vo.ChargeRule;

/**
 * Servlet implementation class ChargeRuleServlet
 */
@WebServlet("/chargeRule.do")
public class ChargeRuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeRuleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String rule=request.getParameter("chargeRule");
		String[] codes=request.getParameterValues("codes");
		ChargeRule cr=new ChargeRule(rule,codes);
		
		MobileDao md=ServiceFactory.getObject(MobileDaoImpl.class);
		md.setChargeRule(cr);
		
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
