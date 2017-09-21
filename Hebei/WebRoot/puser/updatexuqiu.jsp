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
    
    <title>My JSP 'updatexuqiu.jsp' starting page</title>
     <script src="jquery/jquery2.0.0.min.js"></script>
      <script language="javascript" type="text/javascript" src="js/information.js" charset="u"></script>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body  style=" background:#F0F0F0">
 <jsp:useBean id="db" class="DB.DBBean" scope="page" />

       <div align="center">  
        <div style="height:40px;text-align:center;" ><p><font size="5" color="blue" style="font-weight:bold;">河北省重大技术需求征集修改</font></p>
       </div>
  <form id="form1" name="form1" method="post" action="informationUpdate.action">
   <table width="828" height="1000" border="1">
   
      <tr>     
        <td width="88" height="32"> *机构全称</td>
        <td width="323"><s:property value="ifn.CompanyName" /></td>
        <td colspan="2">归口管理部门</td>
       
        <td colspan="4"><s:property value="ifn.CenManagement" /></td>
       
        </tr>
      <tr>
        <td height="31">*通讯地址</td>
        <td><s:property value="ifn.CompanyAddress" /></td>
        <td colspan="2">*所在地域</td>
        <td colspan="4"><s:property value="ifn.Area" /></td>
        </tr>
      <tr>
        <td height="31"> 网址</td>
        
        <td width="323"><s:property value="ifn.WorkWebSite" /></td>
        
        <td colspan="2">*电子信箱
        </td>
        <td colspan="3"> <s:property value="ifn.Email" /></td>
        
      </tr>
      <tr>
        <td height="31">*法人代表</td>
        <td><s:property value="ifn.LegalRepresenttative" /></td>
        <td colspan="2">邮政编码
         </td>
        
        <td colspan="3"> <s:property value="ifn.PostCode" /></td>
      
      </tr>
  
      <tr>
        <td rowspan="2">*联 系 人</td>
        <td rowspan="2"><s:property value="ifn.ContactName" /></td>
        <td width="85" height="32">*电  话</td>
        <td width="44">1.固定   </td>
        
        <td width="98"><s:property value="ifn.Telephone" /></td>
      
        <td width="45">2.*手机</td>
        <td width="92"><s:property value="ifn.Phone" /></td>
      </tr>
      <tr>
        <td height="26" colspan="2">传  真</td>
        
         <td colspan="4"><s:property value="ifn.Fax" /></td>
        
      </tr>
  
      <tr>
        <td height="39">*机构属性</td>
        <td height="39" colspan="8"><s:property value="ifn.JGshuxing"/></td>
      </tr>
      <tr>
        <td height="123" colspan="9"><p>*机构简介（单位基本情况，研究基础等，限500字）</p>
          <p>
            <textarea name="CompanyIntroduction" id="CompanyIntroduction" style="width:100% ;height:58px"><s:property value="ifn.CompanyIntroduction" /></textarea></p>
   
       </td>
      </tr>
      <tr>
        <td height="42">*技术需求名称</td>
        <td><input type="text" name="TechNeed" id="TechNeed" style="width:100%;height:38px" value="<s:property value="ifn.TechNeed"/>"></td>
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
            <textarea type="text" name="Techkey" id="Techkey" style="width:100%;height:70px"><s:property value="ifn.Techkey"/></textarea>
            
          </p>
          <p>3.预期目标（技术创新性、经济社会效益）</p>
          <p>
            <textarea type="text" name="Techgoal" id="Techgoal" style="width:100%;height:70px"><s:property value="ifn.Techgoal"/></textarea>
          </p></td>
      </tr>
      <tr>
        <td height="35" colspan="9">*关键字（1-5个）
          <input type="text" name="Key1" id="Key1" style="height:25px;width:100px" value="<s:property value="ifn.Key1"/>">
          <input type="text" name="Key2" id="Key2" style="height:25px;width:100px" value="<s:property value="ifn.Key2"/>">
          <input type="text" name="Key3" id="Key3" style="height:25px;width:100px" value="<s:property value="ifn.Key3"/>">
          <input type="text" name="Key4" id="Key4" style="height:25px;width:100px" value="<s:property value="ifn.Key4"/>">
          <input type="text" name="Key5" id="Key5" style="height:25px;width:100px" value="<s:property value="ifn.Key5"/>">
        </td>
      </tr>
      <tr>
        <td height="35">拟投入资金总额</td>
        <%String PlanSum=request.getAttribute("ifn.PlanSum").toString();
        if(PlanSum.equals("0.0"))
        	{%>
       <td colspan="8"><input name="PlanSum" type="text" id="PlanSum" size="10" onblur="touzi()" />万元<label><div id="money" nowrap></div></label></td>
        <%}
        else
        {%>
               <td colspan="8"><input name="PlanSum" type="text" id="PlanSum" size="10" onblur="touzi()" value="<s:property value="ifn.PlanSum"/>" />万元</td>
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
        {%><input name="CoopIntentionUnit" id="CoopIntentionUnit"  style="width:400px;height:30px">
        <% }
        else
        {%>
         <input name="CoopIntentionUnit" id="CoopIntentionUnit"  value="<s:property value="ifn.CoopIntentionUnit"/>"vstyle="width:400px;height:30px">
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
          {%><input type="text" name="Other"  id="Other">
          <%}
          else
          {%>
           <input type="text" name="Other" value="<s:property value="ifn.Other"/>" id="Other">
          
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
     
      <tr>
        <td style="text-align: center;" height="34" colspan="9"> <input type="submit" name="button1" id="button1" value="确认修改" onclick="return Judge()" />
         <!--  &nbsp &nbsp &nbsp &nbsp<input type="button" name="button2" id="button2" value="返回" onclick="act2();"/> --></td>
      </tr>    
    </table>
  </form>
  </div>
</body>
</html> 