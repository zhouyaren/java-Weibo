package com.jaxu.model;

public class Blog {
    private int b_id;
    private int u_id;
    private String b_content;
    private String b_time;
    private String b_img;
    private UserInfo userinfo;
    private int b_degree;
    
    public UserInfo getUserInfo() {
    	return userinfo;
    	
    }
    
    public void setUserInfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
    
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_time() {
		return b_time;
	}
	public void setB_time(String b_time) {
		this.b_time = b_time;
	}
	public String getB_img() {
		return b_img;
	}
	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	public int getB_degree() {
		return b_degree;
	}
	public void setB_degree(int b_degree) {
		this.b_degree = b_degree;
	}
}
