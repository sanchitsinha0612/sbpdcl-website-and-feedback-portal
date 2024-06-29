

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Servlet implementation class feedback
 */
public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String consumer_id=request.getParameter("consumer_id");
		String email_id=request.getParameter("email_id");
		String phone_no=request.getParameter("phone_no");
		String subject=request.getParameter("subject");
		String description=request.getParameter("description");
		
		
		System.out.println(consumer_id +" "+email_id+" "+phone_no+" "+subject+" "+description);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sbpdportal","root","root@123"); 
			
			PreparedStatement ps= con.prepareStatement("insert into feedback (consumer_id,email_id,phone_no,subject,description) values(?,?,?,?,?)");
			ps.setString(1, consumer_id);
			ps.setString(2,email_id);
			ps.setString(3, phone_no);
			ps.setString(4, subject);
			ps.setString(5, description);
			

			ps.executeUpdate();
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		response.sendRedirect(" submission.html ");
		
		//response.getWriter().append(": ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
