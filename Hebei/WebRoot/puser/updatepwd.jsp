<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>密码修改</title>
<script type="text/javascript">

function pwdJudge1()
{
	var pwd1=form1.pwd1.value;
	var pwd=form1.pwd.value;
	if(pwd1=="")
	{
		document.getElementById("mes1").innertHTML="<fornt color='red'>*请输入密码</font>";
	
	      return false;
	}
	else if(pwd!=pwd1)
	{
	  document.getElementById("mes1").innerHTML="<font color='red'>*密码输入不正确</font>";

	  return false;
	}
	else
	{
	  document.getElementById("mes1").innerHTML="<font color='green'>✔<//font>";
	  
	  return true;
	}
	
}
function pwdJudge2()
{ 
 
   var pwd2=form1.password.value;
   var pwd3=form1.pwd3.value;
   if(pwd3!=""&&pwd2!=pwd3)
	   {
	   document.getElementById("pwd3").value="";
	   return false;
	   }
  
   else if(pwd2.length<6||pwd2.length>20)
   {
	   document.getElementById("mes2").innerHTML="<font color='red'>*密码长度在6到20个字符</font>";
	   document.getElementById("pwd3").value="";
	   return false;
   }
   else
	   
		{
		 document.getElementById("mes2").innerHTML="<font color='green'>✔<//font>";
		  
		  return true;
		}
}

function pwdJudge3()
{
	var str = form1.password.value;
	var C_str = form1.pwd3.value;
	if(C_str==""||str!=C_str)
	{
	  document.getElementById("mes3").innerHTML="<font color='red'>*两次密码输入不一致</font>";

	  return false;
	}
	else
	{
	  document.getElementById("mes3").innerHTML="<font color='green'>✔<//font>";
	  
	  return true;
	}
}
function Judge()
{  
		
		if(!pwdJudge1()){
	alert("请正确输入原始密码！");
	return false;
}
else if(!pwdJudge2()){
	alert("请按提示输入密码！");
	return false;
}
	else if(!pwdJudge3())
		{
		alert("请按提示确认密码！");
		return false;
		}
	else
		{
		return true;
		}
	
	}

</script> 
<style>
  tr{
    display:block; /*将tr设置为块体元素*/
    margin:15px 0;  /*设置tr间距为2px*/
}
#in{
width:200px;
height:30px;
}
 #man
 {
    width:1000px;
    height:100%;
	margin:0,auto;
 	
 	
 } 
 #fo{
 	text-align: center;
 }
 input{
 height:28px;
 margin:0px 0px 3px 0px;
 }
  </style>
</head>
<body  style=" width:100%">
 
<jsp:useBean id="db" class="DB.DBBean" scope="page" />
<%
request.setCharacterEncoding("UTF-8");
/* String pwd=(String)session.getAttribute("pwd"); */
String pwd=request.getAttribute("user.password").toString();
String id1=(String)session.getAttribute("id");
session.setAttribute("id", id1);
%>
<center>
 <div id="man">  
   
     <form name="form1" action="userPassword.action" method="post" id="form1">
     <table>
     <tr style="display:none">
     <td><input type="Text" name="pwd" value="<%=pwd%>"></td>
     <td><input type="Text" name="id" value="<%=id1%>"></td>
     </tr>
     <p><font size="5">密码修改</font></p>     
     <tr>
     <th><font color="red">&nbsp &nbsp *</font>原密码:</th>
     <td><input type="password" name="pwd1" id="pwd1"  onblur="pwdJudge1()"></td><td style="width: 250px;"><em id="mes1"></em></td>     
     </tr>
      <tr>
     <th><font color="red">&nbsp &nbsp *</font>新密码:</th>
     <td><input type="password" name="password" id="password"  onblur="pwdJudge2()"></td><td style="width: 250px;"><em id="mes2"></em></td>
     </tr>
      <tr>
     <th><font color="red">*</font>请确认新密码:</th>
     <td><input type="password" name="pwd3" id="pwd3"  onblur="pwdJudge3()"></td><td style="width: 250px;"><em id="mes3" ></em></td>
     </tr>
     <tr>   
              <th></th>
               <td clospan="2"><input type="submit" name="submit" onclick="return Judge()" value="确定">
               &nbsp &nbsp &nbsp &nbsp
               <input type="reset" name="submit" value="重置"></td>
         </tr>
     </table>
     </form>
     </div>
     </center>
   
</body>
</html>