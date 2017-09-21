var tech1;
var tech2;
var tech3;

jQuery(function($){
    var t1 = $("#SbjectFist"),
        t2 = $("#SbjectSecond"),
        t3 = $("#SbjectThird");
    t1.append("<option value='NULL'>请选择</option>");
    t2.append("<option value='NULL'>请选择</option>");
    t3.append("<option value='NULL'>请选择</option>");
    
    $.ajax({   
        type:"POST",  
        url:"Techservlet1", 
        async:false,
        dataType: "text",
        
        //请求成功完成后要执行的方法  
        success: function(msg){  
     	   tech1 = msg.split(" ");
        }, 
        error: function (response) {
      	
        }  
    });
    $(tech1).each(function(i, dom){
 	   t1.append("<option value='"+dom+"'>" + dom + "</option>");
    });
    
    var beforestr;
    t1.change(function(){
        var me = $(this).val();
        beforestr=me;
        $.ajax({   
            type:"POST",  
            url:"Techservlet2", 
            async:false,
            data:{"tech1":me},
            dataType: "text",
            
            //请求成功完成后要执行的方法  
            success: function(msg){  
         	   tech2 = msg.split(" ");
            }, 
            error: function (response) {
            }  
        });  
        
        if(beforestr == me){
     	   t2.html("").append("<option value=''>请选择</option>");
     	   t3.html("").append("<option value=''>请选择</option>");
            $(tech2).each(function(i, dom){
         	   t2.append("<option value='"+dom+"'>" + dom + "</option>");
            });
        }else{
     	   t2.html("").append("<option value=''>请选择</option>");
     	   t3.html("").append("<option value=''>请选择</option>");
        }
    });
    t2.change(function(){
        var me = $(this).val(),str;
        
        $.ajax({   
            type:"POST",  
            url:"Techservlet3", 
            async:false,
            data:{"tech2":me,"tech1":beforestr},
            dataType: "text",
            
            //请求成功完成后要执行的方法  
            success: function(msg){  
         	   tech3 = msg.split(" ");
            }, 
            error: function (response) {
            }  
        });
        
        if(str=me){
     	   t3.html("").append("<option value=''>请选择</option>");
            $(tech3).each(function(i, dom){
         	   t3.append("<option value='"+dom+"'>" + dom + "</option>");
            });
        }else{
     	   t3.html("").append("<option value=''>请选择</option>");
        }
    });
});


var tech4;
var tech5;
var tech6;
jQuery(function($){
    var t4= $("#TNProfessionFist"),
        t5 = $("#TNProfessionSecond"),
        t6 = $("#TNProfessionThird");
    t4.append("<option value='NULL'>请选择</option>");
    t5.append("<option value='NULL'>请选择</option>");
    t6.append("<option value='NULL'>请选择</option>");
    
    $.ajax({   
        type:"POST",  
        url:"Techservlet4", 
        async:false,
        dataType: "text",
        
        //请求成功完成后要执行的方法  
        success: function(msg){  
     	   tech4 = msg.split(" ");
        }, 
        error: function (response) {
      	
        }  
    });
    $(tech4).each(function(i, dom){
 	   t4.append("<option value='"+dom+"'>" + dom + "</option>");
    });
    
    var beforestr;
    t4.change(function(){
        var me = $(this).val();
        beforestr=me;
        $.ajax({   
            type:"POST",  
            url:"Techservlet5", 
            async:false,
            data:{"tech4":me},
            dataType: "text",
            
            //请求成功完成后要执行的方法  
            success: function(msg){  
         	   tech5= msg.split(" ");
            }, 
            error: function (response) {
            }  
        });  
        
        if(beforestr == me){
     	   t5.html("").append("<option value=''>请选择</option>");
     	   t6.html("").append("<option value=''>请选择</option>");
            $(tech5).each(function(i, dom){
         	   t5.append("<option value='"+dom+"'>" + dom + "</option>");
            });
        }else{
     	   t5.html("").append("<option value=''>请选择</option>");
     	   t6.html("").append("<option value=''>请选择</option>");
        }
    });
    t5.change(function(){
        var me = $(this).val(),str;
        
        $.ajax({   
            type:"POST",  
            url:"Techservlet6", 
            async:false,
            data:{"tech5":me,"tech4":beforestr},
            dataType: "text",
            
            //请求成功完成后要执行的方法  
            success: function(msg){  
         	   tech6 = msg.split(" ");
            }, 
            error: function (response) {
            }  
        });
        
        if(str=me){
     	   t6.html("").append("<option value=''>请选择</option>");
            $(tech6).each(function(i, dom){
         	   t6.append("<option value='"+dom+"'>" + dom + "</option>");
            });
        }else{
     	   t6.html("").append("<option value=''>请选择</option>");
        }
    });
});



 
   window.onload= function(){
    var inpt= document.getElementById('form1').getElementsByTagName('input');  //获取表单下所有的input元素
    for(var i=0;i<inpt.length;i++){   //遍历获得的input元素
     if(inpt[i].type=='radio'){   //如果是单选按钮
    
     
      inpt[i].onclick=function(){ // input的单击事件
       if(this.checked)
       if(this.nextSibling.nodeValue=="基础研究")
    	   {
    	     studyrow.style.display="";
    	     
    	     TechNeedFieldrow.style.display="none"; 
    	     
			 Otherrow.style.display="none";
				
    	     applyrow.style.display="none";
			 
  
    	   }
       else if(this.nextSibling.nodeValue=="生产性活动"||this.nextSibling.nodeValue=="应用研究"||this.nextSibling.nodeValue=="试验发展"||this.nextSibling.nodeValue=="研究发展与成果应用"||this.nextSibling.nodeValue=="技术推广与科技服务")
    	   {
    	   studyrow.style.display="none";
    	  TechNeedFieldrow.style.display="";
		   Otherrow.style.display="";
    	     applyrow.style.display="";	
    	   }
     
      }
     }
	  if(inpt[i].type=='checkbox'){
		   inpt[i].onclick=function(){ // input的单击事件
       if(this.checked)
	    if(this.nextSibling.nodeValue=="其他技术")
    	  {
    	 
		   Otherrow.style.display="none";
    	  }
      else
        {
    	    Otherrow.style.display="";
         }
	  }
	  }
    }
   }

   
 //邮箱验证*********************************************************************************
function verifyAddress()    
{    
 var email = document.getElementById('Email').value;    
 var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;    
 flag = pattern.test(email);    
 if(flag)    
 {    
	 document.getElementById("mes").innerHTML="<font color='red'></font>";
   	 return true;    
 }    
 else    
 {    
  document.getElementById("mes").innerHTML="<font color='red'>邮箱格式有误!</font>";
  
  return false;    
 }    
} 
//手机号码验证
  function CheckPhone(){ 
    var phone = document.getElementById('Phone').value;
	var pattern=/^1(3|4|5|7|8)\d{9}$/;
	flag=pattern.test(phone);
	if(flag)
	{
		  document.getElementById("shouji").innerHTML="<font color='red'></font>";
	   	 return true;    
		}
   else    
	 {    
	  document.getElementById("shouji").innerHTML="<font color='red'>手机号码格式错误!</font>";
	  
	  return false;    
	 
    } 
}
//电话验证
function checkTel(){
	 var telphone = document.getElementById('Telephone').value;  
	 if(telphone=="")
		 {
		 return true;
		 }
	 else
		 {
	 var pattern = /^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
	 flag = pattern.test(telphone);
	 
	 if(flag)    
	 {    
		 document.getElementById("dianhua").innerHTML="<font color='red'></font>";
	   	 return true;    
	 }    
	 else    
	 {    
	  document.getElementById("dianhua").innerHTML="<font color='red'>电话格式有误!</font>";
	  
	  return false;    
	 }  
		 }

}
//邮编验证*********************************************************************************
function youbiantest()    
{       
	 var youbian = document.getElementById('PostCode').value;  
	 if(youbian=="")
		 {return true;}
	 else
		 {
	 var pattern = /^[1-9]{1}[0-9]{5}$/;
	 flag = pattern.test(youbian);	 
	 if(flag)    
	 {    
		 document.getElementById("yb").innerHTML="<font color='red'></font>";  
		 return true;
	 }    
	 else    
	 {    
	  document.getElementById("yb").innerHTML="<font color='red'>邮编格式有误!</font>";
	  return false;
	   
	 }  
   }
	    
}
//需求时限验证***********************************************************************
function YearYanzheng()
{
	var a = document.getElementById('StartYear').value; 
	var b = document.getElementById('EndYear').value;
	if(a>b)
	{
	    document.getElementById("mesyear").innerHTML="<font color='red'>请确保第一个年份小于第二个!</font>";
         document.getElementById("StartYear").focus();
         return false;
	}
	else
	{
		
		   document.getElementById("mesyear").innerHTML="<font color='red'></font>";
   	     return true;
	}
}
/*function add()
{
	  var num1 = document.getElementById('ComSelf').value; //获取第一个输入框的值
    var num2 = document.getElementById('BankMoney').value;//获取第二个输入框的值
    var num3=document.getElementById('OtherMoney').value;//第三个值
    num1 = parseInt(num1);  //转换为整数
    num2 = parseInt(num2);
    num3=parseInt(num3);
    if (isNaN(num1) || isNaN(num2)||isNaN(num3)) {  //如果为非数字，结果为空
        document.getElementById('PlanSum').value = "";
    } else {  //将第三个输入框设置为和
        document.getElementById('PlanSum').value = num1 + num2 + num3;
    }
}*/
//字数限制
 function textCounter1(field, countfield, maxlimit) {
// 函数，3个参数，表单名字，表单域元素名，限制字符；
if (field.value.length > maxlimit)
{//如果元素区字符数大于最大字符数，按照最大字符数截断；
//field.value = field.value.substring(0, maxlimit);
document.getElementById("word1").innerHTML="<font color='red'>已超过五百字，请简略</font>";
return false;
}
else
 {//在记数区文本框内显示剩余的字符数；
countfield.value = maxlimit - field.value.length;
document.getElementById("word1").innerHTML="<font color='red'></font>";
return true;
 }
}

function textCounter2(field, countfield, maxlimit) {
	if (field.value.length > maxlimit)
	{	
	document.getElementById("word2").innerHTML="<font color='red'>已超过五百字，请简略</font>";
	return false;
	}
	else
	 {
	countfield.value = maxlimit - field.value.length;
	document.getElementById("word2").innerHTML="<font color='red'></font>";
	return true;
	 }
	}
function textCounter3(field, countfield, maxlimit) {

	if (field.value.length > maxlimit)
	{	
	document.getElementById("word3").innerHTML="<font color='red'>已超过五百字，请简略</font>";
	return false;
	}
	else
	 {
	countfield.value = maxlimit - field.value.length;
	document.getElementById("word3").innerHTML="<font color='red'></font>";
	return true;
	 }
	}
function textCounter4(field, countfield, maxlimit) {

	if (field.value.length > maxlimit)
	{	
	document.getElementById("word4").innerHTML="<font color='red'>已超过五百字，请简略</font>";
	return false;
	}
	else
	 {
	countfield.value = maxlimit - field.value.length;
	document.getElementById("word4").innerHTML="<font color='red'></font>";
	return true;
	 }
	}


//数值验证
 function touzi()    
{    
	
 var plansum = document.getElementById('PlanSum').value;   
 if(plansum=="")
	 {return true;}
 else
	 {
 var pattern =/^(([1-9]\d{0,9})|0)(\.\d{1,2})?$/;    
 flag = pattern.test(plansum);    
 if(flag)    
 {    
	 document.getElementById("money").innerHTML="<font color='red'></font>";
   	return true;
 }    
 else    
 {    
  document.getElementById("money").innerHTML="<font color='red'>请输入数值!</font>";  
  return false;    
 } }
 
}
//机构属性非空
 function JGshuxing()
 {
	   var JGshuxing=form1.JGshuxing.value;
	   if(JGshuxing=="")
		   { return false;}	  
	   else
		   {return true;}
 }
 //技术需求解决方式非空
 function  TechNeedMode()
 {
	   var TechNeedMode=form1.TechNeedMode.value;
	   if(TechNeedMode=="")
		   { return false;}	  
	   else
		   {return true;}
 }
 //科技活动类型非空
 function StudyType()
 {
	 var StudyType=form1.StudyType.value;
	   if(StudyType=="")
		   { return false;}	  
	   else
		   {return true;}
 }
//输入框依次输入
function yici(){
var input1=document.getElementById("Key1").value;
var input2=document.getElementById("Key2").value;
var input3=document.getElementById("Key3").value;
var input4=document.getElementById("Key4").value;
var input5=document.getElementById("Key5").value;//通过id获得
if(input1=="")
 {
	Key2.readOnly=true;
	Key3.readOnly=true;
	Key4.readOnly=true;
	Key5.readOnly=true;
       
	}
	else
	{
		Key2.readOnly=false;
		
	}

 if(input2=="")
{
	Key3.readOnly=true;
	Key4.readOnly=true;
	Key5.readOnly=true;
}
else
{ Key3.readOnly=false;
}
if(input3=="")
{
	Key4.readOnly=true;
	Key5.readOnly=true;
}
else
{ Key4.readOnly=false;
}
if(input4=="")
{
	Key5.readOnly=true;
}
else
{ Key5.readOnly=false;
}
}
  function Judge()
  {  
	  if(!verifyAddress())
		{
		 alert("请输入正确的邮箱格式！");
		 return false;
		}
	  
	  else if(!StudyType())
	  {
	  alert("请选择机科技活动类型!");
	  return false;
	  }
	  
	   else if(!JGshuxing())
	  {
	  alert("请选择机构属性!");
	  return false;
	  }
	  
	   else if(!touzi())
	  {
		  alert("请确保投资金额为数值!");
	      return false;
	  }
	   else  if(!TechNeedMode())
		  {
		  alert("请选择技术需求解决方式");
		  return false;
		  } 
	   
	  else if(!CheckPhone())
		  {
		    alert("请输入正确的手机格式！");
			 return false;
		  }
	  else if(!checkTel())
		  {
		  alert("请输入正确的电话格式!");
		  return false;
		  }
	  else if(!youbiantest())
		  {
		  alert("请输入正确的邮编格式!");
		  
		  return false;
		  }
	  else if(!YearYanzheng())
		  {
		  alert("请确保第二个年份大于第一个年份!");
		  return false;
		  }
	  else if(!textCounter1())
		  {
		  alert("请确保字数少于500字!");
		  return false;
		  }
	  else if(!textCounter2())
	  {
	  alert("请确保字数少于500字!");
	  return false;
	  }
	  else if(!textCounter3())
	  {
	  alert("请确保字数少于500字!");
	  return false;
	  }
	 
	  else if(!textCounter4())
	  {
	  alert("请确保字数少于500字!");
	  return false;
	  }
	  
	  
	  else if(!StudyType())
		  {
		  alert("请选择科技活动类型!");
		  return false;
		  }
	  else 
		  {
		  return true;
		  }
  }