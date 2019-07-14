package com.jaxu.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.jaxu.utils.Page;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
    
	protected final static int PAGESIZE = 10;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//字符编码
		response.setCharacterEncoding("utf-8");
		
		this.request=request;
		this.response=response;
		super.service(request, response);
	}
	
	

    /**
	 * 获取page
	 * @author yup
	 *
	 * @param request
	 * @return
	 * 2017年6月9日
	 */
	protected Page getPage(HttpServletRequest request) {
		String pageNo = request.getParameter("pageNo");
		int pageNo_ = 1;
		try{
			pageNo_ = Integer.parseInt(pageNo);
		}catch(Exception e) {
		}
		if(pageNo_ < 1) {
			pageNo_ = 1;
		}
		Page page = new Page(pageNo_, PAGESIZE);
		return page;
	}
	
	/**
	 * 获取page
	 * @author yup
	 *
	 * @param request
	 * @return
	 * 2017年6月9日
	 */
	protected Page getPage(HttpServletRequest request, int pageSize) {
		String pageNo = request.getParameter("pageNo");
		int pageNo_ = 1;
		try{
			pageNo_ = Integer.parseInt(pageNo);
		}catch(Exception e) {
		}
		if(pageNo_ < 1) {
			pageNo_ = 1;
		}
		Page page = new Page(pageNo_, pageSize);
		return page;
	}

	
	
	//根据name来获取参数
	
	protected String getParam(String name) {//获取参数简化
		
		return request.getParameter(name);
	}
	
	//文件的上传
	/*
	 * request 请求
	 * savePath  图片存放路径
	 * param    表单参数
	 * 
	 * */
	protected boolean upload(HttpServletRequest request, String savePath, Map<String, String> param) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart) {
			return false;
		}
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload uploade = new ServletFileUpload(factory);
		
		String encoding = request.getCharacterEncoding();
		
		//设置上传的字符编码
		uploade.setHeaderEncoding(encoding);
		
		try {
			RequestContext ctx = new ServletRequestContext(request);
			List<FileItem> list= uploade.parseRequest(ctx);
			for(FileItem item : list) {
				if(item.isFormField()) {
					param.put(item.getFieldName(), item.getString(encoding));
				}else {
					String fileName = item.getName();
					param.put("fileName", fileName);
					String suffix = fileName.substring(fileName.lastIndexOf("."));
					String newFileName = new Date().getTime() + suffix;
					savePath =  savePath + "\\" + newFileName;
					param.put("path", savePath);
					param.put("newFileName", newFileName);
					InputStream input = item.getInputStream();
					FileOutputStream output = new FileOutputStream(savePath);
					byte[] data = new byte[1024];
					int length = 0;
					while((length = input.read(data)) != -1) {
						output.write(data,0, length);
					}
					output.close();
					input.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
  
}
