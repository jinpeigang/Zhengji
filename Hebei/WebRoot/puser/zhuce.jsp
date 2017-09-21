<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script>
function userNameJudge()
{
	var str = form1.username.value;
	var str1=/^([a-zA-Z0-9_-])+/;
	flag=str1.test(str);
	if(!flag)
		{
		document.getElementById("mes0").innerHTML="<font color='red'>*用户名为数字与字母的组合</font>";
		  return false;
		}
	else if(str=="")
		{
		  document.getElementById("mes0").innerHTML="<font color='red'>*用户名不能为空</font>";
		  return false;
		}
    else if(str.length<6)
    {
		  document.getElementById("mes0").innerHTML="<font color='red'>*用户名不能少于6个字符</font>";
		  return false;
		}
	else if(str.length>20)
		{
		  document.getElementById("mes0").innerHTML="<font color='red'>*用户名不能超过20个字符</font>";
		  return false;
		}
	else
		{
		  document.getElementById("mes0").innerHTML="<font color='green'>✔<//font>";
		  return true;
		}
}

function pwdJudge(){
	var str = form1.pwd1.value;
	//var yanZheng = /^[a-zA-Z]\w{5,17}$/;
	var C_str = form1.pwd2.value;
	var str1=/^([a-zA-Z0-9_-])+/;
	flag=str1.test(str);
	if(!flag)
		{
		document.getElementById("mes0").innerHTML="<font color='red'>*用户名为数字与字母的组合</font>";
		  return false;
		}
	if(C_str!=""&&C_str!=str)
	{
		document.getElementById("mes2").innerHTML="<font color='red'>*两次密码输入不一致</font>";
	}
	if(str =="")
	{
	  document.getElementById("mes1").innerHTML="<font color='red'>*密码不能为空</font>";
	  return false;
	}
	
else if(str.length<6||str.length>20)
	{
	  document.getElementById("mes1").innerHTML="<font color='red'>*密码长度在6-20个字符之间</font>";
	}
else
	{
	  document.getElementById("mes1").innerHTML="<font color='green'>✔<//font>";
	  return true;
	}
}
function C_pwdJudge(){
	var str = form1.pwd1.value;
	var C_str = form1.pwd2.value;
	if(C_str==""||str!=C_str)
	{
	  document.getElementById("mes2").innerHTML="<font color='red'>*两次密码输入不一致</font>";
	  return false;
	}
	else
	{
	  document.getElementById("mes2").innerHTML="<font color='green'>✔<//font>";
	  return true;
	}
}
function firmCodeJudge(){
	var str = form1.companynum.value;
	var reg = /^[0-9]*$/;
	if(str=="")
	{
	  document.getElementById("mes4").innerHTML="<font color='red'>*企业代码不能为空</font>";
	  return false;
	}
	else if(!reg.test(str))
	{
		document.getElementById("mes4").innerHTML="<font color='red'>*企业代码由0-9的数字组成</font>";
		return false;
	}
	else
	{
		document.getElementById("mes4").innerHTML="<font color='green'>✔<//font>";
		return true;
	}
	
}
function IDcardJudge(){
	var str = form1.ID.value;
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	if(str=="")
		{
			document.getElementById("mes6").innerHTML="<font color='red'>*身份证号不能为空</font>";
			return false;
		}
	else if(!reg.test(str))
		{
			document.getElementById("mes6").innerHTML="<font color='red'>*身份证号格式不正确</font>";
			return false;
		}
	else
		{
			document.getElementById("mes6").innerHTML="<font color='green'>✔<//font>";
			return true;
		}
}

function Judge(){
	/* if(!userNameJudge()){
		alert("请按提示输入用户名！");
		return false;
	}
	else if(!pwdJudge()){
		alert("请按提示输入密码！");
		return false;
	}
	else if(!C_pwdJudge()){
		alert("请按提示确认密码！");
		return false;
	}
	
	else if(!IDcardJudge()){
		alert("请按提示输入身份证号！");
		return false;
	}
	else if(!firmCodeJudge()){
		alert("请按提示输入机构代码！");
		return false;
	}
	else{
		return true;
	} */
      return true;
}
</script>
  <style>
  tr{
    display:block; /*将tr设置为块体元素*/
    margin:5px 0;  /*设置tr间距为2px*/
}
#in{
width:200px;
height:30px;
}
 #man
 {
    width:500px;
    height:100%;
	margin:0,auto;
 	background-color:#f5f5f5
 	
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
<body style=" background:#F0F0F0; width:100%">

     <div style="width:100%;height:100%;">
   
	   <center>
        <div id="man">    
     <form   name="form1" action="userRegister.action" method="post" id ="form1"   onsubmit="return isValidate(form1)">
    <table>
        <p> 用户注册</p>
         <tr>
           <th>&nbsp;<font color="red">*</font>用户名:</th>
           <td><input type="text" name="username" id="username" onblur="userNameJudge()" required /></em></td>
         <td><em id="mes0"></td>
         </tr>
         
          <tr>
           <th><font color="red">*</font>用户密码:</th>
           <td><input type="password" name="password" id="password" onblur="pwdJudge()"/></td>
         <td ><em id="mes1"></em></td>
         </tr>
         
          <tr>
           <th><font color="red">*</font>密码确认:</font></th>
           <td><input type="password" name="password2" id="pwd2" onblur="C_pwdJudge()"/></td>
           <td><em id="mes2"></em></td>         
         </tr>
         
          <tr>
           <th><font color="red">*</font>机构名称:</th>
           <td><input type="text" name="companyName" id="companyName" required></td>
           <td></td>
         </tr>
        
          <tr>
           <th><font color="red">*</font>真实姓名:</th>
           <td><input type="text" name="name" id="name" required></td>
           <td></td>
         </tr>
         
          <tr>
           <th><font color="red">*</font>身份证号:</th>
           <td><input type="text" name="cardID" id="ID" required onblur="IDcardJudge()"/></td>
         <td><em id="mes6"></em></td>
         </tr>
        
          <tr>
           <th><font color="red">*</font>企业代码:</th>
           <td><input type="text" name="companynum" id="companynum"  onblur="firmCodeJudge()"/></td>
         <td><em id="mes4"></em></td>
         </tr>
         
          <tr>
           <th><font color="red">*</font>企业法人:</th>
           <td><input type="text" name="legalRepresenttative" id="legalRepresenttative"></td>
           <td></td>
         </tr>
         
           <tr>
           <th><font color="red">*</font>通讯地址:</th>
           <td><input type="text" name="address" id="address"></td>
           <td></td>
         </tr>
         <tr>    
              <th></th>
               <td clospan="2"><input type="submit" name="submit" value="注册" onclick="return Judge()"> &nbsp &nbsp &nbsp &nbsp <input type="reset" name="submit" value="重置"></td>
               <td></td><td></td>
         </tr>
      </table>
 </form> 
   </div>
   </div>
   </center>
</body>
</html>