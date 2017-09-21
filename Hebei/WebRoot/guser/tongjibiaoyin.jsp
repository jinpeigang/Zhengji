<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tongjibiaoyin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
input{
font-size:15px;
}
 table{
width: 80%;
border-color: #e9e6e7;
margin: auto;
text-align:center;
}
div{
      text-align: center;
}
</style>
  </head>
  
  <body>
    <div>
<form id="form1" name="form1" action="pieChart3D.action">
  <fieldset style="height:100px;"> 
      <legend>统计条件</legend> 
        <table style="width:350px">
      <tr style=" background: none;"><td>请选择统计条件</td><td><select name="biaoyin" id="biaoyin" style="font-size:16px">
      <option>请选择</option>
      <option value="flage">审核结果</option>
      <option value="JGshuxing">机构属性</option>
      <option value="techNeedMode">技术需求解决方式</option>
      <option value="studyType">科技活动类型</option>
      </select>
      </td>
        <td><input type="submit" name="button1" id="button1" value="查询"></td>
      </tr>
      </table>    
  </fieldset>
  </form>
</div>
  </body>
</html>
