package com.jaxu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.One;

import com.jaxu.model.Blog;
import com.jaxu.model.UserInfo;

//操作blog表的接口，用来写微博和查询自己的微博
public interface BlogMapper {

	 //写微博
	@Insert("insert into blog(b_id,u_id,b_content,b_time,b_img,b_degree) "
		+ "value(#{b_id},#{u_id},#{b_content},#{b_time},#{b_img},#{b_degree})")
	public int WriteBlog(Blog blog);
	//查询微博
	@Select("select * from blog where u_id=#{u_id}")
	public List<Blog> ShowBlog(UserInfo userinfo);
	
	//动态sql
	@Select("<script>"
	+"select * from blog"
	+"<where>"
	+"<if test='search != null and search != \"\"'>"
	+"b_content LIKE  #{search}"
	+"</if>"
    +"</where>"
	+"order by b_time desc"
    +" "+"limit #{startIndex},#{pageSize}"
	+"</script>")
	@Results({@Result(column="u_id",property="userinfo",one=@One(select="com.jaxu.mapper.UserInfoMapper.getUser"))})
	public List<Blog> findBlog(@Param("search")String search,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);
	
	//连接数据 三个框架 help net  mybatis   重点学习
	                                      //微架构spring boot springJDBC 
	                                      //spring clod 前后台分离
	
	@Select("<script>"
			+"select count(*) from blog"
			+"<where>"
			+"<if test='search != null and search != \"\"'>"
		    +"b_content LIKE  #{search}"
			+"</if>"
		    +"</where>"
			+"</script>")
	public int countBlog(@Param("search")String search);
	
	
	
}
