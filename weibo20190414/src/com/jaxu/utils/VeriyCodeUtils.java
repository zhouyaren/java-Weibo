package com.jaxu.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

/**
 *@victe
 *2019年4月15日-上午11:39:45
 */
public class VeriyCodeUtils {
	/** 
	  * @param output 保存验证图像的流 
	  * @return 验证码 
	  */
	 public static String newVeriyCode(HttpServletRequest request,OutputStream output) 
	 { 
	  int width = 90; 
	  int height = 40; 
	  int codeCount = 4; 
	  char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',  
	    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
	    'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' }; 
	    
	  //创建图像对象,8位RGB 
	  BufferedImage buffered = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
	    
	  //通过Crapahices来绘制图像到BufferedImage中 
	  Graphics2D gra = buffered.createGraphics(); 
	    
	  //设置图片背景：白色 
	  gra.setColor(Color.WHITE); 
	  gra.fillRect(0, 0, width, height); 
	    
	  //设置字体,字体大小根据图片高度决定 
	  gra.setFont(new Font("Fixedsys",Font.PLAIN,height-2)); 
	    
	  //设置边框：黑色,1cm 
	  gra.setColor(Color.BLACK); 
	  gra.drawRect(0, 0, width-1, height-1); 
	    
	  //生成10条黑色干扰线 
	  gra.setColor(Color.BLACK); 
	  Random ran = new Random(); 
	  for(int i = 0; i < 70;i++) 
	  { 
	   int x = ran.nextInt(255); 
	   int y = ran.nextInt(255); 
	   int x1 = ran.nextInt(255); 
	   int y1 = ran.nextInt(255); 
	   gra.drawLine(x, y,x+x1, y+y1);//画直线 
	  } 
	  //生成验证码 
	  StringBuffer sb = new StringBuffer(); 
	  int r = 0,g = 0,b = 0; 
	  for(int i = 0; i < codeCount; i++) 
	  { 
	   String strRand = String.valueOf(codeSequence[ran.nextInt(codeSequence.length)]); 
	   //对每位验证码都生成不同的颜色，增加识别系统难度 
	   r = ran.nextInt(255); 
	   g = ran.nextInt(255); 
	   b = ran.nextInt(255); 
	   gra.setColor(new Color(r, g, b)); 
	   gra.drawString(strRand, (i+1)*13, height-4); 
	   sb.append(strRand); 
	  } 
	  try { 
		  request.getSession().setAttribute("yzmcode",sb.toString());
	   ImageIO.write(buffered, "jpeg", output); 
	  } catch (Exception e) { 
	   throw new RuntimeException(e); 
	  } 
	    
	  return sb.toString(); 
	 } 
}
