<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xshenhejudge.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript" >
window.onload= function(){
 var inpt= document.getElementById('form1').getElementsByTagName('input');  //获取表单下所有的input元素
 for(var i=0;i<inpt.length;i++){   //遍历获得的input元素
  if(inpt[i].type=='radio'){   //如果是单选按钮
   inpt[i].onclick=function(){ // input的单击事件
    if(this.checked)
    if(this.nextSibling.nodeValue=="审核不通过")
 	   {
 	     reasonrow.style.display="";
 	   xxrow.style.display="none";
 	   }
    if(this.nextSibling.nodeValue=="审核通过")
 	   {
 	   reasonrow.style.display="none";
 	 xxrow.style.display="";
 	   }
  
      }
  }
 }
}
</script>
 <script type="text/javascript" language="javascript">
 function act1(){

    document.form1.action="informationList.action";
    document.form1.submit();   
}
function act2(){

    document.form1.action="informationList.action";

    document.form1.submit();   

} 
function Judge1()
{ 
	var panduan=form1.reason1.value;
	if(panduan=="")
		{
		
		return false;
		}
	else
		{return true;}
	}
function Judge()
{
	if(!Judge1())
		{
		alert("请先进行审核!");
		return false;
		}
	else
		{return true;}
}
/*function $(id){
	return document.getElementById(id);
}
function opendialog(){
	var reason;
	var someValue=window.showModalDialog('reason.jsp','','dialogWidth=400px;dialogHeight=300px;status=no;help=no;scollbar=no');
	$('returnvalue').innerHTML=someValue;
	window.location='xshenhebutongguo.jsp';
	window.location.href="xshenhebutongguo.jsp?reason="+ someValue;
}*/
</script>
  </head>
  
 <body  style=" background:#F0F0F0">
 <jsp:useBean id="db" class="DB.DBBean" scope="page" />
<div align="center">
     <div style="height:40px;text-align:center;" ><p><font size="5" color="blue" style="font-weight:bold;">xxx需求审核</font></p>
       </div>
     <div>     
  <form id="form1" name="form1" method="post" action="informationShenheTijiao.action">
    <table width="828" height="1274" border="1">
      <tr>
        <td width="88" height="32"> *机构全称</td>
        <td width="323"><s:property value="ifn.CompanyName"/></td>
        <td colspan="2">归口管理部门</td>
       
        <td colspan="4"><s:property value="ifn.CenManagement"/></td>
       
        </tr>
      <tr>
        <td height="31">*通讯地址</td>
        <td><s:property value="ifn.CompanyAddress"/></td>
        <td colspan="2">*所在地域</td>
        <td colspan="4"><s:property value="ifn.Area"/></td>
        </tr>
      <tr>
        <td height="31"> 网址</td>
        
        <td width="323"><s:property value="ifn.WorkWebSite"/></td>
        
        <td colspan="2">*电子信箱
        </td>
        <td colspan="3"> <s:property value="ifn.Email"/></td>
        
      </tr>
      <tr>
        <td height="31">*法人代表</td>
        <td><s:property value="ifn.LegalRepresenttative"/></td>
        <td colspan="2">邮政编码
         </td>
        
        <td colspan="3"> <s:property value="ifn.PostCode"/></td>
      
      </tr>
  
      <tr>
        <td rowspan="2">*联 系 人</td>
        <td rowspan="2"><s:property value="ifn.ContactName"/></td>
        <td width="85" height="32">*电  话</td>
        <td width="44">1.固定   </td>
        
        <td width="98"><s:property value="ifn.Telephone"/></td>
      
        <td width="45">2.*手机</td>
        <td width="92"><s:property value="ifn.Phone"/></td>
      </tr>
      <tr>
        <td height="26" colspan="2">传  真</td>
        
         <td colspan="4"><s:property value="ifn.Fax"/></td>
        
      </tr>
  
      <tr>
        <td height="39">*机构属性</td>
        <td height="39" colspan="8"><s:property value="ifn.JGshuxing"/></td>
      </tr>
      <tr>
        <td height="123" colspan="9"><p>*机构简介（单位基本情况，研究基础等，限500字）</p>
          <p>
            <textarea name="CompanyIntroduction" id="CompanyIntroduction" style="width:100% ;height:58px"><s:property value="ifn.CompanyIntroduction"/></textarea></p>
   
       </td>
      </tr>
      <tr>
        <td height="42">*技术需求名称</td>
        <td><s:property value="ifn.TechNeed"/></td>
        <td colspan="2">*需求时限</td>
        <td colspan="4"><s:property value="ifn.StartYear"/>年至<s:property value="ifn.EndYear"/>年</td>
      </tr>
      <tr>
        <td height="155" colspan="9"><p>*技术需求概述：</p>
          <p>1.主要问题（需要解决的重大技术问题）</p> 
          <p>
            <textarea type="text" name="Techquest" id="Techquest" style="width:100%;height:70px"><s:property value="ifn.Techquest"/></textarea>
          </p>
          <p>2.技术关键（所需的关键技术，主要指标）</p>
          <p>
            <textarea type="text" name="TechKey" id="TechKey" style="width:100%;height:70px"><s:property value="ifn.Techkey"/></textarea>
            
          </p>
          <p>3.预期目标（技术创新性、经济社会效益）</p>
          <p>
            <textarea type="text" name="Techgoal" id="Techgoal" style="width:100%;height:70px"><s:property value="ifn.Techgoal"/></textarea>
          </p></td>
      </tr>
      <tr>
        <td height="35" colspan="9">*关键字（1-5个）
        <s:property value="ifn.Key1"/>
        <s:property value="ifn.Key2"/>
        <s:property value="ifn.Key3"/>
        <s:property value="ifn.Key4"/>
        <s:property value="ifn.Key5"/>
        </td>
      </tr>
      <tr>
        <td height="35">拟投入资金总额</td>
        <%String PlanSum=request.getAttribute("ifn.PlanSum").toString();
        if(PlanSum.equals("0.0"))
        	{%>
        <td colspan="8"></td>
        <%}
        else
        {%>
               <td colspan="8"><s:property value="ifn.PlanSum"/>万元</td>
               <%} %>
      </tr>
      <tr>
        <td rowspan="2"><p align="center">*技术需求解决方式</p></td>
        <td height="25" colspan="6"><p>
         <s:property value="ifn.TechNeedMode"/>     
        </p></td>
        </tr>
      <tr>
        <td height="10" colspan="6"><p>合作意向单位:
        <%String CoopIntentionUnit=request.getAttribute("ifn.CoopIntentionUnit").toString();
        if(CoopIntentionUnit.equals(""))
        {%>无
        <% }
        else
        {%>
         <s:property value="ifn.CoopIntentionUnit"/>
         <%} %>
        </p></td>
        </tr>
       
        <tr>
        <td height="30">科技活动类型</td>
        <td colspan="8"><p>
       <s:property value="ifn.StudyType"/>
        </p></td>
        
      </tr>
      <%  
      String StudyType=request.getAttribute("ifn.StudyType").toString();  
      if(StudyType.equals("基础研究"))
      {%>
    	  <tr>
          <td height="40" >学科分类</td>
          <td colspan="10">
          <s:property value="ifn.SbjectThird"/>
             </td>
        </tr>
      <% }
      else
      {%>
    	  <tr>
          <td height="50" rowspan="2"><p align="center">需求技术所属领域(非基础研究填写）</p></td>
          <td height="41" colspan="8"><p>
   <s:property value="ifn.TechNeedField"/>
          </p>
          
            </td>
        </tr>
        <tr id="Otherrow">
          <td height="20"  colspan="8">其他技术：
         <%
         String  Other=request.getAttribute("ifn.Other").toString();
         if(Other.equals(""))
          {%>无
          <%}
         else
          {%>
           <s:property value="ifn.Other"/>
            <%} %>
          </td>
        </tr>
        <tr id="applyrow">
          <td height="64">需求技术应用行业（非基础研究填写）</td>
          <td colspan="7"> <s:property value="ifn.TNProfessionThird"/>
             </td>
        </tr>
      <%}
     
    	  %> 
    	   <tr>
    	  <td style="text-align: center" height="34" colspan="2"><label><input type="radio" name="reason1" value="审核通过" id="tongguo"/>审核通过</label></td>
          <td  style="text-align: center" height="34" colspan="5"><label><input type="radio" name="reason1" value="审核不通过" id="butongguo"/>审核不通过</label></td>
          </tr>
    
              <tr id="reasonrow" style="display:none">
        <td height="123" colspan="9">审核不通过的理由<textarea name="reason" id="reason" style="width:100% ;height:58px"></textarea></td></tr>
            <tr id="xxrow" style="display:none">
        <td height="30" colspan="9">请选择要提交到的管理部门:<select name="guanli" id="guanli" >
        <%String information1="select *from guanli";
		 ResultSet rs1 =db.executeQuery(information1);
		 while(rs1.next()){
		 %>
		 <option value="<%=rs1.getString("bumen")%>"><%=rs1.getString("bumen")%></option>
						<%
							 }
		       rs1.close();
			db.close(); %>
        </select></td></tr>
      <tr>
         <td style="text-align: center;" height="34" colspan="9" > <input type="submit" name="button1" id="button1" onclick="return Judge()" value="确定" />
          &nbsp &nbsp &nbsp &nbsp<input type="button" name="button2" id="button2" value="返回" onclick="act2()"/></td>
      </tr>    
    </table>
  </form>
  </div>
</div>
</body>
</html>
