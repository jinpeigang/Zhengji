<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zjiansuo.jsp' starting page</title>
    
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
<jsp:include page="fjiansuo.jsp"></jsp:include>

<%-- <%@include file="fjiansuo.jsp"%> --%>


    <form id="form2">
  <table style="width:900px" border="1">
      <tr id="row">
      <th>序号</th>
      <th>需求名称</th>
      <th>机构名称</th>
      <th>所在地域</th>
      <th>审核状态</th>
      <th>操作</th>
       </tr>
         <% int x=0;%>
       <s:iterator value="#request.list" id="ifn" status="st">             		
     			<tr>
     			<td><% x++;%><%=x%></td>
     			<td><s:property value="TechNeed"/></td>
     			<td><s:property value="CompanyName"/></td>
     			<td><s:property value="Area"/></td>
     			<%String str="";
     			int Flage=(Integer)request.getAttribute("Flage"); 
     			if(Flage==0){str="未审核";}
     			if(Flage==2){str="形审通过";}
     			if(Flage==3){str="形审未通过";}
     			if(Flage==4){str="部门审核通过";}
     			if(Flage==5){str="部门审核未通过";}    			
     			%>     		
     			<td><%=str %></td>
     			<td><a href="informationSxiangxi.action?informationInfo.ID=<s:property value="ID"/>">查看</a></td>
     			</tr>    		
       </s:iterator>  
       </table>
       <%--  <%if(x==0)
         {
            out.println("<script language='javaScript'> alert('不存在记录!');window.location.href='fjiansuo.jsp'</script> ");
         }else
         { %> --%>
         
    <br>
    <center>
     <s:if test="%{pageBean.currentPage == 1}">首页 上一页</s:if>
	       <s:else>
		        <a href="retrieveInformation.action?page=1">首页</a>
		        <a href="retrieveInformation.action?page=<s:property value="%{pageBean.currentPage-1}"/>" >上一页</a>
                   </s:else>
	
	      <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
		<a href="retrieveInformation.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页</a>
		<a href="retrieveInformation.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>
	      </s:if>
	      <s:else> 
		下一页	 尾页 
　　　　  </s:else>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		第<s:property value="pageBean.currentPage" />页
		 共<s:property value="pageBean.totalPage" />页   共<s:property value="pageBean.AllRow" />记录
 	   </center>
 	   <%-- <%} %> --%>
 	   </form> 
  </body>
</html>
