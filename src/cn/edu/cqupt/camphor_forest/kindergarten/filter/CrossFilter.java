package cn.edu.cqupt.camphor_forest.kindergarten.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CrossFilter
 */
@WebFilter(filterName="/CrossFilter",urlPatterns="/*")
public class CrossFilter implements Filter {

    public CrossFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response; 
	       res.setHeader("Access-Control-Allow-Origin", "*");  
	       res.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
	       res.setHeader("Access-Control-Max-Age", "3600");  
	       res.setHeader("Access-Control-Allow-Headers", "x-requested-with");  

		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
