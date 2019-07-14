package com.jaxu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jaxu.mapper.UserInfoMapper;
import com.jaxu.model.UserInfo;
import com.jaxu.utils.MybatisUtils;

//����ҵ���߼�  ʵ��map�ӿ�
public class UserInfoDao {
    public List<UserInfo> getAllUser(){//��ȡ�Ự
    	SqlSession session = MybatisUtils.getFactory().openSession();
    	
    	UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
    	//��ȡ����
    	List<UserInfo> users=mapper.getAllUserInfo();   	
    	session.close();   	
    	return users;
    	
    }
    
    public UserInfo login(UserInfo userinfo) {
       SqlSession session = MybatisUtils.getFactory().openSession();
    	
    	UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
    	//��ȡ����
    	UserInfo user=mapper.login(userinfo);  	
    	session.close();  	
    	return user;
    	
    }
    
    
    //�޸����ݿ�ʱ��Ҫcommit
    public int register(UserInfo userinfo) {
        SqlSession session = MybatisUtils.getFactory().openSession();
     	//������ִ��ӳ���ļ���sql��sqlSession
     	UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
     	//��ȡ����
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
