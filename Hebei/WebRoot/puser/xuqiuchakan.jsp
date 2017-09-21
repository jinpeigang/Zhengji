<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ page import="java.sql.*" %>
      <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<div><font size="5px">我的需求</font></div>
<table border="1">
       <tr>
       <th>序号</th> 
       <th>需求名称</th>        
       <th>机构属性</th>
       <th>科技活动类型</th>
       <th>状态</th>
       <th>操作</th>
       </tr>
       
       <% int i=0;%>
       <s:iterator value="ifns">
       <tr><td><% i++; %><%=i%></td>
       <td><s:property value="TechNeed"/></td>
       <td><s:property value="JGshuxing"/></td>
       <td><s:property value="StudyType"/></td>
       <td>
       <% int flage=(Integer)request.getAttribute("Flage"); 
          String ss="";
       if(flage==0)	{ss="形式审核中";}
       if(flage==1){ ss="形式审核中";}
       if(flage==3){ss="未通过形式审核";}
       if(flage==2){ ss="技术审核中";}
       if(flage==5){ss="未通过技术审核";	}
       if(flage==4){ss="通过技术审核";} 
       %>
       <%=ss%>
       </td>
       <td><a href="informationXiangxi.action?informationInfo.ID=<s:property value="ID"/>">查看</a></td>
       </tr>
       </s:iterator>
   
</table>
 
</body>
</html>