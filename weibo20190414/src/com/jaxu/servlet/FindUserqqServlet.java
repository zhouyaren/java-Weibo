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
 * Servlet implementation class FindUserqq
 */
@WebServlet("/FindUserqqServlet")
public class FindUserqqServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserqqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account = getParam("username");
		String userqq =getParam("userqq");
		if(account==null) {
			return ;
		}
		UserInfo userinfo=new UserInfo();
		userinfo.setU_account(account);
		userinfo.setU_qq(userqq);
		userinfo.setU_mail(userqq);
		System.out.println(userqq);
		
		UserInfoDao userdao = new UserInfoDao();
		UserInfo user = userdao.getAccount(userinfo);
		
		if(user!=null) 
		{
			
				user = userdao.getUserqq(userinfo);
				if(user==null) 
				{
					request.setAttribute("tips", "qq或邮箱错误");
					//request.getSession().setAttribute("mess", "该用户未注册");
					request.getRequestDispatcher("findpassword.jsp").forward(request, response);
					
				}else 
				{
					request.setAttribute("tips", "匹配成功");
					request.getSession().setAttribute("account",account );
					//request.getSession().setAttribute("mess", "匹配成功，请继续找回密码");
					System.out.println(userdao.getAccount(userinfo).getU_nick());
					request.getRequestDispatcher("modify.jsp").forward(request, response);
				}
						
		}else {
			request.setAttribute("mess", "该用户未注册");
			//request.getSession().setAttribute("mess", "该用户未注册");
			request.getRequestDispatcher("findpassword.jsp").forward(request, response);
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
