package com.kenscio.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1 implements Filter {

	@Override
	public void destroy() {
		System.out.println("Destroyed");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		System.out.println("inside begin doFilter");
		fc.doFilter(req, resp);
		System.out.println("inside end do filter");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("inside init of filter");
		
	}

}
