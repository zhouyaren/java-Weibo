package com.jaxu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jaxu.model.UserInfo;

//�����ñ�Ľӿ�  ִ��SQL���  ��һ���ӿ�
public interface UserInfoMapper {
	//��ȡ�����û� mybatis����ע�� �����ݻ�ȡ��������
   @Select("select * from userinfo")
   public List<UserInfo> getAllUserInfo();
	
   @Select("select * from userinfo where u_account = #{u_account} and u_password = #{u_password}")	
   public UserInfo login(UserInfo userinfo);
   //�������ķ�����ע��
   
   @Insert("insert into userinfo(u_account,u_password,u_nick,u_img,u_sex,"
   		+ "u_name,u_date,u_addr,u_mail,u_qq,u_msn,u_sign,u_url,u_question) "
   		+ "value(#{u_account},#{u_password},#{u_nick},#{u_img},#{u_sex},"
   		+ "#{u_name},#{u_date},#{u_addr},#{u_mail},#{u_qq},#{u_msn},#{u_sign},#{u_url},#{u_question})")
   public int register(UserInfo userinfo);
   
   @Select("select * from userinfo where u_id=#{u_id}")
	public UserInfo getUser(UserInfo userinfo);
   
   @Select("select * from userinfo where u_account=#{u_account}")
	public UserInfo getAccount(UserInfo userinfo);
   
   @Select("select * from userinfo where u_account=#{u_account} and u_qq=#{u_qq} or u_mail=#{u_mail}")
	public UserInfo getUserqq(UserInfo userinfo);
   
   @Update("update userinfo set u_password=#{u_password} where u_account=#{u_account}")
   public void Update(UserInfo userinfo);
}
