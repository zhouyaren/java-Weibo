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
 *�ļ��ϴ���һ��Ҫ��post,��Ϊget�г�������  
 *  from�������Լ���enctype="multipart/form-data"
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
		//�ļ����ϴ������أ�����java�е�IO��
		//��ȡ������
		Map<String,String> param=new HashMap<String,String>();
		String savePath=this.getServletContext().getRealPath("/upload/pic");
		System.out.println(savePath);
		//�ϴ��ɹ���ʧ��
		boolean state=this.upload(request, savePath, param);
		if(state) {
			//1�ɹ� 0ʧ�ܴ������ݿ�
			Blog b=new Blog();
			//��ǰ�û���id,��session�л�ȡ,���ص���object������Ҫǿת
			UserInfo users=(UserInfo)request.getSession().getAttribute("user");
			b.setU_id(users.getU_id());
			//�����͸��ˣ�����getParam()��ȡ����  blog��������
			b.setB_content(param.get("b_content"));
			//javaʹ�õ�ǰ���ݿ�ʱ��
			//b.setB_time(new java.sql.Date(System.currentTimeMillis()));
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
			b.setB_time(df.format(new Date()));//�������ݿ�ʱ��
			//ͼƬ�ķ���·��
			String imgPath=request.getContextPath()+"/upload/pic/"+param.get("newFileName");
			b.setB_img(imgPath);
			b.setB_degree(0);//ת����Ĭ��Ϊ0
			
			BlogDao dao=new BlogDao();
			//������
			int num=dao.WriteBlog(b);
			if(num==1) {
				//�����ɹ�
				response.sendRedirect("home.jsp");
			}else {
				System.out.println("����ʧ��");
			}
			
			
		}
		
	}

}
