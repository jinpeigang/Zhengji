<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="../js/jquery-1.4.js">
	
</script>
<script type="text/javascript" src="../js/framework.js">
	
</script>
<link href="../css/import_basic.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" id="skin" />
<!--框架必需end-->
<script type="text/javascript" src="../js/nav/ddaccordion.js">
	
</script>
<script type="text/javascript" src="../js/text/text-overflow.js">
	
</script>
<style>
a {
	
}

.categoryitems span {
	width: 160px;
}
</style>
<body leftFrame="true">
<% String ID=(String)session.getAttribute("ID");
 String bumen=(String)session.getAttribute("bumen");
 int Flage;
 %>
	<div id="scrollContent">
		<div class="arrowlistmenu">
			<div class="menuheader expandable">系统菜单</div>
			<ul class="categoryitems" id="category">
					
			<li><a><span>网络审核</span></a>
					<ul>
					<%if(bumen.equals("1"))
					{ %>
						<li><a href='../informationList.action?Flage=0'  target='frmright'><span>形式审核</span></a></li>
						<%}
						else
						{ %>
                        <li><a href='../binformationList.action?Flage=2' target='frmright'><span>部门审核</span></a></li>
                      
                        <%  } %>
					</ul>
				</li> 
				<!--  <li><a href='../suser/fjiansuo.jsp'  target='frmright'><span>分类检索</span></a></li>	 -->
				 <li><a href='../suser/highSearch2.jsp'  target='frmright'><span>分类检索</span></a></li>	
				<li><a href="../suserLoad.action?ID=<%=ID%>" target='frmright'><span>修改密码</span></a></li>
				
			</ul>
			</div>
			</div>
</body>
</html>