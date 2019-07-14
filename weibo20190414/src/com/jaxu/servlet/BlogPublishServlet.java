package com.jaxu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaxu.dao.BlogDao;
import com.jaxu.model.Blog;
import com.jaxu.model.UserInfo;

/**
 * Servlet implementation class BlogPublishServlet
 *文件上传，一定要是post,因为get有长度限制  
 *  from表单的属性加上enctype="multipart/form-data"
 */
@WebServlet("/BlogPublishServlet")
public class BlogPublishServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogPublishServlet() {
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
		//文件的上传与下载，就是java中的IO流
		//获取表单参数
		Map<String,String> param=new HashMap<String,String>();
		String savePath=this.getServletContext().getRealPath("/upload/pic");
		System.out.println(savePath);
		//上传成功或失败
		boolean state=this.upload(request, savePath, param);
		if(state) {
			//1成功 0失败存入数据库
			Blog b=new Blog();
			//当前用户的id,从session中获取,返回的是object，所以要强转
			UserInfo users=(UserInfo)request.getSession().getAttribute("user");
			b.setU_id(users.getU_id());
			//表单类型改了，所以getParam()获取不到  blog发送内容
			b.setB_content(param.get("b_content"));
			//java使用当前数据库时间
			//b.setB_time(new java.sql.Date(System.currentTimeMillis()));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
			b.setB_time(df.format(new Date()));//插入数据库时间
			//图片的访问路径
			String imgPath=request.getContextPath()+"/upload/pic/"+param.get("newFileName");
			b.setB_img(imgPath);
			b.setB_degree(0);//转发数默认为0
			
			BlogDao dao=new BlogDao();
			//添加入库
			int num=dao.WriteBlog(b);
			if(num==1) {
				//发布成功
				response.sendRedirect("home.jsp");
			}else {
				System.out.println("发布失败");
			}
			
			
		}
		
	}

}
