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
		//��ѯ login
		
		UserInfo user= dao.login(userinfo);//��¼
		//System.out.println(user.getU_account()+user.getU_password());
		
		if(user !=null && user.getU_id()>0) {
			//��¼�ɹ����ѵ�ǰ�û�����session��
			//session����ҳ�Ự������վ�ĵ�һ��ҳ�浽������رն���Ч
//			HttpSession session = request.getSession();
//			session.setAttribute("name", user.getU_nick());
			request.getSession().setAttribute("user", user);//��request��ȡsession
			response.sendRedirect("home.jsp");
			System.out.println("��¼�ɹ�");
			
		}else {
			System.out.println("��¼ʧ��");
			request.setAttribute("tips", "�û������������");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
				
	}

}
