<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modify.jsp</title>
</head>
<body>
 <h3>通过验证，请继续修改密码</h3>
<form action="ModifypasswordServlet" method="post" onsubmit="return checkForm()">

<table>
  <tr>
    <td>新 密 码:</td>
    <td><input type="password" name="newpasswd"></td>   
  </tr>

<tr>
    <td>确认密码:</td>
    <td><input type="password" name="cpasswd"></td>   
  </tr>
 <tr>
    <td><input type="submit"  text="确认修改"></td>   
    <td><div style="color:red;">${mes }</div></td>
  </tr> 
  
</table>

</form>


</body>
</html>