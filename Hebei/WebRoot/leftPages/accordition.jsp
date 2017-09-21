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
<%
request.setCharacterEncoding("utf-8");
 String CompanyName=(String)session.getAttribute("companyName");

  String id=(String)session.getAttribute("id"); %>

<div id="scrollContent">
		<div class="arrowlistmenu">
			<div class="menuheader expandable">系统菜单</div>
 			<ul class="categoryitems" id="category">
						<li><a><span>技术需求</span></a>
					<ul>
					  <li><a href='../informationTianbao.action'  target='frmright'><span>需求填报</span></a></li>
					   <!-- <li><a href='../xuqiuchakan.jsp'  target='frmright'><span>需求查看</span></a></li> -->
					   <li><a href="../informationChakan.action" target='frmright'><span>需求查看</span></a></li>
					</ul>
				</li> 							
				<li><a href="../userLoad.action?id=<%=id%>"  target='frmright'><span>密码修改</span></a></li>
				
			</ul>
			</div>
			</div>
</body>
</html>