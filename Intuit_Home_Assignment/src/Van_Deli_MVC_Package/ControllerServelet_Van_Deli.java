package Van_Deli_MVC_Package;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.FilterConfig;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Model_Van_Deli.java
 * This Controller/Servlet class is responsible for handling the 
 * get requests from user to retrieve results from
 * the data from the database.
 */

public class ControllerServelet_Van_Deli {
	private DAO_Van_Deli VanDeliDAO;
	 
	private FilterConfig config;

	public void init(FilterConfig config) {
	    this.config = config;
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ServletContext context = config.getServletContext();
        String action = request.getServletPath();
        String jdbcURL = context.getInitParameter("jdbcURL");
        String jdbcUsername = context.getInitParameter("jdbcUsername");
        String jdbcPassword = context.getInitParameter("jdbcPassword");
 
        VanDeliDAO = new DAO_Van_Deli(jdbcURL, jdbcUsername, jdbcPassword);
 
        try {
            switch (action) {
            case "/Task1":
            	task1Result(request, response);
                break;
            case "/Task2":
            	task2Result(request, response);
                break;
            default:
                System.out.println("Try Again!!!!");
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void task1Result(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Model_Van_Deli> task1Result = VanDeliDAO.queryResultsTask1();
        request.setAttribute("task1Result", task1Result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("TaskResult1.jsp");
        dispatcher.forward(request, response);
    }
    
    private void task2Result(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Model_Van_Deli> task2Result = VanDeliDAO.queryResultsTask2();
        request.setAttribute("task2Result", task2Result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("TaskResult2.jsp");
        dispatcher.forward(request, response);
    }
}
