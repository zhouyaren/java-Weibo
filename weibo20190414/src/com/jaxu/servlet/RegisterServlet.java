package com.jaxu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaxu.dao.UserInfoDao;
import com.jaxu.model.UserInfo;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String yzm=getParam("yzm");
		if(!request.getSession().getAttribute("yzmcode").toString().equalsIgnoreCase(yzm)) {
			request.setAttribute("tips", "ÑéÖ¤ÂëÊäÈë´íÎó");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return ;
			
		}
		
		
		
		
		String email=getParam("email");
		String password=getParam("npassword");
		String nick =getParam("nickname");
		String sex =getParam("sex");
		String city =getParam("city");
	    String question=getParam("question");
	    
	    UserInfo user=new UserInfo();
	    user.setU_mail(email);
        user.setU_password(password);
        user.setU_nick(nick);
        user.setU_sex(sex);
        user.setU_addr(city);
        user.setU_question(question);
	    UserInfoDao dao=new UserInfoDao();
		int result = dao.register(user);
		if(result>0) {
			//µÇÂ¼³É¹¦
			response.sendRedirect("index.jsp");
			
		}else {
			//Ê§°Ü
			request.setAttribute("tips", "×¢²áÊ§°Ü");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			
		}
	}

}
