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
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/ModifypasswordServlet")
public class ModifypasswordServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifypasswordServlet() {
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
		String newpasswd=getParam("newpasswd");
		String cpassword=getParam("cpasswd");
		if(!newpasswd.equals(cpassword)) {
			request.setAttribute("mes", "两次密码不一致");
			return ;
		}else {
			UserInfo user=new UserInfo();
			user.setU_account(request.getSession().getAttribute("account").toString());
			//System.out.println(request.getSession().getAttribute("account").toString());
			user.setU_password(newpasswd);
			UserInfoDao dao=new UserInfoDao();
			dao.Update(user);
			request.setAttribute("mes", "密码修改成功");
			request.getRequestDispatcher("modify.jsp").forward(request, response);
		}
		
		
		
		
	}

}
