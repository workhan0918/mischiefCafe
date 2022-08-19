package com.varxyz.cafe.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Alert {
	
	public static void init(HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
	}
	
	public static void alert(HttpServletResponse response, String alertText) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>alert('" + alertText + "');</script> ");
		out.flush();
	}
	
	public static void alertAndMovePage(HttpServletResponse response, String alertText, String nextPage) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>alert('" + alertText + "'); window.location.href='"+ nextPage + "';</script> ");
		out.flush();
	}
	
	public static void alertAndBackPage(HttpServletResponse response, String alertText) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>alert('" + alertText + "'); window.history.back(); </script> ");
		out.flush();
	}
	
}