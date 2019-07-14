package com.jaxu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jaxu.mapper.BlogMapper;
import com.jaxu.model.Blog;
import com.jaxu.model.UserInfo;
import com.jaxu.utils.MybatisUtils;
import com.jaxu.utils.Page;

public class BlogDao { 
	 public List<Blog> ShowBlog(UserInfo userinfo){//获取该用户的所有blog
	    	SqlSession session = MybatisUtils.getFactory().openSession();
	    	
	    	BlogMapper mapper = session.getMapper(BlogMapper.class);
	    	//获取数据
	    	List<Blog> blogs = mapper.ShowBlog(userinfo);   	
	    	session.close();   	
	    	return blogs;	
	    }
	 
	 /*
	  * 发布微博
	  * param blog
	  * return 
	  * */
	 public int WriteBlog(Blog blog) {//写博客
		 SqlSession session = MybatisUtils.getFactory().openSession();
		 BlogMapper mapper = session.getMapper(BlogMapper.class);
		 int num = mapper.WriteBlog(blog);
		 session.commit();
		 session.close();
		 return num;
	 }
	 
	 public Page findBlog(Page page,String search) {
		 SqlSession session = MybatisUtils.getFactory().openSession();
		 BlogMapper mapper = session.getMapper(BlogMapper.class);
		 List<Blog> blogList = mapper.findBlog(search, page.getStartIndex(), page.getPageSize());	 
		 int rowCount=mapper.countBlog(search);
		 page.setResult(blogList, rowCount);
		 session.close();
		 return page;
		 
	 }
	
}
