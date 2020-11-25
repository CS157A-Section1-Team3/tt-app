package home.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import home.dao.trackingdao;
import home.model.tracking;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private trackingdao trackingdao = new trackingdao();
	
	public void init() {
		trackingdao = new trackingdao();
	} 
	public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ttapp/home.jsp");
		dispatcher.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Start = request.getParameter("Start");
		String End = request.getParameter("End");
		String PID = request.getParameter("PID");
		String Team = request.getParameter("Team");
		
		tracking tracking = new tracking();
		tracking.setStart(Start);
		tracking.setEnd(End);
		tracking.setPID(PID);
		tracking.setTeam(Team);
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		tracking.setUsername(username);
		System.out.println("Username in servlet: "+ username);

		try {
			trackingdao.enterHours(tracking);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request,response);
	}

}
