package com.jaxu.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
   public static SqlSessionFactory getFactory() {
	   String conf = "mybatisConf.xml";//mybatis�������ļ�
	   InputStream inputstream =  //ʹ�������������mybatis�������ļ���ת��Ϊinput ��
			   MybatisUtils.class.getClassLoader().getResourceAsStream(conf);
	  
	   SqlSessionFactory factory = //����sqlSession�Ĺ���
			   new SqlSessionFactoryBuilder().build(inputstream);
	   return factory; //���ع���
   } 
}
