<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/register.css" />
<title>微博 - 快速注册</title>
<script type="text/javascript">
	function getimgCodes() {
		document.getElementById("imagcode").src = "YzmServlet?t="+ new Date();

	}
</script>



</head>
<body onload="createCode()">
	<!-- header开始-->
	<table id="header" align="center" border="0" cellspacing="0"
		cellpadding="0">
		<tr>
			<td width="20%" align="center"><img src="images/logo.png"
				width="178" height="62" /></td>
			<td width="55%" align="left">&nbsp;</td>
			<td width="25%" align="right">&nbsp;</td>
		</tr>
	</table>
	<!-- header结束-->
	<!-- container 开始-->

	<table border="0" align="center" cellpadding="0" cellspacing="0"
		id="container">
		<tr>
			<td width="670" valign="top">
				<form action="RegisterServlet" method="post"
					onsubmit="return checkForm()">
					<table border="0" align="center" cellpadding="0" cellspacing="0"
						id="register">
						<tr>
							<td class="title">30秒快速开通微博</td>
						</tr>
						<tr>
							<td><table width="90%" border="0" cellpadding="5"
									cellspacing="0" id="register_content">
									<tr>
										<td width="20%" align="right">我的邮箱：</td>
										<td width="53%"><input name="email" type="text"
											class="input1" id="email" onblur="checkemail()"
											value="${param.emailExist}" /></td>
										<td width="27%"><span id="emailmsg"><a
												href="https://reg.mail.163.com/unireg/call.do?cmd=register.entrance">还没有邮箱?</a><span></td>
									</tr>
									<tr>
										<td width="20%" align="right">创建密码：</td>
										<td width="53%"><input name="npassword" type="password"
											class="input1" id="npassword" onblur="checkPwd()" /></td>
										<td width="27%"><span id="pwdmsg"><span></td>
									</tr>
									<tr>
										<td width="20%" align="right">确认密码：</td>
										<td width="53%"><input name="rpassword" type="password"
											class="input1" id="rpassword" onblur="checkRpwd()" /></td>
										<td width="27%"><span id="rpwdmsg"><span></td>
									</tr>
									<tr>
										<td width="20%" align="right">昵称：</td>
										<td width="53%"><input name="nickname" type="text"
											class="input1" id="nickname" onblur="checkNick()" /></td>
										<td width="27%"><span id="nickmsg"><span></td>
									</tr>
									<tr>
										<td width="20%" align="right">性别：</td>
										<td width="53%"><input type="radio" name="sex" id="sex1"
											value="男" /> 男 &nbsp; &nbsp; &nbsp; &nbsp; <input
											type="radio" name="sex" id="sex2" value="女" /> 女</td>
										<td width="27%"><span id="sexmsg"><span></td>
									</tr>
									<tr>
										<td width="20%" align="right">密保问题：</td>
										<td width="53%"><select>
												<option>你最喜欢的颜色？</option>
												<option>你最喜欢的歌曲？</option>
												<option>你最喜欢的明星？</option>
										</select></td>
										<td width="27%"><span id="addrmsg"><span></td>
									</tr>
									<tr>
										<td width="20%" align="right">密保答案：</td>
										<td width="53%"><input name="question" type="text"
											class="input1" id="question" /></td>
										<td width="27%"><span id="addrmsg"><span></td>
									</tr>
									<tr>
										<td width="20%" align="right">所在地：</td>
										<td width="53%"><input name="city" type="text"
											class="input1" id="city" /></td>
										<td width="27%"><span id="addrmsg"><span></td>
									</tr>
									<tr>
										<td align="right">验证码：</td>
										<td><input name="yzm" type="text" id="input2"
											class="input2" id="yzm" /> <img onclick="getimgCodes()"
											width="90px" height="40px" id="imagcode" /> <a
											onclick="getimgCodes()" href="#" style="text-decoration: none">&nbsp;看不清楚</a></td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td align="center">&nbsp;</td>
										<td align="left"><input type="submit"
											style="background-image: url('images/regbtn1.png'); height: 37px; width: 150px;"
											value="" /></td>
										<td align="center">&nbsp;</td>
									</tr>
									<tr>
										<td align="center">&nbsp;</td>
										<td align="left"><input type="checkbox" checked="checked" />同意
											《微博网络使用协议》</td>
										<td align="center">&nbsp;</td>
									</tr>
								</table></td>
						</tr>
					</table>

				</form>

             <div style="color:red; align:center;">${tips }</div>  
             

			</td>
			<td width="280" align="center" valign="top" class="pageright">
				<!-- userlogin 开始-->
				<form id="form1" name="form1" method="post"
					action="<%=request.getContextPath()%>/LoginServlet"
					onsubmit="return checkForm1()">
					<table id="login" width="220" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td colspan="2" class="title">已有微博登录账号？</td>
						</tr>
						<tr>
							<td colspan="2" align="left">邮箱/会员账号/手机号：<br /> <input
								name="userid" type="text" class="logininput" id="userid"
								onmouseover="this.focus()" />
							</td>
						</tr>
						<tr>
							<td colspan="2" align="left">输入你的登录密码：<br /> <input
								name="password" type="password" class="logininput" id="password"
								onmouseover="this.focus()" />
							</td>
						</tr>
						<tr>
							<td width="120"><input name="save" type="checkbox" id="save"
								value="yes" />下次自动登录</td>
							<td width="100"><a href="findpassword.jsp"
								style="text-decoration: none"><font color="#0066CC">找回登录密码</font></a></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input name="Submit"
								type="submit" class="loginbtn" id="Submit" value="登录微博  " /></td>
						</tr>
					</table>
				</form> <!-- userlogin 结束-->
				<table id="msnlogin">
					<tr>
						<td align="center"><img src="images/msnlogin.png" width="143"
							height="32" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>


	<!-- container 结束-->

	<!--footer开始-->
	<table id="footer" border="0" align="center" cellpadding="3"
		cellspacing="0">
		<tr>
			<td width="534" align="left"><a
				href="http://help.sina.com.cn/p/i_12.html">帮助</a>&nbsp;&nbsp; <a
				href="http://weibo.com/signup/signup.php?c=&type=&inviteCode=&code=&spe=&lang=">意见反馈</a>&nbsp;&nbsp;
				<a
				href="http://weibo.com/login.php?url=http%3A%2F%2Fweibo.com%2Fpub%2Fverified">微博认证及合作</a>&nbsp;&nbsp;
				<a href="http://open.weibo.com/">开放平台</a>&nbsp;&nbsp; <a
				href="http://hr.t.sina.com.cn/">微博招聘</a>&nbsp;&nbsp; <a
				href="http://news.sina.com.cn/guide/">微博导航</a></td>
			<td width="447" align="right">Copyright: 2011-2015<a
				href="http://corp.sina.com.cn/chn/copyright.html"> 微博系统 版权所有</a></td>
		</tr>
		<tr>
			<td align="left">客服电话：400 123 12345（按当地市话标准收费）</td>
			<td align="right">语言： <select name="select" id="select">
					<option>中文(简体)</option>
					<option>中文(繁体)</option>
			</select></td>
		</tr>
	</table>
	<!--footer结束-->
</body>
</html>
</html>

<script type="text/javascript">
	document.getElementById("imagcode").src = "YzmServlet";

	<!--
	通过根路径给他们赋值
//-->
</script>
