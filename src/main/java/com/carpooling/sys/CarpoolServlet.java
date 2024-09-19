package com.carpooling.sys;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CarpoolServlet
 */
public class CarpoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Rides> rideList;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarpoolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // Initialize the list of available carpool rides
    public void init() throws ServletException {
		rideList = new ArrayList<>();

		getServletContext().log("Initialize the list of available carpool rides...");
	}
    
    // Log every incoming request, including the request type and URL
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestType = request.getMethod();
		String requestUrl = request.getRequestURL().toString();

		getServletContext().log("Incoming request: " + requestType + " " + requestUrl);
		
		super.service(request, response);
	}
    
	// Log a message indicating that the servlet is being terminated
    public void destroy() {
		getServletContext().log("The CarpoolServlet is being terminated.");
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
