<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@include file="base.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/global.css">
<link rel="stylesheet" type="text/css" href="css/home.css">

<title>微博 - 李四的主页</title>
<script type="text/javascript" src="script/home.js"></script>
<script type="text/javascript" src="script/page.js"></script>
<script type="text/javascript" src="script/imgchange.js"></script>
<script type="text/javascript">  
//微博字数控制函数
function checktext(text){
	allValid = true;
	for (i = 0;  i < text.length;  i++)
	{
		if (text.charAt(i) != " ")
				{
					allValid = false;
					break;
				}
			}
	return allValid;
	}

	function gbcount(message,total,used,remain)
	{
		var max;
		max = total.value;
		if (message.value.length > max) {
		message.value = message.value.substring(0,max);
		used.value = max;
		remain.value = 0;
		alert("留言不能超过 140 个字!");
		}
		else {
		used.value = message.value.length;
		remain.value = max - used.value;
		}
	}
//display 显示工具
var xmlHttpRequest;
var x, y;
function createXmlHttpRequest(){
	if(window.ActiveXObject){
		try{
			xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
		}catch(e){
			xmlHttpRequest=new ActiveXObject("Msxml2.XMLHTTP");
		}
		return xmlHttpRequest;
	}else if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}
}
//显示信息
function over(id){
	//记录鼠标位置
	x=event.clientX;
	y=event.clientY;
	//创建对象
	createXmlHttpRequest();
	xmlHttpRequest.onreadystatechange=processor;
	//调用方法
	var url="http://localhost:8080//CodecoreMicroblog/ShowAttentonBlogServlet?id="+id;
	xmlHttpRequest.open("GET",url, true);
	//发送请求
	xmlHttpRequest.send();
}
//处理请求
function processor(){
	var result;
	if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
		result=xmlHttpRequest.responseText;
	}
} 


function loadpages(){
	if(a==0){
		window.location.href="BlogSearchServlet";
	    a++;	
	}else{
		return ;
	}
	
}

</script></head>

<body onload="loadpages()">
    <a href="javascript:scroll(0,0)" id="top"> <img src="images/returntotop.jpg" border="0"></a>
<!-- header开始-->
<table id="header" align="center" border="0" cellspacing="0" cellpadding="0">
  <tbody><tr>
    <td width="20%" align="center"><img src="images/logo.png" width="178" height="62"></td>
    <td width="55%" align="right">
      <table border="0" align="right" cellpadding="0" cellspacing="0" id="daohang">
        <tbody><tr>
          <td width="20%"><a href="myhome.jsp">我的首页</a></td>
          <td width="20%"><a href="/CodecoreMicroblog/PageServlet?curUid=53">我的博客</a></td>
          <td width="20%"><a href="servlet/ShowFriendsServlet?u_id=53">我的好友</a></td>
          <td width="20%"><a href="user.jsp">随便看看</a></td>
        </tr>
      </tbody></table>
    </td>
    <td width="25%" align="right">
      <table id="welcome" border="0" cellspacing="0" cellpadding="0">
        <tbody><tr>          
          <td width="30" height="30" rowspan="2" class="userface_bg"><img src="${user.u_img}" border="0" width="30" height="30"></td>
          <td>欢迎您，${user.u_nick}</td>
        </tr>
        <tr>
          <td><a href="LogoutServlet">[ 退出 ]</a></td>
        </tr>
      </tbody></table>
    </td>
  </tr>
</tbody></table>
<!-- header结束-->
<!-- container 开始-->
<table border="0" align="center" cellpadding="0" cellspacing="0" id="container">
  <tbody><tr>
    <td width="670" height="600" valign="top">
  <form action="BlogPublishServlet" method="post" name="blogpublish" enctype="multipart/form-data">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" id="input">
      <tbody><tr>
        <td width="160" height="48">&nbsp;</td>
        <td width="479">
		<table width="483" border="0">
            <tbody><tr>
              <td width="477" height="1">&nbsp;</td>
            </tr>
            <tr>
              <td height="15" align="right" class="STYLE1">
              		<input disabled="" style="visibility:hidden" maxlength="4" name="total" size="3" value="140" class="inputtext">
                    <input disabled="" style="visibility:hidden" maxlength="4" name="used" size="3" value="0" class="inputtext">
                 还可以输入<input disabled="" maxlength="4" name="remain" size="3" value="140" class="inputtext" style="border:none;background:transparent;font-size:20px;">个字 </td>
            </tr> 
          </tbody></table></td>
        <td width="31">&nbsp;</td>
      </tr>
      <tr>
        <td height="89"><span class="STYLE2"></span></td>
        <td><textarea name="b_content" rows="6" cols="40" wrap="PHYSICAL" onkeydown="gbcount(this.form.b_content,this.form.total,this.form.used,this.form.remain);" onkeyup="gbcount(this.form.b_content,this.form.total,this.form.used,this.form.remain);"></textarea></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="35">&nbsp;</td>
        <td align="right" valign="middle">

          选择图片:<input type="file" name="b_img" value="上传图片" style="border:none;background:transparent;">
          
          
          <input name="blogpublish" type="submit" class="STYLE1" style="background-image:url(images/btn_input .png)" ;="" font-size:20px;"="" value="发 布">
          </td>
    <td>&nbsp;</td>
      </tr>
    </tbody></table>
</form>	

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="menu">
		          <tbody><tr>
		            <td width="33%" align="center"><table width="165" border="0" align="center" cellpadding="0" cellspacing="0">
		          
		            </table></td>
		            <td width="18%" align="right">&nbsp;</td>
		            <td width="49%" align="center">
			            <form id="form1" name="form1" method="post" action="BlogSearchServlet">
			              <input name="search" type="text" class="input" id="textfield1">
			              <input name="button" type="submit" class="btnsearch" id="button" value="搜索">
			            </form>
		            </td>
		          </tr>
      </tbody></table>
        <!-- weibo 开始-->
        
        <c:forEach items="${page.resultList }" var="item">  
        <!-- jstl表达式  遍历显示  下面的内容显示  u_id 内容 图片 -->    
        
       <table id="weibo" width="90%" border="0" align="center" cellpadding="3" cellspacing="0">
          <tbody><tr>
            <td rowspan="3" align="center" valign="top"><a href="/CodecoreMicroblog/ShowInterestBlogServlet?uid=53"><img src="${item.getUserInfo().getU_img()}" width="50" height="50" title="${item.u_id} "></a> </td>
            <td width="88%" class="content"><a href="user.jsp">${item.getUserInfo().getU_nick()}</a><img src="icon/v.gif" width="11" height="10" align="middle">：${item.b_content}</td>
          </tr>
          <tr>
            <td>
            	<img src="${item.b_img }" width="89" height="120" name="image1" id="imgid72" style="cursor:url(mouse/0001.ani)" ondblclick="" onclick="bigsmall(72)">
           </td>
          </tr>
          <tr>
            <td height="25"><table width="100%" border="0" cellpadding="0" cellspacing="0" id="weibo_status">
              <tbody><tr>
                <td>${item.b_time }</td>
                <td align="right"><a style="text-decoration:none;color:#09C" href="/CodecoreMicroblog/DispatchBlogServlet?bid=72">转发(1)</a> 
                &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="/CodecoreMicroblog/servlet/AddCollectServlet?bid=72&amp;type=home" style="text-decoration: none;color:#09C">收藏</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
                <label onclick="display(72)">评论(0)</label><form action="/CodecoreMicroblog/AddCommentServlet?curUid=53&amp;bid=72" method="post">
                <div id="divtext72" style="display: none">
                <textarea rows="1" cols="35" name="txtContent" id="textarea"></textarea><br>
                <input type="submit" value="评论">&nbsp;&nbsp;&nbsp;
                <input type="button" onclick="display(72)" value="取消"> 
                <table width="70%" border="0">
                	
                </table>
                </div> </form> 
               </td>
              </tr>
            </tbody></table></td>
          </tr>
    	</tbody></table>
        	

 </c:forEach>
        	
     <!-- 分页处理 -->
	<table align="center" id="page">
		<form action="/CodecoreMicroblog/ShowAttentionBlogServlet?pageNumber=1" id="navigatorForm"></form>
      <tbody><tr>
        <td align="right"><a style="text-decoration: none;color:#09C" href="/CodecoreMicroblog/ShowAttentionBlogServlet?pageNumber=1">首页</a>&nbsp;
        	第 <select name="pageNumber" onchange="gotoSelectedPage();">
        			    
       					   
            				  
               					 <option value="1" selected="selected">1</option>  
            				  
           				   
       					  
    				  
       					   
            				  
           				   
                			<option value="2">2</option>  
            			   
       					  
    				  
       					   
            				  
           				   
                			<option value="3">3</option>  
            			   
       					  
    				  
       					   
            				  
           				   
                			<option value="4">4</option>  
            			   
       					  
    				  
       					   
            				  
           				   
                			<option value="5">5</option>  
            			   
       					  
    				  
       					   
            				  
           				   
                			<option value="6">6</option>  
            			   
       					  
    				  
       					   
            				  
           				   
                			<option value="7">7</option>  
            			   
       					  
    				  
       					   
            				  
           				   
                			<option value="8">8</option>  
            			   
       					  
    				  
       					   
            				  
           				   
                			<option value="9">9</option>  
            			   
       					  
    				  
				  </select>&nbsp;页
           &nbsp;
           			
           			
           				<a style="text-decoration: none;color:#09C" href="/CodecoreMicroblog/ShowAttentionBlogServlet?pageNumber=2">下一页</a>
           			
           		
	</td>
      </tr>
      
    </tbody></table>
    <!-- weibo 结束-->
    </td>
	    <td width="280" align="center" valign="top" class="pageright">
        <!-- userinfo 开始-->
        <table align="center" id="userinfo">
          <tbody><tr>
            <td width="25%" rowspan="2"><a href="myhome.jsp"><img src="${user.u_img}" width="50" height="50"></a></td>
            <td width="75%"><a href="profile.jsp">${user.u_nick}</a></td>
          </tr>
          <tr>
            <td valign="top">${user.u_addr}</td>
          </tr>
          <tr>
            <td colspan="2" align="left"><table width="80%" border="0" align="left" cellpadding="3" cellspacing="0">
              <tbody><tr>
                <td align="center" class="split2"><a href="servlet/ShowFollowingServlet?u_id=53">关注</a><br>3</td>
                <td align="center" class="split2"><a href="servlet/ShowFansServlet?u_id=53">粉丝</a><br>0
                </td>
                <td align="center"><a href="/CodecoreMicroblog/PageServlet?curUid=53">微博</a><br>
                7</td>
              </tr>
            </tbody></table></td>
          </tr>
          <tr>
            <td colspan="2" class="split1"><a href="userinfo.jsp">个人账户设置</a></td>
          </tr>
           <tr>
            <td colspan="2" class="split1"><a href="/CodecoreMicroblog/servlet/ShowCollectServlet?curUid=53"> 我的收藏</a></td>
          </tr> 
        </tbody></table>
        <table border="0" align="center" cellpadding="0" cellspacing="0" id="userlist">
          <tbody><tr>
            <td class="title" height="29">可能感兴趣的人</td>
            <td align="right" class="title"></td>
          </tr>
                 	
                  
       
          <tr>
            <td colspan="2"><table border="0" cellpadding="0" cellspacing="0" class="userdetail">
              <tbody><tr>
                <td width="26%"><a href="/CodecoreMicroblog/ShowInterestBlogServlet?uid=4"><img src="/CodecoreMicroblog/face/4.jpg" width="50" height="50" border="0"></a></td>
                <td width="74%"><a href="user.jsp">hellokitty</a> 
                <a href="/CodecoreMicroblog/AddAttentionServlet?goal_uid=4&amp;flag=home" class="btnguanzhu">+关注</a>
                <br>
                canada<br>生日：1988-12-30</td>
              </tr>
            
            </tbody></table></td>
            
                    	
                  
       
          </tr><tr>
            <td colspan="2"><table border="0" cellpadding="0" cellspacing="0" class="userdetail">
              <tbody><tr>
                <td width="26%"><a href="/CodecoreMicroblog/ShowInterestBlogServlet?uid=5"><img src="/CodecoreMicroblog/face/5.jpg" width="50" height="50" border="0"></a></td>
                <td width="74%"><a href="user.jsp">死性不改</a> 
                <a href="/CodecoreMicroblog/AddAttentionServlet?goal_uid=5&amp;flag=home" class="btnguanzhu">+关注</a>
                <br>
                中国台湾<br>生日：1990-12-02</td>
              </tr>
            
            </tbody></table></td>
            
                    	
                  
       
          </tr><tr>
            <td colspan="2"><table border="0" cellpadding="0" cellspacing="0" class="userdetail">
              <tbody><tr>
                <td width="26%"><a href="/CodecoreMicroblog/ShowInterestBlogServlet?uid=6"><img src="/CodecoreMicroblog/face/6.jpg" width="50" height="50" border="0"></a></td>
                <td width="74%"><a href="user.jsp">angle</a> 
                <a href="/CodecoreMicroblog/AddAttentionServlet?goal_uid=6&amp;flag=home" class="btnguanzhu">+关注</a>
                <br>
                中国<br>生日：1989-10-18</td>
              </tr>
            
            </tbody></table></td>
            
                    	
                  
       
          </tr><tr>
            <td colspan="2"><table border="0" cellpadding="0" cellspacing="0" class="userdetail">
              <tbody><tr>
                <td width="26%"><a href="/CodecoreMicroblog/ShowInterestBlogServlet?uid=7"><img src="/CodecoreMicroblog/face/7.jpg" width="50" height="50" border="0"></a></td>
                <td width="74%"><a href="user.jsp">K歌之王</a> 
                <a href="/CodecoreMicroblog/AddAttentionServlet?goal_uid=7&amp;flag=home" class="btnguanzhu">+关注</a>
                <br>
                印度<br>生日：1989-10-30</td>
              </tr>
            
            </tbody></table></td>
            
                    	
                  
       
          </tr><tr>
            <td colspan="2"><table border="0" cellpadding="0" cellspacing="0" class="userdetail">
              <tbody><tr>
                <td width="26%"><a href="/CodecoreMicroblog/ShowInterestBlogServlet?uid=8"><img src="/CodecoreMicroblog/face/8.jpg" width="50" height="50" border="0"></a></td>
                <td width="74%"><a href="user.jsp">灰色头像</a> 
                <a href="/CodecoreMicroblog/AddAttentionServlet?goal_uid=8&amp;flag=home" class="btnguanzhu">+关注</a>
                <br>
                北京<br>生日：1991-11-21</td>
              </tr>
            
            </tbody></table></td>
            
              
          </tr>
                 
        </tbody></table>
            <table class="userdetail">  <tbody><tr><td> 
                 <center> <a href="home.jsp?page=2" style="text-decoration: none">[换一换]</a> </center>
             </td>
             </tr> 
          </tbody></table>
         
        <!-- userinfo 结束--></td>
          
  </tr>
    
	</tbody></table>
<!-- container 结束-->

<!--footer开始-->
<table id="footer" border="0" align="center" cellpadding="3" cellspacing="0">
    <tbody><tr>
    <td width="534" align="left"><a href="http://help.sina.com.cn/p/i_12.html">帮助</a>&nbsp;&nbsp; <a href="http://weibo.com/signup/signup.php?c=&amp;type=&amp;inviteCode=&amp;code=&amp;spe=&amp;lang=">意见反馈</a>&nbsp;&nbsp; 
    <a href="http://weibo.com/login.php?url=http%3A%2F%2Fweibo.com%2Fpub%2Fverified">微博认证及合作</a>&nbsp;&nbsp;
     <a href="http://open.weibo.com/">开放平台</a>&nbsp;&nbsp; <a href="http://hr.t.sina.com.cn/">微博招聘</a>&nbsp;&nbsp;
      <a href="http://news.sina.com.cn/guide/">微博导航</a></td>        
    <td width="447" align="right">Copyright: 2011-2015<a href="http://corp.sina.com.cn/chn/copyright.html"> 微博系统 版权所有</a></td>
  </tr>
  <tr>
    <td align="left">客服电话：400 123 12345（按当地市话标准收费）</td>
    <td align="right">语言：
      <select name="select" id="select">
        <option>中文(简体)</option>
        <option>中文(繁体)</option>
    </select></td>
  </tr>        
</tbody></table>
<!--footer结束-->
  


</body>
</html>