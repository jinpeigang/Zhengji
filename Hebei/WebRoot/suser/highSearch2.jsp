<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.div {
	border: 1px solid grey;
	border-bottom: 1px solid transparent;
	font-size: 14px;
}

.div2 {
	border: 1px solid grey;
	border-top: 1px solid transparent;
	font-size: 14px;
}

select {
	height: 24px;
	font-size: 14px;
}

input {
	height: 18px;
	font-size: 14px;
}

.btn {
	margin-left: 5px;
	vertical-align: middle;
	width: 60px;
	height: 26px;
	font-size: 14px;
	border: none;
	border-radius: 5px;
	color: white;
	background-color: rgba(99, 86, 255, 1);
}

.btn:hover {
	background-color: #282ff7;
}
</style>
<script type="text/javascript" src="../js/jquery-1.4.js"></script>

<script>
	function addtr() {
		var rows = $("#mytable").find("tr").length;
		if (rows < 15) {
			$("#mytable").append("<tr style='background:none;'><td>"
									+ "<select style='margin:auto 5px;' name='sel0'>"
									+ "<option value='and'>并且</option>"
									+ "<option value='or'>或者</option>"
									+ "</select></td><td>"
									+ "<select style='margin:auto 5px;' name='sel2'>"
									+ "<option value='techNeed'>需求名称</option>"
									+ "<option value='companyName'>机构名称</option>"
									+ "<option value='planSum'>资金总额</option> "
									+ "<option value='key1'>关键字</option>"
									+ "<option value='legalRepresenttative'>法人代表</option>"
									+ "<option value='contactName'>联系人</option>"
									+ "<option value='studyType'>学科分类</option>"
									+ "<option value='cenManagement'>归口管理单位</option>"
									+ "<option value='area'>所在地域</option>"
									+ "<option value='JGshuxing'>机构属性</option>"
									+ "<option value='techNeedMode'>技术需求解决方式</option>"
									+ "<option value='studyType'>科技活动类型</option>"
									+ "</select>"
									+ "<input style='margin:auto 5px;' name='inputvalue'/>"
									+ "<select style='margin:auto 5px;' name='sel3'>"
									+ "<option value='jingque'>精确</option>"
									+ "<option value='mohu'>模糊</option>"
									+ "</select></td></tr>");
		}
	}
	function deltr() {
		var rows = $("#mytable").find("tr").length;
		if (rows > 1) {
			$("#mytable tr:last-child").remove();
		}
	}

	function submit() {
		var s0 = document.getElementsByName("sel0");
		var s2 = document.getElementsByName("sel2");
		var s3 = document.getElementsByName("sel3");
		var sel4 = document.getElementById("sel4").value;
		var iv = document.getElementsByName("inputvalue");

		var sel0 = new Array();
		var sel2 = new Array();
		var sel3 = new Array();
		var inputvalue = new Array();
		for ( var i = 0; i < s0.length; i++) {
			sel0[i] = s0[i].value;
		}
		for ( var i = 0; i < s2.length; i++) {
			sel2[i] = s2[i].value;
		}
		for ( var i = 0; i < s3.length; i++) {
			sel3[i] = s3[i].value;
		}
		for ( var i = 0; i < iv.length; i++) {
			inputvalue[i] = iv[i].value;
		}

		var s0=JSON.stringify(sel0);
		var s2=JSON.stringify(sel2);
		var s3=JSON.stringify(sel3);
		var iv=JSON.stringify(inputvalue);
		
		/* var url="highSearch.action?sel0="+s0+"&sel2="+s2+"&sel3="+s3+"&sel4="+sel4+"&inputvalue="+iv;*/
		
		 $.ajax({
			type : "post",
			url : "highSearch.action",  //不知道zhjs是接受什么的。action中路径		
			data : {
			"sel0" : s0,//JSON.stringify(sel0),
			"sel2" : s2,//JSON.stringify(sel2),
			"sel3" : s3,//JSON.stringify(sel3),
			"sel4" : sel4,
			"inputvalue" : iv//JSON.stringify(inputvalue)
			},
			dataType : "json",
			success : function(data) {		
			 	$("#divshow").html(data); 
			},
			error : function(msg) {
			//为什么是错误返回
				 $("#divshow").html(msg.responseText); 				
			} 
		});
	}
</script>
<!-- 动态增减 查询条件 -->
<script>
	$(function() {
		$("#add").click(addtr);
		$("#del").click(deltr);
		$("#submit").click(submit);
	});
</script>
</head>

<body>
	<div class="div">
		<p style="margin-left:5px;font-size:14px;text-align:left">输入检索条件：</p>
		<table width="100%" id="mytable" style="text-align:left">
			<tr style=" background: none;">
				<td width="8%">
					<button id="add" style="width:16px;height:16px;margin-left:6px;">
						<font style="margin:auto -5px;">+</font>
					</button>
					<button id="del" style="width:16px;height:16px;margin-left:6px;">
						<font style="margin:auto -5px;">-</font>
					</button></td>
				<td><select style="margin-left:5px;" name="sel2">
				        <option value="companyName">机构名称</option>
						<option value="techNeed">需求名称</option>						
						<option value="planSum">资金总额</option>
						<option value="key1">关键字</option>
						<option value="legalRepresenttative">法人代表</option>
						<option value="contactName">联系人</option>
						<option value="studyType">学科分类</option>
						<option value="cenManagement">归口管理单位</option>
						<option value="area">所在地域</option>
						<option value="JGshuxing">机构属性</option>
						<option value="techNeedMode">技术需求解决方式</option>
						<option value="studyType">科技活动类型</option>					
				</select> 
				<input style="margin-left:3px;" name="inputvalue" id="a" /> 
				<select style="margin-left:3px;" name="sel3">
						<option value="jingque">精确</option>
						<option value="mohu">模糊</option>
				</select></td>
			</tr>
		</table>
	</div>
	<div class="div2">

		<div style="margin:5px;text-align:left" >
			<font style="font-size:14px;">审核情况：</font> <select
				style="margin-left:3px;" name="sel4" id="sel4">
	  <option>请选择</option>
      <option value="0">未审核</option>
      <option value="2">形审通过</option>
      <option value="3">形审未通过</option>
      <option value="4">部门审核通过</option>
      <option value="5">部门审核未通过</option>
			</select> <input type="submit" value="检索" class="btn" id="submit" />
		</div>
	</div>
	<div style="margin-top:10px;" id="divshow">
		 <%-- <jsp:include page="highSearchDisplay.jsp"></jsp:include> --%>
	</div>
	
</body>

</html>