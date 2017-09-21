<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>xxx需求征集表</title>
    <script src="jquery/jquery2.0.0.min.js"></script>
      <script language="javascript" type="text/javascript" src="js/information.js" charset="u"></script>
      
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
 <body  style=" background:#F0F0F0">
     <jsp:useBean id="db" class="DB.DBBean" scope="page"/>
<%    
        request.setCharacterEncoding("UTF-8");
       String  CompanyName=(String)session.getAttribute("companyName"); 
      
       %>
<div align="center">
     <div style="height:40px;text-align:center;" ><p><font size="5" color="blue" style="font-weight:bold;">xxx需求征集</font></p>
       </div>
       <div>
  <form id="form1" name="form1" method="post" action="informationAdd.action">
    <table width="966" border="1">
    <tr style="display:none">
     <td><input type="Text" name="CompanyName" value="<%=CompanyName%>"></td>
    
     </tr>
        <tr>
        <td width="86" height="32">*机构全称</td>
        <td width="400"><input type="text" name="CompanyName1" id="CompanyName1" style="width:100%;height:28px" value="<%=CompanyName%>" disabled="disabled"
 required/></td>
        <td width="100">归口管理部门</td>
        <td colspan="4"><select name="CenManagement" style="width:200px;height:28px" id="CenManagement">
        <option value=""></option>
       <%   request.setCharacterEncoding("UTF-8");
       
		String information="select *from Guikou";
		 ResultSet rs =db.executeQuery(information);
		 while(rs.next()){
		 %>
		 
		 <option value="<%=rs.getString("bunmen")%>"><%=rs.getString("bunmen")%></option>
						<%
   							 }
		       rs.close();
							
							
							
						%>  </select></td>
      </tr>
      <tr>
        <td height="31">*通讯地址</td>
        <td><input type="text" name="CompanyAddress" id="CompanyAddress"  style="width:100%;height:28px" required/></td>
        <td colspan="1">*所在地域</td>
        <td colspan="4">
        <select name="Area" style="width:200px;height:28px" id="Area">
           <%   request.setCharacterEncoding("UTF-8");
       
		String information1="select *from Sheet1$";
		 ResultSet rs1 =db.executeQuery(information1);
		 while(rs1.next()){
		 %>
		 <option value="<%=rs1.getString("Code")%><%=rs1.getString("Title")%>"><%=rs1.getString("Code")%><%=rs1.getString("Title")%></option>
						<%
   							 }
		       rs1.close();
							 db.close();
							
							
						%>
        </select></td>
        </tr>
      <tr>
        <td height="39"> 网址</td>
        <td><input name="WorkWebSite" type="text" id="WorkWebSite" style="width:400px;height:35px" /></td>
        <td width="70" height="20">*电子信箱</td>
          <td><input type="text" name="Email" onblur="verifyAddress()" style="width:200px;height:35px" id="Email"  required="required" placeholder="例如:1062855360@qq.com"/><label id="mes" nowrap></label></td>
      </tr>
      <tr>
        <td height="39">*法人代表</td>
        <td><input type="text" name="LegalRepresenttative" style="width:400px;height:35px" id="LegalRepresenttative" required/></td>
        <td  width="70" height="20">邮政编码</td>
          <td><input name="PostCode" type="text" onblur="youbiantest()" id="PostCode" style="width:200px;height:35px" size="500" placeholder="例如：130021"/><label id="yb" nowrap></label></td>
      </tr>
  
      <tr>
        <td>*联 系 人</td>
        <td ><input type="text" name="ContactName" id="ContactName" style="height:40px;width:100%" required/></td>
        <td width="70" height="20">固定电话  </td>
        <td><input type="text" name="Telephone" id="Telephone" style="height:30px;width:200px" onblur="checkTel()" placeholder="区号+座机号码"/><label id="dianhua" nowrap></label></td>
        
        
      </tr>
      <tr>
       
        <td width="36">*手机</td>
        <td width="183"><input type="text" name="Phone" style="height:30px;width:100%" id="Phone" onblur="CheckPhone()"  required placeholder="11位"/><label id="shouji" nowrap></label></td>
        <td height="34">传  真</td>
        <td colspan="4"><input type="text" name="Fax" id="Fax" style="height:30px;width:200px" placeholder="区号+座机号码" /></td>
      </tr>
  
      <tr>
        <td height="35">*机构属性</td>
        <td height="35" colspan="7"><label>
          <input type="radio" name="JGshuxing" value="企业" id="JGshuxing_0" />
          企业</label>
          <input type="radio" name="JGshuxing" value="高等院校" id="JGshuxing_1" />
高等院校
<label>
  <input type="radio" name="JGshuxing" value="研究机构" id="JGshuxing_2" />
  研究机构</label>
<label>
  <input type="radio" name="JGshuxing" value="其它" id="JGshuxing_3" />
  其他</label></td>
      </tr>
      <tr>
        <td height="123" colspan="8"><p>*机构简介（单位基本情况，研究基础等，限500字）</p>
          <p>
            <textarea name="CompanyIntroduction" id="CompanyIntroduction" style="width:100%;height:58px" onKeyDown="textCounter1(CompanyIntroduction,remLen,500);" onKeyUp="textCounter1(CompanyIntroduction,remLen,500);" required></textarea>
      您还可以输入:<input name="remLen" type="text" value="500" size="5" readonly>个汉字  <label id="word1" nowrap></label>  </p>
   
       </td>
      </tr>
      <tr>
        <td height="42">*技术需求名称</td>
        <td><input type="text" name="TechNeed" id="TechNeed" style="width:100%;height:38px" required/></td>
        <td>*需求时限</td>
        <td colspan="4"><select name="StartYear" style="width: 90px;" id="StartYear"> 
     <option value="">--- 请选择 ---</option> 
              <%  
                     StringBuffer bufYear = new StringBuffer();  
                     //下拉列表的年数  
                     for(int i=0;i<100;i++){  
                     //最小年  
                     int iYear = 2016+i;  
                     bufYear.append("<option value = '"+iYear+"'");  
                     Date date = new Date();  
                     int sYear = date.getYear();  
                     //系统时间从1900年开始  
                     int sYearc = sYear+1900;  
                     if(iYear == sYearc){  
                          bufYear.append(" selected");  
                      }  
                     bufYear.append(" >"+iYear+"</option>\n");  
                     }  
                     out.println(bufYear.toString());  
               %>  
      </select>-  
     <select name='EndYear' style="width: 90px;" id="EndYear"onblur="YearYanzheng()">  
       <option value="">--- 请选择 ---</option>
              <%  
                     StringBuffer bufYear2 = new StringBuffer();  
                     //下拉列表的年数  
                     for(int i=0;i<100;i++){  
                     //最小年  
                    
                     int iYear2 = 2016+i;  
                     bufYear2.append("<option value = '"+iYear2+"'");  
                     Date date = new Date();  
                     int sYear2 = date.getYear();  
                     //系统时间从1900年开始  
                     int sYearc2 = sYear2+1900;  
                      if(iYear2 == sYearc2){  
                          bufYear2.append(" selected");  
                      }  
                     bufYear2.append(" >"+iYear2+"</option>\n");  
                     }  
                     out.println(bufYear2.toString());  
               %>  
      </select>  
        <label><div id="mesyear" nowrap></div></label></td>
      </tr>
      <tr>
        <td height="155" colspan="8"><p>*技术需求概述：</p>
          <p>1.主要问题（需要解决的重大技术问题）</p> 
          <p>
            <textarea type="text" name="Techquest" id="Techquest" style="width:100%;height:70px" onKeyDown="textCounter2(Techquest,remLen1,500);" onKeyUp="textCounter2(Techquest,remLen1,500);" required></textarea>
      您还可以输入:<input name="remLen1" type="text" value="500" size="5" readonly>个汉字<label id="word2" nowrap></label>
          </p>
          <p>2.技术关键（所需的关键技术，主要指标）</p>
          <p>
            <textarea type="text" name="Techkey" id="Techkey" style="width:100%;height:70px" onKeyDown="textCounter2(TechKey,remLen2,500);" onKeyUp="textCounter2(TechKey,remLen2,500);" required></textarea>
      您还可以输入:<input name="remLen2" type="text" value="500" size="5" readonly>个汉字<label id="word3" nowrap></label></textarea>
            
          </p>
          <p>3.预期目标（技术创新性、经济社会效益）</p>
          <p>
            <textarea type="text" name="Techgoal" id="Techgoal" style="width:100%;height:70px"onKeyDown="textCounter4(Techgoal,remLen3,500);" onKeyUp="textCounter4(Techgoal,remLen3,500);" required></textarea>
      您还可以输入:<input name="remLen3" type="text" value="500" size="5" readonly>个汉字<label id="word4" nowrap></label></textarea>
          </p></td>
      </tr>
      <tr>
        <td height="35" colspan="8">*关键字（1-5个）
          <input type="text" name="Key1" id="Key1" style="height:25px;width:130px" onblur="yici()" required/>
          <input type="text" name="Key2" id="Key2" style="height:25px;width:130px" readOnly=true  onblur="yici()"/>
          <input type="text" name="Key3" id="Key3" style="height:25px;width:130px" readOnly=true  onblur="yici()" />
          <input type="text" name="Key4" id="Key4" style="height:25px;width:130px" readOnly=true  onblur="yici()" />
          <input type="text" name="Key5" id="Key5" style="height:25px;width:130px" readOnly=true  onblur="yici()"/>（请依次输入）</td>
      </tr>
      <tr>
        <td height="35">拟投入资金总额</td>
        <td colspan="7"><input name="PlanSum" type="text" id="PlanSum" size="10" onblur="touzi()"  placeholder="请输入数值"/>万元<label><div id="money" nowrap></div></label>
</td>
      </tr>
      <tr>
        <td rowspan="2" height="30"><p align="center">*技术需求解决方式</p></td>
        <td colspan="5"><p>
          <label>
              <input type="radio" name="TechNeedMode" value="独立开发" id="TechNeedMode_0" />
   独立开发</label>
          <label>
            <input type="radio" name="TechNeedMode" value="委托开发" id="TechNeedMode_1" />
 委托开发</label>
          <label>
            <input type="radio" name="TechNeedMode" value="合作开发" id="TechNeedMode_2" />
  合作研发
            <input type="radio" name="TechNeedMode" value="其他" id="TechNeedMode_3" />
  其他</label></td>
        </tr>
      <tr>
        <td colspan="5"><p>合作意向单位
          <input name="CoopIntentionUnit" id="CoopIntentionUnit"  style="width:300px;height:20px">
          （选填）<br />
        </p></td>
        </tr>
       
        <tr>
        <td height="35">科技活动类型</td>
        <td colspan="7"><p>
          <label>
          <input type="radio" name="StudyType" value="基础研究" id="StudyType_0" />基础研究</label>
          <label>
            <input type="radio" name="StudyType" value="应用研究" id="StudyType_1" />应用研究</label>
          <label>
            <input type="radio" name="StudyType" value="试验发展" id="StudyType_2" />试验发展</label>
          <label>
            <input type="radio" name="StudyType" value="研究发展与成果应用" id="StudyType_3" />研究发展与成果应用</label>
          <label>
            <input type="radio" name="StudyType" value="推广与科技服务" id="StudyType_4" />技术推广与科技服务</label>
            <label>
             <input type="radio" name="StudyType" value="生产性活动" id="StudyType_5" />生产性活动</label>
        </p></td>
      </tr>
       <tr id="studyrow">
        <td height="40" >*学科分类</td>
        <td colspan="9">一级
          <select name="SbjectFist" style="width:100px"  id="SbjectFist">
          </select>
          二级
           <select name="SbjectSecond" style="width:100px" id="SbjectSecond">
          </select> 
            三级
            <select name="SbjectThird" style="width:100px" id="SbjectThird">
          </select> 
            
           </td>
      </tr>
      <tr id="TechNeedFieldrow">
        <td height="50" rowspan="2"><p align="center">*需求技术所属领域(非基础研究填写）</p></td>
        <td height="77" colspan="7"><p>
  <label>
    <input type="checkbox" name="TechNeedField" value="电子信息技术" id="TechNeedField_0" />电子信息技术</label>
  <label>
    <input type="checkbox" name="TechNeedField" value="光电一体化" id="TechNeedField_1" />光机电一体化</label>
  <label>
    <input type="checkbox" name="TechNeedField" value="生物制药技术" id="TechNeedField_2" />
    生物制药与技术</label>
  <label>
    <input type="checkbox" name="TechNeedField" value="新材料及应用技术" id="TechNeedField_3" />新材料及应用技术</label>
  <label>
    <input type="checkbox" name="TechNeedField" value="先进制造技术" id="TechNeedField_4" />先进制造技术</label>
        </br>
            <label>
              <input type="checkbox" name="TechNeedField" value="现代农业技术" id="TechNeedField_5" />现代农业技术</label>
            <label>
              <input type="checkbox" name="TechNeedField" value="新能源与高效节能技术" id="TechNeedField_6" />新能源与高效节能技术</label>
            <label>
              <input type="checkbox" name="TechNeedField" value="资源与环境保护新技术" id="TechNeedField_7" />
              资源与环境</label>
               <label>
              <input type="checkbox" name="TechNeedField" value="高技术服务业" id="TechNeedField_8" />
              高技术服务业</label> <label>
              <input type="checkbox" name="TechNeedField" value="海洋" id="TechNeedField_9" />海洋</label>
              <label>
                <input type="checkbox" name="TechNeedField" value="社会公共事业" id="TechNeedField_10" />
                社会公共事业</label>
              <label>
                <input type="checkbox" name="TechNeedField" value="医疗卫生" id="TechNeedField_11" />
                医疗卫生</label>
              <label>
                <input type="checkbox" name="TechNeedField" value="其他技术" id="TechNeedField_12" />
                其他技术（注明）</label>
              </br>
        </p>       
          </td>
      </tr>
      <tr id="Otherrow">
        <td height="42"  colspan="7"><label>其他技术
          <input type="text" name="Other"  id="Other" placeholder="其他技术" style="height:20px;width:300px" />
        </label></td>
      </tr>
      <tr id="applyrow">
        <td height="50">*需求技术应用行业（非基础研究填写）</td>
        <td colspan="6">一级<select name="TNProfessionFist" style="width:100px"  id="TNProfessionFist">
          </select>
          二级
           <select name="TNProfessionSecond" style="width:100px" id="TNProfessionSecond">
          </select> 
            三级
           <select name="TNProfessionThird" style="width:100px" id="TNProfessionThird">
          </select> 
           </td>
      </tr>
      <tr>
        <td style="text-align: center;" height="34" colspan="8"> <input type="submit" name="button" id="button" onclick="return Judge()" value="提交" />
         &nbsp &nbsp &nbsp &nbsp <input type="reset" name="button2" id="button2" value="重置" /></td>
      </tr>
    </table>
  </form>
  </div>
</div> 
</body>
</html>
