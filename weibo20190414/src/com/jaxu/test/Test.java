package com.jaxu.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jaxu.dao.BlogDao;
import com.jaxu.dao.UserInfoDao;
import com.jaxu.model.Blog;
import com.jaxu.model.UserInfo;

public class Test {

	public static void main(String[] args) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
//		//����дblog
//		Blog blog=new Blog();
//		blog.setU_id(3);
//		blog.setB_content("����һ������blog");
//		blog.setB_time(df.format(new Date()));
//		
//		BlogDao dao=new BlogDao();
//	    int num= dao.WriteBlog(blog);
//	    
//	    if(num==0) {
//	    	System.out.println("д����ʧ��");
//	    }else {
//	    	System.out.println("д��ɹ�");
//	    }
//		
//		UserInfo user=new UserInfo();
//		user.setU_id(3);
//		List<Blog> blogs=dao.ShowBlog(user);
//		for(Blog b:blogs) {
//			System.out.println(b.getB_content()+b.getB_degree()+b.getB_time());
//		}
//		
		
		
		
		// TODO Auto-generated method stub
    	UserInfoDao dao=new UserInfoDao();
//		List<UserInfo> users=dao.getAllUser();
//		System.out.println(users.size());
		
		
//		UserInfo userinfo =new UserInfo();
//		userinfo.setU_account("aaa@126.com");
//		userinfo.setU_password("123456");
//		UserInfo user= dao.login(userinfo);
//		if(user ==null) {
//			System.out.println("���û�������");
//		}else {
//			
//			System.out.println(user.getU_account()+user.getU_addr()+user.getU_id());
//		}
		
		
		UserInfo userinfo=new UserInfo();
		userinfo.setU_account("zyr");
		userinfo.setU_password("123");
		userinfo.setU_img("/weibo20190414/WebContent/face/1025.jpg");
		userinfo.setU_nick("zyr");
		userinfo.setU_name("zyr");
		int num= dao.register(userinfo);
		if(num==1) {
		System.out.println("ע��ɹ�");//�����ӡ����id˵����ӡ�ɹ�
		}else {
			System.out.println("ע��ʧ��");	
		}
	}

}
