package com.jaxu.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
   public static SqlSessionFactory getFactory() {
	   String conf = "mybatisConf.xml";//mybatis的配置文件
	   InputStream inputstream =  //使用类加载器加载mybatis的配置文件，转化为input 流
			   MybatisUtils.class.getClassLoader().getResourceAsStream(conf);
	  
	   SqlSessionFactory factory = //构建sqlSession的工厂
			   new SqlSessionFactoryBuilder().build(inputstream);
	   return factory; //返回工厂
   } 
}
