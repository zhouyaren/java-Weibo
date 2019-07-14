package com.jaxu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jaxu.mapper.UserInfoMapper;
import com.jaxu.model.UserInfo;
import com.jaxu.utils.MybatisUtils;

//处理业务逻辑  实现map接口
public class UserInfoDao {
    public List<UserInfo> getAllUser(){//获取会话
    	SqlSession session = MybatisUtils.getFactory().openSession();
    	
    	UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
    	//获取数据
    	List<UserInfo> users=mapper.getAllUserInfo();   	
    	session.close();   	
    	return users;
    	
    }
    
    public UserInfo login(UserInfo userinfo) {
       SqlSession session = MybatisUtils.getFactory().openSession();
    	
    	UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
    	//获取数据
    	UserInfo user=mapper.login(userinfo);  	
    	session.close();  	
    	return user;
    	
    }
    
    
    //修改数据库时，要commit
    public int register(UserInfo userinfo) {
        SqlSession session = MybatisUtils.getFactory().openSession();
     	//创建能执行映射文件中sql的sqlSession
     	UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
     	//获取数据
     	int num=mapper.register(userinfo); 
     	session.commit();
     	session.close();  	
     	return num;
     	
     }
    
    
    public UserInfo getAccount(UserInfo userinfo) {
    	
    	SqlSession session = MybatisUtils.getFactory().openSession();
    	UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
    	UserInfo user=mapper.getAccount(userinfo);
    	session.close();	
    	return user;
    }
    
public UserInfo getUserqq(UserInfo userinfo) {
    	
    	SqlSession session = MybatisUtils.getFactory().openSession();
    	UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
    	UserInfo user=mapper.getUserqq(userinfo);
    	session.close();	
    	return user;
    }

public void Update(UserInfo userinfo) {
	SqlSession session = MybatisUtils.getFactory().openSession();
	UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
	mapper.Update(userinfo);
	session.commit();
	session.close();
	return ;
}

}
