package com.gvace.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gvace.domain.User;

//@WebFilter(filterName="LoginFilter", urlPatterns="/*")
public class LoginFilter implements Filter {
 private FilterConfig filterConfig;
 /**
  * Default constructor. 
  */
 public LoginFilter() {
 }
 public void destroy() {
  filterConfig = null;
 }
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
  HttpServletRequest httpRequest = (HttpServletRequest)request;
  String uri = httpRequest.getRequestURI();
  if(uri.startsWith(httpRequest.getContextPath()+"/ValidateCode") || 
		  uri.startsWith(httpRequest.getContextPath()+"/imgs") || 
		  uri.equals(httpRequest.getContextPath()+"/") ||
		  uri.equals(httpRequest.getContextPath()) ||
		  uri.startsWith(httpRequest.getContextPath()+"/login.do")
		  ){
   chain.doFilter(request, response);
  }
  else{
	  System.out.println("uri"+uri);
   HttpSession session = httpRequest.getSession();
   User user = (User)session.getAttribute("loginUser");
   if(user!=null) chain.doFilter(request, response);
   else ((HttpServletResponse)response).sendRedirect(httpRequest.getContextPath());
  }
 }
 public void init(FilterConfig fConfig) throws ServletException {
  this.filterConfig = fConfig;
 }

}