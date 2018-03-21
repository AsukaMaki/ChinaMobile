package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter({ "*.do", "*.jsp" })
public class AdminFilter implements Filter {

	private List<String> list;
    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		int isAdmin=0;
		String uri=req.getRequestURI();
		String path=req.getContextPath();
		uri=uri.replace(path, "");
		
		if(uri.equals("/login.do")) {
			chain.doFilter(request, response);
		}else {
			isAdmin=(int) req.getSession().getAttribute("isAdmin");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=res.getWriter();
		
		if(isAdmin==1 || list.contains(uri)) {
			chain.doFilter(request, response);
		}else {
			pw.println("<script>window.top.location.href='"+path+"/mainNotAdmin.jsp'</script>");
		}
		
		pw.flush();
		pw.close();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		list=new ArrayList<String>();
		list.add("/login.do");
		list.add("/logout.do");
		list.add("/admin.do");
		list.add("/customer.do");
		list.add("/newCustomer.do");
		list.add("/getNumbers.do");
		list.add("/user.do");
		list.add("/mainNotAdmin.jsp");
		list.add("/newCustomerNotAdmin.jsp");
		list.add("/newCustomer1NotAdmin.jsp");
		list.add("/newUserNotAdmin.jsp");
		list.add("/list.jsp");
		list.add("/saveInfoNotAdmin.jsp");
	}

}
