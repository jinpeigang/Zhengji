<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分类检索</title>
    <script src="jquery/jquery2.0.0.min.js">
   </script>
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

 <script type="text/javascript"> 
  function change(){   
	  var pro = $("#biaoyin2");    
	  var provalue = pro.find("option:selected").text();  
	  var city = $("#tiaojian2");    
	  city.empty();//清空城市下拉框    
	  switch(provalue){          
     case "所在地域":      
			  city.append($("<option>130100.0石家庄市</option>"));   
			  city.append($("<option>130200.0唐山市</option>"));
			  city.append($("<option>130300.0秦皇岛市</option>"));    
			  city.append($("<option>130400.0邯郸市</option>")); 
			  city.append($("<option>130500.0邢台市</option>"));    
			  city.append($("<option>130600.0保定市</option>"));    
			  city.append($("<option>130700.0张家口市</option>"));   
			  city.append($("<option>130800.0承德市</option>"));
			  city.append($("<option>130900.0沧州市</option>"));    
			  city.append($("<option>131000.0廊坊市</option>")); 
			  city.append($("<option>131100.0衡水市</option>"));    
			  city.append($("<option>130682.0定州市</option>"));
			  city.append($("<option>130181.0辛集市</option>"));    
			  city.append($("<option>120000.0其他</option>"));
			  break;            
	 case "机构属性":      
		  city.append($("<option>企业</option>")); 
		  city.append($("<option>高等院校</option>"));      
		  city.append($("<option>研究机构</option>")); 
		  city.append($("<option>其他</option>"));         
		  break;   	  
     case "技术需求解决方式":      
		  city.append($("<option>独立开发</option>")); 
		  city.append($("<option>委托研发</option>"));      
		  city.append($("<option>合作研发</option>")); 
		  city.append($("<option>其他</option>"));         
		  break;    
     case "科技活动类型":      
		  city.append($("<option>基础研究</option>")); 
		  city.append($("<option>应用研究</option>"));      
		  city.append($("<option>试验发展</option>")); 
		  city.append($("<option>研究与试验发展成果应</option>"));  
		  city.append($("<option>技术推广与科技服务</option>"));
		  city.append($("<option>生产性活动</option>"));
		  break;  
     case "管理处室":      
		  city.append($("<option>办公室</option>"));   
		  city.append($("<option>人事处</option>"));
		  city.append($("<option>机关党委</option>"));    
		  city.append($("<option>政策法规处</option>"));
		  city.append($("<option>计划财务处</option>"));    
		  city.append($("<option>平台与基础处</option>")); 
		  city.append($("<option>国际合作处</option>"));    
		  city.append($("<option>高新技术处</option>")); 
		  city.append($("<option>农村科技处</option>"));    
		  city.append($("<option>社会发展处</option>")); 
		  city.append($("<option>成果与市场处</option>"));    
		  city.append($("<option>监察室</option>")); 
		  city.append($("<option>离退休干部处</option>"));    
		  city.append($("<option>知识产权局</option>")); 
		  city.append($("<option>半干旱中心</option>"));    
		  city.append($("<option>山办</option>")); 
		  city.append($("<option>机关服务中心</option>"));    
		  city.append($("<option>科技研发中心</option>")); 
		  city.append($("<option>科技情报研究院</option>"));    
		  city.append($("<option>器材公司</option>")); 
		  city.append($("<option>基金办</option>"));    
		  city.append($("<option>档案馆</option>")); 
		  city.append($("<option>科技管理信息中心</option>"));    
		  city.append($("<option>科技投资中心</option>")); 
		  city.append($("<option>成果转换中心</option>"));    
		  city.append($("<option>中小企业创新资金管理中心</option>")); 
		  city.append($("<option>对外交流中心</option>"));    		  
		  break;
     case "归口管理部门":      
    	 city.append($("<option>邯郸市科技局</option>"));
    	 city.append($("<option>邢台市科技局</option>"));
    	 city.append($("<option>石家庄市科技局</option>"));
    	 city.append($("<option>保定市科技局</option>"));
    	 city.append($("<option>张家口市科技局</option>"));
    	 city.append($("<option>承德市科技局</option>"));
    	 city.append($("<option>秦皇岛市科技局</option>"));
    	 city.append($("<option>唐山市科技局</option>"));
    	 city.append($("<option>廊坊市科技局</option>"));
    	 city.append($("<option>沧州市科技局</option>"));
    	 city.append($("<option>衡水市科技局</option>"));
    	 city.append($("<option>省科技厅</option>"));
    	 city.append($("<option>省财政厅</option>"));
    	 city.append($("<option>省工业和信息化厅</option>"));
    	 city.append($("<option>省住房和城乡建设厅</option>"));
    	 city.append($("<option>省水利厅</option>"));
    	 city.append($("<option>省计生委</option>"));
    	 city.append($("<option>省食品药品监督管理局</option>"));
    	 city.append($("<option>省质量技术监督局</option>"));
    	 city.append($("<option>省环保厅</option>"));
    	 city.append($("<option>省卫生厅</option>"));
    	 city.append($("<option>省农业厅</option>"));
    	 city.append($("<option>省教育厅</option>"));
    	 city.append($("<option>省林业厅</option>"));
    	 city.append($("<option>省中小企业局</option>"));
    	 city.append($("<option>省交通厅</option>"));
    	 city.append($("<option>省国防科技工业局</option>"));
    	 city.append($("<option>省审计厅</option>"));
    	 city.append($("<option>省文化厅</option>"));
    	 city.append($("<option>省统计局</option>"));
    	 city.append($("<option>省公安厅</option>"));
    	 city.append($("<option>省人力资源和社会保障厅</option>"));
    	 city.append($("<option>省体育局</option>"));
    	 city.append($("<option>省国土资源厅</option>"));
    	 city.append($("<option>省科学院</option>"));
    	 city.append($("<option>省农科院</option>"));
    	 city.append($("<option>省社会科学院</option>"));
    	 city.append($("<option>省气象局</option>"));
    	 city.append($("<option>省地震局</option>"));
    	 city.append($("<option>省民政厅</option>"));
    	 city.append($("<option>省委宣传部</option>"));
    	 city.append($("<option>省委组织部</option>"));
    	 city.append($("<option>省供销合作社 </option>"));
    	 city.append($("<option>省广播电视局</option>"));
    	 city.append($("<option>省委办公厅</option>"));
    	 city.append($("<option>省政府研究室</option>"));
    	 city.append($("<option>省盐务局</option>"));
    	 city.append($("<option>省档案局</option>"));
    	 city.append($("<option>省物价局</option>"));
    	 city.append($("<option>省人民政府外事办公室</option>"));
    	 city.append($("<option>省政府办公厅</option>"));
    	 city.append($("<option>省信访局</option>"));
    	 city.append($("<option>省妇联</option>"));
    	 city.append($("<option>省法院</option>"));
    	 city.append($("<option>省检察院</option>"));
    	 city.append($("<option>省商务厅</option>"));
    	 city.append($("<option>省发改委</option>"));
    	 city.append($("<option>省国资委</option>"));
    	 city.append($("<option>辛集市科技局</option>"));
    	 city.append($("<option>定州市科技局</option>"));
    	 city.append($("<option>省安全生产监督管理局</option>"));
    	 city.append($("<option>省国家安全厅</option>"));
    	 city.append($("<option>省中医药管理局</option>"));
    	 city.append($("<option>河北出入境检验检疫局</option>"));
    	 city.append($("<option>省科协</option>"));
    	 city.append($("<option>河北钢铁集团有限公司</option>"));
    	 city.append($("<option>石家庄国家高新技术产业开发区</option>"));
    	 city.append($("<option>保定国家高新技术产业开发区</option>"));
    	 city.append($("<option>省总工会</option>"));
    	 city.append($("<option>省旅游局</option>"));
    	 city.append($("<option>省新闻出版广电局</option>"));
    	 city.append($("<option>省社科联</option>"));
    	 city.append($("<option>团省委</option>"));
    	 city.append($("<option>省司法厅</option>"));
    	 city.append($("<option>唐山国家高新技术产业开发区</option>"));
    	 city.append($("<option>燕郊国家高新技术产业开发区</option>"));
    	 city.append($("<option>河北行政学院</option>"));
    	 city.append($("<option>河北省机构编制委员会办公室</option>"));
    	 city.append($("<option>省政府法制办</option>"));
    	 city.append($("<option>中共河北省委党校</option>"));
    	 city.append($("<option>省工商行政管理局</option>"));
    	 city.append($("<option>承德国家高新技术产业开发区</option>"));

	  
		  break;      
	  }
  }
  </script>
</head>
<body>
<div>
<div>
<%request.setCharacterEncoding("UTF-8");//传值编码
response.setContentType("text/html;charset=UTF-8");//设置传输编码 %>
<form id="form1" method="post" name="form1" action="retrieveInformation.action">
  <fieldset> 
      <legend>检索条件</legend> 
        <table style="width:600px">
      <tr style=" background: none;"><td>标引条件1</td><td><select name="biaoyin1" id="biaoyin1" style="font-size:16px">
      <option>请选择</option>
      <option value="companyName">机构全称</option>
      <option value="legalRepresenttative">法人代表</option>
      <option value="contactName">联系人</option>
      <option value="techNeed">技术需求名称</option>
      <option value="key1">关键字</option>
      <option value="planSum">拟投入资金总额</option>
      <option value="studyType">学科分类</option>
      <option value="tNProfessionThird">需求技术应用行业</option>
        <option value="techNeedField">需求技术所属领域</option>
      </select>
      </td>
      <td><input type="text" name="tiaojian1" id="tiaojian1"></td>  
      <td><select name="biaoyin4" id="biaoyin4" style="font-size:16px">
      <option value="精确">精确</option>
      <option value="模糊">模糊</option>
      </select></td></tr>
      <tr style=" background: none;"><td>标引条件2</td><td><select name="biaoyin2" id="biaoyin2" style="font-size:16px" onchange="change()">
       <option>请选择</option>
     <!--  <option value="jGshuxing">机构属性</option> -->
      <option value="area">所在地域</option>
      <option value="cenManagement">归口管理部门</option>
      <option value="techNeedMode">技术需求解决方式</option>
      <option value="studyType">科技活动类型</option>
       <option value="guanli">管理处室</option>
      </select>
      </td>   
      <td>
       <select style="font-size:16px" name="tiaojian2" id="tiaojian2" >
      <option>请选择<option>
      </select>
      </td>
      <tr style="background: none;"><td>标引条件3</td><td><select style="font-size:16px" name="biaoyin3" id="biaoyin3">
       <option value=""></option>
        <option value="0">未审核</option>
      <option value="2">形审通过</option>
      <option value="3">形审未通过</option>
      <option value="4">部门审核通过</option>
      <option value="5">部门审核未通过</option>
      </select>
      </td>   
      <td><input type="submit" name="button1" id="button1" value="查询"></td>
      </tr>   
      </table>    
  </fieldset>
  </form>
  <br>
  <br>
 
</div>
<br>
<br>
</div>
</body>
</html>