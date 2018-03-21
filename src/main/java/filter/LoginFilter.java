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

import vo.Operator;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter({ "*.do", "*.jsp" })
public class LoginFilter implements Filter {
	
	private List<String> list;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
		
		Operator o=(Operator)req.getSession().getAttribute("user");
		String uri=req.getRequestURI();
		String path=req.getContextPath();
		uri=uri.replace(path, "");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=res.getWriter();
		
		if(o!=null || list.contains(uri)) {
			chain.doFilter(request, response);
		}else {
			pw.println("<script>window.top.location.href='"+path+"/index.html'</script>");
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
	}

}
