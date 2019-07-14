package com.jaxu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaxu.dao.BlogDao;
import com.jaxu.model.Blog;
import com.jaxu.utils.Page;

/**
 * Servlet implementation class MyhomeServlet
 */
@WebServlet("/MyhomeServlet")
public class MyhomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyhomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Page page = this.getPage(request,3);
		String search = this.getParam("search");
		BlogDao dao=new BlogDao();
		if(search == null) {search="";}
		page =dao.findBlog(page, "%"+search+"%");
		
		for(Blog b:(List<Blog>)page.getResultList()) {
			System.out.println(b.getB_content()+"=="+b.getUserInfo().getU_nick());
			
		}
		System.out.println("总条数："+page.getRowCount());	
		//将获取的数据存储到request 里面(一次请求有效)
		request.setAttribute("page", page);
		//转发
		request.getRequestDispatcher("myhome.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
