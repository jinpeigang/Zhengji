<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jpg.hebei.model.PageBean"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>形式审核</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <style type="text/css">
 table{
width: 80%;
border-color: #e9e6e7;
margin: auto;
text-align:center;
}
 
 table tr:nth-child(odd){
background: #e9e6e7;
	height: 30px;
}
table tr:nth-child(even){
background:white;
	height: 30px;
}
th {
	height: 30px;
}
div{
      text-align: center;
}
 </style>
  </head>
  
  <body>
      
       <div> <font size="5px">形式审核</font></div>
      <table border="1">
       <tr>
       <th>序号</th>
       <th>需求名称</th>
       <th>机构名称</th> 
        <th>机构属性</th>
       <th>科技活动类型</th>
       <th>操作</th>
       </tr>
       <% int x=0;%>
       <s:iterator value="#request.list" id="ifn" status="st">  
     <%--    <s:if test="#st.Count<=2"> --%>			
     			<tr>
     			<td><% x++;%><%=x%></td>
     			<td><s:property value="TechNeed"/></td>
     			<td><s:property value="CompanyName"/></td>
     			<td><s:property value="JGshuxing"/></td>
     			<td><s:property value="StudyType"/></td>
     			<td><a href="informationShenhe.action?informationInfo.ID=<s:property value="ID"/>">审核</a></td>
     			</tr>
     	<%-- </s:if> --%>
       </s:iterator>  
      
       </table>
    <br>
    <center>
     <s:if test="%{pageBean.currentPage == 1}">首页 上一页</s:if>
	       <s:else>
		        <a href="informationList.action?page=1">首页</a>
		        <a href="informationList.action?page=<s:property value="%{pageBean.currentPage-1}"/>" >上一页</a>
                   </s:else>
	
	      <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
		<a href="informationList.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
		<a href="informationList.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>
	      </s:if>
	      <s:else> 
		下一页	 尾页 
　　　　  </s:else>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		第<s:property value="pageBean.currentPage" />页
		 共<s:property value="pageBean.totalPage" />页   共<s:property value="pageBean.AllRow" />记录
 	   
	   
	   </center>
  </body>
</html>
      