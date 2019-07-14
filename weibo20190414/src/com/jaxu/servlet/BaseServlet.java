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
		request.setCharacterEncoding("utf-8");//�ַ�����
		response.setCharacterEncoding("utf-8");
		
		this.request=request;
		this.response=response;
		super.service(request, response);
	}
	
	

    /**
	 * ��ȡpage
	 * @author yup
	 *
	 * @param request
	 * @return
	 * 2017��6��9��
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
	 * ��ȡpage
	 * @author yup
	 *
	 * @param request
	 * @return
	 * 2017��6��9��
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

	
	
	//����name����ȡ����
	
	protected String getParam(String name) {//��ȡ������
		
		return request.getParameter(name);
	}
	
	//�ļ����ϴ�
	/*
	 * request ����
	 * savePath  ͼƬ���·��
	 * param    ������
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
		
		//�����ϴ����ַ�����
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
