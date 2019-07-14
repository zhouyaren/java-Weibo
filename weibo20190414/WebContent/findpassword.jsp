<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>find password</title>
</head>
<body>
<form action="FindUserqqServlet" method="post" onsubmit="return checkForm()">

  <table>
  
  <tr>
  <td >账 号</td>
  <td><input type="text" name="username"  ></td> 
  <td><input  type="submit"  style=" height: 30px; width: 150px;" 
		value="查询账户" ></td>
  <td> <div style="color:red;">${mess }</div> </td>
  </tr>
  <tr>
   <td>邮箱或者QQ号</td>
   <td><input type="text" name="userqq"  required></td> 
  </tr>
   <tr><td><input type="submit" style="height:30px;width:150px"></td>
   <td><div style="color:red;">${tips }</div></td>
  </tr>
  
 </table>


</form>
</body>
</html>