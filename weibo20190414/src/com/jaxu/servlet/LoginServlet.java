package com.jaxu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jaxu.dao.UserInfoDao;
import com.jaxu.model.UserInfo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String account=getParam("userid");
		String password=getParam("password");
		
		UserInfo userinfo=new UserInfo();
		userinfo.setU_account(account);
		userinfo.setU_password(password);
		
		UserInfoDao dao=new UserInfoDao();
		//查询 login
		
		UserInfo user= dao.login(userinfo);//登录
		//System.out.println(user.getU_account()+user.getU_password());
		
		if(user !=null && user.getU_id()>0) {
			//登录成功，把当前用户存入session中
			//session是网页会话，从网站的第一个页面到浏览器关闭都有效
//			HttpSession session = request.getSession();
//			session.setAttribute("name", user.getU_nick());
			request.getSession().setAttribute("user", user);//用request获取session
			response.sendRedirect("home.jsp");
			System.out.println("登录成功");
			
		}else {
			System.out.println("登录失败");
			request.setAttribute("tips", "用户名或密码错误");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
				
	}

}
