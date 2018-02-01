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
import vo.Mobile;

/**
 * Servlet implementation class Resource
 */
@WebServlet("/resource.do")
public class Resource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String begin=request.getParameter("mobileNumBegin");
		String end=request.getParameter("mobileNumEnd");
		String type=request.getParameter("numType");
		
		long beginNum=Long.valueOf(begin);
		long endNum=Long.valueOf(end);
		long count=endNum-beginNum+1;
		
		Mobile[] mobiles=new Mobile[(int)count];
		for(int i=0;i<mobiles.length;i++){
			mobiles[i]=new Mobile(String.valueOf(beginNum),type,"Y");
			beginNum++;
		}
		
		MobileDao md=ServiceFactory.getObject(MobileDaoImpl.class);
		md.initMobile(mobiles);
		
		response.sendRedirect("resourceComplete.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
