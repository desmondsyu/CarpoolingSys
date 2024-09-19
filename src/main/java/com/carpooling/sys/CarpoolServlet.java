package com.carpooling.sys;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/carpool")
public class CarpoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Rides> rideList;

	public CarpoolServlet() {
		super();
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>"
				+ "<head><title>Carpooling System</title></head>"
				+ "<body><h1>Offer a Ride</h1>" 
				+ "<form action=\"carpool\" method=\"post\">"
				+ "    <label>Start Location</label>" 
				+ "    <input type=\"text\" name=\"startLocation\" required />"
				+ "    <br>" 
				+ "    <label>Destination</label>"
				+ "    <input type=\"text\" name=\"destination\" required />" 
				+ "    <br>"
				+ "    <label>Seats Available</label>"
				+ "    <input type=\"number\" name=\"seatsAvailable\" min=\"1\" required />" 
				+ "    <br>"
				+ "    <input type=\"submit\" value=\"Submit\">" 
				+ "</form>" 
				+ "<h1>Take a Ride</h1>");

		synchronized (rideList) {
			if (rideList.isEmpty()) {
				out.print("<p>No rides available.</p>");
			} else {
				out.println("<ul>");
				for (Rides ride : rideList) {
					out.println("<li>Start Location: " + ride.getStartLocation() + " , Destination: "
							+ ride.getDestination() + " Available Seats: " + ride.getSeatAvailable() + "</li>");
				}
				out.println("</ul>");
			}
		}

		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String startLocation = request.getParameter("startLocation");
		String destination = request.getParameter("destination");
		String seatsAvailable = request.getParameter("seatsAvailable");

		int seats = seatsValidate(seatsAvailable);

		Rides newRide = new Rides(startLocation, destination, seats);

		synchronized (rideList) {
			rideList.add(newRide);
		}

		getServletContext().log("Added ride: " + startLocation + " " + destination + " " + seats);

		response.sendRedirect("carpool");
	}

	// validate the seat input
	private int seatsValidate(String seats) throws NumberFormatException {
		int seatsAvaliable = Integer.parseInt(seats);

		if (seatsAvaliable <= 0) {
			throw new NumberFormatException("Seats number should be positive");
		}

		return seatsAvaliable;
	}
}
